package houses;
import java.util.*;

public class Houses {
    static int findVal(int n , int[] a){
        int maxi=0;
        int val1=0,val2=0;
        for(int i =0;i<n;i+=2){
            val1+=a[i];
        }
        for(int i =1;i<n;i++){
            val2+=a[i];
        }
        maxi = Math.max(val1, val2);
        return maxi;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a= new int[n];
        for(int i =0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int ans = findVal(n,a);
        System.out.print(ans);
        
    }
    
}
