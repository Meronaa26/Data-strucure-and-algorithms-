public class AlgoQuestion2PrintMiddleNode {
    public static void main(String[] args) {
        MySinglyLinkedList sll= new MySinglyLinkedList();
        for(int i=1; i<11;i++){
            sll.add(i);
        }
        sll.printNodes();
        System.out.println();
        printMiddle(sll);
    }
    public  static void printMiddle(MySinglyLinkedList sll){
        if(sll.isEmpty())throw new IllegalArgumentException();
        var singlJump=sll.head;
        var doubleJump=sll.head;
        while(doubleJump!=sll.tail && doubleJump.next!=sll.tail){
            singlJump=singlJump.next;
            doubleJump=doubleJump.next.next;
        }
        if(doubleJump==sll.tail)
            System.out.println(singlJump.value);
        else System.out.println(singlJump.value + " " +singlJump.next.value);
    }
}
