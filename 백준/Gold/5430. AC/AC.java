

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Main {
    static Integer T;
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    static String COMMANDER ;

    static Integer LENGTH ;
    static List<Integer> ARRAY = new ArrayList<>();
    static StringTokenizer stringTokenizer;
    static Integer HEAD;
    static Integer TAIL;
    static Integer FRONT;
    static Integer DIRECTION;

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i<T; i++) {
            getCommander();
            getLength();
            getArray();
            stringBuilder.append(getResult());
        }

        System.out.print(stringBuilder.toString());
    }

    private static String getResult() {
        for(int i = 0; i<COMMANDER.length(); i++) {
            Character character = COMMANDER.charAt(i);
            if(character == 'R') {
                conductRCommand();
                continue;
            }
            try {
                conductDCommand();
            }catch (Exception e) {
                return "error\n";
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        StringJoiner stringJoiner = new StringJoiner(",");
        for(int i = HEAD; i<=TAIL && i>=FRONT; i =i+DIRECTION) {
            stringJoiner.add(ARRAY.get(i).toString());
        }
        stringBuilder.append(stringJoiner);
        stringBuilder.append("]\n");
        return stringBuilder.toString();
    }

    private static void getCommander() throws IOException {
        COMMANDER = bufferedReader.readLine();
    }
    private static void getLength() throws IOException {
        LENGTH = Integer.parseInt(bufferedReader.readLine());
    }
    private static void getArray() throws IOException {
        ARRAY.clear();
        HEAD = 0;
        TAIL = LENGTH -1;
        FRONT = 0;
        DIRECTION = 1;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine(),"[,]");
        for(int i=0; i < LENGTH; i++) {
            ARRAY.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
    }
    private static void conductRCommand() {
        HEAD = HEAD==FRONT ? TAIL : FRONT;
        DIRECTION*=-1;
    }
    private static void conductDCommand() throws Exception {
        if(FRONT>TAIL) {
            throw new Exception();
        }
        if(DIRECTION>0) {
            FRONT+=DIRECTION;
            HEAD = FRONT;
            return;
        }
        TAIL+=DIRECTION;
        HEAD = TAIL;
    }
}
