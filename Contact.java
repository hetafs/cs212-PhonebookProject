package cs212_phonebookProject;


public class Contact implements Comparable<Contact> {
    String contactName;
    String contactPhonenumber;
    String contactEmailaddress;
    String contactAddress;
    String contactBirthday; 
    String contactNotes;
    LinkedList<Event> events ; 
   
    public Contact() {
        contactName = "";
        contactPhonenumber = "";
        contactEmailaddress = "";
        contactAddress ="";
        contactBirthday = "";
        contactNotes = "";
        events = new LinkedList<Event>();
    }

   public Contact(String ContactName, String ContactPhonenumber, String ContactEmailaddress, String ContactAddress, String ContactBirthday, String ContactNotes) {
        this.contactName = ContactName;
        this.contactPhonenumber = ContactPhonenumber;
        this.contactEmailaddress = ContactEmailaddress;
        this.contactAddress = ContactAddress;
        this.contactBirthday = ContactBirthday;
        this.contactNotes = ContactNotes;
        events = new LinkedList<Event>();
    }

    @Override

    public String toString() {
        return "Contact{" + "ContactName=" + contactName + ", ContactPhonenumber=" + contactPhonenumber + ", ContactEmailaddress=" + contactEmailaddress + ", ContactAddress=" + contactAddress + ", ContactBirthday=" + contactBirthday + ", ContactNotes=" + contactNotes+'}';
    }
    
    
    public boolean hasConflict(Event e) {//this method will check if event has conflict 
  	  
    	events.findFirst();
        for (int i = 0; i < events.size; i++) {
            if  ((events.retrieve().date.compareTo(e.date) == 0)&&
            (events.retrieve().time.compareTo(e.time) == 0)){
                return true;
            }
        }
        return false;
  }

    
    public boolean addEvent( Event e) //add an event in sorted inseration
    {
        if (events.empty()|| !hasConflict(e))
        {
        		events.insertSort(e);
                return true;
            }
            return false;
      }
    
    /*    public boolean addEvent( Event e)         //option instead the tow apove methods
    {if (!events.empty()){
        events.findFirst();
        for (int i = 0; i < events.size; i++) {
            if  ((events.retrieve().date.compareTo(e.date) == 0)&&
            (events.retrieve().time.compareTo(e.time) == 0)){
                return false;
            }
        }}
        	events.insertSort(e);
        	return true;
      } */
    

    
    public boolean removeEvent( String eTitle)//remove an event if it exist
    {
        if (events.empty())
            return false;
        
       Event tmp = new Event();
       tmp.title=eTitle;
       
       Event removedEvent= events.remove( tmp );
    
           if( removedEvent!=null)
            return true;
        
        return false;
    }///i remove if statment for search since there is a one on the remove() method 
    
    
    //The Contact class should implement the Comparable interface contacts can be sorted by name
    @Override
    public int compareTo(Contact AnotherContact) {
        return contactName.compareTo(AnotherContact.contactName);}



}
