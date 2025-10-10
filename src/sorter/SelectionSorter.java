package sorter;

/**
 * SelectionSorter
 * 
 * @param <T> type parameter
 */
public class SelectionSorter<T> extends AbstractSorter<T> {
    @Override
    public void sort(T[] arr, java.util.Comparator<T> comp) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (comp.compare(arr[j], arr[maxIdx]) > 0) {
                    maxIdx = j;
                }
            }
            if (maxIdx != i) {
                swap(arr, i, maxIdx);
            }
        }
    }

}
