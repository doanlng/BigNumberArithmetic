
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * 
 * @author doanl
 * @version 7/17
 *          testing linked list and node classes
 */
public class LinkedListNodeTest extends student.TestCase {
    // test field
    private LinkedList li;

    /**
     * set up
     */
    public void setUp() {
        li = new LinkedList();
    }


    /**
     * testing add and size methods
     */
    public void testAddandSize() {
        assertEquals(li.size(), 0);
        assertTrue(li.isEmpty());

        li.add(4);
        assertNotNull(li.head());
        assertNotNull(li.tail());
        assertEquals(li.size(), 1);
        assertFalse(li.isEmpty());

        li.add(5);
        assertEquals(li.size(), 2);
        assertEquals(li.toString(), "4 <-> 5");
        Exception e = null;
        try {
            li.add(null);
        }
        catch (IllegalArgumentException elem) {
            e = elem;
        }
        assertNotNull(e);
    }


    /**
     * testing equals method for node
     */
    public void testNodeEquals() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        assertFalse(n1.equals(n2));
        n2.setElem(1);
        assertTrue(n2.equals(n1));
        assertTrue(n1.equals(n1));
        assertFalse(n1.equals(new Object()));
        Node n3 = null;
        assertFalse(n1.equals(n3));
    }


    /**
     * testing clear and remove
     */

    public void testClearRemove() {
        li.add(1);
        li.add(2);
        li.add(3);
        li.add(4);
        assertEquals(li.head().getNext().getElem(), 1);
        assertEquals(li.tail().getPrev().getElem(), 4);
        assertTrue(li.remove(3));
        li.add(3);
        System.out.print(li.toString());
        Exception e = null;
        try {
            li.remove("apple");
        }
        catch (NoSuchElementException elem) {
            e = elem;
        }
        assertNotNull(e);

        assertTrue(li.remove(3));

        li.clear();
        assertTrue(li.isEmpty());
        assertEquals(li.size(), 0);

    }


    /**
     * tests get method
     */
    public void testGet() {
        Exception elem = null;
        try {
            li.get(0);
        }
        catch (EmptyStackException e) {
            elem = e;
        }
        assertNotNull(elem);
        li.add(1);
        li.get(0);
        li.add(2);
        li.add(3);
        li.add(4);
        li.add(5);
        assertEquals(li.get(0).getElem(), 1);
        assertEquals(li.get(4).getElem(), 4);
        assertEquals(li.get(2).getElem(), 3);

        li.insertAtFront(9);
        assertEquals(li.get(0).getElem(), 9);

    }


    /**
     * tests inserting at the front
     */
    public void testInsert() {
        try {
            li.insertAtFront(null);
        }
        catch (IllegalArgumentException n) {
            assertNotNull(n);
        }
    }
}
