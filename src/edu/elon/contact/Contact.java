package edu.elon.contact;

public class Contact {

    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String major;
    
    
    public Contact(String firstName, String middleName, String lastName, String email, String major){
    	this.firstName = firstName;
    	this.middleName = middleName;
    	this.lastName = lastName;
    	this.email = email;
    	this.major = major;
    }
    
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    
    @Override
    public String toString(){
        return("'" + firstName + "', '" + middleName + "', '" + lastName + "', '" +
    email + "', '" + major + "'");
    }
    
    
    
    
}
