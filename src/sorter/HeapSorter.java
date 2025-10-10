package sorter;

/**
 * HeapSorter
 * 
 * @param <T> type parameter
 */
public class HeapSorter<T extends Comparable<T>> extends AbstractSorter<T> {
    @Override
    public void sort(T[] arr, java.util.Comparator<T> comp) {
        int n = arr.length;

        // Build min heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i, comp);
        }

        // One by one extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0, comp);
        }
    }

    private void heapify(T[] arr, int heapSize, int nodeIndex, java.util.Comparator<T> comp) {
        int smallest = nodeIndex;
        int left = 2 * nodeIndex + 1;
        int right = 2 * nodeIndex + 2;

        if (left < heapSize && comp.compare(arr[left], arr[smallest]) < 0) {
            smallest = left;
        }

        if (right < heapSize && comp.compare(arr[right], arr[smallest]) < 0) {
            smallest = right;
        }

        if (smallest != nodeIndex) {
            swap(arr, nodeIndex, smallest);
            heapify(arr, heapSize, smallest, comp);
        }
    }
}
