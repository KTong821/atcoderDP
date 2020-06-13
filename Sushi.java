import java.util.*;
import java.io.*;

public class Sushi {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double n = Double.parseDouble(br.readLine());
		String[] s = br.readLine().split(" ");
		int[] arr = new int[4];
		for (int q = 0; q < n; q++) {
			arr[Integer.parseInt(s[q])]++;
		}
		
		int m1 = arr[1] + arr[2] + arr[3];
		int m2 = arr[2] + arr[3];
		int m3 = arr[3];
		
		int t = (int) n + 1;
		double 	[][][] dp = new double[t][t][t];
		for (int k = 0; k <= m3; k++) {
			for (int j = 0; j <= m2-k; j++) {
				for (int i = 0; i <= m1-j-k; i++) {
//					System.out.println(i + " " + j + " " + k);
					if (i == 0 && j == 0 && k == 0)
						continue;

					int sum = i + j + k;
					dp[i][j][k] = n / sum;

					if (i != 0)
						dp[i][j][k] += (double) dp[i - 1][j][k] * i / sum;
					if (j != 0)
						dp[i][j][k] += (double) dp[i + 1][j - 1][k] * j / sum;
					if (k != 0)
						dp[i][j][k] += (double) dp[i][j + 1][k - 1] * k / sum;
				}
			}
		}

		System.out.println(dp[arr[1]][arr[2]][arr[3]]);

	}

}
