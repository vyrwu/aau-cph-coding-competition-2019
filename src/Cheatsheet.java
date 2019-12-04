import java.math.BigInteger;
import java.util.Arrays;

public class Cheatsheet {
    static boolean isPowerOfTwo(int x) {
        return x != 0 && ((x & (x - 1)) == 0);
    }

    public static int gcd(int a, int b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();
    }

    public static long gcd(long a, long b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);
        return gcd.longValue();
    }

    static boolean isEven(int a) {
        return (a & 1) == 0;
    }

    static int mostSignificantNumber(int n) {
        double k = Math.log10(n);
        k = k - Math.floor(k);
        return (int) Math.pow(10, k);
    }

    static String[] sortAlphabetically(String[] arr) {
        Arrays.sort(arr);
        return arr;
    }
}
