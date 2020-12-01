public class ContactItem {

    protected String firstName;
    protected String lastName;
    protected String phoneNumber;
    protected String email;

    protected void setFirstName(String fn){
        this.firstName = fn;
    }

    protected void setLastName(String ln){
        this.lastName = ln;
    }

    protected void setPhoneNumber(String pn){
        if(pn.charAt(3) == '-' && pn.charAt(7) == '-')
            this.phoneNumber = pn;
        else{
            System.out.println("WARNING: Incorrect phone number format");
        }
    }

    protected void setEmail(String em){
        this.email = em;
    }

    protected void addNew(ContactList cList, ContactItem temp){
        if(temp.firstName.length() == 0 && temp.lastName.length() == 0 && temp.phoneNumber.length() == 0 && temp.email.length() == 0){
            System.out.println("WARNING: Creation failed due to lack of information");
            return;
        }
        cList.contactList.add(temp);
    }

}
