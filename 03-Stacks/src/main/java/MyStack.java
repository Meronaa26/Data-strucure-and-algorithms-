import java.util.NoSuchElementException;

public class MyStack <T> {
    private Node<T> bottom;
    private Node<T> top;
    private int size;

    public void push (T item) {
        Node<T> node=new Node(item);
        if (isEmpty()) bottom=top=node;
        else {
            top.setNext(node);
            top=node;
        }
        size++;
    }

    public boolean isEmpty() { return bottom==null; }

    public T peek() {return (T) top.getValue();}

    public T pop() {
        Node peekNode;
        if(isEmpty()) throw new NoSuchElementException();
        if(top==bottom) { //one node
            peekNode=bottom;  // why do we assign in here
            bottom=top=null;
        }
        else{  // if we have more than one node
            peekNode=top;   //assign top to peek
            Node<T> previous=getPrevious(top); // the node before the top
            top=previous;   // now top is the previous
            top.setNext(null);  // just in my words==> assigning the top to a new node and assign the previous to top then deleting the top
        }
        size--;
        return (T) peekNode.getValue();
    }

    private Node getPrevious(Node node) {
        Node<T> current=bottom;
        while(current!=null){
            if(current.getNext()==node) return current;
            current=current.getNext();
        }
        return null;
    }

    public int size() {return size;}


}
