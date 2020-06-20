import java.util.*;
import java.io.*;

public class Independent_Set {

	public static Map<Integer, LinkedList<Integer>> graph = new HashMap<>();
	public static long[][] arr;
	public static int n;
	public static final long mod = 1000000007;

	public static long recurse(int cur, int parent, boolean black) {
		int col = black ? 1 : 0;
		if (arr[cur][col] != -1)
			return arr[cur][col];

		LinkedList<Integer> temp = graph.get(cur);
		long sum = 1;
		if (black) {
			for (int k : temp) {
				if (k != parent) {
					sum *= recurse(k, cur, false);
					sum = sum % mod;
				}
			}

			return arr[cur][1] = sum;
		} else {
			for (int k : temp) {
				if (k != parent) {
					sum *= recurse(k, cur, false) + recurse(k, cur, true);
					sum = sum % mod;
				}
			}
			return arr[cur][0] = sum;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); //Bottom up method not possible. Children vary.
		if (n == 1) {
			System.out.println(2);
			return;
		}
		arr = new long[n + 1][2];
		for (int i = 0; i < n + 1; i++)
			Arrays.fill(arr[i], -1);
		String[] s;
		int a, b;
		for (int i = 0; i < n - 1; i++) {
			s = br.readLine().split(" ");
			a = Integer.parseInt(s[0]);
			b = Integer.parseInt(s[1]);
			if (!graph.containsKey(a))
				graph.put(a, new LinkedList<>());
			if (!graph.containsKey(b))
				graph.put(b, new LinkedList<>());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		System.out.println((recurse(1, 0, true) + recurse(1, 0, false)) % mod);
	}

}
