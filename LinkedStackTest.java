
import java.util.EmptyStackException;
/**
 * 
 * @author doanlng 906241273
 * @version 7/17
 *  Is responsible for testing the linked stack class
 */
public class LinkedStackTest extends student.TestCase {
    //field
    private LinkedStack ls;
    /**
     * sets up
     */
    public void setUp() {
        ls = new LinkedStack();
    }

    /**
     * tests pop push and empty
     */
    public void testPopPushEmpty() {
        Exception e = null;
        try {
            ls.pop();
        }
        catch (EmptyStackException ex) {
            e = ex;
        }
        assertNotNull(e);
        ls.push("banana");
        assertFalse(ls.isEmpty()); // test push and empty
        assertEquals(ls.pop().getElem(), "banana"); // test
        assertTrue(ls.isEmpty());

        ls.push("banana");
        ls.push("pancake");
        assertEquals(ls.peek(), "pancake");
        assertEquals(ls.size(), 2);

        ls.clear();
        assertEquals(ls.size(), 0);
    }
}
