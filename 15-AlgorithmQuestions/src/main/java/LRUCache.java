import java.nio.channels.ScatteringByteChannel;
import java.util.HashMap;

public class LRUCache {

    //DNode
    public class DNode{
        int key;
        int value;
        DNode prev;
        DNode next;

        public DNode() {
        }


        public DNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache() {
    }

                                   // HasMap
                                   // int size
                                   // int capacity
    HashMap<Integer,DNode>cacheMap =new HashMap<>();
    int size;
    int capacity;
    DNode head;
    DNode tail;
                          //  constructor LRUCache

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size=0;
        this.head=new DNode();
        this.tail=new DNode();
        head.next=tail;
        tail.prev=head;
    }
                  //  AddNode
    public void addNode(DNode node){
        node.prev=head;
        node.next=head.next;

        head.next.prev=node;
        head.next=node;

    }
           // Remove
    public void removeNode(DNode node){
      DNode prev=node.prev;
      DNode next=node.next;

      prev.next=next;
      next.prev=prev;

    }
                // MoveToHead
    public void moveToHead (DNode node){
     removeNode(node);
     addNode(node);

    }

          //  popTail
          public DNode popTail(){
           DNode popped=tail.prev;
           removeNode(popped);
           return popped;

          }
            //  GET
    public int getNode(int key){
        DNode node=cacheMap.get(key);
       if(node==null)
        return -1;
       moveToHead(node);
        return node.value;
    }
            // PUT
            public void put(int key , int value){
              DNode node= cacheMap.get(key);
              if(node==null){
                  DNode newNode=new DNode(key,value);
                  cacheMap.put(key,newNode);
                  addNode(newNode);
                  size++;
                 if (size>capacity){
                     DNode tail=popTail();
                     cacheMap.remove(tail.key);
                     size--;
                 }

              }
            }
}
