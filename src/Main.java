import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Guest Persoana(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduceti numele de familie.");
        String numeFamilie = sc.nextLine();
        System.out.println("Introduceti prenumele");
        String prenume = sc.nextLine();
        System.out.println("Introduceti adresa de email");
        String email = sc.nextLine();
        System.out.println("Introduceti numarul de telefon");
        String numarDeTelefon = sc.nextLine();
        Guest n1 = new Guest(numeFamilie,prenume,email,numarDeTelefon);
        return n1;
    }

    public static Guest checkPersoana(GuestList lista){
        Scanner sc = new Scanner(System.in);
        System.out.println("Alege o metoda prin care sa te autentifici, tastand:\n"+
                "nume\n"+
                "prenume\n"+
                "email;\n"+
                "numar de telefon");
        String raspuns = sc.nextLine();
        if (raspuns.equalsIgnoreCase("nume")){
            System.out.println("Introduceti numele.");
            String numeDeFamilie = sc.nextLine();
            return lista.checkLastName(numeDeFamilie);
            }
        else if (raspuns.equalsIgnoreCase("prenume")) {
            System.out.println("Introduceti prenumele");
            String prenume = sc.nextLine();
            return lista.checkFirstName(prenume);
        }
        else if (raspuns.equalsIgnoreCase("email")) {
            System.out.println("Introduceti email");
            String email = sc.nextLine();
            return lista.checkEmail(email);
        }
        else if (raspuns.equalsIgnoreCase("numar de telefon")) {
            System.out.println("Introduceti numar de telefon");
            String numar = sc.nextLine();
            return lista.checkPhoneNumber(numar);
        }
        return null;
        }

    public static Guest removePersoana(GuestList lista){
        Scanner sc = new Scanner(System.in);
        System.out.println("Alege o metoda prin care sa te autentifici, tastand:\n"+
                "nume\n"+
                "prenume\n"+
                "email\n"+
                "numar de telefon");
        String raspuns = sc.nextLine();
        if (raspuns.equalsIgnoreCase("nume")){
            System.out.println("Introduceti numele.");
            String numeDeFamilie = sc.nextLine();
            return lista.removeDupaNumeDeFamilie(numeDeFamilie);
        }
        else if (raspuns.equalsIgnoreCase("prenume")) {
            System.out.println("Introduceti prenumele");
            String prenume = sc.nextLine();
            return lista.removeDupaPrenume(prenume);
        }
        else if (raspuns.equalsIgnoreCase("email")) {
            System.out.println("Introduceti email");
            String email = sc.nextLine();
            return lista.removeDupaEmail(email);
        }
        else if (raspuns.equalsIgnoreCase("numar de telefon")) {
            System.out.println("Introduceti numar de telefon");
            String numare = sc.nextLine();
            return lista.removeDupaNumarTelefon(numare);
        }
        return null;
    }


    public static String comenzi() {
        String listaComenzi = "help - Afiseaza aceasta lista de comenzi\n" +
                "add - Adauga o noua persoana (inscriere)\n" +
                "check - Verifica daca o persoana este inscrisa la eveniment\n" +
                "remove - Sterge o persoana existenta din lista\n" +
                "update - Actualizeaza detaliile unei persoane\n" +
                "guests - Lista de persoane care participa la eveniment\n" +
                "waitlist - Persoanele din lista de asteptare\n" +
                "available - Numarul de locuri libere\n" +
                "guests_no - Numarul de persoane care participa la eveniment\n" +
                "waitlist_no - Numarul de persoane din lista de asteptare\n" +
                "subscribe_no - Numarul total de persoane inscrise\n" +
                "search - Cauta toti invitatii conform sirului de caractere introdus\n" +
                "quit - Inchide aplicatia";
        return listaComenzi;
    }

    public static void main(String[] args) {
        System.out.println("Inregistrare pentru participare eveniment");
        int numarMaximParticipanti = 5;
        GuestList listaInvitati = new GuestList(numarMaximParticipanti);
        Scanner sc = new Scanner(System.in);
        System.out.println("Pentru afisare lista comenzi disponibile, tastati 'help'.");
        String incepem = sc.nextLine();

        if (incepem.equalsIgnoreCase("help")) {
            System.out.println(comenzi());
        }
        String stopWord = "quit";
        String incepem2 = sc.nextLine();
        while (!incepem2.equalsIgnoreCase(stopWord)){
            if (incepem2.equalsIgnoreCase("add")){
                listaInvitati.adaugareInLista(Persoana());
            }

            else if (incepem2.equalsIgnoreCase("check")){
                listaInvitati.esteSauNuPeListe(checkPersoana(listaInvitati));
            }

            else if (incepem2.equalsIgnoreCase("remove")){
                listaInvitati.eliminarePersoana(removePersoana(listaInvitati));
            }

            else if (incepem2.equalsIgnoreCase("update")){
                listaInvitati.actualizareDate(checkPersoana(listaInvitati));
            }

            else if (incepem2.equalsIgnoreCase("guests")) {
               listaInvitati.printListaParticipanti();
            }

            else if (incepem2.equalsIgnoreCase("waitlist")) {
                listaInvitati.printListaParticipantiInAsteptare();
            }

            else if (incepem2.equalsIgnoreCase("guests_no")) {
                listaInvitati.printNumarPersoaneParticipante();
            }

            else if (incepem2.equalsIgnoreCase("waitlist_no")) {
                listaInvitati.printNumarPersoaneInAsteptare();
            }

            else if (incepem2.equalsIgnoreCase("available")) {
                listaInvitati.printNumarLocuriRamase(numarMaximParticipanti);
            }

            else if (incepem2.equalsIgnoreCase("subscribe_no")) {
                listaInvitati.printNumarTotalDePersoaneInscrisePeAmbeleListe();
            }

            else if (incepem2.equalsIgnoreCase("search")) {
                listaInvitati.cautareDupaSubsir();
            }

            else if (incepem2.equalsIgnoreCase("help")) {
                System.out.println(comenzi());
            }
            System.out.println();
            System.out.println("--Meniu Principal--\n"+
                    "Introduceti o noua comanda.");
            incepem2 = sc.nextLine();
        }
    }
}
