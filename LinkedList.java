
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * 
 * @author doanlng 906241273
 * @version 7/17
 *          Linked list class that will serve as the backend for the stack
 *          Implemented to be more efficient as part of a stack
 *          Uses phantom head and tail nodes for easy appending
 *          is doubly linked
 */
public class LinkedList {
    // members
    private int size;
    private Node head;
    private Node tail;

    /**
     * Constructor
     */
    public LinkedList() {
        tail = new Node(null); // create a phantom tail node
        head = new Node(null, tail); // create a phantom head node set next to
                                     // tail
        tail.setPrev(head); // set tail previous to head
        size = 0;
    }


    /**
     * adds an object to the end of the list
     * 
     * @param e
     *            object to be added
     */
    public void add(Object e) {
        if (e == null) {
            throw new IllegalArgumentException("Object is null");
        }
        else {
            Node nodeToAdd = new Node(e, tail);
            if (size == 0) { // if this is the first node with element
                head.setNext(nodeToAdd); // set head's next it
                tail.setPrev(nodeToAdd); // set tail's prev to it
                nodeToAdd.setPrev(head);
            }
            else {
                nodeToAdd.setPrev(tail.getPrev()); // make the new node's
                                                   // previous tail's previous
                tail.getPrev().setNext(nodeToAdd); // set tails previous node's
                                                   // next to the node we add
                tail.setPrev(nodeToAdd); // set tails previous to nodeToAdd
            }
        }
        size++; // increment size
    }


    /**
     * the size of the list
     * 
     * @return size how many nodes are in the list
     */
    public int size() {
        return size;
    }


    /**
     * removes an object from the last
     * 
     * @param e
     *            object element that we are trying to remove
     * @return true if we remove properly
     * @throws NoSuchElementException
     *             if element cannot be found in the list
     */
    public boolean remove(Object e) {
        Node current = head.getNext(); // create node marker in the list
        while (current.getElem() != null) {
            if (current.getElem().equals(e)) {
                if (current.getNext() != tail) { // If we are not at the tail
                                                 // node
                    current.setElem(current.getNext().getElem()); // copy the
                                                                  // next nodes
                                                                  // element
                                                                  // into this
                                                                  // one
                    current.setNext(current.getNext().getNext()); // skip over
                                                                  // the next
                                                                  // node
                    current.getNext().setPrev(current);
                    size--; // reduce the size
                }
                else {
                    this.removeLast();
                }
                return true;
            }
            current = current.getNext();
        }
        throw new NoSuchElementException();
    }


    /**
     * inserts a node at the front of the list
     * will help when we are reading BigNumbers
     * 
     * @param e
     *            object we are inserting to the front
     */
    public void insertAtFront(Object e) {
        if (e == null) {
            throw new IllegalArgumentException("Object is null");
        }
        else {
            Node newNode = new Node(e, null);
            head.getNext().setPrev(newNode);
            newNode.setNext(head.getNext());
            head.setNext(newNode);
            newNode.setPrev(head);
            size++;
        }

    }


    /**
     * removes last node from the list
     * 
     * @return node we are removing
     */
    public Node removeLast() {
        Node temp = tail.getPrev();
        tail.setPrev(temp.getPrev());
        temp.setNext(null);
        temp.setPrev(null);
        size--;
        return temp;
    }


    /**
     * Clears the list by resetting head, tail, and size
     */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }


    /**
     * formats list in string format in the form
     * a -> b -> c
     * 
     * @return str
     */
    public String toString() {
        StringBuilder str = new StringBuilder("");
        Node current = head.getNext();
        while (current.getElem() != null) {
            str.append(current.getElem());
            if (current.getNext() != tail) {
                str.append(" <-> ");
            }
            current = current.getNext();
        }

        return str.toString();
    }


    /**
     * @return true if the list is empty
     *         false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * @return head node
     */
    public Node head() {
        return head;
    }


    /**
     * @return tail node
     */
    public Node tail() {
        return tail;
    }


    /**
     * @return node at index i
     * @param i
     *            index
     */
    public Node get(int i) {
        Node curr = head.getNext();
        if (this.size == 0) {
            throw new EmptyStackException();
        }
        if (this.size != 1) {
            if (i > this.size / 2) {
                curr = tail.getPrev();
                for (int j = this.size - i; j > 0; j--) {
                    curr = curr.getPrev();
                }
            }
            else {
                for (int j = i; i > 0; i--) {
                    curr = curr.getNext();
                }
            }
        }
        return curr;
    }
}
