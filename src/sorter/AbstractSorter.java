package sorter;

import java.util.Comparator;

/**
 * AbstractSorter
 * 
 * @param <T> type parameter
 */
public abstract class AbstractSorter<T> {
    /**
     * sort
     * 
     * @param arr  wait to sort array
     * @param comp comparator
     */
    public abstract void sort(T[] arr, Comparator<T> comp);

    /**
     * swap two elements in an array
     */
    protected void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}