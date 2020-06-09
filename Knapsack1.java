import java.util.*;
import java.io.*;

public class Knapsack1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int w = Integer.parseInt(s[1]);
		int[][] items = new int[n+1][2];
		for (int i = 1; i < n+1; i++) {
			s = br.readLine().split(" ");
			items[i][0] = Integer.parseInt(s[0]);
			items[i][1] = Integer.parseInt(s[1]);
		}

		long[][] dp = new long[w + 1][n + 1]; //works on atcoder; MLE on dmoj
		for (int i = 1; i < w + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (items[j][0] <= i)
					dp[i][j] = Math.max(dp[i][j-1], items[j][1] + dp[i - items[j][0]][j - 1]);
				else 
					dp[i][j] = dp[i][j-1];
			}
		}
		

		System.out.println(dp[w][n]);
	}

}
