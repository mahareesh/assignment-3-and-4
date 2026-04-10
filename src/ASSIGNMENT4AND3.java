import java.util.*;

class Client {
    String name;
    int riskScore;
    double accountBalance;

    public Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return name + ":" + riskScore + " (Bal:" + accountBalance + ")";
    }
}

public class ASSIGNMENT4AND3{

    // 🔵 Bubble Sort (Ascending by riskScore)
    public static void bubbleSortAsc(Client[] arr) {
        int n = arr.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    // swap
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swaps++;
                    swapped = true;

                    // visualize swap
                    System.out.println("Swapped: " + arr[j].name + " <-> " + arr[j + 1].name);
                }
            }

            if (!swapped) break; // optimization
        }

        System.out.println("Total Swaps: " + swaps);
    }

    // 🟢 Insertion Sort (Descending riskScore + accountBalance)
    public static void insertionSortDesc(Client[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 && compare(arr[j], key) < 0) {
                arr[j + 1] = arr[j]; // shift right
                j--;
            }

            arr[j + 1] = key;
        }
    }

    // Comparison: DESC riskScore, then DESC accountBalance
    private static int compare(Client a, Client b) {
        if (a.riskScore != b.riskScore) {
            return Integer.compare(a.riskScore, b.riskScore);
        }
        return Double.compare(a.accountBalance, b.accountBalance);
    }

    // 🔝 Top N highest risk clients
    public static void printTopClients(Client[] arr, int topN) {
        System.out.println("Top " + topN + " Highest Risk Clients:");
        for (int i = 0; i < Math.min(topN, arr.length); i++) {
            System.out.println(arr[i].name + "(" + arr[i].riskScore + ")");
        }
    }

    public static void main(String[] args) {

        Client[] clients = {
                new Client("clientC", 80, 5000),
                new Client("clientA", 20, 2000),
                new Client("clientB", 50, 3000)
        };

        // 🔵 Bubble Sort (Ascending)
        System.out.println("Bubble Sort (Ascending by Risk):");
        bubbleSortAsc(clients);

        System.out.println("After Bubble Sort:");
        for (Client c : clients) {
            System.out.println(c);
        }

        // 🟢 Insertion Sort (Descending)
        insertionSortDesc(clients);

        System.out.println("\nInsertion Sort (Descending by Risk + Balance):");
        for (Client c : clients) {
            System.out.println(c);
        }

        // 🔝 Top clients
        printTopClients(clients, 10);
    }
}