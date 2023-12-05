import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        //Variables:
        Scanner sc = new Scanner(System.in);
        Game g = new Game();
        String playAgain;

        //Initializing Game:
        g.play();
        System.out.println("Please enter 'yes' if you want to play again:");
        playAgain = sc.nextLine();
        //Play Again Logic: as long as user inputs 'yes', will keep restarting the game with the same player states.   
        while (playAgain.equals("yes")){
            g.playAgain();     
            g.play();
            System.out.println("Please enter 'yes' if you want to play again:");
            playAgain = sc.nextLine();   
        }
        
        
    }
}
