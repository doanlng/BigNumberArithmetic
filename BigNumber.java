/**
 * 
 * @author doanlng
 * @version 7/17
 *         Object Class that takes in sample inputs and puts them into a linked
 *         list
 */
public class BigNumber extends LinkedList {
    /**
     * constructor
     */
    public BigNumber() {
        super();
    }


    /**
     * Adds 2 bigNumbers together
     * 
     * @param n
     *            BigNumber we are adding to this
     * @return the sum of the two BigNumbers
     */
    public BigNumber bNadd(BigNumber n) {
        BigNumber newNum = new BigNumber();
        Node curr = this.tail().getPrev();
        Node other = n.tail().getPrev();
        boolean carryOver = false;
        int total = 0;
        while (curr.getElem() != null && other.getElem() != null) {
            total = (int)curr.getElem() + (int)other.getElem();
            if (carryOver) {
                total++;
                carryOver = false;
            }
            if (total > 9) {
                carryOver = true;
            }
            newNum.insertAtFront(total % 10);
            curr = curr.getPrev();
            other = other.getPrev();
        }
        if (curr.getElem() != null) {
            carryDown(curr, newNum, carryOver);
        }
        else if (other.getElem() != null) {
            carryDown(other, newNum, carryOver);
        }
        if (carryOver) {
            curr = curr.getPrev();
            // Cases where 2 lists of the same length add together to make a new
            // number of a different length
            if (total > 9 && this.size() == n.size()) {
                newNum.insertAtFront(1);
            }
        }
        return newNum;
    }


    /**
     * helper method for bNadd, this when we are carrying down when the numbers
     * are 2 different sizes
     * 
     * @param n
     *            node of the number that isn't null we left off
     * @param bn
     *            the total of the BigNumber we already have
     * @param b
     *            whether there is carryover left over
     */
    private void carryDown(Node n, BigNumber bn, boolean b) {
        int total = 0;
        while (n.getElem() != null) {
            total = (int)n.getElem();
            if (b) {
                total += 1;
                if (total > 9) {
                    b = true;
                }
                else {
                    b = false;
                }
            }
            bn.insertAtFront(total % 10);
            n = n.getPrev();
        }
        if (total == 10) {
            bn.insertAtFront(1);
        }
    }


    /**
     * Multiplies 2 BigNumbers together
     * 
     * @param n
     *            number we are multiplying by
     * @return product of these 2 big numbers
     */
    public BigNumber bNmult(BigNumber n) {
        Node other = n.tail().getPrev();
        BigNumber total = multHelper(new BigNumber(), other, 0);
        return total;
    }


    /**
     * helper for the multiplication method, where the recursion occurs
     * 
     * @param total
     *            - how much we have added onto our total
     * @param n
     *            - node of the number that is going to be multiplied by n
     * @param tens
     *            - how many 10s places we have to move over(for adding once the
     *            multiplication is done)
     * @return the product of 2 BigNumbers
     */
    private BigNumber multHelper(BigNumber total, Node n, int tens) {
        Node curr = this.tail().getPrev();
        if (n.getElem() != null) {
            BigNumber temp = new BigNumber();
            for (int i = 0; i < tens; i++) {
                temp.insertAtFront(0);
            }
            tens++;
            int product;
            int carry = 0;
            while (curr.getElem() != null) {
                product = (int)n.getElem() * (int)curr.getElem();
                if (carry != 0) {
                    product = product + carry;
                    carry = 0;
                }
                if (product > 9) {
                    carry = product / 10;
                    product = product % 10;
                }
                temp.insertAtFront(product);
                curr = curr.getPrev();
            }
            if (carry != 0) {
                temp.insertAtFront(carry);
            }
            total = total.bNadd(temp);
            return multHelper(total, n.getPrev(), tens);
        }
        else {
            return total;
        }
    }


    /**
     * Raises a BigNumber to a certain power
     * 
     * @param exp
     *            - how much we multiply by
     * @return total we have after exponentiating
     */
    public BigNumber bNexp(int exp) {
        BigNumber total = expHelper(this, exp);
        return total;
    }


    /**
     * Helps with exponentiation, where recursion is being done
     * 
     * @param num
     *            - BigNumber we are raising to a power
     * @param exp
     *            - power we are raising that number to
     * @return total we have after exponentiation
     */
    private BigNumber expHelper(BigNumber num, int exp) {
        if (exp == 2) {
            return num.bNmult(num);
        }
        else if (exp == 1) {
            return num;
        }
        else if (exp == 0) {
            BigNumber b = new BigNumber();
            b.add(1);
            return b;
        }
        else if (exp % 2 == 0) { // even case
            return expHelper(num.bNmult(num), exp / 2);
        }
        else { // odd
            return num.bNmult(expHelper(num.bNmult(num), (exp - 1) / 2));
        }
    }


    /**
     * @return newStr
     *         toString version of a bignumber, to be displayed on console
     */
    public String toString() {
        String[] str = super.toString().split(" <-> ");
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            newStr.append(str[i]);
        }
        return newStr.toString();

    }

}
