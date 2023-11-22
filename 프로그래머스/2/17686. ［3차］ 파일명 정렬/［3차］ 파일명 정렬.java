import java.util.*;
class Solution {
    /*
    파일명에 포함된 숫자를 반영한 정렬
    파일명 -> HEAD, NUMBER, TAIL 로 분리
    HEAD -> 사진 순 정렬 (대소문자 구분 x)
    NUMBER -> 숫자 순 정렬 (HEAD부분이 같을 경우)
    TAIL -> 원래 순서 유지 (NUMBER 같을 경우)
    */
    class File {
        String HEAD;
        String NUMBER;
        String TAIL;
        public File(String head, String number, String tail) {
            HEAD = head;
            NUMBER = number;
            TAIL = tail;
        }
        @Override
        public String toString() {
            return HEAD  + NUMBER + TAIL;
        }
    }
    public List<String> solution(String[] files) {
        List<String> answer = new ArrayList<>();
        List<File> fileList = new ArrayList<>();
        for(String f : files) {
            File file = parser(f);
            fileList.add(file);
        }
        
        Collections.sort(fileList, new Comparator<File>() {
            @Override
            public int compare(File f1, File f2) {
                if(f1.HEAD.toLowerCase().compareTo(f2.HEAD.toLowerCase())==0) {
                    return Integer.parseInt(f1.NUMBER) - Integer.parseInt(f2.NUMBER);
                    }
                return f1.HEAD.toLowerCase().compareTo(f2.HEAD.toLowerCase());
                }
        });
        for(File f : fileList) {
            answer.add(f.toString());
        }
        return answer;
    }
    private File parser(String file) {
        String head= "";
        String number = "";
        String tail = "";
        for(int i=0;i<file.length(); i++) {
            if(head.equals("") && Character.isDigit(file.charAt(i))) {
               head = file.substring(0,i);
            }
            if(!head.equals("") && !Character.isDigit(file.charAt(i))) {
                number = file.substring(head.length(), i);
                tail = file.substring(i,file.length());
                break;
            }
        }
        if(number.equals("")) {
            number = file.substring(head.length(), file.length());
        }
        return new File(head,number,tail);
    }
}