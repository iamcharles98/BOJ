import java.util.*;

/*
같은 모양의 블록이 2*2형태로 4개가 붙어있을 경우 사라지면서 점수 얻는 게임
판의 높이 m, 폭 n (2<= n, m <= 30)
입력으로 주어진 판 정보를 가지고 몇 개의 블록이 지워질지 출력하라.
최대 30*30

1.맵을 순회하면서 2*2 단위로 확인
2.같은 모양의 블록 발견 시 좌표 저장
3.제거 후 아래로 내리기
4.제거할 것이 없을 때까지 반복
*/

class Solution {
    static int height;
    static int width;
    static int count = 0;
    static List<List<Character>> map = new ArrayList<>();
    static final Character POP_CHAR = 'X';
    static class Pop {
        int row;
        int col;
        public Pop(int row, int col) {
            this.row = row;
            this.col = col;
        }
        @Override
        public String toString() {
            return "{ "+ row + ", " + col + " }";
        }
    }
    public int solution(int m, int n, String[] board) {
        height = m;
        width = n;
        for(String str : board){
            List<Character> list = new ArrayList<>();
            for(int i=0; i<str.length();i++) {
                list.add(str.charAt(i));
            }
            map.add(list);
        }
       
        for(int i=0; i<map.size(); i++) {
            System.out.println(map.get(i));
        }
        while(true) {
            List<Pop> popList = getPopSquare();
            
            if(popList.isEmpty()) {
                break;
            }
            for(Pop p : popList) {
                makePop(p);
            }
            downMap();
        }
        
        return count;
    }
    
    private List<Pop> getPopSquare() {
        List<Pop> popList = new ArrayList<>();
        for(int row =0; row<height-1; row++) {
            for(int col = 0; col<width-1;col++) {
                if(canPop(row,col)) {
                    popList.add(new Pop(row,col));
                }
            }
        }
        return popList;
    }
    
    private boolean canPop(int row, int col) {
        char symbol = map.get(row).get(col);
        for(int i=row; i<row+2; i++) {
            for(int j=col; j<col+2;j++) {
                if(symbol == '-' || symbol != map.get(i).get(j)) {
                    return false;
                }
            }
        }
        return true;
    }
    private void makePop(Pop p) {
        for(int i=p.row; i<p.row+2; i++) {
            for(int j=p.col; j<p.col+2;j++) {
                if(map.get(i).get(j) != POP_CHAR) {
                    map.get(i).set(j,POP_CHAR);
                    count++;
                }
            }
        }
        return;
    }
    
    private void downMap(){
        char removed = '-';
        for(int col =0; col<width; col++) {
            for(int row =0; row<height; row++) {
                if(map.get(row).get(col)=='X') {
                    for(int temp = row-1; temp>=0; temp--) {
                        char c = map.get(temp).get(col);
                        map.get(temp+1).set(col,c);
                        map.get(temp).set(col,removed);
                    }
                }
            }
        }
        return;
    }
}