public class PalindromeLL {
    // Time complexity = O(n), where n = size of linkedlist
    // Space Complexity = O(1)
    public static boolean isPalindrome(){
        // cal size
        int sz =0;
        node temp = head;
        while (temp != null) {
            sz++;
            temp = temp.next;
        }

        // find mid
        int mid = sz/2;

        // traverse till mid & reverse the first half
        int i=0;
        node prev = null;
        node curr = head;
        node next = null;

        while (i < mid) {
            // reverse the first half
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }

        // prev node is pointing to the last node of first half
        // curr node is pointing to the first node of last half

        // if size is odd
        if(sz%2 !=0){
            curr = curr.next;
        }
        
        // Comparison step
        while (prev != null && curr != null) {
            if(prev.data != curr.data){
                return false;
            }else{
                prev = prev.next;
                curr = curr.next;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        PalindromeLL ll = new PalindromeLL();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(2);
        ll.addLast(1);

        ll.printLL();
        System.out.println(ll.isPalindrome());
    }
}
