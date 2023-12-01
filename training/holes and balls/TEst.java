import java.util.*;
public class TEst {
    static void count(ArrayList<Integer> b, ArrayList<Integer> h) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i =0;i<h.size();i++){
            mp.put(i+1,mp.getOrDefault(mp, 0));
        }
        for(int i =0;i<b.size();i++){
            boolean placed =false;
            int ball = b.get(i);
            for(int j =h.size()-1;j>=0;j--){
                int hei = h.get(i);
                if(mp.get(j+1)<(j+1) && ball<=hei){
                    ball=(j+1);
                    mp.put((j+1),mp.get((j+1))+1);
                    placed=true;
                    break;


                }
                if(!placed){
                    ball=0;
                }
            }
        }

        for(int i =0;i<b.size();i++){
            System.out.print(b.get(i)+" ");
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        int h = sc.nextInt();
        ArrayList<Integer> balls = new ArrayList<>();
        ArrayList<Integer> height= new ArrayList<>();
        for(int i=0;i<b;i++){
            int a = sc.nextInt();
            balls.add(a);
            
        }
        for(int i=0;i<h;i++){
            int a = sc.nextInt();
            balls.add(a);

        }
        count(balls,height);

    }
    
}
