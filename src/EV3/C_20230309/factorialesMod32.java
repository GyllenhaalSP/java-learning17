package EV3.C_20230309;

public class factorialesMod32 {
    public static void main(String[] args) {
        long r = 1;
        for (int i = 1; i <= 150; i++) {
            r *= i;
            System.out.printf("%d! = %d mod 2^32%n", i, longFactorial(r));
        }
    }

    public static long longFactorial(long r){
        r %= (1L << 32);
        if (r < (1L << 31)) return r;
        else return (r - (1L << 32));
    }
}
