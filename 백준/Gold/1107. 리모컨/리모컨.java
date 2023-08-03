

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static Integer minMove = Integer.MAX_VALUE;
    static Integer curChannel = 100;
    static Integer targetChannel;

    static Integer forbiddenNum;
    static List<String> availNumList = new ArrayList<>();

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            availNumList.add(Integer.toString(i));
        }
        targetChannel = Integer.parseInt(bufferedReader.readLine());
        forbiddenNum = Integer.parseInt(bufferedReader.readLine());
        if (forbiddenNum != 0) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i < forbiddenNum; i++) {
                availNumList.remove(stringTokenizer.nextToken());
            }
        }

        System.out.println(solution());

    }

    private static Integer solution() {
        int decreaseNum;
        int increaseNum;
        minMove = getMove(curChannel);
        if (availNumList.isEmpty() || minMove == 0) {
            return minMove;
        }

        int temp = targetChannel;
        while (getMove(temp) <= minMove) {
            if (Find(temp)) {
                decreaseNum = getCount(temp) + getMove(temp);
                if (minMove >= decreaseNum) {
                    minMove = decreaseNum;
                }
                break;
            }
            temp -= 1;
        }

        temp = targetChannel;

        while (getMove(temp) <= minMove) {
            if (Find(temp)) {
                increaseNum = getCount(temp) + getMove(temp);
                if (minMove >= increaseNum) {
                    minMove = increaseNum;
                }
                break;
            }
            temp += 1;
        }

        return minMove;

    }

    private static int getCount(int temp) {
        return Integer.toString(temp).length();
    }

    private static boolean Find(int channel) {
        String stringChannel = Integer.toString(channel);
        String[] array = stringChannel.split("");
        for (String string : array) {
            if (!availNumList.contains(string)) return false;
        }
        return true;
    }

    private static Integer getMove(int cur) {
        return Math.abs(targetChannel - cur);
    }
}
