import java.lang.Math;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class Game {
    Player player1;
    Player player2;
    int numPieces;
    int changeVal;
    boolean player1Turn;
    String compVal;
    int randVal;
    Scanner sc = new Scanner(System.in);
    String name;
    String[] messages = {"You suck!", "I'm going to win!", "Was that really the right move?", "I've met one line algorithms who play better than you!", "Your chances of winning are zero!", "Wrong move!", "That was a misplay.", "Resign now!", "Quit while you stlil can!", "That was the only wrong move you could've made..."};
    public Game() {
        System.out.println("Please enter your name:");
        name = sc.nextLine();
        System.out.println("Is " + name + " a computer? Please enter 'true' or 'false'");
        compVal = sc.nextLine();
        System.out.println("Welcome to the game " + name + "!\n");
        player1 = new Player(name, compVal);
        System.out.println("Please enter your name:");
        name = sc.nextLine();   
        System.out.println("Is " + name + " a computer? Please enter 'true' or 'false'");
        compVal = sc.nextLine();
        System.out.println("Welcome to the game " + name + "!\n");
        player2 = new Player(name, compVal);
        numPieces = (10 + (int)(Math.random() * 40) + 1);
        if ((Math.random() * 2) == 1) {
            player1Turn = true;
        } else {
            player1Turn = false;
        }   
    }

    public void playAgain() {
        numPieces = (10 + (int)(Math.random() * 40) + 1);
        if ((Math.random() * 2) == 1) {
            player1Turn = true;
        } else {
            player1Turn = false;
        }   
    }
    public void play() {

        while (numPieces > 1) {
            System.out.println("There are currently " + numPieces + " left in the pile.");
            if (player1Turn) {
                if (player1.getComp().equals("true")){
                    randVal = (int)(Math.random()*(numPieces/2)+1);
                    numPieces -= randVal; 
                    System.out.println(player1.getName() + " took " + randVal + " pieces.");
                    System.out.println(messages[(int)(Math.random() * messages.length)]);
                    try { 
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    player1Turn = false;
                }   
                else{
                    System.out.println(player1.getName() + ", please enter the number of pieces you want to take:");
                    changeVal = sc.nextInt();
                    if (changeVal <= (numPieces/2) && changeVal > 0){
                        numPieces -= changeVal;
                        player1Turn = false;
                    } else {
                        System.out.println("Invalid response, please try again.");
                    } 
            }
            }
            else{
                if (player2.getComp().equals("true")){
                    randVal = (int)(Math.random()*(numPieces/2)+1);
                    numPieces -= randVal;
                    System.out.println(player2.getName() + " took " + randVal + " pieces.");
                    System.out.println(messages[(int)(Math.random() * messages.length)]);
                    try { 
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    player1Turn = true;
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
    }
    if (player1Turn){
        System.out.println(player2.getName() + " has won!");
    }
    else{
        System.out.println(player1.getName() + " has won!");
    }
    }
}