import java.util.*;
import java.io.*;

public class Longest_Path {

	public static int n, m;
	public static Map<Integer, LinkedList<Integer>> graph = new HashMap<>();
	public static int[] dp;

	public static int TopologicalSort() {
		Queue<Integer> qu = new LinkedList<>();
		for (int i = 1; i <= n; i++)
			if (dp[i] == 0)
				qu.add(i);

		int count = 0;
		while (!qu.isEmpty()) {
			int size = qu.size();
			for (int k = 0; k < size; k++) {
				LinkedList<Integer> temp = graph.get(qu.poll());
				if (temp == null)
					continue;
				for (int t : temp) {
					dp[t]--;
					if (dp[t] == 0)
						qu.add(t);
				}
			}
			count++;
		}
		return count - 1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		dp = new int[n + 1];

		for (int i = 0; i < m; i++) {
			s = br.readLine().split(" ");
			int x = Integer.parseInt(s[0]);
			int y = Integer.parseInt(s[1]);
			if (!graph.containsKey(x))
				graph.put(x, new LinkedList<Integer>());
			graph.get(x).add(y);
			dp[y]++;
		}

		System.out.println(TopologicalSort());

	}

}
