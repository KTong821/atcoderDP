import java.util.*;
import java.io.*;

public class Grid1 {

	public static int h, w;
	public static final int mod = 1000000007;
	public static boolean[][] map;
	public static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		h = Integer.parseInt(s[0]);
		w = Integer.parseInt(s[1]);
		map = new boolean[h][w];
		dp = new int[h][w];

		String st;
		for (int i = 0; i < h; i++) {
			st = br.readLine();
			for (int j = 0; j < w; j++)
				if (st.charAt(j) == '.')
					map[i][j] = true;
		}

		dp[0][0] = 1;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				int k = i - j;
				if (k < 0)
					break;
				if (!map[k][j])
					continue;
				if (k - 1 >= 0 && map[k - 1][j]) {
					dp[k][j] += dp[k - 1][j];
					dp[k][j] %= mod;
				}
				if (j - 1 >= 0 && map[k][j - 1]) {
					dp[k][j] += dp[k][j - 1];
					dp[k][j] %= mod;
				}
			}
		}
		for (int j = 1; j < w; j++) {
			for (int i = h - 1; i >= 0; i--) {
				int k = j + h - i - 1;
				if (k == w)
					break;
				if (!map[i][k])
					continue;
				if (i - 1 >= 0 && map[i - 1][k]) {
					dp[i][k] += dp[i - 1][k];
					dp[i][k] %= mod;
				}
				if (k - 1 >= 0 && map[i][k - 1]) {
					dp[i][k] += dp[i][k - 1];
					dp[i][k] %= mod;
				}
			}
		}
//		for (int i = 0; i < h; i++) {
//			for (int j = 0; j < w; j++)
//				System.out.print(dp[i][j] + " ");
//			System.out.println();
//		}
		System.out.println(dp[h - 1][w - 1]);

	}

}
