import java.util.*;
import java.io.*;

public class Frog1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int[] h = new int[n];
		for (int i = 0 ; i < n; i++) 
			h[i] = Integer.parseInt(s[i]);
		
		if (n == 2) {
			System.out.println(h[1]-h[0]);
			return;
		}
		
		int[] dp = new int[n];
		dp[1] = Math.abs(h[1]-h[0]);
		for (int i = 2; i < n; i++) {
			dp[i] = Math.min(dp[i-1] + Math.abs(h[i-1]-h[i]), dp[i-2] + Math.abs(h[i-2]-h[i]));
		}
		System.out.print(dp[n-1]);
	}

}
