public class MainRecursion {
    public static void main(String[] args) {

        MainRecursion main = new MainRecursion();

        int factorial = main.factorial(10);
        System.out.println("Факториал: " + factorial);

        int fib = main.fib(15);
        System.out.println("Фибоначчи: " + fib);

    }

    public int fib(int value) {

        if (value == 0) {
            return 0;
        }

        if (value == 1 || value == 2) {
            return 1;
        }

        return fib(value - 1) + fib(value - 2);
    }

    public int factorial(int value) {
        return value <= 1
                ? 1
                : value * factorial(value - 1);
    }
}
