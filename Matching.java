import java.util.*;
import java.io.*;

public class Matching {

	public static final int mod = 1000000007;
	
	public static int count(int k) { //count number of ones in binary
		int c = 0;
		while (k > 0) {
			k &= k-1;
			c++;
		}
		return c;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] s;
		boolean[][] matches = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < n; j++)
				matches[i][j] = Integer.parseInt(s[j]) == 1;
		}

		int[] dp = new int[(1 << n)];
		dp[0] = 1;
		for (int j = 0; j < (1 << n) - 1; j++) {
			int taken = count(j); //number of women left
			for (int i = 0; i < n; i++) { //left therefore goes from n toward zero
//				if (matches[taken][i])
//					System.out.println("1*");
//				else
//					System.out.println("0*");
				if (matches[taken][i] && !((j & (1<<i)) == 1)) { //1 means taken, 0 means available
					//if man [i] can be matched with woman [#remaining]
					//and this woman has not already been taken
					dp[j^(1<<i)] = (dp[j^(1<<i)] + dp[j]) % mod;
					
					System.out.printf("%-5s %d %d %s\n", Integer.toBinaryString(j), taken, i, Integer.toBinaryString(j^(1<<i)) );
					//then add onto the case where this woman is taken (XOR)
					//the number of possibilities if she had not
				}
			}
		}
		System.out.println(dp[(1<<n)-1]);

	}

}
