
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// On my honor:
// - I have not used source code obtained from another student,
// or any other unauthorized source, either modified or
// unmodified.
//
// - All source code and documentation used in my program is
// either my original work, or was derived by me from the
// source code published in the textbook for this course.
//
// - I have not discussed coding details about this project
// with anyone other than my partner (in the case of a joint
// submission), instructor, ACM/UPE tutors or the TAs assigned
// to this course. I understand that I may discuss the concepts
// of this program with other students, and that another student
// may help me debug my program so long as neither of us writes
// anything during the discussion or modifies any computer file
// during the discussion. I have violated neither the spirit nor
// letter of this restriction.

/**
 * @version 7/17/21
 * @author doanlng <906241273>
 *         Primary driver for doing arithmetic with BigNumber
 */
public class BigNumArithmetic {
    /**
     * main method that takes in file args
     * 
     * @param args
     *            arguments specified when we run the program
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1) {
            throw new IllegalArgumentException(
                "Exactly one argument needed: file-input");
        }
        String inputFilePath = args[0];

        // We could do all this in a static way, but then we would
        // need to reset our static variables for every test!
        // Let's avoid that by using the object approach like so:

        BigNumArithmetic superCalc = new BigNumArithmetic();
        superCalc.printCalculations(inputFilePath);
    }


    /**
     * BigNumArithmetic object responsible for parsing file
     */
    public BigNumArithmetic() {
        // If I had any fields, I'd initialize them here
    }


    /**
     * prints the calculations to std out
     * 
     * @param filepath
     *            for file we are using
     */
    public void printCalculations(String filepath)
        throws FileNotFoundException {
        Scanner scanIn = new Scanner(new File(filepath));
        while (scanIn.hasNextLine()) {
            LinkedStack exp = new LinkedStack(); // expression is a linked list
                                                 // of bignumbers and operators
            String line = scanIn.nextLine();
            Boolean validEq = true;
            if (!(line.trim().isEmpty())) {
                String delimiters = "\\s+|\t";
                String[] words = line.trim().split(delimiters);
                BigNumber n = new BigNumber(); // will be the total
                for (int i = 0; i < words.length; i++) {
                    String word = words[i];
                    word = word.replaceFirst("^0*", "");
                    if (word.isEmpty()) {
                        word = "0";
                    }
                    System.out.print(word + " "); // echos word to output
                    if (Character.getNumericValue(word.charAt(0)) >= 0) {
                        exp.push(convertBN(word));
                    }
                    else if (checkValid(exp)) {
                        BigNumber x = (BigNumber)exp.pop().getElem();
                        BigNumber y = (BigNumber)exp.pop().getElem();
                        if (word.charAt(0) == '*') {
                            n = x.bNmult(y);
                        }
                        else if (word.charAt(0) == '+') {
                            n = x.bNadd(y);
                        }
                        else {
                            n = y.bNexp((Integer.parseInt(x.toString())));
                        }
                        exp.push(n);
                    }
                    else {
                        validEq = false;
                    }
                }
                System.out.print("=");
                if (validEq && exp.size() == 1) {
                    if ((int)((BigNumber)exp.peek()).head().getNext()
                        .getElem() == 0) {
                        System.out.print(" 0");
                    }
                    else {
                        System.out.print(" " + exp.pop().getElem().toString());
                    }
                }
                else {
                    System.out.print(" ");
                }
                System.out.print("\n");

            }
        }
        scanIn.close();
    }


    /**
     * converts string of numbers to BigNumber
     * 
     * @param num
     *            String we are reading from input file
     * @return b BigNumber filled with numbers from input file
     */
    private BigNumber convertBN(String num) {
        BigNumber b = new BigNumber();
        for (int i = 0; i < num.length(); i++) {
            b.add(Character.getNumericValue(num.charAt(i)));
        }
        return b;
    }


    /**
     * checks if the operator call is valid by seeing if there exists 2 or more
     * numbers on the stack
     * 
     * @param exp
     * @return
     */
    private boolean checkValid(LinkedStack exp) {
        return (exp.size() >= 2);
    }

}
