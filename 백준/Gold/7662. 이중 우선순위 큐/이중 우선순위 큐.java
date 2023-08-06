

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int tc = 0; tc < T; tc++) {
			TreeMap<Integer, Integer> map = new TreeMap<>();
			int k = Integer.parseInt(in.readLine());

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(in.readLine());

				char c = st.nextToken().charAt(0);
				int n = Integer.parseInt(st.nextToken());

				if (c == 'I') {
					map.put(n, map.getOrDefault(n, 0) + 1);
				}
				else if (map.size() == 0) {
					continue;
				}
				else {
					int key = n == 1 ? map.lastKey() : map.firstKey();
					int cnt = map.get(key);

					if (cnt == 1) {
						map.remove(key);
					} else {
						map.put(key, cnt - 1);
					}
				}
			}

			if (map.size() == 0) {
				sb.append("EMPTY\n");
			} else {
				sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
			}
		}

		System.out.println(sb.toString());
	}

}