package cs212_phonebookProject;


import java.util.Scanner;
public class Phonebook {

    /**
     * @param args the command line arguments
     */
    public static Scanner input = new Scanner (System.in);
    public static LinkedList <Contact> contacts = new LinkedList <Contact>();
    public static LinkedList <Event> events = new LinkedList <Event>();
    
    
    
    // 1. Add a contact
    public static void AddContact(){
    	   Contact c = new Contact();
           System.out.println("Enter the contact\'s name: ");
           c.name = input.nextLine();
        
        if (!contacts.empty() && contacts.search(c))
        {
                System.out.println("Contact found!");
                return;
        }
        System.out.print("Enter the contact's phone number:");
        c.phoneNumber = input.nextLine();
        
        if (!contacts.empty())
        {
            contacts.findFirst();
            for (int i = 0; i < contacts.size ; i++)
            {
                    if (contacts.retrieve().phoneNumber.compareTo(c.phoneNumber) == 0)
                    {
                            System.out.println("Contact found!");
                            return;
                    }
                    contacts.findNext();
            }
        }    
        System.out.print("Enter the contact's email address: ");
        c.emailAddress = input.nextLine();
        
        System.out.print("Enter the contact's address: ");
        c.address = input.nextLine();
        
        System.out.print("Enter the contact's birthday: ");
        c.birthday =input.nextLine();
        
        System.out.print("Enter any notes for the contact: ");
        c.notes = input.nextLine();
        
        if (contacts.insertSort(c))
            System.out.println("Contact added successfully!");
        
    }

    //2. Search for a contact
    public static void SearchContact(int n){
        int ch = n;
        if (contacts.empty())
            System.out.println("Contact not found!");
        else
        {
            contacts.findFirst();
            switch ( ch )
           {
               case 1:
               {
                    System.out.print("Enter the contact\'s name: ");
                    String name = input.nextLine();
                    
                    for (int i = 0; i < contacts.size ; i++)
                    {
                        if (contacts.retrieve().name.compareTo(name) == 0)
                        {
                            System.out.println("Contact found!");
                            System.out.println(contacts.retrieve());
                            break;
                        }
                        contacts.findNext();
                    }
               }
               break;

               case 2:
               {
                   System.out.print("Enter the contact's phone number:");
                   String phonenumber = input.nextLine();
                   
                    for (int i = 0; i < contacts.size ; i++)
                    {
                        if (contacts.retrieve().phoneNumber.compareTo(phonenumber) == 0)
                        {
                            System.out.println("Contact found!");
                            System.out.println(contacts.retrieve());
                            break;
                        }
                        contacts.findNext();
                    }
               }
               break;

               case 3:
               {
                   System.out.print("Enter the contact's email address: ");
                   String s=input.nextLine();
                   String emailaddress = input.nextLine();
                   
                    for (int i = 0; i < contacts.size ; i++)
                    {
                        if (contacts.retrieve().emailAddress.compareTo(emailaddress) == 0)
                        {
                            System.out.println("Contact found!");
                            System.out.println(contacts.retrieve());
                        }
                        contacts.findNext();
                    }
               }                
               break;

               case 4:
               {
                   System.out.print("Enter the contact's address: ");
                   String address = input.nextLine();
                   
                    for (int i = 0; i < contacts.size ; i++)
                    {
                        if (contacts.retrieve().address.compareTo(address) == 0)
                        {
                            System.out.println("Contact found!");
                            System.out.println(contacts.retrieve());
                        }
                        contacts.findNext();
                    }
               }
               break;

               case 5:
               {
                   System.out.print("Enter the contact's Birthday: ");
                   String birthday = input.next();
                   
                    for (int i = 0; i < contacts.size ; i++)
                    {
                        if (contacts.retrieve().birthday.compareTo(birthday) == 0)
                        {
                            System.out.println("Contact found!");
                            System.out.println(contacts.retrieve());
                        }
                        contacts.findNext();
                    }
               }
           }
        }            
    }
    
