package cs212_phonebookProject;

import java.util.Scanner;


public class main {
	public static Scanner input = new Scanner (System.in);
    public static void main (String[] args) {
        // TODO code application logic here
    	
    	int choice ;
    	int ch ;
    	do {
    	 System.out.println("\n Please choose an option:");
         System.out.println("1. Add a contact");
         System.out.println("2. Search for a contact");
         System.out.println("3. Delete a contact");
         System.out.println("4. Schedule an event");
         System.out.println("5. Print event details");
         System.out.println("6. Print contacts by first name");
         System.out.println("7. Print all events alphabetically");
         System.out.println("8. Exit");
         System.out.println("\nEnter your choice: ");
          choice = input.nextInt();
          input.nextLine();
          switch(choice) {
          case 1:
        	  Phonebook.AddContact();
        	  break;
          
          case 2:
        	  System.out.println("Enter search criteria:");
              System.out.println("1. Name");
              System.out.println("2. Phone Number");
              System.out.println("3. Email Address");
              System.out.println("4. Address");
              System.out.println("5. Birthday");
              System.out.println("\nEnter your choice: ");
              ch = input.nextInt();
              Phonebook.SearchContact(ch);
              break;
              
          case 3:
        	  Contact c = new Contact();
              System.out.print("Enter the contact\'s name: ");
              c.name = input.nextLine();
        	  Phonebook.DeleteContact(c);
        	  break;
              
          case 4:
        	  Phonebook.ScheduleEvent();
        	  break;
        	  
          case 5:
        	  System.out.println("Enter search criteria:");
              System.out.println("1. contact name");
              System.out.println("2. Event tittle");
              System.out.println("\nEnter your choice: ");
             
              ch = input.nextInt();
              Phonebook.PrintEvent(ch);
              break;
              
          case 6:

              System.out.print("Enter the first name:");
              String fname = input.nextLine();
        	  Phonebook.PrintContactsFirstName(fname);
        	  break;
          
          case 7:
        	  Phonebook.PrintAllEvents();
        	  break;
          }
          
          
  
          }while(choice!=8);
    	
    	
    }
}

