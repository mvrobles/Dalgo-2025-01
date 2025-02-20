package ejemplo_lcs_dp;
import java.util.ArrayList;
import java.util.Scanner;

class LongestCommonSubsequence {
    public int lcs(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        int[][] dpMatrix = new int[n1 + 1][n2 + 1];

        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i == 0 || j == 0) {
                    dpMatrix[i][j] = 0;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dpMatrix[i][j] = 1 + dpMatrix[i - 1][j - 1];
                } else {
                    dpMatrix[i][j] = Math.max(dpMatrix[i - 1][j], dpMatrix[i][j - 1]);
                }
            }
        }

        return dpMatrix[n1][n2];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());


        ArrayList<String> inputs = new ArrayList<>();

        for (int i = 0; i < testCases * 2; i++) {
            inputs.add(scanner.nextLine());
        }

        scanner.close();

        LongestCommonSubsequence solution = new LongestCommonSubsequence(); 
        ArrayList<String> results = new ArrayList<>(); 

        for (int i = 0; i < testCases * 2; i += 2) {
            String text1 = inputs.get(i);
            String text2 = inputs.get(i + 1);
            int result = solution.lcs(text1, text2);
            results.add(String.valueOf(result)); 
        }

        System.out.println(String.join("\n", results));
    }
}
