import java.util.*;

public class Test{
    public static void main(String[] args){
        random();
    }

    public static String hashTag(String s1){
        char c1, c2;
        StringBuilder result = new StringBuilder("#");
        c1 = s1.charAt(0);
        c1 = Character.toUpperCase(c1);
        result.append(c1);
        for (int i = 1; i <= s1.length(); i++){
            c2 = s1.charAt(i);
            if (c2 != ' ') {
                if (s1.charAt(i - 1) == ' ') {
                    c2 = Character.toUpperCase(c2);
                }
                result.append(c2);
            }
        }
        return result.toString();
    }

    public static double stockMarket(Scanner console) {
        double container = 0;
        double increase = 0;
        double value = 0;
        int maxStock = 0;
        int maxDay = 0;
        double containerIncrease = 0;
        System.out.print("How many stocks? ");
        int stock = console.nextInt();
        System.out.print("How many days ");
        int days = console.nextInt();
        for (int i = 1; i <= stock; i++){
            System.out.printf("Stock %d: ", i);
            for (int j = 1; j <= days; j++){
                value = console.nextDouble();
                if (j == 1){
                    container = value;
                } else{
                    increase = value - container;
                    container = value;
                    if (increase > containerIncrease) {
                        containerIncrease = increase;
                        maxStock = i;
                        maxDay = j;
                    }

                }
            }
        }
        System.out.printf("Stock %d had greatest price increase of %.1f on day %d", maxStock,
                containerIncrease, maxDay);
        return increase;
    }

    public static void invest(double capital, double interest, int years){
        double sum = 0;
        double initial = capital;
        for (int i = 1; i <= years; i++){
            capital = capital * (1 + interest / 100);
            System.out.printf("After year %d: $%.2f\n", i, capital);
        }
        sum = capital - initial;
        System.out.printf("Total interest earned: $%.2f", sum);
    }

    public static void lucky(int number){
        int i = 1;

        Random r = new Random();
        int times = 0;
        while (i < 4){
            int dieResult = r.nextInt(6) + 1;
            System.out.printf("%d ", dieResult);
            if (dieResult <= number){
                i++;
            } else{
                i = 0;
            }
            times++;

        }
        System.out.println();
        System.out.printf("Finished after %d rolls.", times);

    }

    public static void purpleGold(Scanner input){
        int purpleNames = 0;
        int goldNames = 0;
        int purpleSum = 0;
        int goldSum = 0;
        int i = 1;
        while (input.hasNext()){
            String token = input.next();
            int num = input.nextInt();
            // System.out.print(token + " ");
            if (i % 2 == 0) {
                purpleNames++;
                purpleSum += num;
            }
            else{
                goldNames++;
                goldSum += num;
            }
            i++;
        }
        System.out.println(purpleNames + " purple, " + goldNames + " gold ");
        int diff = goldSum - purpleSum;
        diff = Math.abs(diff);
        System.out.println("Difference between purple team and gold team sums: " + diff);
    }

    public static void collapseSpaces(Scanner input){
        while (input.hasNextLine()){
            String line = input.nextLine();
            Scanner lineScan = new Scanner(line);
            while (lineScan.hasNext()){
                String token = lineScan.next();
                System.out.print(token + " ");
            }
            System.out.println();
        }
    }

    public static double calcMidterm(Scanner input){
        double sum = 0;
        int student = input.nextInt();
        while(input.hasNext()){
            sum += input.nextInt();
        }
        return sum/student;
    }

    public static void testInput(){
        String line = "CONVERT 0 C";
        Scanner inputLine = new Scanner(line);
        int degree = inputLine.nextInt();
        System.out.println(degree);
    }

    public static String range(int startIndex, int endIndex, int step){
        int i = startIndex;
        String result = "";
        while (i < endIndex){
            result = result + i + " ";
            i = i + step;
        }
        return result;
    }

    public static int findMin(int[] arr){
        int min = arr[0];
        for (int i = 0; i <= arr.length - 1; i++){
            min = Math.min(min, arr[i]);
        }
        return min;
    }

    public static int[] sum5(int[] arr){
        int[] sum = new int[5];
        for (int i = 0; i <= 4; i++){
            for (int j = 0; j <= arr.length - 1; j = j + 5){
                sum[i] += arr[j];
            }
        }
        return sum;
    }

    public static void point(){
        double percentage = (double)3/10*100;
        int roundedPercent = (int)Math.round(percentage);
        System.out.print(roundedPercent);
    }

    public static void random(){
        Random r = new Random();
        int number = r.nextInt(3) + 1;
        System.out.print(number);
    }
}