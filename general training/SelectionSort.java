import java.util.*;
public class SelectionSort {
   static void sort(int[] a){
        int n =a.length;
        for(int i =0;i<n-1;i++){
            int mini =i;
            for(int j =i+1;j<n;j++){
                if(a[j]<a[mini]){
                    mini=j;
                }
            }
            int temp =a[mini];
            a[mini]=a[i];
            a[i]=temp;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i =0;i<n;i++){
            a[i]=sc.nextInt();
        }
        sort(a);
        for(in)
    }
    
}
