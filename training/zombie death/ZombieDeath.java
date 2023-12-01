import java.util.*;
public class ZombieDeath {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        int n=sc.nextInt();
        int[] z =  new int[n];
        for(int i =0;i<n;i++){
            z[i]=sc.nextInt();
        }
        int loss=0;
        for(int i =0;i<n;i++){
            loss+=((z[i]%2)+(z[i]/2));
        }
        int ans =b-loss;
        System.out.print((ans > 0) ? "yes" : "no");



        
    }
    
}
