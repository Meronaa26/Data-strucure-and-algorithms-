public class AlgoQuestion1LRUCache {
    public static void main(String[] args) {
        LRUCache lru= new LRUCache(3);
        lru.put(1,1);
        lru.put(2,2);
        lru.put(3,3);
        System.out.println(lru.getNode(1));// access, makes(1,1) most recently used
        lru.put(4,4);//cache ={(4,4),(1,1)(3,3)}
        System.out.println(lru.getNode(2)); // return -1 because  it doesn't exist in cache
    }
}
