package cs212_phonebookProject;


public class Contact implements Comparable<Contact> {
    String name;
    String phoneNumber;
    String emailAddress;
    String address;
    String birthday; 
    String notes;
    LinkedList<Event> events ; 
   
    public Contact() {
       name = "";
        phoneNumber = "";
        emailAddress = "";
        address = "";
        birthday = "";
        notes = "";
        events = new LinkedList<Event>();
    }

    public Contact(String name, String phonenumber, String emailaddress, String address, String birthday, String notes) {
        this.name = name;
        this.phoneNumber = phonenumber;
        this.emailAddress = emailaddress;
        this.address = address;
        this.birthday =birthday;
        this.notes = notes;
        events = new LinkedList<Event>();
    }

    @Override
    public String toString() { 
        return "\nName: " + name +
                "\nPhone Number: " + phoneNumber +
                "\nEmail Address: " + phoneNumber +
                "\nAddress: " +  address +
                "\nBirthday: " + birthday +
                "\nNotes: " + notes + "\n";
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
    
    
    
    @Override
    public int compareTo(Contact o) {
       
            return (this.name.compareTo(o.name));
        
     
    }



}
