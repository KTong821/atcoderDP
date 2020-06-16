import java.util.*;
import java.io.*;

public class Slimes {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		long[] prefix = new long[n + 1];
		for (int i = 0; i < n; i++)
			prefix[i + 1] = prefix[i] + Integer.parseInt(s[i]);

		long[][] dp = new long[n + 1][n + 1];

		for (int i = 2; i <= n; i++) {
			for (int j = i - 1; j > 0; j--) {
				dp[j][i] = Long.MAX_VALUE;
				for (int k = j; k < i; k++) {
					long val = dp[j][k] + dp[k + 1][i] + (prefix[k] - prefix[j - 1]) + (prefix[i] - prefix[k]);
					if (dp[j][i] > val)
						dp[j][i] = val;
				}
			}
		}
		System.out.println(dp[1][n]);
	}

}
