
/**
 * 
 * @author doanlng
 * @version 7/17
 *          Node class for linked list
 *          is doubly linked node which includes next and prev
 */
public class Node {

    // members
    private Object elem;
    private Node next;
    private Node prev;

    /**
     * Constructor
     * 
     * @param e
     *            element to be stored in node
     */
    public Node(Object e) {
        elem = e;
        next = null;
        prev = null;
    }


    /**
     * Constructor w/ next specified
     * 
     * @param e
     *            element to be stored in node
     * @param n
     *            pointer to the next node
     */
    public Node(Object e, Node n) {
        elem = e;
        next = n;
    }


    /**
     * sets next node
     * 
     * @param n
     *            target node
     */
    public void setNext(Node n) {
        next = n;
    }


    /**
     * sets element of a node
     * 
     * @param e
     *            new data for node
     */
    public void setElem(Object e) {
        elem = e;
    }


    /**
     * gets next
     * 
     * @return n next node
     */
    public Node getNext() {
        return next;
    }


    /**
     * gets elem
     * 
     * @return elem data in node
     */
    public Object getElem() {
        return elem;
    }


    /**
     * sets prev node pointer
     * 
     * @param p
     *            node we are setting
     */
    public void setPrev(Node p) {
        prev = p;
    }


    /**
     * gets next
     * 
     * @return n next node
     */
    public Node getPrev() {
        return prev;
    }


    /**
     * equals method
     * 
     * @param o
     *            object we are comparing the node to
     * @return true or false depending on the equality of the node elems
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        else if (o == null) {
            return false;
        }
        else if (this.getClass().equals(o.getClass())) {
            Node other = (Node)o;
            return this.getElem().equals(other.getElem());
        }
        else {
            return false;
        }

    }
}
