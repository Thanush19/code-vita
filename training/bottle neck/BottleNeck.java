import java.util.*;

public class BottleNeck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i =0;i<n;i++){
            a[i]=sc.nextInt();

        }
        Arrays.sort(a);
        for(int i =0;i<n-1;i++){
            for(int j =1;j<n-1;j++){
                if(a[i]<a[j] && (a[i]!=0 && a[j]!=0)){
                    a[i]=0;
                    a[j]=0;

                }
            }
        }
        int cnt=0;
        for(int j =0;j<n;j++){
            if(a[j]!=0){
                cnt++;
            }
        }
        System.out.print(cnt);

        
    }
    
}
