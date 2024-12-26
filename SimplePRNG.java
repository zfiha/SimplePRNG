public class SimplePRNG {
    private static final long MODULUS = 4294967296L;
    private static final long MULTIPLIER = 1664525L;
    private static final long INCREMENT = 1013904223L;

    private long seed;

    public SimplePRNG(long seed) {
        this.seed = seed;
    }

    public int next() {
        seed = (MULTIPLIER * seed + INCREMENT) % MODULUS;
        return (int) (seed & 0xFFFFFFFF);
    }

    public int nextInt(int min, int max) {
        return min + Math.abs(next()) % (max - min + 1);
    }

    public static void main(String[] args) {
        SimplePRNG prng = new SimplePRNG(System.currentTimeMillis());
        for (int i = 0; i < 10; i++) {
            System.out.println("Random Number: " + prng.nextInt(1, 100));
        }
    }
}