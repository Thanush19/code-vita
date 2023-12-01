import java.util.Scanner;
public class ZeroCount{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int l = sc.nextInt();
    int k = sc.nextInt();
    if(k>l){
      System.out.println("Invalid input");
      return;
    }
    int maxi = (k == 0)?l:1;
    System.out.println(maxi);
  }
}