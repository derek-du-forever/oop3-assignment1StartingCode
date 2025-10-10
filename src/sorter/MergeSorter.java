package sorter;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSorter<T extends Comparable<T>> extends AbstractSorter<T> {

    @Override
    public void sort(T[] arr, Comparator<T> comp) {
        if (arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1, comp);
    }

    private void mergeSort(T[] arr, int left, int right, Comparator<T> comp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, comp);
            mergeSort(arr, mid + 1, right, comp);
            merge(arr, left, mid, right, comp);
        }
    }

    private void merge(T[] arr, int left, int mid, int right, Comparator<T> comp) {
        T[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        T[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0;
        int k = left;

        while (i < leftArr.length && j < rightArr.length) {
            if (comp.compare(leftArr[i], rightArr[j]) >= 0) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }
    }
}
