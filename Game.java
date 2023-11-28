import java.lang.Math;
import java.util.Scanner;

public class Game {
    Player player1;
    Playe player2;
    int numPieces;
    int changeVal;
    boolean player1Turn;
    Scanner sc = new Scanner(System.in);
    String name;
    public Game() {
        System.out.println("Please enter your name:");
        name = sc.nextLine();
        System.out.println("Welcome to the game " + name + "!\n");
        player1 = new Player(name);
        System.out.println("Please enter your name:");
        name = sc.nextLine();
        System.out.println("Welcome to the game " + name + "!\n");
        player2 = new Player(name);
        numPieces = (10 + (Math.random() * 40 + 1));
        if ((Math.random() * 2) == 1) {
            player1Turn = true;
        } else {
            player1Turn = false;
        }   
    }

    public void play() {

        while (numPieces > 1) {
            if (player1Turn) {
                System.out.println(player1.getName() + ", please enter the number of pieces you want to take:");
                changeVal = sc.nextInt();
                if (changeVal <= (numPieces/2)){
                    numPieces -= changeVal;
                player1Turn = false;
                }
            }
            else{
                System.out.println(player2.getName() + ", please enter the number of pieces you want to take:");
                changeVal = sc.nextInt();
                if (changeVal <= (numPieces/2)){
                    numPieces -= changeVal;
                player1Turn = true;
            }
        }
    }
    if (player1True){
        System.out.println("Player 2 has won!");
    }
    else{
        System.out.println("Player 1 has won!");
    }
    }
}