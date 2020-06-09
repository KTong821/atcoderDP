import java.util.*;
import java.io.*;

public class Vacation {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] activities = new int[n+1][3];
		String[] s;
		for (int i = 1; i < n+1; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < 3; j++)
				activities[i][j] = Integer.parseInt(s[j]);
		}

		int[][] max = new int[n + 1][3];
		for (int i = 1; i < n + 1; i++) {
			max[i][0] = activities[i][0] + Math.max(max[i - 1][1], max[i - 1][2]);
			max[i][1] = activities[i][1] + Math.max(max[i - 1][0], max[i - 1][2]);
			max[i][2] = activities[i][2] + Math.max(max[i - 1][0], max[i - 1][1]);
		}

		int k = -1;
		for (int i = 0; i < 3; i++) {
			if (max[n][i] > k)
				k = max[n][i];
		}
		System.out.println(k);
	}

}
