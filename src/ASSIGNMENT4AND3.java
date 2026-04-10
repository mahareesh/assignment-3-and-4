import java.util.*;

public class ASSIGNMENT4AND3{

    // 🔍 Linear Search (unsorted)
    public static int linearSearch(int[] arr, int target) {
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear Search → Found at index " + i + ", Comparisons: " + comparisons);
                return i;
            }
        }

        System.out.println("Linear Search → Not Found, Comparisons: " + comparisons);
        return -1;
    }

    // ⚡ Binary Search (exact match)
    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid] == target) {
                System.out.println("Binary Search → Found at index " + mid + ", Comparisons: " + comparisons);
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Binary Search → Not Found, Comparisons: " + comparisons);
        return -1;
    }

    // 📍 Find Insertion Point (lower_bound)
    public static int insertionPoint(int[] arr, int target) {
        int low = 0, high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low; // position where target should be inserted
    }

    // ⬇ Floor (largest ≤ target)
    public static Integer floor(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        Integer result = null;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) return arr[mid];

            if (arr[mid] < target) {
                result = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    // ⬆ Ceiling (smallest ≥ target)
    public static Integer ceiling(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        Integer result = null;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) return arr[mid];

            if (arr[mid] > target) {
                result = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] unsorted = {50, 10, 100, 25};
        int[] sorted = {10, 25, 50, 100};

        int target = 30;

        // 🔍 Linear Search (unsorted)
        linearSearch(unsorted, target);

        // ⚡ Binary Search (sorted)
        binarySearch(sorted, target);

        // 📍 Insertion Point
        int pos = insertionPoint(sorted, target);
        System.out.println("Insertion Position for " + target + ": " + pos);

        // ⬇ Floor & ⬆ Ceiling
        Integer f = floor(sorted, target);
        Integer c = ceiling(sorted, target);

        System.out.println("Floor(" + target + "): " + f);
        System.out.println("Ceiling(" + target + "): " + c);
    }
}