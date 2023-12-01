import java.util.*;

public class SuperAscii {
    static boolean ans(HashMap<Character, Integer> mp, String s) {
        boolean ans = false;
        for (char c : s.toCharArray()) {
            int ascii = (int) (c);
            mp.put(c, mp.getOrDefault(c, ascii));
        }
        for (int i = 0; i < s.length(); i++) {
            ans = false;
            int cnt = 0;
            char test = s.charAt(i);
            for (int j = i + 1; j < s.length() - 1; j++) { 
                if (test == s.charAt(j)) {
                    cnt++;
                }
            }
            if (cnt == mp.get(test)) {
                ans = true;
            }
            if (!ans) {
                return false;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        HashMap<Character, Integer> mp = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        boolean ans1 = ans(mp, s);
        System.out.print(ans1 ? "No" : "Yes");
    }
}
