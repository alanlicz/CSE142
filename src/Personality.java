// Alan Li
// 02/29/2020
// CSE142
// TA: Eric Koegler
// Assignment #7
//
// This program will read a file including personality test answer then output type of personality

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Personality {
    public static final int DIMENSION = 4;
    // class constant indicates how many dimensions of personality

    public static void main(String[] args) throws FileNotFoundException {
        printMessage();
        Scanner console = new Scanner(System.in);
        System.out.print("input file name? ");
        String inputFile = console.nextLine();
        System.out.print("output file name? ");
        String outputFile = console.nextLine();

        int[] bPercentage = new int[DIMENSION];
        String personality = "";
        File f = new File(inputFile);
        PrintStream out = new PrintStream(new File(outputFile));
        Scanner fileInput = new Scanner(f);

        while (fileInput.hasNextLine()){
            int[] aCount = new int[]{0, 0, 0, 0};
            int[] bCount = new int[]{0, 0, 0, 0};
            String name = fileInput.nextLine();
            out.print(name + ": ");
            String answer = fileInput.nextLine();
            splitLine(answer, aCount, bCount);
            int[] bPercentageValue = percentage(aCount, bCount, bPercentage, out);
            out.print(whichType(bPercentageValue, personality));
            out.println();

            // clears aCount and bCount for next person
        }
    }


    /**
     * print out the introduction message
     */
    public static void printMessage(){
        System.out.println("This program processes a file of answers to the");
        System.out.println("Keirsey Temperament Sorter. It converts the");
        System.out.println("various A and B answers for each person into");
        System.out.println("a sequence of B-percentages and then into a");
        System.out.println("four-letter personality type.");
        System.out.println();
    }

    /**
     * split the line into groups and let count method count the a and b in answer
     * @param line the answer line in the file
     * @param aCount the array that stores how many "a"s in each type of question
     * @param bCount the array that stores how many "b"s in each type of question
     */
    public static void splitLine(String line, int[] aCount, int[] bCount) {
        for (int i = 0; i <= 69; i += 7) {
            count(i, aCount, bCount, line, 0);
        }
        // count the answer for personality extrovert or introvert

        for (int i = 1; i <= 2; i++){
            for (int j = i; j <= 69; j += 7){
                count(j, aCount, bCount, line, 1);
            }
        }
        // count the answer for personality sensation or intuition

        for (int i = 3; i <= 4; i++){
            for (int j = i; j <= 69; j += 7){
                count(j, aCount, bCount, line, 2);
            }
        }
        // count the answer for personality thinking or feeling

        for (int i = 5; i <= 6; i++){
            for (int j = i; j <= 69; j += 7){
                count(j, aCount, bCount, line, 3);
            }
        }
        // count the answer for personality judging or perceiving
    }

    /**
     * count how many "a"s or "b"s
     * @param i indicate what kind of question is being processed
     * @param aCount the array that stores how many "a"s in each type of question
     * @param bCount the array that stores how many "b"s in each type of question
     * @param line the answer line in the file
     * @param type indicate the kind of question in the array
     */
    public static void count(int i, int[] aCount, int[] bCount, String line, int type) {
        String s = line.substring(i, i + 1).toLowerCase();
        if (s.equals("a")) {
            aCount[type]++;
        }
        else if (s.equals("b")) {
            bCount[type]++;
        }
    }

    /**
     * calculate the percentage of "b"s in total answer
     * @param aCount the array that stores how many "a"s in each type of question
     * @param bCount the array that stores how many "b"s in each type of question
     * @param bPercentage the array that store the percentage of "b"s in each type of question
     * @param out the output file
     * @return return the array that contains how many "b"s in a answer
     */
    public static int[] percentage(int[] aCount, int[] bCount, int[] bPercentage, PrintStream out){
        for (int i = 0; i <= bPercentage.length - 1; i++){
            double percentage = (double)bCount[i]/(aCount[i] + bCount[i])*100;
            int roundedPercent = (int)Math.round(percentage);
            bPercentage[i] = roundedPercent;
        }
        out.print(Arrays.toString(bPercentage));
        out.print(" = ");
        return bPercentage;
    }

    /**
     * return a string that contains the type of personality
     * @param bPercentage the array that store the percentage of "b"s in each type of question
     * @param personality the string that store the type of personality
     * @return return the string that contains types of personality
     */
    public static String whichType(int[] bPercentage, String personality) {
        String type = "EISNTFJP";
        for (int i = 0; i <= bPercentage.length - 1; i++) {
            int m = i * 2;
            // m indicates which letter(aka personality type) is being processed, since every
            // personality has two type, so m times two

            if (bPercentage[i] < 50) {
                personality += type.charAt(m);
            } else if (bPercentage[i] > 50) {
                personality += type.charAt(m + 1);
            } else {
                personality += 'X';
            }
        }
        return personality;
    }

}
