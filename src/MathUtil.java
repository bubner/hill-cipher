/**
 * Math utilities.
 */
public class MathUtil {
    /**
     * gcd(a,b) = ax + by
     *
     * @param a first argument
     * @param b second argument
     * @return [gcd(a,b), x, y] in ax + by = gcd(a,b)
     */
    public static int[] eea(double a, double b) {
        if (a % 1 != 0)
            throw new IllegalArgumentException("a cannot be a fractional value");
        if (b % 1 != 0)
            throw new IllegalArgumentException("b cannot be a fractional value");
        int argA = (int) a;
        int argB = (int) b;
        if (argB == 0) {
            // Base case, gcd(a,b) = ax + by = a*1 + b*0 = a
            return new int[]{argA, 1, 0};
        }
        // Recursively find the GCD by the modulo property
        int[] ret = eea(argB, posMod(argA, argB));
        // Calculate the new x and y used to calculate the GCD
        int tmp = ret[1] - ret[2] * (argA / argB);
        ret[1] = ret[2];
        ret[2] = tmp;
        return ret;
    }

    /**
     * Get the modulus value in the positive domain.
     *
     * @param x the number
     * @param mod modulus value
     * @return x>0 modulus
     */
    public static double posMod(double x, int mod) {
        return (x % mod + mod) % mod;
    }
}
