import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static PriorityQueue<Integer> room = new PriorityQueue<>();

    static class Lecture implements Comparable<Lecture> {
        int num;
        int start;
        int end;

        public Lecture(int num, int start, int end) {
            this.num = num;
            this.start = start;
            this.end = end;
        }


        @Override
        public int compareTo(Lecture o) {
            return Integer.compare(this.start, o.start);
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        PriorityQueue<Lecture> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.offer(new Lecture(num, start, end));
        }

        while (!pq.isEmpty()) {
            Lecture lecture = pq.poll();

            if (!room.isEmpty() && room.peek() <= lecture.start) {
                room.poll();
            }

            room.add(lecture.end);

        }

        System.out.println(room.size());
    }

}
