package cs212_phonebookProject;


public class LinkedList<T extends Comparable<T>> {
    
    private Node<T> head;
    private Node<T> current;
    int size;
    
    public LinkedList () {
        size = 0;
        head = current = null;
    }
    public boolean empty () {
        return head == null;
    }
    public boolean last () {
        return current.next == null;
    }
    public boolean full () {
            return false;
    }
    public void findFirst () {
            current = head;
    }
    public void findNext () {
            current = current.next;
    }
    public T retrieve () {
            return current.data;
    }
    public void update (T d) {
            current.data = d;
    }

    /* AnotherOOOpation
    public void sort_Aadd(T d){
        Node<T> Contact_= new Node<T>(d);
        //empty List
        
        if(head==null){
            head=current=Contact_;
        }
        else{
            //if the Node is smaller then the head we will insert it at First As head  
            if(((Contact)Contact_.data).compareTo((Contact)head.data)<0){
                Contact_.next=head;
                head=Contact_;}
            
            
            else{
                Node<T> pointer=head;
                Node<T> pointer_2=null;
                while(pointer!=null&&(((Contact)pointer.data).compareTo((Contact)Contact_.data)<=0)){
                    pointer_2=pointer;
                    pointer=pointer.next;}
                //now we add it at middlel or at last 
                pointer_2.next=Contact_;
                Contact_.next=pointer;}       
        }}
    public boolean insertSort (T d) {
           
            Node<T> tmp;
            if (empty()) {
                    current = head = new Node (d);
            }
            else {
                if ( head.getData().compareTo(d) >0)
                {
                    tmp = new Node(d);
                    tmp.setNext(head);
                    head = tmp;
                }
                else
                {
                    Node<T> prev = null;
                    current = head;
                    
                    while (( current != null ) && (current.getData().compareTo(d) <= 0))
                    {
                        prev = current;
                        current = current.getNext();
                    }
                    tmp = new Node (d);
                    if ( current != null)
                    {
                        tmp.next = current;
                        prev.next = tmp;
                        current = tmp;
                    }
                    else
                        current = prev.next =tmp;
                }
            }
            size++;
            return true;
    }
	
	

    public boolean search (T d) {
	    Node<T> serNode = head;
	    //we move through list until the end or a match =d is found
	    while (serNode != null && serNode.getData().compareTo(d) != 0) {
	    	serNode = serNode.getNext();
	    }
	    // if it's not null that's means that we found it we will return ture

	    if (serNode != null) {
	    	current=serNode ;
	        return true;
	    }
	    // we serch throw the whole list it is not exsist return false

	    return false;
	}  
    
    
    public T remove (T d) {
            
        if (!search (d) )
         return null;

        T data = current.getData();
        
        if (current == head) {
                head = head.next;
        }
        else {
                Node tmp = head;

                while (tmp.next != current)
                        tmp = tmp.next;
               tmp.next = current.next;
        }
        if (current.next == null)
                current = head;
        else
                current = current.next;
        size -- ;
        return data;    
    }

        public void display(){
        
            Node<T> Cueent_node= head;
            //we will let the  move until the end of list 
            while ( Cueent_node!= null)
            {
                System.out.print(Cueent_node.data +" ");
                Cueent_node = Cueent_node.next;
            }
            System.out.println();
        }
}
}
