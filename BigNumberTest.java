
/**
 * 
 * @author doanlng
 *         test cases the bigNumber class
 * @version 7/17
 */
public class BigNumberTest extends student.TestCase {
    /**
     * fields
     */
    private BigNumber b;
    private BigNumber n;

    /**
     * setup
     */
    public void setUp() {
        b = new BigNumber();
        b.add(2);
        b.add(6);
        b.add(7);
        b.add(6);

        n = new BigNumber();
        n.add(5);
        n.add(4);
        n.add(7);

    }


    /**
     * test toString
     */
    public void testToString() {
        assertEquals(b.toString(), "2676");
    }


    /**
     * tests Add
     */
    public void testAdd() {
        assertEquals(b.bNadd(n).toString(), "3223");
        n.add(6);
        n.add(9);
        assertEquals(b.bNadd(n).toString(), "57445");
        b.add(2);
        b.add(7);
        b.add(3);
        assertEquals(b.bNadd(n).toString(), "2731042");
        n.add(1);
        n.add(1);
        assertEquals(b.bNadd(n).toString(), "8153184");
    }


    /**
     * testsAdd with a special carry case
     */
    public void testAddSpecialCarry() {
        BigNumber c = new BigNumber();
        c.add(9);
        c.add(7);
        c.add(3);
        c.add(2);
        c.add(4);
        assertEquals(c.bNadd(b).toString(), "100000");

        BigNumber d = new BigNumber();
        d.add(9);
        d.add(9);
        d.add(9);
        BigNumber e = new BigNumber();
        e.add(1);
        assertEquals(e.bNadd(d).toString(), "1000");

    }


    /**
     * tests Multiplication
     */
    public void testMultiplication() {
        BigNumber m = new BigNumber();
        m.add(4);
        assertEquals(b.bNmult(m).toString(), "10704");
        assertEquals(m.bNmult(b).toString(), "10704");
        m.add(3);
        assertEquals(b.bNmult(m).toString(), "115068");
        m.add(6);
        assertEquals(b.bNmult(m).toString(), "1166736");
        m.add(7);
        assertEquals(b.bNmult(m).toString(), "11686092");
        m.add(9);
        assertEquals(b.bNmult(m).toString(), "116885004");

    }


    /**
     * tests a variety of special cases in addition but uses different numbers
     */
    public void testSpecial() {
        BigNumber x = new BigNumber();
        BigNumber t = new BigNumber();
        x.add(5);
        t.add(5);
        assertEquals(t.bNadd(x).toString(), "10");
        t.remove(5);
        x.remove(5);

        x.add(9);
        t.add(6);
        assertEquals(t.bNadd(x).toString(), "15");

        x.remove(9);
        x.add(2);
        assertEquals(t.bNadd(x).toString(), "8");

        x.removeLast();
        t.removeLast();

        t.add(3);
        x.add(6);
        assertEquals(t.bNadd(x).toString(), "9");

    }


    /**
     * tests exponentiation
     */
    public void testExp() {
        assertEquals(b.bNexp(2).toString(), "7160976");

        BigNumber y = new BigNumber();
        y.add(4);
        assertEquals(y.bNexp(4).toString(), "256");
        assertEquals(y.bNexp(5).toString(), "1024");
        assertEquals(y.bNexp(8).toString(), "65536");
        y.add(3);
        assertEquals(y.bNexp(8).toString(), "11688200277601");
        assertEquals(y.bNexp(3).toString(), "79507");
        assertEquals(y.bNexp(0).toString(), "1");

    }

}
