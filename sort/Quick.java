import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Quick {
    public static <E> void sort(Queue<E> input, Comparator<E> comp) {
        int len = input.size();
        if (len < 2) {
            return;
        }

        E pivot = input.peek();
        Queue<E> small = new LinkedList<>();
        Queue<E> equal = new LinkedList<>();
        Queue<E> large = new LinkedList<>();

        while (!input.isEmpty()) {
            E tmp = input.poll();
            int c = comp.compare(tmp, pivot);
            if (c < 0) {
                small.offer(tmp);
            } else if (c == 0) {
                equal.offer(tmp);
            } else {
                large.offer(tmp);
            }
        }

        sort(small, comp);
        sort(large, comp);

        while (!small.isEmpty()) {
            input.offer(small.poll());
        }
        while (!equal.isEmpty()) {
            input.offer(equal.poll());
        }
        while (!large.isEmpty()) {
            input.offer(large.poll());
        }
    }
}