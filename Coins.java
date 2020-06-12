import java.util.*;
import java.io.*;

public class Coins {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		s = br.readLine().split(" ");
		double[] probs = new double[n + 1];
		double[][] dp = new double[n + 1][n + 1];
		for (int i = 1; i <= n; i++)
			probs[i] = Double.parseDouble(s[i - 1]);

		dp[1][0] = 1 - probs[1];
		dp[1][1] = probs[1];

		for (int i = 2; i <= n; i++)
			dp[i][0] = (1 - probs[i]) * dp[i - 1][0];

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i][j] = (dp[i - 1][j - 1] * probs[i]) + (dp[i - 1][j] * (1 - probs[i]));

			}
		}

//		for (int j = 0; j <= n; j++) {
//			for (int i = 1; i <= n; i++)
//				System.out.printf("%.4f %-10s", dp[i][j], "");
//			System.out.println();
//		}

		double sum = 0;
		for (int i = n; i >= (n + 1) / 2; i--)
			sum += dp[n][i];

		System.out.println(sum);
	}

}
