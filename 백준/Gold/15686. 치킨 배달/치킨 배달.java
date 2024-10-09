import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Spot {
        int x, y;
        int type;

        public Spot(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    static List<Spot> houses = new ArrayList<>();
    static List<Spot> chickens = new ArrayList<>();
    static int N, M;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            int y = 0;
            st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                int type = Integer.parseInt(st.nextToken());
                if (type == 1) {
                    houses.add(new Spot(i, y, type));
                } else if (type == 2) {
                    chickens.add(new Spot(i, y, type));
                }
                y++;
            }
        }

        recur(new ArrayList<>(), 0);

        System.out.println(ans);

    }

    private static void recur(List<Spot> pickedChicken, int depth) {
        if (pickedChicken.size() == M) {
            int curDist = 0;
            for (Spot h : houses) {
                curDist += chickenDist(h, pickedChicken);
            }
            ans = Math.min(ans, curDist);
            return;
        }

        for (int i = depth; i < chickens.size(); i++) {
            List<Spot> nList = new ArrayList<>(pickedChicken);
            nList.add(chickens.get(i));
            recur(nList, i + 1);

        }

    }

    private static int chickenDist(Spot house, List<Spot> chickens) {
        int dist = Integer.MAX_VALUE;
        for (Spot chicken : chickens) {
            dist = Math.min(dist, Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y));
        }
        return dist;
    }
}
