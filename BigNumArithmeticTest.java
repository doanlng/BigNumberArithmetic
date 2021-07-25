import java.io.FileNotFoundException;

/**
 * 
 * @author doanlng
 * @version 7/17
 *          test class for bigNumArithmetic
 */
public class BigNumArithmeticTest extends student.TestCase {
    /**
     * fields
     */
    private BigNumArithmetic calc;

    /**
     * sets up
     */
    public void setUp() {
        calc = new BigNumArithmetic();
    }


    /**
     * tests the print calc of BigNumArithmetic
     */
    public void testPrintCalc() {
        try {
            calc.printCalculations("SampleInput2.txt");
        }
        catch (FileNotFoundException f) { 
            System.out.print("File not found");
        }
        try {
            calc.printCalculations("SampleInput1.txt");
        }
        catch (FileNotFoundException f) {
            assertNotNull(f);
        }
    }
}
