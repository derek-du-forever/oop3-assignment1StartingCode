package sorter;

import java.util.Comparator;

/**
 * BubbleSorter
 * 
 * @param <T> type parameter
 */
public class BubbleSorter<T extends Comparable<T>> extends AbstractSorter<T> {

    @Override
    public void sort(T[] arr, Comparator<T> comp) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (comp.compare(arr[j], arr[j + 1]) < 0) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
}
