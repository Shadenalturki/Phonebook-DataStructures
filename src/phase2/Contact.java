
package phase2;
import java.util.Date;

public class Contact implements Comparable<Contact> {
    String name;
    String phonenumber;
    String emailaddress;
    String address;
    Date birthday; 
    String notes;
    LinkedList<Event> events ; 
   
    public Contact() {
        this.name = "";
        this.phonenumber = "";
        this.emailaddress = "";
        this.address = "";
        this.birthday = null;
        this.notes = "";
        events = new LinkedList<Event>();
    }

    public Contact(String name, String phonenumber, String emailaddress, String address, String birthday, String notes) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.emailaddress = emailaddress;
        this.address = address;
        this.birthday = new Date(birthday);
        this.notes = notes;
        events = new LinkedList<Event>();
    }

    @Override
    public String toString() {
        return "\nName: " + name +
                    "\nPhone Number: " + phonenumber +
                    "\nEmail Address: " + emailaddress +
                    "\nAddress: " +  address +
                    "\nBirthday: " + birthday +
                    "\nNotes: " + notes + 
                    "\nEvents : " + events.toString();

    }

    public boolean addEvent( Event e)
    {
        {
                if (! events.empty())
                {
                    events.findFirst();
                    for ( int i = 0 ; i < events.size ; i++)
                    {
                        if ((events.retrieve().dateAndTime.compareTo(e.dateAndTime) == 0))
                            return false;
                    }
                }
            events.insert(e);
            return true;
        }
    }

    public boolean removeEvent(String eTitle)
    {
        if (events.empty())
            return false;
       Event val = new Event();
       val.title = eTitle;
        if (events.search(val))
        {
            events.remove(val);
            return true;
        }
        return false;
    }
    
    @Override
    public int compareTo(Contact o) {
        try {
            return (this.name.compareToIgnoreCase(o.name));
        }
        catch (Exception e)
        {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    
    public int compareToPhone(String Phone) {
        try {
            return (this.phonenumber.compareToIgnoreCase(Phone));
        }
        catch (Exception e)
        {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    public int compareToEmail(String emailaddress) {
        try {
            return (this.emailaddress.compareToIgnoreCase(emailaddress));
        }
        catch (Exception e)
        {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    public int compareToAddress(String address) {
        try {
            return (this.address.compareToIgnoreCase(address));
        }
        catch (Exception e)
        {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    public int compareToBirthday(Date birthday) {
        try {
            return (this.birthday.compareTo(birthday) ) ;
        }
        catch (Exception e)
        {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    
    public int compareFirstName(String n) {
        try {
            String [] new_name = this.name.split(" ");
            return (new_name[0].trim().compareToIgnoreCase(n) ) ;
        }
        catch (Exception e)
        {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}

