public class DoublyLL {
    public static class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;


    // addFirst
    public  void addFirst(int data){
        // create 
        Node newNode = new Node(data);
        size++;

        // base case
        if (head == null) {
            tail= head = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        newNode = head;

    }
    // addLast
    public void addLast(int data){
        // create
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            tail = head = newNode ;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // removeFirst

    public  int removeFirst(){
        if(head == null){
            return Integer.MIN_VALUE;
        }
        if (size == 1) { // means we have only 1 node
            int val = head.data;
            head = tail= null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    // removeLast
    public  int removeLast(){
        // base case
        if(head == null){
            return Integer.MAX_VALUE;
        }
        if(size == 1){
            int val = head.data;
            head = tail= null;
            size = 0;
            return val;
        }
        int val = tail.data;
        tail = tail.prev;
        tail.next = null;
        return val;
    }

    public void print(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();
        dll.addFirst(0);
        dll.addLast(1);
        dll.addLast(1);
        dll.addLast(1);
        dll.print();
        dll.removeFirst();
        dll.print();

    }
}
