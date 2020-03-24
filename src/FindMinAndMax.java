// A program to read in exactly 5 real numbers from a file and find
//   the minimum and maximum values read.  Assumes the file contains at
//   least five number and no other tokens.
//
// Note the use of Scanner to read from a file instead of from the 
//   user, the "throws" clause in the header of main, and the algorithm
//   to find a minimum or maximum.
import java.util.*;
import java.io.*;

public class FindMinAndMax {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("numbers.txt"));

        double number = input.nextDouble();
        System.out.println("Read number: " + number);

        double min = number;
        double max = number;
        int count = 1;

        while (input.hasNextDouble()) {
            number = input.nextDouble();
            count++;
            System.out.println("Read number: " + number);

            if (number > max) {
                max = number;
            }
            if (number < min) {
                min = number;
            }
        }

        System.out.println();
        System.out.println("Read " + count + " numbers.");
        System.out.println("Maximum value: " + max);
        System.out.println("Minimum value: " + min);
    }
}