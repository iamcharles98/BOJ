import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N;
        int L;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        L = scanner.nextInt();

        while (L <= 100) {
            int temp = (N / L - (L - 1) / 2);
            if (temp < 0) break;
            if (N == (temp * 2 + L - 1) * L / 2) {
                for (long i = 0; i < L; i++) {
                    System.out.print(temp + i + " ");
                }
                return;
            }
            L++;
        }
        System.out.println(-1);
        return;
    }
}
