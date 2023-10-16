package cs212_phonebookProject;



public class Event implements Comparable<Event> {
    String title;
    String date;
    String time;
    String location;
    LinkedList <String> contacts_names;

    public Event() {
        this.title = "";
        this.date = "";
        this.time = "";
        this.location = "";
        this.contacts_names = new LinkedList<String> ();
    }
    
    public Event(String title, String date, String time, String location, String contact) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
        this.contacts_names = new LinkedList<String> ();
        addContact(contact);
        // contacts_names.insertSort(contact);
    }

    public boolean addContact (String contact)
    {
        return contacts_names.insertSort(contact);
    }
    
    public boolean removeContact(String contact)
    {
            String removedName = contacts_names.remove(contact);
            if ( removedName != null)
                return true; 
            return false;
    }

    @Override
 
                
        public String toString() {
            String str ="\nEvent title: " + title +
                    "\nEvent date and time (MM/DD/YYYY HH:MM): " + date + " " + time +
                    "\nEvent location: " + location + "\n" +
                    "\nContacts names:   ";
            contacts_names.findFirst();
            while (!contacts_names.last());{
                 str+=contacts_names.retrieve() + "\n";
                 contacts_names.findNext(); 
                } 
            str+= contacts_names.retrieve() + "\n";
                //Hetaf: change print method 
            return str;
            }



    @Override
    public int compareTo(Event obj) {
      
            return (this.title.compareToIgnoreCase(obj.title));
       
    }

}