import java.util.*;

public class Permutation {
    static void permute(String pre , String rem){
        if(rem.length()==0){
            System.out.println(pre);
            return;

        }
        for(int i =0;i<rem.length();i++){
            String newPre= pre+rem.charAt(i);
            String newRem = rem.substring(0,i)+rem.substring(i+1);
            permute(newPre, newRem);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        permute("",s);

        
    }
    
}
