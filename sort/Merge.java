import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;


class MergeArray {
    public static <E> void mergeSort(E[] S, Comparator<E> comp) {
        int n = S.length;
        if (n < 2) {
            return;
        }
        // divide
        int mid = n / 2;
        E[] S1 = Arrays.copyOfRange(S, 0, mid);
        E[] S2 = Arrays.copyOfRange(S, mid, n); // conquer (with recursion)

        mergeSort(S1, comp);
        mergeSort(S2, comp); // merge results merge(S1, S2, S, comp);
        merge(S1, S2, S, comp);
    }

    public static <K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp) {
        int i = 0, j = 0;
        while (i + j < S.length) {
            if (j == S2.length || (i < S1.length && comp.compare(S1[i], S2[j]) < 0))
                S[i + j] = S1[i++]; // copy ith element of S1 and increment i
            else
                S[i + j] = S2[j++]; // copy jth element of S2 and increment j
        }
    }
}

class MergeLinkedList {
    public static <K> void merge(Queue<K> S1, Queue<K> S2, Queue<K> S, Comparator<K> comp) {
        while (!S1.isEmpty() && !S2.isEmpty()) {
            if (comp.compare(S1.peek(), S2.peek()) < 0) {
                // take next element from S1
                S.offer(S1.poll());
            } else {
                // take next element from S2
                S.offer(S2.poll());
            }
            // move any elements that remain in S1
            while (!S1.isEmpty()) {
                S.offer(S1.poll());
            }
            // move any elements that remain in S2
            while (!S2.isEmpty()) {
                S.offer(S2.poll());
            }
        }

    }

    /* Merge-sort contents of queue. */
    public static <K> void mergeSort(Queue<K> S, Comparator<K> comp) {
        int n = S.size();
        if (n < 2) {
            // queue is trivially sorted
            return;
        }
        Queue<K> S1 = new LinkedList<>();
        Queue<K> S2 = new LinkedList<>();

        while (S1.size() < n / 2) {
            S1.offer(S.poll());

        }

        while (!S.isEmpty()) {
            S2.offer(S.poll());
        }
        mergeSort(S1, comp);
        mergeSort(S2, comp);
        merge(S1, S2, S, comp);
    }

}

class MergeBottomUp {
    public static <K> void merge(K[] in, K[] out, Comparator<K> comp, int start, int inc) {
        int end1 = Math.min(start + inc, in.length);
        int end2 = Math.min(start + 2 * inc, in.length);
        int x = start;
        int y = start + inc;
        int z = start;

        while (x < end1 && y < end2) {
            if (comp.compare(in[x], in[y]) < 0) {
                out[z++] = in[x++];
            } else {
                out[z++] = in[y++];
            }
        }
        if (x < end1) {
            System.arraycopy(in, x, out, z, end1 - x);
        }

        if (y < end1) {
            System.arraycopy(in, y, out, z, end2 - y);
        }
    }

    public static <K> void mergetSortBottomUp(K[] ori, Comparator<K> comp) {
        int n = ori.length;
        K[] src = ori;
        K[] dst = (K[]) new Object[n];
        K[] tmp;
        for (int i = 1; i < n; i *= 2) {
            for (int j = 0; j < n; j += 2 * i) {
                merge(src, dst, comp, j, i);
            }
            tmp = src;
            src = dst;
            dst = tmp;
        }
        if (ori != src) {
            System.arraycopy(src, 0, ori, 0, n);
        }
    }
}