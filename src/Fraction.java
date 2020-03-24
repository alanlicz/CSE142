public class Fraction {
    public static void main(String[] args){
        double result = fractionSum(5);
        System.out.print(result);
    }

    public  static double fractionSum(int n){
        double sum = 0;
        for (double i = 1; i <= n; i++){
            sum = sum + 1/i;
        }
        return sum;
    }
}
