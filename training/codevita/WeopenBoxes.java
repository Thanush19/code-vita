
import java.util.*;
import java.io.*;

public class WeopenBoxes {
    public static boolean tri(long sum) {
        long n = 0;
        while ((n * (n + 1)) / 2 < sum) {
            n++;
        }
        if ((n * (n + 1)) / 2 == sum) {
            return true;
        }
        return false;
    }

    public static void main(String[] args)
 
{
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();

        long n, k;
        n = sc.nextLong();
        k = sc.nextLong();

        List<Long> a = new ArrayList<>();

        String[] sp = ip.split("\\s+");
        for (String str : sp) {
            a.add(Long.parseLong(str));
        }

        List<Long> consec = new ArrayList<>();

        long am = 0;

        while (consec.size() < k) {
            for (int i = 0; i < n - 1; i++) {
                long f = a.get(0);
                long s = a.get(1);
                long mini = Math.min(f, s);

                if (mini == f) {
                    a.add(f);
                    if (!tri(f)) {
                        am += f;
                    }
                    a.remove(0);
                } else if (mini == s) {
                    a.add(s);
                    if (!tri(s)) {
                        am += s;
                    }
                    a.remove(1);
                }
            }

            long maxi = a.get(0);
            int l = consec.size();
            if (l != 0 && consec.get(l - 1) != maxi) {
                consec.clear();
            }
            consec.add(maxi);
        }

        System.out.print(am);
    }
}
