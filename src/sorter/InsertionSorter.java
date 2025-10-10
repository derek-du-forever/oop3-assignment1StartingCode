package sorter;

/**
 * InsertionSorter
 * 
 * @param <T> type parameter
 */
public class InsertionSorter<T> extends AbstractSorter<T> {
    @Override
    public void sort(T[] arr, java.util.Comparator<T> comp) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            T key = arr[i];
            int j = i - 1;
            while (j >= 0 && comp.compare(arr[j], key) < 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

}
