import java.util.Arrays;

public class RadixSorter {
    public static boolean USE_LINK = true;

    /**
     *
     * @param keys
     * @param from
     * @param len
     * @param radix
     *            key's radix
     * @param d
     *            how many sub keys should one key divide to
     */
    public void sort(int[] keys, int from, int len, int radix, int d) {
        if (USE_LINK) {
            linkRadixSort(keys, from, len, radix, d);
        } else {
            arrayRadixSort(keys, from, len, radix, d);
        }
    }

    private final void arrayRadixSort(int[] keys, int from, int len,
                                      int radix, int d) {
        int[] temporary = new int[len];
        int[] count = new int[radix];
        int R = 1;

        for (int i = 0; i < d; i++) {
            System.arraycopy(keys, from, temporary, 0, len);
            Arrays.fill(count, 0);
            for (int k = 0; k < len; k++) {
                int subkey = (temporary[k] / R) % radix;
                count[subkey]++;
            }

            for (int j = 1; j < radix; j++) {
                count[j] += count[j - 1];
            }

            for (int m = len - 1; m >= 0; m--) {
                int subkey = (temporary[m] / R) % radix;
                --count[subkey];
                keys[from + count[subkey]] = temporary[m];
            }
            R *= radix;
        }
    }

    private static class LinkQueue {
        int head = -1;
        int tail = -1;
    }

    private final void linkRadixSort(int[] keys, int from, int len,
                                     int radix, int d) {
        int[] nexts = new int[len];

        LinkQueue[] queues = new LinkQueue[radix];
        for (int i = 0; i < radix; i++) {
            queues[i] = new LinkQueue();
        }

        for (int i = 0; i < len - 1; i++) {
            nexts[i] = i + 1;
        }
        nexts[len - 1] = -1;

        int first = 0;
        for (int i = 0; i < d; i++) {
            linkRadixSortDistribute(keys, from, len, radix, i, nexts, queues, first);
            first = linkRadixSortCollect(keys, from, len, radix, i, nexts, queues);
        }

        int[] tmps = new int[len];
        int k = 0;
        while (first != -1) {

            tmps[k++] = keys[from + first];
            first = nexts[first];
        }
        System.arraycopy(tmps, 0, keys, from, len);
    }

    private final void linkRadixSortDistribute(int[] keys, int from, int len,
                                               int radix, int d, int[] nexts, LinkQueue[] queues, int first) {

        for (int i = 0; i < radix; i++) {
            queues[i].head = queues[i].tail = -1;
        }

        while (first != -1) {
            int val = keys[from + first];
            for (int j = 0; j < d; j++) {
                val /= radix;
            }
            val = val % radix;

            if (queues[val].head == -1) {
                queues[val].head = first;
            } else {
                nexts[queues[val].tail] = first;
            }

            queues[val].tail = first;
            first = nexts[first];
        }
    }

    private int linkRadixSortCollect(int[] keys, int from, int len, int radix,
                                     int d, int[] nexts, LinkQueue[] queues) {
        int first = 0;
        int last = 0;
        int fromQueue = 0;

        for (; (fromQueue < radix - 1) && (queues[fromQueue].head == -1);
             fromQueue++) {
            ;
        }

        first = queues[fromQueue].head;
        last = queues[fromQueue].tail;

        while (fromQueue < radix - 1 && queues[fromQueue].head != -1) {
            fromQueue += 1;
            for (; (fromQueue < radix - 1) && (queues[fromQueue].head == -1);
                 fromQueue++) {
                ;
            }

            nexts[last] = queues[fromQueue].head;
            last = queues[fromQueue].tail;
        }
        if (last != -1) {
            nexts[last] = -1;
        }
        return first;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] a = { 1, 9, 83, 34, 2,59, 54, 0, 77, 64, 95, 10, 9, 135, 14, 25, 121,
                12345, 9876, 11 };
        USE_LINK = false;
        RadixSorter sorter = new RadixSorter();
        sorter.sort(a, 0, a.length, 10, 10);
        System.out.println(Arrays.toString(a));
    }
}