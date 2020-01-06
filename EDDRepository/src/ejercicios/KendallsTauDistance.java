package ejercicios;
import java.util.Arrays;

public class KendallsTauDistance <T> implements Distance<T> {
    private final double p;

    public KendallsTauDistance() {
        this(0);
    }

    public KendallsTauDistance(double p) {
        this.p = p;
    }

    @Override
    public double calculate(T[] a, T[] b) {
        final int la = a.length;
        final int lb = b.length;

        int[] ra = new int[lb];
        int[] rb = new int[la];
        Arrays.fill(ra, -1);
        Arrays.fill(rb, -1);

        for (int i = 0; i < la; i++) {
            for (int j = 0; j < lb; j++) {
                if (a[i].equals(b[j])) {
                    ra[i] = j;
                    rb[j] = i;
                }
            }
        }

        double distance = 0;

        for (int i = 0; i < la; i++) {
            for (int j = 0; j < lb; j++) {
                if (rb[j] == -1 || ra[i] == -1) {
                    distance += p;
                    continue;
                }

                if ((i - rb[j]) * (ra[i] - j) < 0) {
                    distance++;
                }
            }
        }

        return distance;
    }
}