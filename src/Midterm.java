// This program calculates and reports various statistics about the results of
//   a CSE142 midterm exam. 
//
// DEVELOPMENT NOTES:
// (These notes would not be in your program's comments. They are here
// to help you understand important topics or elements of this code.)
//
// Notice the use of arrays throughout the program, especially as parameters
//   and return values. Also notice the various array traversals.
import java.util.*;
import java.io.*;

public class Midterm {
   public static final int MAX_SCORE = 101;

   public static void main(String[] args) throws FileNotFoundException {
      Scanner console = new Scanner(System.in);
      System.out.print("Input file: " );
      String inFile = console.nextLine();
      Scanner input = new Scanner(new File(inFile));
      
      int[] scores = getScores(input);
      double mean = getMean(scores);
      int numAboveAvg = numAboveAvg(scores);
      int[] counts = getCounts(scores);
      int mode = getMode(counts);

      printStats(scores, counts, mean, numAboveAvg, mode);
   }
   
   // Reads in scores from the given Scanner and returns an array
   //   containing each individual score. Assumes the first value in
   //   the input is the number of scores to be read.
   //
   // Scanner input - the Scanner from which to read scores
   public static int[] getScores(Scanner input) {
      int[] scores = new int[input.nextInt()];
      for (int i = 0; i < scores.length; i++) {
         int nextScore = input.nextInt();
         scores[i] = nextScore;
      }
      return scores;   
   }
   
   // Computes and returns the mean score on the exam.
   //
   // int[] scores - the scores 
   public static double getMean(int[] scores) {
      int total = 0;
      
      for (int i = 0; i < scores.length; i++) {
         total += scores[i];
      }
      
      return (double) total / scores.length;
   } 

   // Computes and returns the number of scores above average.
   //
   // int[] scores - the scores 
   public static int numAboveAvg(int[] scores) {
      double average = getMean(scores);
      int count = 0;
      for (int i = 0; i < scores.length; i++) {
         if (scores[i] > average) {
            count++;
         }
      }
      return count;
   }
   
   // Computes and returns the number of times each individual score was
   //   earned on the exam.
   //
   // int[] scores - the individual exam scores
   public static int[] getCounts(int[] scores) {
      int[] counts = new int[MAX_SCORE + 1];
      
      for (int i = 0; i < scores.length; i++) {
         int score = scores[i];
         counts[score]++;
      }
      
      return counts;
   }
   
   // Computes and returns the mode (most common score) on the exam.
   //
   // int[] counts - the number of times each score was earned
   public static int getMode(int[] counts) {
      int maxIndex = 0;
      
      for (int i = 0; i < counts.length; i++) {
         if (counts[i] > counts[maxIndex]) {
            maxIndex = i;
         }
      }
      
      return maxIndex;
   }

   // Prints out the various computed statistics about the exam
   //
   // int[] scores - the scores on the exam
   // int[] counts - the number of times each score was earned   
   // double mean - the average score
   // int numAboveAvg - the number of scores above the mean
   // int mode - the most common score
   public static void printStats(int[] scores, int[] counts, double mean, int numAboveAvg, int mode) {
      System.out.println("Scores: " + Arrays.toString(scores));
      System.out.println("Counts: " + Arrays.toString(counts));
      System.out.println("Mean: " + mean);
      System.out.println("Scores above average: " + numAboveAvg);
      System.out.println("Mode: " + mode);
   }
}
