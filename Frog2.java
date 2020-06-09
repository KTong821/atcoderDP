import java.util.*;
import java.io.*;

public class Frog2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		s = br.readLine().split(" ");
		int[] h = new int[n];
		for (int i = 0; i < n; i++)
			h[i] = Integer.parseInt(s[i]);

		if (n == 2) {
			System.out.println(h[1] - h[0]);
			return;
		}

		int[] min = new int[n];

		for (int i = 1; i < n; i++) {
			int m = Integer.MAX_VALUE;
			for (int j = 1; j <= k; j++) {
				int x = Math.abs(h[i] - h[i - j]) + min[i-j];
				if (m > x) {
					m = x;
				}
				if (i - j == 0)
					break;
			}
			min[i] = m;
		}

		System.out.println(min[n-1]);
	}

}
