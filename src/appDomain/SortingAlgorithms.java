package appDomain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingAlgorithms {

	public static class BubbleSort {
	    public static <T extends Comparable<T>> void sort(T[] arr) {
	        sort(arr);
	    }

	    public static <T extends Comparable<T>> void sort(List<T> shapes, Comparator<T> comparator) {
	        int n = shapes.size();
	        for (int i = 0; i < n - 1; i++) {
	            for (int j = 0; j < n - 1 - i; j++) {
	                if (comparator.compare(shapes.get(j), shapes.get(j + 1)) < 0) {
	                    Collections.swap(shapes, j, j + 1);
	                }
	            }
	        }
	    }

	    private static <T> void swap(T[] arr, int i, int j) {
	        T temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	    }
	}

	public static class SelectionSort {
	    public static <T extends Comparable<T>> void sort(T[] arr) {
	        sort(arr);
	    }

	    public static <T> void sort(List<T> list, Comparator<T> comparator) {
	        int n = list.size();
	        for (int i = 0; i < n - 1; i++) {
	            int minIndex = i;
	            for (int j = i + 1; j < n; j++) {
	                if (comparator.compare(list.get(j), list.get(minIndex)) < 0) {
	                    minIndex = j;
	                }
	            }
	            if (minIndex != i) {
	                Collections.swap(list, i, minIndex);
	            }
	        }
	    }

	    private static <T> void swap(T[] arr, int i, int j) {
	        T temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	    }
	}

	public static class InsertionSort {
	    public static <T extends Comparable<T>> void sort(T[] arr) {
	        sort(arr);
	    }

	    public static <T> void sort(List<T> list, Comparator<T> comparator) {
	        int n = list.size();
	        for (int i = 1; i < n; i++) {
	            for (int j = i; j > 0 && comparator.compare(list.get(j), list.get(j - 1)) > 0; j--) {
	                swap(list, j, j - 1);
	            }
	        }
	    }

	    private static <T> void swap(List<T> list, int i, int j) {
	        T temp = list.get(i);
	        list.set(i, list.get(j));
	        list.set(j, temp);
	    }
	}

	public static class MergeSort {
	    public static <T extends Comparable<T>> void sort(T[] arr) {
	        sort(arr);
	    }

	    public static <T> void sort(List<T> list, Comparator<T> comparator) {
	        mergeSort(list, 0, list.size() - 1, comparator);
	    }

	    private static <T> void mergeSort(List<T> list, int left, int right, Comparator<T> comparator) {
	        if (left < right) {
	            int middle = (left + right) / 2;
	            mergeSort(list, left, middle, comparator);
	            mergeSort(list, middle + 1, right, comparator);
	            merge(list, left, middle, right, comparator);
	        }
	    }

	    private static <T> void merge(List<T> list, int left, int middle, int right, Comparator<T> comparator) {
	        int n1 = middle - left + 1;
	        int n2 = right - middle;

	        List<T> leftArray = new ArrayList<T>(n1);
	        List<T> rightArray = new ArrayList<T>(n2);

	        for (int i = 0; i < n1; i++) {
	            leftArray.add(list.get(left + i));
	        }
	        for (int i = 0; i < n2; i++) {
	            rightArray.add(list.get(middle + 1 + i));
	        }

	        int i = 0, j = 0;

	        while (i < n1 && j < n2) {
	            if (comparator.compare(leftArray.get(i), rightArray.get(j)) > 0) {
	                list.set(left++, rightArray.get(j++));
	            } else {
	                list.set(left++, leftArray.get(i++));
	            }
	        }

	        while (i < n1) {
	            list.set(left++, leftArray.get(i++));
	        }

	        while (j < n2) {
	            list.set(left++, rightArray.get(j++));
	        }
	    }
	}
    
	public static class QuickSort {

	    public <T extends Comparable<T>> void sort(T[] arr) {
	        sort(arr, 0, arr.length - 1);
	    }

	    public static  <T> void sort(List<T> list, Comparator<T> comparator) {
	        sort(list, 0, list.size() - 1, comparator);
	    }

	    private <T extends Comparable<T>> void sort(T[] arr, int low, int high) {
	        if (low < high) {
	            int pi = partition(arr, low, high);
	            sort(arr, low, pi - 1);
	            sort(arr, pi + 1, high);
	        }
	    }

	    private static <T> void sort(List<T> list, int low, int high, Comparator<T> comparator) {
	        if (low < high) {
	            int pi = partition(list, low, high, comparator);
	            sort(list, low, pi - 1, comparator);
	            sort(list, pi + 1, high, comparator);
	        }
	    }

	    private <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
	        T pivot = arr[high];
	        int i = low - 1;
	        for (int j = low; j < high; j++) {
	            if (arr[j].compareTo(pivot) > 0) {
	                i++;
	                swap(arr, i, j);
	            }
	        }
	        swap(arr, i + 1, high);
	        return i + 1;
	    }

	    private static <T> int partition(List<T> list, int low, int high, Comparator<T> comparator) {
	        T pivot = list.get(high);
	        int i = low - 1;
	        for (int j = low; j < high; j++) {
	            if (comparator.compare(list.get(j), pivot) > 0) {
	                i++;
	                swap(list, i, j);
	            }
	        }
	        swap(list, i + 1, high);
	        return i + 1;
	    }

	    private <T> void swap(T[] arr, int i, int j) {
	        T temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	    }

	    private static <T> void swap(List<T> list, int i, int j) {
	        T temp = list.get(i);
	        list.set(i, list.get(j));
	        list.set(j, temp);
	    }
	}
}
