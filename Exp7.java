import java.util.Scanner;

public class LCS {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String a = sc.nextLine();

        System.out.print("Enter second string: ");
        String b = sc.nextLine();

        int m = a.length();
        int n = b.length();

        int[][] dp = new int[m + 1][n + 1];

        // Creating LCS table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    // 1 + diagonal value
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } 
                else {
                    // Maximum of top and left value
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println("Length of LCS = " + dp[m][n]);

        sc.close();
    }
}