public class Guest {

    private String lastName;
    private String firstName;
    private String email;
    private String phoneNumber;

    // Contructor pentru a initializa datele de mai sus
    public Guest(String lastName, String firstName, String email, String phoneNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // getteri si setteri necesari pentru interogari si altele
    public void setName(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }
}
