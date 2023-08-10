public class FindMiddleNode {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node Head;
    public static Node Tail;
    public static int size;

   
    public static Node findMidNode(){
        if (Head == null) {
            return Head;
        }
        Node slow = Head;
        Node fast = Head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // increase slow pointer by 1
            fast = fast.next.next; //increase fast pointer by 2
        }
        // after getting out from the loop, I'm standing middle Node which is indicated by slow pointer
        return slow;
    }

    public static void main(String[] args) {
        
    }
}
