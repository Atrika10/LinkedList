// find & remove nth node from end of the linkedlist

//Approach -1 
/*
 * 1.Reverse the Linkedlist
 * 2.Traverse from head & delete nth node
 */

// Approach -2 
/*
 * 1. Calculate the position of nth node from first (size - n +1)
 * 2. Traverse from head & delete nth node
 */
public class RemoveNthNodeEnd {

    public class node{
        int data;
        node next;

        public node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static node head = null;
    public static node tail = null;

    public static int findRemoveNthNodeEnd(int n){
        // calculate the size of ll
        node temp = head;
        int sz =0;
        int val =0;
        while (temp != null) {
            sz++;
            temp = temp.next;
        }

        int idx = sz-n;    // cal idx of nth node from first (idx start from 0, 4th node is in 3rd index)
        // check index is valid
        if(idx < 0 || idx > sz){
            System.out.println("Invalid index");
            return -1;
        }

        // Corner case, if the nth node from end is head
        if (sz == n) {
            val = head.data;
            head = head.next;
            return val;
        }

        // traverse till prev node
        temp = head;
        node prev = null;
        int count =0;
        while (count < idx) {
            prev = temp;
            temp = temp.next;
            count++;
        }
        // after getting out from the loop, prev is pointing to n-1th node
         val = temp.data;
        prev.next = temp.next;
        return val;
    }
    public static void main(String[] args) {
        RemoveNthNodeEnd ll =  new RemoveNthNodeEnd();
        // ll.addFirst(0);
        // ll.addLast(12);
        // ll.addLast(25);
        // ll.addLast(83);
        // ll.addLast(42);
        // ll.addLast(65);

        // ll.printLL();
        // int ans = ll.findRemoveNthNodeEnd(6);
        // ll.printLL();
    }
    
}
