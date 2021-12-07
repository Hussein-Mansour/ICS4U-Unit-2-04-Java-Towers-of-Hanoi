/*
* This program solves
* the Tower of Hanoi riddle.
*
* @author  Hussein
* @version 1.0
* @since   2021-12-5
*/

import java.util.Scanner;

/**
* This is the Tower of Hanoi program.
*/
final class TowersOfHanoi {
    /**
    * Declaring exponent variable.
    */
    public static final String SPACE = "\n";
    /**
    * Declaring exponent variable.
    */
    public static final String TOPEG = " to peg ";
    /**
    * Declaring exponent variable.
    */
    public static final String FROMPEG = " from peg ";

    /**
    * Prevent instantiation
    * Throw an exception IllegalStateException.
    * if this ever is called
    *
    * @throws IllegalStateException
    *
    */
    private TowersOfHanoi() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * Calculating...
    *
    * @param nOfDisks number of disks.
    * @param startPeg first.
    * @param auxPeg Mid.
    * @param endPeg last.
    */
    static void hanoi(final int nOfDisks, final int startPeg,
                       final int auxPeg, final int endPeg) {
        // This function calculates where the disks should be placed in
        if (nOfDisks == 1) {
            System.out.println("Move disk 1 from peg " + startPeg + TOPEG
                               + endPeg);
        } else {
            hanoi(nOfDisks - 1, startPeg, endPeg, auxPeg);
            System.out.println("Move disk " + nOfDisks + FROMPEG
                                + startPeg + TOPEG + endPeg);
            hanoi(nOfDisks - 1, auxPeg, startPeg, endPeg);
        }
    }

    /**
    * Starting... the main method
    *
    * @param args No args will be used
    */
    public static void main(final String[] args) {
        final int startPeg = 1;
        final int auxPeg = 2;
        final int endPeg = 3;

        System.out.println("Tower of Hanoi");

        // input
        final Scanner userInput = new Scanner(System.in);
        System.out.print(SPACE + "How many disks would you like");
        System.out.print(" in your tower (1 ->): ");

        try {
            final int nOfDisks = userInput.nextInt();
            System.out.println();
            if (nOfDisks > 0) {
                // process
                hanoi(nOfDisks, startPeg, auxPeg, endPeg);
            } else {
                System.out.println(SPACE + "Please enter a positive integer!");
            }
        } catch (java.util.InputMismatchException errorCode) {
            System.err.print(SPACE + "This is not an integer!" + SPACE);
        }
        System.out.print(SPACE + "Done." + SPACE);
    }
}
