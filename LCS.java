import java.util.*;
import java.io.*;

public class LCS {

	public static String s, t;
	public static int[][] dp;

	public static String recurse(int i, int j) {
		if (dp[i][j] == 0)
			return "";
		if (s.charAt(i-1) == t.charAt(j-1))
			return recurse(i - 1, j - 1) + s.charAt(i-1);
		else if (dp[i - 1][j] > dp[i][j - 1])
			return recurse(i - 1, j);
		else
			return recurse(i, j - 1);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		t = br.readLine();

		dp = new int[s.length() + 1][t.length() + 1];
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= t.length(); j++) {
				if (s.charAt(i-1) == t.charAt(j-1))
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		System.out.println(recurse(s.length(), t.length()));
	}

}
