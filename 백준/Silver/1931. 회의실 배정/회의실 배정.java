

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Schedule implements Comparable<Schedule> {
        int startTime;
        int endTime;


        public Schedule(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Schedule o) {
            if (this.endTime > o.endTime) {
                return 1;
            } else if (this.endTime < o.endTime) {
                return -1;
            }
            return this.startTime-o.startTime;
        }
    }

    private static int N;
    private static int max=0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        List<Schedule> scheduleList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] token = bufferedReader.readLine().split(" ");
            scheduleList.add(new Schedule(Integer.parseInt(token[0]), Integer.parseInt(token[1])));
        }

        sortList(scheduleList);

        solution(scheduleList);
        System.out.println(max);
    }

    private static void solution(List<Schedule> scheduleList) {

        int prev_end_time = 0;
        for(Schedule schedule : scheduleList) {
            if(schedule.startTime >= prev_end_time) {
                max++;
                prev_end_time= schedule.endTime;
            }
        }

    }

    private static void sortList(List<Schedule> scheduleList) {
        Collections.sort(scheduleList);
    }

}
