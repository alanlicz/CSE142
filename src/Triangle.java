public class Triangle {
    public static void main(String[] args){
        String result1 = printTriangleType(5, 7, 7);
        String result2 = printTriangleType(6, 6, 6);
        String result3 = printTriangleType(5, 7, 8);
        String result4 = printTriangleType(12, 18, 12);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }

    public static String printTriangleType(int a, int b, int c){
        String type = "";
        if (a == b && b == c){
            type = "equilateral";
        }
        else if (a == b || a == c || b == c){
            type = "isosceles";
        }
        else type = "scalene";
        return type;
    }
}
