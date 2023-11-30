import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Game g = new Game();
        String playAgain;
        g.play();
        System.out.println("Please enter 'yes' if you want to play again:");
        playAgain = sc.nextLine();   
        while (playAgain.equals("yes")){
            g.playAgain();     
            g.play();
            System.out.println("Please enter 'yes' if you want to play again:");
            playAgain = sc.nextLine();   
        }
        
        
    }
}
