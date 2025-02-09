import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Sorter {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (right + left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while (i < n1) {
            arr[k++] = L[i++];
        }
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = null;
        if (args.length >= 1) {
            try {
                System.setIn(new FileInputStream(args[0]));
                scanner = new Scanner(System.in);
            } catch (FileNotFoundException e) {
                System.err.println("File not found " + args[0]);
            }
        } else {
            scanner = new Scanner(System.in);
        }
        if (args.length >= 2) {
            try {
                System.setOut(new PrintStream(args[1]));
            } catch (FileNotFoundException e) {
                System.err.println("File not found  " + args[1]);
                return;
            }
        }
        int cases = scanner.nextInt();
        String[] results = new String[cases];
        scanner.nextLine();
        for (int i = 0; i < cases; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().trim().split(" "))
                              .mapToInt(Integer::parseInt)
                              .toArray();
            try{
                mergeSort(arr, 0, arr.length - 1);
                results[i] = String.join(" ", Arrays.stream(arr)
                                          .mapToObj(String::valueOf)
                                          .toArray(String[]::new));

            }
            catch(Exception e){
                results[i] = "Error" + e.getMessage();
            }
        }
        for (int i = 0; i < cases; i++) {
            System.out.println(results[i]);
        }
        scanner.close();
    }
}