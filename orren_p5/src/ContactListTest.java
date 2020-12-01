import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {
    @Test
    public void addingItemsIncreasesSize(){
        ContactList cList = new ContactList();
        ContactItem c = new ContactItem();
        c.setFirstName("test");
        c.setLastName("test");
        c.setPhoneNumber("123-456-7890");
        c.setEmail("x@y.z");
        assertEquals(0, cList.contactList.size());
        cList.addNew(cList, c);
        assertEquals(1, cList.contactList.size());
    }

    @Test
    public void editingItemsFailsWithAllBlankValues(){
        ContactList cList = new ContactList();
        ContactItem c = new ContactItem();
        c.setFirstName("test");
        c.setLastName("test");
        c.setPhoneNumber("123-456-7890");
        c.setEmail("x@y.z");
        cList.addNew(cList, c);
        cList.editContact(cList, "","","","",0);
        assertEquals("test", cList.contactList.get(0).firstName);
    }

    @Test
    public void editingItemsFailsWithInvalidIndex(){
        ContactList cList = new ContactList();
        ContactItem c = new ContactItem();
        c.setFirstName("test");
        c.setLastName("test");
        c.setPhoneNumber("123-456-7890");
        c.setEmail("x@y.z");
        cList.addNew(cList, c);
        assertThrows(IndexOutOfBoundsException.class, ()-> cList.editContact(cList, "test","","","", 99));
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
    public void newListIsEmpty(){
        ContactList cList = new ContactList();
        assertEquals(0, cList.contactList.size());
    }

    @Test
    public void removingItemsDecreasesSize(){
        ContactList cList = new ContactList();
        ContactItem c = new ContactItem();
        c.setFirstName("test");
        c.setLastName("test");
        c.setPhoneNumber("123-456-7890");
        c.setEmail("x@y.z");
        cList.addNew(cList, c);
        assertEquals(1, cList.contactList.size());
        cList.removeContact(0);
        assertEquals(0, cList.contactList.size());
    }

    @Test
    public void removingItemsFailsWithInvalidIndex(){
        ContactList cList = new ContactList();
        ContactItem c = new ContactItem();
        c.setFirstName("test");
        c.setLastName("test");
        c.setPhoneNumber("123-456-7890");
        c.setEmail("x@y.z");
        cList.addNew(cList, c);
        assertThrows(IndexOutOfBoundsException.class, ()-> cList.removeContact(99));
    }

    @Test
    public void savedContactListCanBeLoaded(){
        ContactList cList = new ContactList();
        cList.actualizeList("contactTest.txt", cList);
        assertEquals("test", cList.contactList.get(0).firstName);
        assertEquals("test", cList.contactList.get(0).lastName);
        assertEquals("123-456-7890", cList.contactList.get(0).phoneNumber);
        assertEquals("x@y.z", cList.contactList.get(0).email);
    }

}