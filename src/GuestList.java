import java.util.ArrayList;
import java.util.Scanner;

public class GuestList {

    private int numarLocuriDisponibileEveniment;
    private ArrayList<Guest> listaParticipanti;
    private ArrayList<Guest> listaParticipantiInAsteptare;

    GuestList(int numarLocuriDisponibileEveniment){
        this.numarLocuriDisponibileEveniment = numarLocuriDisponibileEveniment;
        this.listaParticipanti = new ArrayList<Guest>();
        this.listaParticipantiInAsteptare = new ArrayList<Guest>();
    }


    public boolean verificareInListe(ArrayList<Guest> lista, Guest object){
        if (object != null) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getName().equalsIgnoreCase(object.getName()) ||
                        lista.get(i).getEmail().equalsIgnoreCase(object.getEmail()) ||
                        lista.get(i).getPhoneNumber().equals(object.getPhoneNumber())) {
                    return true;
                }
            }
        }
        return false;
    }

    // 1. adaugarea unei noi persoane
    public int adaugareInLista(Guest object){
        if (this.listaParticipanti.size() < this.numarLocuriDisponibileEveniment &&
                (verificareInListe(listaParticipanti,object) == false)){
            this.listaParticipanti.add(object);
            System.out.println(object.getName() + ", felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
            return 0;
        } else if (this.listaParticipanti.size() == this.numarLocuriDisponibileEveniment &&
                verificareInListe(listaParticipantiInAsteptare,object) == false) {
            this.listaParticipantiInAsteptare.add(object);
            System.out.println(object.getName() + ", te-ai inscris cu succes in lista de asteptare si ai\n" +
                    "primit numarul de ordine " + (listaParticipantiInAsteptare.indexOf(object) + 1) +
                    ". Te vom notifica daca un loc devine disponibil.");
            return (listaParticipantiInAsteptare.indexOf(object) + 1);
        }
        return -1;
    }

    // 2. determina daca o persoana este adaugata pe una din liste
    public boolean esteSauNuPeListe(Guest object) {
        String nuEste = "Nu esti inscris pe nicio lista";
        if (verificareInListe(listaParticipanti,object) == true) {
            return true;
        } else if (verificareInListe(listaParticipantiInAsteptare,object) == true) {
            return true;
        }
        return false;
    }


    public Guest checkLastName (String lastName){
        for (int i = 0; i < this.listaParticipanti.size(); i++){
            Guest invitatInscris = listaParticipanti.get(i);
            if (listaParticipanti.get(i).getLastName().equalsIgnoreCase(lastName)){
                System.out.println("Esti inscris pe lista de invitati.");
                return invitatInscris;
            }
        }
        for (int i = 0; i < this.listaParticipantiInAsteptare.size(); i++){
            Guest invitatInAsteptare = listaParticipantiInAsteptare.get(i);
            if (listaParticipantiInAsteptare.get(i).getLastName().equalsIgnoreCase(lastName)){
                System.out.println("Esti inscris pe lista de asteptare");
                return invitatInAsteptare;
            }
        }
        System.out.println("Persoana cu numele de familie " + lastName + " nu este inscrisa pe nicio lista");
        return null;
    }


    public Guest checkFirstName (String firstName){
        for (int i = 0; i < this.listaParticipanti.size(); i++){
            Guest invitatInscris = listaParticipanti.get(i);
            if (listaParticipanti.get(i).getFirstName().equalsIgnoreCase(firstName)){
                System.out.println("Esti inscris pe lista de invitati.");
                return invitatInscris;
            }
        }
        for (int i = 0; i < this.listaParticipantiInAsteptare.size(); i++){
            Guest invitatInAsteptare = listaParticipantiInAsteptare.get(i);
            if (listaParticipantiInAsteptare.get(i).getFirstName().equalsIgnoreCase(firstName)){
                System.out.println("Esti inscris pe lista de asteptare");
                return invitatInAsteptare;
            }
        }
        System.out.println("Persoana cu prenumele " + firstName + " nu este inscrisa pe nicio lista");
        return null;
    }

    public Guest checkEmail (String email){
        for (int i = 0; i < this.listaParticipanti.size(); i++){
            Guest invitatInscris = listaParticipanti.get(i);
            if (listaParticipanti.get(i).getEmail().equalsIgnoreCase(email)){
                System.out.println("Esti inscris pe lista de invitati.");
                return invitatInscris;
            }
        }
        for (int i = 0; i < this.listaParticipantiInAsteptare.size(); i++){
            Guest invitatInAsteptare = listaParticipantiInAsteptare.get(i);
            if (listaParticipantiInAsteptare.get(i).getEmail().equalsIgnoreCase(email)){
                System.out.println("Esti inscris pe lista de asteptare");
                return invitatInAsteptare;
            }
        }
        System.out.println("Persoana cu email-ul " + email + " nu este inscrisa pe nicio lista");
        return null;
    }

    public Guest checkPhoneNumber (String phoneNumber){
        for (int i = 0; i < this.listaParticipanti.size(); i++){
            Guest invitatInscris = listaParticipanti.get(i);
            if (listaParticipanti.get(i).getPhoneNumber().equalsIgnoreCase(phoneNumber)){
                System.out.println("Esti inscris pe lista de invitati.");
                return invitatInscris;
            }
        }
        for (int i = 0; i < this.listaParticipantiInAsteptare.size(); i++){
            Guest invitatInAsteptare = listaParticipantiInAsteptare.get(i);
            if (listaParticipantiInAsteptare.get(i).getPhoneNumber().equalsIgnoreCase(phoneNumber)){
                System.out.println("Esti inscris pe lista de asteptare");
                return invitatInAsteptare;
            }
        }
        System.out.println("Persoana cu nr. de telefon " + phoneNumber + " nu este inscrisa pe nicio lista");
        return null;
    }



    // 3. eliminarea unei persoane
    public boolean eliminarePersoana(Guest object) {
        if (verificareInListe(listaParticipantiInAsteptare,object) == true) {
            listaParticipantiInAsteptare.remove(object);
            System.out.println("Persoana a fost stearsa");
            return true;
        }

        else if (verificareInListe(listaParticipanti,object) == true) {
            listaParticipanti.remove(object);
            if (listaParticipantiInAsteptare.size() > 0){
                for (int i = 0; i < 1; i++){
                    listaParticipanti.add(listaParticipantiInAsteptare.get(0));
                    listaParticipantiInAsteptare.remove(i);
                    System.out.println(listaParticipanti.get(4).getName() + " ai fost mutat pe lista de participanti");
                }
            }
            return true;
        }
        return false;
    }

    public Guest removeDupaNumeDeFamilie (String lastName){
        for (int i = 0; i < this.listaParticipanti.size(); i++){
            Guest invitatInscris = listaParticipanti.get(i);
            if (listaParticipanti.get(i).getLastName().equalsIgnoreCase(lastName)){
                System.out.println("Ai fost sters de pe lista.");
                eliminarePersoana(invitatInscris);
                return invitatInscris;
            }
        }
        for (int i = 0; i < this.listaParticipantiInAsteptare.size(); i++){
            Guest invitatInAsteptare = listaParticipantiInAsteptare.get(i);
            if (listaParticipantiInAsteptare.get(i).getLastName().equalsIgnoreCase(lastName)){
                System.out.println("Esti inscris pe lista de asteptare");
                return invitatInAsteptare;
            }
        }
        System.out.println("Persoana cu numele de familie " + lastName + " nu este inscrisa pe nicio lista");
        return null;
    }

    public Guest removeDupaPrenume (String firstName){
        for (int i = 0; i < this.listaParticipanti.size(); i++){
            Guest invitatInscris = listaParticipanti.get(i);
            if (listaParticipanti.get(i).getFirstName().equalsIgnoreCase(firstName)){
                System.out.println("Ai fost sters de pe lista.");
                eliminarePersoana(invitatInscris);
                return invitatInscris;
            }
        }
        for (int i = 0; i < this.listaParticipantiInAsteptare.size(); i++){
            Guest invitatInAsteptare = listaParticipantiInAsteptare.get(i);
            if (listaParticipantiInAsteptare.get(i).getFirstName().equalsIgnoreCase(firstName)){
                System.out.println("Esti inscris pe lista de asteptare");
                return invitatInAsteptare;
            }
        }
        System.out.println("Persoana cu prenumele " + firstName + " nu este inscrisa pe nicio lista");
        return null;
    }

    public Guest removeDupaEmail (String email){
        for (int i = 0; i < this.listaParticipanti.size(); i++){
            Guest invitatInscris = listaParticipanti.get(i);
            if (listaParticipanti.get(i).getEmail().equalsIgnoreCase(email)){
                System.out.println("Ai fost sters de pe lista.");
                eliminarePersoana(invitatInscris);
                return invitatInscris;
            }
        }
        for (int i = 0; i < this.listaParticipantiInAsteptare.size(); i++){
            Guest invitatInAsteptare = listaParticipantiInAsteptare.get(i);
            if (listaParticipantiInAsteptare.get(i).getEmail().equalsIgnoreCase(email)){
                System.out.println("Esti inscris pe lista de asteptare");
                return invitatInAsteptare;
            }
        }
        System.out.println("Persoana cu emailul " + email + " nu este inscrisa pe nicio lista");
        return null;
    }

    public Guest removeDupaNumarTelefon (String numarTelefon){
        for (int i = 0; i < this.listaParticipanti.size(); i++){
            Guest invitatInscris = listaParticipanti.get(i);
            if (listaParticipanti.get(i).getPhoneNumber().equalsIgnoreCase(numarTelefon)){
                System.out.println("Ai fost sters de pe lista.");
                eliminarePersoana(invitatInscris);
                return invitatInscris;
            }
        }
        for (int i = 0; i < this.listaParticipantiInAsteptare.size(); i++){
            Guest invitatInAsteptare = listaParticipantiInAsteptare.get(i);
            if (listaParticipantiInAsteptare.get(i).getPhoneNumber().equalsIgnoreCase(numarTelefon)){
                System.out.println("Esti inscris pe lista de asteptare");
                return invitatInAsteptare;
            }
        }
        System.out.println("Persoana cu numarul " + numarTelefon + " nu este inscrisa pe nicio lista");
        return null;
    }

    // 4. actualizare date persoana

    public void actualizareDate(Guest object) {
        System.out.println("Ce anume doriti sa modificati?\n" +
                "nume\n" +
                "prenume\n" +
                "email\n" +
                "numar de telefon\n"+
                "Daca doriti sa va intoarceti la meniul principal, tastati 'quit'");
        Scanner sc = new Scanner(System.in);
        String stopWord = "quit";
        String raspuns = sc.nextLine();
        while (!raspuns.equalsIgnoreCase(stopWord)) {
            if (raspuns.equalsIgnoreCase("nume")) {
                System.out.println("Care va fi noul nume?");
                String update = sc.nextLine();
                cautarePrinListeLastName(listaParticipanti, object, update);
                cautarePrinListeLastName(listaParticipantiInAsteptare, object, update);
            } else if (raspuns.equalsIgnoreCase("prenume")) {
                System.out.println("Care va fi noul prenume?");
                String update = sc.nextLine();
                cautarePrinListeFirstName(listaParticipanti, object, update);
                cautarePrinListeFirstName(listaParticipantiInAsteptare, object, update);
            } else if (raspuns.equalsIgnoreCase("email")) {
                System.out.println("Care va fi noul email?");
                String update = sc.nextLine();
                cautarePrinListeEmail(listaParticipanti, object, update);
                cautarePrinListeEmail(listaParticipantiInAsteptare, object, update);
            } else if (raspuns.equalsIgnoreCase("numar de telefon")) {
                System.out.println("Care va fi noul numar de telefon?");
                String update = sc.nextLine();
                cautarePrinListePhoneNumber(listaParticipanti, object, update);
                cautarePrinListePhoneNumber(listaParticipantiInAsteptare, object, update);
            } else {
                System.out.println("Nu ati introdus o comanda valida");
            }
            System.out.println("Introduceti o noua comanda pentru actualizarea datelor sau reveniti la meniul principal");
            raspuns = sc.nextLine();
        }
    }

    private void cautarePrinListeFirstName(ArrayList<Guest> lista, Guest object, String newFirstName){
        for (int i = 0; i < lista.size(); i++){
            if (lista.get(i) == object){
                object.setFirstName(newFirstName);
                System.out.println("Prenumele a fost actualizat cu succes.");
            }
        }
    }

    private void cautarePrinListeLastName(ArrayList<Guest> lista, Guest object, String newLastName){
        for (int i = 0; i < lista.size(); i++){
            if (lista.get(i) == object){
                object.setLastName(newLastName);
                System.out.println("Numele a fost actualizat cu succes.");
            }
        }
    }

    private void cautarePrinListeEmail(ArrayList<Guest> lista, Guest object, String newEmail){
        for (int i = 0; i < lista.size(); i++){
            if (lista.get(i) == object){
                object.setEmail(newEmail);
                System.out.println("Email a fost actualizat cu succes.");
            }
        }
    }

    private void cautarePrinListePhoneNumber(ArrayList<Guest> lista, Guest object, String newPhoneNumber){
        for (int i = 0; i < lista.size(); i++){
            if (lista.get(i) == object){
                object.setPhoneNumber(newPhoneNumber);
                System.out.println("Numarul de telefon a fost actualizat cu succes.");
            }
        }
    }

    // 5.
    public void printListaParticipanti(){
        for (int i = 0; i < listaParticipanti.size(); i++){
            System.out.println(listaParticipanti.get(i).getName() + " " +
                    listaParticipanti.get(i).getEmail() + " " +
                    listaParticipanti.get(i).getPhoneNumber());
        }
        if (listaParticipanti.size() == 0){
            System.out.println(listaParticipanti.size());
        }
    }

    // 6.
    public void printListaParticipantiInAsteptare(){
        for (int i = 0; i < listaParticipantiInAsteptare.size(); i++){
            System.out.println(listaParticipantiInAsteptare.get(i).getName() + " " +
                    listaParticipantiInAsteptare.get(i).getEmail() + " " +
                    listaParticipantiInAsteptare.get(i).getPhoneNumber());
        }
        if (listaParticipantiInAsteptare.size() == 0){
            System.out.println(listaParticipantiInAsteptare.size());
        }
    }

    // 7.
    public void printNumarLocuriRamase(int numarLocuri) {
        int numarLocuriRamase = 0;
        if (listaParticipanti.size() > 0) {
            numarLocuriRamase = numarLocuri - listaParticipanti.size();
            System.out.println("Au mai ramas " + numarLocuriRamase + " locuri");
        } else {
            System.out.println("Nu sunt participanti inscrisi.");
        }
    }


    // 8.
    public void printNumarPersoaneParticipante(){
        System.out.println(listaParticipanti.size());
    }

    // 9.
    public void printNumarPersoaneInAsteptare(){
        System.out.println(listaParticipantiInAsteptare.size());
    }


    // 10.
    public void printNumarTotalDePersoaneInscrisePeAmbeleListe(){
        System.out.println(listaParticipanti.size() + listaParticipantiInAsteptare.size());
    }

    // 11. il facem daca merge
    public void cautareDupaSubsir(){
        System.out.println("Introduceti subsirul pentru cautare.");
        Scanner sc = new Scanner(System.in);
        String subsir = sc.nextLine();
        ArrayList<String> filtru = new ArrayList<String>();
        for (int i = 0; i < listaParticipanti.size(); i++){
            if (listaParticipanti.get(i).getFirstName().toLowerCase().contains(subsir.toLowerCase())){
                filtru.add(listaParticipanti.get(i).getFirstName());
            }
            if (listaParticipanti.get(i).getLastName().toLowerCase().contains(subsir.toLowerCase())){
                filtru.add(listaParticipanti.get(i).getLastName());
            }
            if (listaParticipanti.get(i).getEmail().toLowerCase().contains(subsir.toLowerCase())){
                filtru.add(listaParticipanti.get(i).getEmail());
            }
            if (listaParticipanti.get(i).getPhoneNumber().contains(subsir)){
                filtru.add(listaParticipanti.get(i).getPhoneNumber());
            }
        }
        for (int i = 0; i < listaParticipantiInAsteptare.size(); i++){
            if (listaParticipantiInAsteptare.get(i).getFirstName().toLowerCase().contains(subsir.toLowerCase())){
                filtru.add(listaParticipantiInAsteptare.get(i).getFirstName());
            }
            if (listaParticipantiInAsteptare.get(i).getLastName().toLowerCase().contains(subsir.toLowerCase())){
                filtru.add(listaParticipantiInAsteptare.get(i).getLastName());
            }
            if (listaParticipantiInAsteptare.get(i).getEmail().toLowerCase().contains(subsir.toLowerCase())){
                filtru.add(listaParticipantiInAsteptare.get(i).getEmail());
            }
            if (listaParticipantiInAsteptare.get(i).getPhoneNumber().contains(subsir)){
                filtru.add(listaParticipantiInAsteptare.get(i).getPhoneNumber());
            }
        }
        System.out.println(filtru);
    }
}

