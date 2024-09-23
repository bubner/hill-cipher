public class Main {
    public static int[] extendedGcd(int a, int b) {
        if (b == 0) {
            // Base case, gcd(a,b) = ax + by = a*1 + b*0 = a
            return new int[]{a, 1, 0};
        }
        // Recursively find the GCD by the modulo property
        int[] ret = extendedGcd(b, a % b);
        // Calculate the new x and y used to calculate the GCD
        int tmp = ret[1] - ret[2] * (a / b);
        ret[1] = ret[2];
        ret[2] = tmp;
        return ret;
    }

    public static void main(String[] args) {
    }
}