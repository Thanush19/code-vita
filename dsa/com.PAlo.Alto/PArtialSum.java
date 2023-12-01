import java.util.*;

public class PArtialSum {
    static ArrayList<Integer> fib(Integer a) {
        ArrayList<Integer> ans = new ArrayList<>();
        Integer s = 0;
        Integer b = 1;
        Integer c = 0;
        ans.add(s);
        ans.add(b);
        for (Integer i = 2; i <= a; i++) {
            c = s + b;
            ans.add(c);
            s = b;
            b = c;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        Integer m = sc.nextInt();
        ArrayList<Integer> ans;
        int sum = 0;

        if (n >= m) {
            ans = fib(n);
            for (int i = m; i <= n; i++) {
                sum += ans.get(i);
            }
        } else if (m > n) {
            ans = fib(m);
            for (int i = n; i <= m; i++) {
                sum += ans.get(i);
            }
        }
        System.out.println(sum % 10);
    }
}
