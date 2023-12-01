import java.util.Scanner;

public class NewAtmDesign {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int withdrawalAmount = scanner.nextInt();
        int note100 = scanner.nextInt(); 
        int note200 = scanner.nextInt(); 
        int note500 = scanner.nextInt(); 
        int note1000 = scanner.nextInt(); 

        int maxNotes = calculateMaxNotes(N, withdrawalAmount, note100, note200, note500, note1000);

        System.out.println(maxNotes);

        scanner.close();
    }

    private static int calculateMaxNotes(int N, int withdrawalAmount, int note100, int note200, int note500, int note1000) {
        int max1000 = Math.min(note1000, withdrawalAmount / 1000);
        int max500 = Math.min(note500, (withdrawalAmount - max1000 * 1000) / 500);
        int max200 = Math.min(note200, (withdrawalAmount - max1000 * 1000 - max500 * 500) / 200);
    
        int max100 = Math.min(note100, (withdrawalAmount - max1000 * 1000 - max500 * 500 - max200 * 200) / 100);
    
        int totalNotes = max1000 + max500 + max200 + max100;
    
        if (totalNotes > N) {
            totalNotes = N;
        }
        return totalNotes;
    }
    
}
