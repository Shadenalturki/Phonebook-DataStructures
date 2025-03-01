
package phase2;
import java.util.Date;

public class Event implements Comparable<Event> {
    String title;
    String dateAndTime;
    String location;
    boolean EventType;  // event true , appointment = false;
    LinkedList <String> contacts_names;

    public Event() {
        this.title = "";
        this.dateAndTime = "";
        this.location = "";
        this.EventType = true;
        this.contacts_names = new LinkedList<String> ();
    }
    
    public Event(String title, String dateAndTime,  String location, boolean t, String contact) {
        this.title = title;
        this.dateAndTime = dateAndTime;
        this.location = location;
        this.EventType =t;
        this.contacts_names = new LinkedList<String> ();
        contacts_names.insert(contact);
    }

    public boolean addContact (String contact)
    {
        if ((this.EventType == true) || ((this.EventType == false)&&(contacts_names.size == 0)))
            return contacts_names.insert(contact);
        
        System.out.println("Could not add more than contact for an appoinment");
        return false;
    }

    public boolean removeContact(String contact)
    {
            String name = contacts_names.remove(contact);
            if ( name != null)
                return true; 
            return false;
    }
 
    @Override
    public String toString() {
        String EventT = (this.EventType == true)? "Event ": "Appoinment ";     
        String str = "\n" + EventT + "title: " + title +
                    "\nContacts names: " + contacts_names.toString() +
                    "\n" + EventT + "date and time (MM/DD/YYYY HH:MM): " + dateAndTime +
                   "\n" + EventT + "location: " + location ;
                
          return str;
    }
    
    @Override
    public int compareTo(Event obj) {
        try {
            return (this.title.compareToIgnoreCase(obj.title));
        }
        catch (Exception e)
        {
             //To change body of generated methods, choose Tools | Templates.
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    public boolean compareToSameEvent(Event obj) {
        try {
            return ((this.title.compareToIgnoreCase(obj.title) == 0) && 
                    (this.dateAndTime.compareTo(obj.dateAndTime) == 0)  && (this.EventType == obj.EventType));
        }
        catch (Exception e)
        {
             //To change body of generated methods, choose Tools | Templates.
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    
}

