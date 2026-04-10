import java.util.*;
import java.time.LocalTime;

class Transaction {
    String id;
    double fee;
    LocalTime timestamp;

    public Transaction(String id, double fee, String ts) {
        this.id = id;
        this.fee = fee;
        this.timestamp = LocalTime.parse(ts);
    }

    @Override
    public String toString() {
        return id + ":" + fee + "@" + timestamp;
    }
}

public class ASSIGNMENT4AND3 {

    // 🔵 Bubble Sort (by fee)
    public static void bubbleSortByFee(List<Transaction> list) {
        int n = list.size();
        int passes = 0, swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            passes++;

            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Transaction temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) break; // early termination
        }

        System.out.println("Bubble Sort → Passes: " + passes + ", Swaps: " + swaps);
    }

    // 🟢 Insertion Sort (by fee + timestamp)
    public static void insertionSort(List<Transaction> list) {
        int n = list.size();

        for (int i = 1; i < n; i++) {
            Transaction key = list.get(i);
            int j = i - 1;

            while (j >= 0 && compare(list.get(j), key) > 0) {
                list.set(j + 1, list.get(j)); // shift
                j--;
            }

            list.set(j + 1, key);
        }
    }

    // Comparison: fee first, then timestamp
    private static int compare(Transaction a, Transaction b) {
        if (a.fee != b.fee) {
            return Double.compare(a.fee, b.fee);
        }
        return a.timestamp.compareTo(b.timestamp);
    }

    // 🚨 High-fee outliers (> 50)
    public static List<Transaction> findHighFee(List<Transaction> list) {
        List<Transaction> outliers = new ArrayList<>();

        for (Transaction t : list) {
            if (t.fee > 50.0) {
                outliers.add(t);
            }
        }
        return outliers;
    }

    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();

        // Sample Input
        transactions.add(new Transaction("id1", 10.5, "10:00"));
        transactions.add(new Transaction("id2", 25.0, "09:30"));
        transactions.add(new Transaction("id3", 5.0, "10:15"));

        // Choose sorting based on size
        if (transactions.size() <= 100) {
            bubbleSortByFee(transactions);
        } else {
            insertionSort(transactions);
        }

        // Output sorted transactions
        System.out.println("Sorted Transactions:");
        for (Transaction t : transactions) {
            System.out.println(t);
        }

        // Detect outliers
        List<Transaction> outliers = findHighFee(transactions);

        System.out.println("High-Fee Outliers:");
        if (outliers.isEmpty()) {
            System.out.println("None");
        } else {
            for (Transaction t : outliers) {
                System.out.println(t);
            }
        }
    }
}