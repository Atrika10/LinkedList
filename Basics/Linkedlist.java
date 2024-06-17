
public class Linkedlist {

    public static class node{
        int data;
        node next;

        public node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static node head = null;
    static node tail = null;
    static int size = 0;

    // print linkedlist
    public static void printLL(){
        // base case
        if(head == null){
            System.out.println("Linkedlist is empty");
            return;
        }

        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    // calulate size
    public static int sizeOfLL(node head){
        if(head == null){
            return 0;
        }
        node temp = head;
        while (temp != tail) {
            size++;
            temp = temp.next;
        }
        
        return ++size;  // for tail node
    }

    // add first
    public static void addFirst(int data){
        // create node
        node newNode = new node(data);

        // add node
        // base case
        if(head == null){   // this is the first node
            head = tail= newNode;
            return;
        }

        // normal case
        newNode.next = head;    // connect with prev head
        head = newNode;         // update head
    }

    public static void addLast (int data){
        // create node
        node newNode = new node(data);

        // add
            // base case
            if(head == null){
                head = tail = newNode;
                return ;
            }
            // normal add
            tail.next = newNode;
            tail = newNode ;

    }

    // Add in the middle
    public static void addInMiddle(int idx, int data){
        //step -1 create node
        node newNode  = new node(data);

        // if idx exixt then search for the prev elem
        if (size < idx) {
            System.out.println("index doesn't exist");
            return;
        }

        //step -2  search prev node
        node prev = searchPrevElem(idx);

        // step -3 add node in the right position
        newNode.next = prev.next;
        prev.next = newNode;

    }
    
    public static node searchPrevElem (int idx){
        node temp = head;   // it hold prev node of the given idx
        int count =0;       // track of the idx

        while (temp != null) {
            if(count == idx-1){ // found prev elem
                break;
            }

            temp = temp.next;
            count++;
        }

        return temp;
    }

    public static int removeFirst(){
        // base case
        if(head == null){
            System.out.println("LL is empty");
            return -1;
        }
        // if we have only one node
        int value = head.data;

        if(head.next == null){
            head = tail = null;
            return value;
        }
       
        head = head.next;       // if we have other node also 
        return value;
    }

    public static int removeLast(){
        if (head== null) {
            return -1;
        }else if (head.next == null) {
            int val = head.data;
            head = tail = null;
            return val;
        }

        // search prev node of tail node
        node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }

        // now temp is the prev elem of tail node
        int val = tail.data;
        temp.next = null;
        tail = temp;
        return val;
    }
    public static void main(String[] args) {
        Linkedlist ll = new Linkedlist();   // create an object of Linkedlist class
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addFirst(0);
        ll.addLast(10);
        ll.addLast(15);
        ll.printLL();
        System.out.println(ll.removeFirst());
        System.out.println();
        ll.printLL();
        System.out.println(ll.removeLast());
        ll.printLL();

    }
    
}
