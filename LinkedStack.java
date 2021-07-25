import java.util.EmptyStackException;

/**
 * 
 * @author doanlng
 * @version 7/17
 *          Stack implementation with a linkedlist back end
 *          To be used for the backEnd of BigNumArithmetic
 *
 */
public class LinkedStack {
    // members
    private int size; // size of the stack
    private LinkedList li; // linked list backend of the stack
    private Node top; // top of the stack

    /**
     * Constructor
     */
    public LinkedStack() {
        size = 0;
        li = new LinkedList();
        top = null;
    }


    /**
     * pushes an object onto the stack
     * 
     * @param e
     *            obejct we are pushing
     */
    public void push(Object e) {
        li.add(e);
        size++;
        top = li.tail().getPrev();
    }


    /**
     * pops an element off the stack
     * 
     * @return element that was popped
     * @throws EmptyStackException
     *             if stack was empty when pop was called
     */
    public Node pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        else {
            size--;
            top = top.getPrev();
            return li.removeLast();
        }
    }


    /**
     * returns whether the stack is empty or not
     * 
     * @return true if the stack is empty
     *         false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * returns the top item of the stack
     * 
     * @return top
     *         top element of the stack
     */
    public Object peek() {
        return top.getElem();
    }


    /**
     * size
     * 
     * @return size of the stack
     */
    public int size() {
        return size;
    }


    /**
     * clears stack
     */
    public void clear() {
        li = null;
        size = 0;
        top = null;
    }
}
