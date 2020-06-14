import java.util.*;
import java.io.*;

public class Deque {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int[] arr = new int[n + 1];
		long[][] dp = new long[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(s[i - 1]);
			dp[i][i] = arr[i];
		}

		for (int i = 2; i <= n; i++)
			for (int j = i - 1; j > 0; j--)
				dp[i][j] = Math.max(arr[j] - dp[i][j + 1], arr[i] - dp[i - 1][j]);

		System.out.println(dp[n][1]);
	}

}