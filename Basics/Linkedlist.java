
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

    // print linkedlist
    public static void printLL(node head){
        // base case
        if(head == null){
            System.out.println("Linkedlist is empty");
            return;
        }

        node temp = head;
        while (temp !=tail) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.err.print(tail.data);
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
    public static void main(String[] args) {
        Linkedlist ll = new Linkedlist();   // create an object of Linkedlist class
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addFirst(0);
        ll.printLL(head);
    }
    
}