    //3. Delete a contact
    public static void DeleteContact(Contact c)
    {
       
        if (contacts.empty())
            System.out.println("Contact not found!");
        else
        {
            c = contacts.remove(c);
            if ( c == null)
                System.out.println("Contact not found!");
            else
            {
                if (! c.events.empty())
                {
                    c.events.findFirst();
                    for ( int i = 0 ; i < c.events.size ; i++)
                    {
                        Event e = c.events.retrieve();
                        if (events.search(e))
                        {
                            Event Update_Event = events.retrieve();
                            Update_Event.removeContact(c.name);
                            if (Update_Event.contacts_names.empty())
                            {
                                events.remove(e);
                                System.out.println("Delete event, No cantact particapate");
                            }
                            else
                                events.update(Update_Event);
                            
                        }
                        c.events.findNext();
                    }
                }
                System.out.println("Contact Deleted Successfully !");
                System.out.println(c);
            }    
        }        
    }
    
    //4. Schedule an event
    public static void ScheduleEvent()
    {
        Contact c = new Contact();
        Event e = new Event();
        
        boolean event_Updated = false;
        boolean Added_Event_To_Contact = false;
        
        System.out.print("Enter event title: ");
        e.title = input.nextLine();
        
        System.out.print("Enter contact name: ");
        c.name = input.nextLine();
        
        if ( ! contacts.empty() && contacts.search(c) == true)
        {
            System.out.print("Enter event date and time (MM/DD/YYYY HH:MM): ");
            e.date = input.next();
            
            System.out.print("Enter event location: ");
            e.location = input.nextLine();
            
            c = contacts.retrieve();
            Added_Event_To_Contact = c.addEvent(e);
            if (Added_Event_To_Contact)
            {
                // event added to contact
                contacts.update(c);
                if (!events.empty() && events.search(e))
                {
                    Event eventFound = events.retrieve();
                    if ((eventFound.date.compareTo(e.date)== 0 ) 
                            && (eventFound.time.compareTo(e.time)== 0 ) 
                            && (eventFound.location.compareTo(e.location)== 0 ))
                    {
                        eventFound.contacts_names.insertSort(c.name);
                        events.update(eventFound);
                        event_Updated = true;
                    }
                }
                if (! event_Updated)  
                {
                    e.contacts_names.insertSort(c.name);
                    events.insertSort(e);
                }
                System.out.println("Event scheduled successfully!   ");
            }
            else
                System.out.println("Contact has conflict Event !  ");
        }
        else
            System.out.println("Cantcat not found !");
        
    }
    
    //5. Print event details
    public static void PrintEvent(int n){
        int choice = n;
        switch ( choice )
        {
            case 1:
            {
                Contact c = new Contact();
                System.out.print("Enter the contact name :  ");
                c.name = input.nextLine();
                        
                if (! contacts.empty() )
                {
                  if (contacts.search(c) == true)
                  {
                    System.out.println("Contact found !");
                    c = contacts.retrieve();

                    c.events.findFirst();

                    for (int i = 0 ; i < c.events.size ; i++)
                    {
                        Event e = c.events.retrieve();
                        if (!events.empty() && events.search(e))
                            System.out.println(events.retrieve());
                        c.events.findNext();
                    }
                    if (c.events.empty())
                        System.out.println("No events found for this contact !");
                     }
                else
                    System.out.println("Contact not found !");
                }
                else
                    System.out.println("Contact not found !");
            }
            break;

            case 2:
            {
                Event e = new Event();
                System.out.print("Enter the event title:  ");
                e.title = input.nextLine();
                
                if (! events.empty() && events.search(e))
                {
                    System.out.println("Event found!");
                    System.out.println(events.retrieve());
                }
                else
                    System.out.println("Event not found !");
            }
            break;
        }
    }
    
    //6. Print contacts by first name
    public static void PrintContactsFirstName(String Pname){
   
        
        if (contacts.empty())
            System.out.println("No Contacts found !");
        /* 
         contacts.findFirst();
        for ( int i = 0 ; i < contacts.size ; i++)
        {
            String name = contacts.retrieve().name;
             
             */
        contacts.findFirst();
        for ( int i = 0 ; i < contacts.size ; i++)
        {
    
            String name = contacts.retrieve().name;
            String [] firstName = name.split(" ");


            if (firstName[0].compareToIgnoreCase(Pname) == 0)
                System.out.println(contacts.retrieve() + "\n");
            contacts.findNext();
        }
    }
    
    //7. Print all events alphabetically // O(n)
    public static void PrintAllEvents(){
        if (!events.empty())
        {
            events.findFirst();
            for (int i = 0 ; i < events.size ; i++)
            {
                System.out.println((i+1) + ". Event : " + events.retrieve().title);
                events.findNext();
            }
        }
        else
            System.out.println("No events found !");
    }
        
   
    }
        
