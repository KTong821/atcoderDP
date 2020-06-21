import java.util.*;
import java.io.*;

public class Flowers {

	public static long[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] height = new int[n];
		int[] beauty = new int[n];
		long[] dp = new long[n + 1];
		String[] s = br.readLine().split(" ");
		for (int i = 0; i < n; i++)
			height[i] = Integer.parseInt(s[i]);

		s = br.readLine().split(" ");
		for (int i = 0; i < n; i++)
			beauty[i] = Integer.parseInt(s[i]);

		int b = 1;
		while (b < n)
			b *= 2;
		tree = new long[b * 2]; // segment tree stores max beauty in given range
								// we treat the segment tree as storing beauties of flowers w/
								// heights going from 1 -> n
		for (int i = 0; i < n; i++) {
			int k = b + height[i]-1;
			long max = 0;
			while (k > 1) { // because queries will always be from 1-height[i], we never care about right
								// side only care about left side (we are on right side)

				if (k % 2 == 1)
					max = Math.max(max, tree[k - 1]); //bottom up; if sibling, compare
				k /= 2;
			}
			dp[height[i]] = beauty[i] + max; // dp[x] now represents the max beauty of flower w/
												// height i where it currently stands. if shorter flower
												// comes later, then shorter will have 0, which is ignored.
			k =b + height[i]-1;
			while (k >= 1) {
				tree[k] = Math.max(tree[k], dp[height[i]]);
				k /= 2;
			}
			
//			for (int j = i; j >= 0; j--) {
//				if (height[j] < height[i] && dp[j] > max)
//					max = dp[j];
//			}
			// old n^2 approach TLE where dp[i] represents
			// the max beauty if the i'th flower was chosen

		}
		System.out.println(tree[1]);
	}

}
