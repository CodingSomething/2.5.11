import java.lang.Math;
import java.util.Scanner;

public class Game {
    Player player1;
    Player player2;
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
        numPieces = (10 + (int)(Math.random() * 40) + 1);
        if ((Math.random() * 2) == 1) {
            player1Turn = true;
        } else {
            player1Turn = false;
        }   
    }

    public String play() {

        while (numPieces > 1) {
            System.out.println("There are currently " + numPieces + " left in the pile.");
            if (player1Turn) {
                System.out.println(player1.getName() + ", please enter the number of pieces you want to take:");
                changeVal = sc.nextInt();
                if (changeVal <= (numPieces/2) && changeVal > 0){
                    numPieces -= changeVal;
                    player1Turn = false;
                } else {
                    System.out.println("Invalid response, please try again.");
                } 
            }
            else{
                System.out.println(player2.getName() + ", please enter the number of pieces you want to take:");
                changeVal = sc.nextInt();
                if (changeVal <= (numPieces/2) && changeVal > 0){
                    numPieces -= changeVal;
                    player1Turn = true;
                } else {
                    System.out.println("Invalid response, please try again.");
                }   
         }
    }
    if (player1Turn){
        System.out.println(player2.getName() + " has won!");
    }
    else{
        System.out.println(player1.getName() + " has won!");
    }
    System.out.println("Please enter \"yes\" if you want to play again");
    name = sc.nextLine();
    return name;
    }
}