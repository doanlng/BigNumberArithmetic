# BigNumberArithmetic
BigNumberArithmetic is essentially a calculator that allows for the adding, multiplication, and division of numbers past the 32 bit limit imposed by standard java ints
It uses linear data structures to hold the numbers together and read the expressions to be calculated.

From SampleInput.txt, we can see that expressions are written in reverse polish notation, so each expression lists its operators, followed by its operands.

For example,
    2 2 + reads 2 + 2
    2 2 + 3 * reads (2 + 2) * 3
    
The program is an implementation of a project from a data structures and algorithms class which focuses on algorithmic efficiency and effective use of popular data structures.  In this instance, reading the expressions was implemented with a stack, while numbers were implemented using a linked list. 
