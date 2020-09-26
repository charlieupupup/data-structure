import java.util.Arrays;
import java.util.Random;

public class Bucket {
    public static int[] sort(int[] input, int maxVal) {
        if (input == null || input.length < 2) {
            return input;
        }
        int[] bucket = new int[maxVal + 1];
        int[] res = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            bucket[input[i]]++;
        }

        int idx = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                res[idx++] = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int N = 20;
        int[] input = new int[N];

        for (int i = 0; i < N; i++) {
            input[i] = random.nextInt(100);
        }

        for (int i : input) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] res = sort(input, Arrays.stream(input).max().getAsInt());
        System.out.println(Arrays.toString(res));
    }
}