package ejercicios;
import java.util.Arrays;

public class SpearmansFootruleDistance <T> implements Distance<T> {
    @Override
    public double calculate(T[] a, T[] b) {
        final int la = a.length;
        final int lb = b.length;

        int[] ra = new int[lb];
        int[] rb = new int[la];
        Arrays.fill(ra, lb);
        Arrays.fill(rb, la);

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
            distance += Math.abs(i - ra[i]);
        }

        for (int j = 0; j < lb; j++) {
            if (rb[j] == la) {
                distance += Math.abs(j - rb[j]);
            }
        }

        return distance;
    }
}
