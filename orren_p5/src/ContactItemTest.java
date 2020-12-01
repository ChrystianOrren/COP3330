import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest {

    @Test
    public void creationFailsWithAllBlankValues(){
        ContactItem c = new ContactItem();
        ContactList cList = new ContactList();
        c.setFirstName("");
        c.setLastName("");
        c.setPhoneNumber("");
        c.setEmail("");
        cList.addNew(cList, c);
        assertEquals(0, cList.contactList.size());
    }
    @Test
    public void creationSucceedsWithBlankEmail(){
        ContactItem c = new ContactItem();
        ContactList cList = new ContactList();
        c.setFirstName("test");
        c.setLastName("test");
        c.setPhoneNumber("123-456-7890");
        c.setEmail("");
        cList.addNew(cList, c);
        assertEquals(1, cList.contactList.size());
    }
    @Test
    public void creationSucceedsWithBlankFirstName(){
        ContactItem c = new ContactItem();
        ContactList cList = new ContactList();
        c.setFirstName("");
        c.setLastName("test");
        c.setPhoneNumber("123-456-7890");
        c.setEmail("x@y.z");
        cList.addNew(cList, c);
        assertEquals(1, cList.contactList.size());
    }

    @Test
    public void creationSucceedsWithBlankLastName(){
        ContactItem c = new ContactItem();
        ContactList cList = new ContactList();
        c.setFirstName("test");
        c.setLastName("");
        c.setPhoneNumber("123-456-7890");
        c.setEmail("x@y.z");
        cList.addNew(cList, c);
        assertEquals(1, cList.contactList.size());
    }

    @Test
    public void creationSucceedsWithBlankPhone(){
        ContactItem c = new ContactItem();
        ContactList cList = new ContactList();
        c.setFirstName("test");
        c.setLastName("test");
        c.setPhoneNumber("");
        c.setEmail("x@y.z");
        cList.addNew(cList, c);
        assertEquals(1, cList.contactList.size());
    }

    @Test
    public void creationSucceedsWithNonBlankValues(){
        ContactItem c = new ContactItem();
        ContactList cList = new ContactList();
        c.setFirstName("test");
        c.setLastName("test");
        c.setPhoneNumber("123-456-7890");
        c.setEmail("x@y.z");
        cList.addNew(cList, c);
        assertEquals(1, cList.contactList.size());
    }

    @Test
    public void editingFailsWithAllBlankValues(){
        ContactList cList = new ContactList();
        ContactItem c = new ContactItem();
        c.setEmail("");
        c.setPhoneNumber("");
        c.setFirstName("test");
        c.setLastName("");
        cList.addNew(cList, c);
        assertEquals(1, cList.contactList.size());
        cList.editContact(cList, "","","","",0);
        assertEquals("test", cList.contactList.get(0).firstName);
    }

    @Test
    public void editingSucceedsWithBlankEmail(){
        ContactList cList = new ContactList();
        ContactItem c = new ContactItem();
        c.setEmail("");
        c.setPhoneNumber("");
        c.setFirstName("test");
        c.setLastName("");
        cList.addNew(cList, c);
        assertEquals(1, cList.contactList.size());
        cList.editContact(cList, "test1","test","123-456-7890","",0);
        assertEquals("test1", cList.contactList.get(0).firstName);
    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactList cList = new ContactList();
        ContactItem c = new ContactItem();
        c.setEmail("x@y.z");
        c.setPhoneNumber("123-456-7890");
        c.setFirstName("test");
        c.setLastName("test");
        cList.addNew(cList, c);
        assertEquals(1, cList.contactList.size());
        cList.editContact(cList, "","test1","123-456-7890","x@y.z",0);
        assertEquals("", cList.contactList.get(0).firstName);
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactList cList = new ContactList();
        ContactItem c = new ContactItem();
        c.setEmail("x@y.z");
        c.setPhoneNumber("123-456-7890");
        c.setFirstName("test");
        c.setLastName("test");
        cList.addNew(cList, c);
        assertEquals(1, cList.contactList.size());
        cList.editContact(cList, "test","","098-765-4321","z@x.y",0);
        assertEquals("", cList.contactList.get(0).lastName);
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactList cList = new ContactList();
        ContactItem c = new ContactItem();
        c.setEmail("x@y.z");
        c.setPhoneNumber("123-456-7890");
        c.setFirstName("test");
        c.setLastName("test");
        cList.addNew(cList, c);
        assertEquals(1, cList.contactList.size());
        cList.editContact(cList, "test","test","","z@x.y",0);
        assertEquals("", cList.contactList.get(0).phoneNumber);
    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactList cList = new ContactList();
        ContactItem c = new ContactItem();
        c.setEmail("x@y.z");
        c.setPhoneNumber("123-456-7890");
        c.setFirstName("test");
        c.setLastName("test");
        cList.addNew(cList, c);
        assertEquals(1, cList.contactList.size());
        cList.editContact(cList, "new","new","098-765-4321","z@x.y",0);
        assertEquals("new", cList.contactList.get(0).lastName);
    }

    @Test
    public void testToString(){

    }

}