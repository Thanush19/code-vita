import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChakravyuhaTest {
    public static int[][] spiral(int n){
        int[][] matrix =new int[n][n];
        int cnt =1;
        int num = 1;
        int top = 0, bottom = n- 1, left = 0, right = n - 1;


        while (num <= n * n) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
             
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
              
            }
            right--;

            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = num++;
               
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = num++;
                
            }
            left++;
        }      
        return matrix;

    }
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = spiral(n);
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
         List<String> list = new ArrayList<>();
        list.add("(0"+"0)");
        int cnt=1;
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                if(a[i][j]%11==0){
                    list.add(i+" "+j);
                     cnt++;
                }
               
            }
        }
        System.out.println(cnt);
        // for(String i : list){
        //     System.out.println(i);
        // }
        

    }

    
}
