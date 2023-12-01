import java.util.*;

public class Elections {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] p = new char[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.next().charAt(0);
        }

        for (int i = 0; i < n; i++) {
            if (p[i] == 'A' && i >= 1) {
                for (int j = i - 1; j >= 0; j--) {
                    if (p[j] == '-') {
                        p[j] = 'A';
                    } else if (p[j] == 'B') {
                        break;
                    }
                }
            } else {
                if (p[i] == 'B' && i < n - 1) {
                    for (int j = i + 1; j < n; j++) {
                        if (p[j] == '-') {
                            p[j] = 'B';
                        } else if (p[j] == 'A') {
                            break;
                        }
                    }
                }
            }
        }

        int cntA = 0;
        int cntB = 0;
        for (int i = 0; i < n; i++) {
            if (p[i] == 'A') cntA++;
            if (p[i] == 'B') cntB++;
        }

        if (cntA > cntB) {
            System.out.println('A');
        } else if (cntA == cntB) {
            System.out.println("Coalition government");
        } else {
            System.out.println('B');
        }
    }
}
