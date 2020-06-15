import java.util.*;
import java.io.*;

public class Candies {

	public static final int mod = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		int[] arr = new int[n + 1];
		int[][] dp = new int[n + 1][k + 1];
		int[] prefix = new int[k+1];
		s = br.readLine().split(" ");

		dp[0][0] = 1;
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(s[i - 1]);
			dp[i][0] = 1;
		}

		int max = 0;
		for (int i = 1; i <= n; i++) {
			prefix[0] = dp[i-1][0];
			max += arr[i];
			for (int j = 1; j <= max && j <=k; j++) {
				prefix[j] = (dp[i-1][j]+ prefix[j-1]) % mod;
				if (j-arr[i]-1 < 0) {
					dp[i][j] = prefix[j];
				} else {
					dp[i][j] = (prefix[j]-prefix[j-arr[i]-1]+mod)%mod;
				}
			}
		}
		System.out.println(dp[n][k]);

	}

}
