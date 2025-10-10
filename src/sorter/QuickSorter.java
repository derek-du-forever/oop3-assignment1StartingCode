package sorter;

/**
 * QuickSorter
 * 
 * @param <T> type parameter
 */
public class QuickSorter<T> extends AbstractSorter<T> {

    @Override
    public void sort(T[] arr, java.util.Comparator<T> comp) {
        if (arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1, comp);
    }

    private void quickSort(T[] arr, int low, int high, java.util.Comparator<T> comp) {
        if (low < high) {
            int pi = partition(arr, low, high, comp);
            quickSort(arr, low, pi - 1, comp);
            quickSort(arr, pi + 1, high, comp);
        }
    }

    private int partition(T[] arr, int low, int high, java.util.Comparator<T> comp) {
        T pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comp.compare(arr[j], pivot) >= 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

}
