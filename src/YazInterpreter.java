// Alan Li
// 02/21/2020
// CSE142
// TA: Eric Koegler
// Assignment #6
//
// This program will either interpret a YazInterpreter program or execute single command line

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class YazInterpreter {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        printMessage();
        String answer = "";
        while (!answer.equals("q")) {
            System.out.print("(C)onsole YazInteractions, (I)nterpret .yzy program, (Q)uit? ");
            answer = input.nextLine().toLowerCase();
            if (answer.equals("c")) {
                System.out.println("YazInteractions session. Type END to exit.");
                interaction(input);
            }
            else if (answer.equals("i")) {
                interpret(input);
            }
        };
    }

    /**
     * print out the welcome message
     */
    public static void printMessage(){
        System.out.print("Welcome to the YazInterpreter!\n");
        System.out.print("You may interpret a YazLang program and output\n");
        System.out.print("the results to a .txt file or enter console YazInteractions\n");
        System.out.print("mode to run single commands of YazLang.\n");
        System.out.println();
    }


    /**
     * execute the command line that is input by the user
     * @param input the console that process the input
     */
    public static void interaction(Scanner input) {
        boolean flag = true;
        while(flag) {
            System.out.print("> ");
            String line = input.nextLine().toLowerCase();
            Scanner inputLine = new Scanner(line);
            if (line.contains("end")) {
                System.out.println();
                flag = false;
            }
            else {
                System.out.println(selectOps(line, inputLine));
            }
        }
    }

    /**
     * select which operator to execute
     * @param line the command line that is either in the file or in the input console
     * @param inputLine the scanner that process the line
     */
    public static String selectOps(String line, Scanner inputLine){
        String type = inputLine.next();
        // store the command so the nextInt or nextDouble can find the correct argument

        if (line.startsWith("convert")){
            double degree = inputLine.nextDouble();
            String unit = null;
            if (line.contains("f")){
                unit = "f";
            }
            else if (line.contains("c")){
                unit = "c";
            }
            return (convert(degree, unit));
        }
        else if (line.startsWith("range")){
            int startIndex = inputLine.nextInt();
            int endIndex = inputLine.nextInt();
            int step = inputLine.nextInt();
            return (range(startIndex, endIndex, step));
        }
        else{
            String result = "";
            while(inputLine.hasNext()){
                String wordQuo = inputLine.next();
                // the word with quotation mark

                String word = wordQuo.substring(1, wordQuo.length() - 1);
                // the word without the quotation mark

                int times = inputLine.nextInt();
                result = result + repeat(word, times);
            }
            return result;
        }
    }

    /**
     * convert the temperature unit
     * @param degree the temperature value
     * @param unit the temperature unit
     * @return the converted temperature
     */
    public static String convert(double degree, String unit){
        if (unit.equals("c")){
            degree = 1.8 * degree + 32;
            return (int)degree + "F";
        }
        else{
            degree = (degree - 32) / 1.8;
            return (int)degree + "C";
        }
    }

    /**
     * print a sequence of number start from starterIndex and end with endIndex with step value step
     * @param startIndex the sequence starts with startIndex
     * @param endIndex the sequence ends with endIndex
     * @param step the difference between every two numbers in the sequence
     * @return the string that contains the sequence
     */
    public static String range(int startIndex, int endIndex, int step){
        int i = startIndex;
        String result = "";
        while (i < endIndex){
            result = result + i + " ";
            i = i + step;
        }
        return result;
    }

    /**
     * repeat the string
     * @param word the word that needs to be repeated
     * @param times how many times the word needs to be repeated
     * @return the string that contains the repeated word
     */
    public static String repeat(String word, int times){
        word = word.replace("_", " ");
        String result = "";
        for (int i = 1; i <= times; i++){
           result = result + word;
        }
        return result;
    }

    /**
     * interpret the file and output the result to another file
     * @param input the scanner that receive the input and output file name
     * @throws FileNotFoundException for file not found error
     */
    public static void interpret(Scanner input) throws FileNotFoundException {
        File f = null;
        System.out.print("Input file name: ");
        boolean flag = true;
        // flag indicate if the user type in a file name that exists
        while(flag) {
            String inputFile = input.nextLine();
            f = new File(inputFile);
            if (f.exists()) {
                flag = false;
            }
            else{
                System.out.print("File not found. Try again: ");
            }
        }
        Scanner fileInput = new Scanner(f);
        System.out.print("Output file name: ");
        String outputFile = input.nextLine();
        PrintStream out = new PrintStream(new File(outputFile));

        while (fileInput.hasNextLine()){
            String commandLine = fileInput.nextLine().toLowerCase();
            Scanner inputLine = new Scanner(commandLine);
            out.println(selectOps(commandLine, inputLine));
        }
        System.out.println("YazLang program interpreted and output to .txt file!");
        System.out.println();
    }
}
