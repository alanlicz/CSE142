// Alan Li
// 02/10/2020
// CSE142
// TA: Eric Koegler
// Assignment #5
//
// This program will create a guessing game

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static final int MAXNUM = 100;
    // MAXNUM is set to 100 by default

    public static void main(String[] args){
        Random r = new Random();
        Scanner console = new Scanner(System.in);
        haikuPoem();
        createGame(r, console);
    }

    /**
     * Print out the haiku poem
     */
    public static void haikuPoem(){
        System.out.println("Here we go again.");
        System.out.println("Guessing a number is truly fun.");
        System.out.println("Give it a try now.");
    }

    /**
     * Initialize the game and determine if game need to continue
     * @param r generates the random number
     * @param console create the console that receive input
     */
    public static void createGame(Random r, Scanner console){
        int totalGames = 1;
        int totalGuess = 0;
        int bestGame = 1000000;
        // Assume that no game will require one million or more guesses

        boolean flag = true;
        // Flag indicates if the game needs to continue or stop
        int randomNumber;
        int guessResult;

        while(flag){
            randomNumber = r.nextInt(MAXNUM) + 1;
            guessResult = makeGuess(console, randomNumber);
            totalGuess += guessResult;
            if (guessResult < bestGame){
                bestGame = guessResult;
            }
            // Determine if the game is the best game(least guess)
            System.out.print("Do you want to play again? ");
            String s1;
            s1 = console.next().toLowerCase();
            if (s1.charAt(0) == 'y'){
                flag = true;
                totalGames += 1;
            }
            else{
                flag = false;
            }
        }
        printStats(totalGames, totalGuess, bestGame);
    }

    /**
     * Play a guess game with user
     * @param console receive input
     * @param randomNumber the random number generates by r
     * @return numbers of the guess
     */
    public static int makeGuess(Scanner console, int randomNumber){
        System.out.println();
        System.out.printf("I'm thinking of a number between 1 and %d...\n", MAXNUM);
        int input = 0;
        int numGuesses = 0;
        while (input != randomNumber) {
            numGuesses++;
            System.out.print("Your guess? ");
            input = console.nextInt();
            if (input < randomNumber) {
                System.out.println("It's higher.");
            }
            else if (input > randomNumber) {
                System.out.println("It's lower.");
            }
            else {
                if (numGuesses == 1) {
                    System.out.print("You got it right in 1 guess!");
                }
                else {
                    System.out.printf("You got it right in %d guesses!\n", numGuesses);
                }
                }
            }
        return numGuesses;
    }

    /**
     * Print out the game statistic
     * @param totalGames Games that played with user
     * @param totalGuesses Guesses that user takes to guess all the numbers
     * @param bestGame The least number of guess that user takes to get the number
     */
    public static void printStats(int totalGames, int totalGuesses, int bestGame){
        double guessPerGames = (double)totalGuesses/totalGames;
        System.out.println();
        System.out.println("Overall results:");
        System.out.println("Total games   = " + totalGames);
        System.out.println("Total guesses = " + totalGuesses);
        System.out.printf("Guesses/game  = %.1f\n", guessPerGames);
        System.out.println("Best game     = " + bestGame);
    }
}
