import java.util.Scanner;

public class ZeroCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ip1 = sc.nextInt();
        int ip2= sc.nextInt();

        int output = maxi(ip1, ip2);
        System.out.print(output);
    }

    public static int maxi(int ip1, int ip2) {
        if (ip2 == 0) {
            return ip1;
        }

        int z = ip1 - ip2;
        int maxim = z / (ip2 + 1);
        int bal = z % (ip2 + 1);

        if (bal > 0) {
            maxim += 1;
        }

        return maxim;
    }
}
