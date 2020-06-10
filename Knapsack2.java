import java.util.*;
import java.io.*;

public class Knapsack2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int w = Integer.parseInt(s[1]);
		int[][] items = new int[n + 1][2];
		for (int i = 1; i < n + 1; i++) {
			s = br.readLine().split(" ");
			items[i][0] = Integer.parseInt(s[0]);
			items[i][1] = Integer.parseInt(s[1]);
		}

		long[][] dp = new long[n+1][100010];
		for (long[] l : dp)
			Arrays.fill(l, Integer.MAX_VALUE);
		for (int i = 0; i < n + 1; i++) {
			dp[i][0] = 0;
		}
		

		int max = -1;
		
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < 100009; j++) {
				if (items[i][1] <= j) {
					dp[i][j] = Math.min(dp[i - 1][j], items[i][0] + dp[i - 1][j - items[i][1]]);
				} else
					dp[i][j] = dp[i - 1][j];
				if (dp[i][j] <= w && j > max)
					max = j;
			}
		}

//		for (int i = 0; i < n + 1; i++) {
//			for (int j = 0; j < 19; j++) {
//				System.out.printf("%-11s", dp[i][j]);
//			}
//			System.out.println();
//		}

		System.out.println(max);
	}

}
