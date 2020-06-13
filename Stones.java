import java.util.*;
import java.io.*;

public class Stones {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		s = br.readLine().split(" ");
		int[] arr = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(s[i]);

		Arrays.sort(arr);

		boolean[] dp = new boolean[k + 1];

		for (int i = 1; i <= k; i++) {
			for (int j = 0; j < n && arr[j] <= i; j++) {
				if (!dp[i - arr[j]]) {
					dp[i] = true;
					break;
				}
			}			
		}
		if (dp[k])
			System.out.println("First");
		else
			System.out.println("Second");
	}

}
