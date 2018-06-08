/**
 * Factorial
 */
public class Factorial {
    public static void main(String[] args) {
        if (args.length == 1) {
            int n = Integer.parseInt(args[0]);
            print(iterate(n));
            print(recurse(n));
        } else {
            print(iterate(10));
            print(recurse(10));
        }
    }

    public static int iterate(int n) {
        int factorial = 1;
        
        for (int i = n; i > 0 && n > 1; i--) {
            factorial *= i;
        }
        return factorial;
    }

    public static int recurse(int n) {
        if (n < 2) return 1;
        return n * recurse(n - 1);
    }

    public static void print(int n) {
        System.out.println(n);
    }
}