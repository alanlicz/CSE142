public class SectionHW3 {
    public static void main(String[] args) {
        int x = 15;
        int y = 2;
        int z = 9;

        mystery(x, y, z);
        mystery(z, x, y);
        mystery(y, z, x);
    }

    public static void mystery(int a, int b, int c) {
        System.out.println("The " + a + " monkeys ate " + (b + c) + " bananas");
    }
}
