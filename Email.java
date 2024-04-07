package emailAdmin;


import java.util.Scanner;

public class Email {

    //Initializing and encapsulating the required variables
    //encapsulation since it should not be manipulated by others
    private String firstName;
    private String lastName;
    private String password;
    private int defaultPasswordLength = 12;
    private String dept;
    private int defaultMailboxCap = 500;
    private String email;
    private String alternateEmail;
    private String companyname = "ayzcompany.com";

    // !!! BLUEPRINT FOR THE APP !!! ///

   /*
   1 Constructor to receive firstname and lastname
   2 get input department
   3 generate random password
   4 set mailboxCap capacity
   5 generate alternate email
   6 change password
    */

    //CONSTRUCTOR FOR FIRST NAME AND LAST NAME

    //DOCUMENTATION
    /* constructor is called when an object of a class is created.
    It can be used to set initial values for object

     'this' refers to class variable
      after = <refers to local variable passed in parameter>
     */

    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        //System.out.println("email created" +" "+this.firstName+" "+this.lastName);

        //call a method to ask for a department
        this.dept = setDept();
        //System.out.println("Department :"+" "+this.dept);

        //call a method to generate random password
        this.password = generatePass(defaultPasswordLength);
        //System.out.println("Password "+this.password);

        //generating email
        email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+dept+companyname;
        //System.out.println("Your email id is" +"-"+ email);
    }

    private String setDept() {
        System.out.println("Department:\n1 for HR\n2 for admin\n3 for development\n0 for none\nChoose your Dept");
        Scanner sc = new Scanner(System.in);
        int dept = sc.nextInt();
        if (dept == 1) {return "hr";}
        else if (dept == 2) {return "admin";}
        else if(dept == 3){return "dev";}
        else return "";
    }

    //Taking integer length for safety purposes if the requirement changes to change the
    //password length it will be easy to change from here rather than generating randomly
    private String generatePass(int length){
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#%*&abcdefghijklmnopqrstuvwxyz";
        char[] password = new char[length];
        for(int i =0; i<length; i++){
            int p = (int)(Math.random() * base.length());
            password[i] = base.charAt(p);
        }
        return new String(password);
    }

    //set mailbox capacity
    //mailbox capacity may be have to be changed
    //making it public
    //we are encapsulating the value here
    public void setmailboxcapacity(int capacity){
        this.defaultMailboxCap = capacity;
    }
    public int getmailboxcapacity(){
        return defaultMailboxCap;
    }


    //set alternate email
    //same as above
    public void setAlternateemail(String almail){
        this.alternateEmail = almail;
    }
    public String getAlternateEmail(){
        return alternateEmail;
    }

    //for changing password
    public void setchangepass(String password){
        this.password = password;
    }
    public String getchangepass(){
        return password;
    }
    public String allInformation(){
        return
                "Name: " + firstName +" "+lastName +
                       "\n"+ "Company Email: " + email +
                        "\n" + "Password: " +password +
                        "\n"+ "MailBox Capacity: "+ defaultMailboxCap +"mb";
    }
}
