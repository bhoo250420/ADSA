import java.util.*;

public class OptimalStorageOnTape {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of files: ");
        int n = sc.nextInt();

        int[] files = new int[n];

        System.out.println("Enter file lengths:");
        for (int i = 0; i < n; i++) {
            files[i] = sc.nextInt();
        }

        // Sort files in ascending order
        Arrays.sort(files);

        int totalRetrievalTime = 0;
        int currentTime = 0;

        for (int file : files) {
            currentTime += file;
            totalRetrievalTime += currentTime;
        }

        double meanRetrievalTime = (double) totalRetrievalTime / n;

        System.out.println("Optimal storage order: " + Arrays.toString(files));
        System.out.println("Total retrieval time: " + totalRetrievalTime);
        System.out.println("Mean retrieval time: " + meanRetrievalTime);

        sc.close();
    }
}
