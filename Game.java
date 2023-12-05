import java.lang.Math;
import java.util.concurrent.TimeUnit;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    //Variables:
    private Player player1;
    private Player player2;
    private int numPieces;
    private int changeVal;
    private boolean player1Turn;
    private String compVal;
    private int randVal;
    private String name;
    private Scanner sc = new Scanner(System.in);
    private String[] messages = {"You suck!", "I'm going to win!", "Was that really the right move?", "I've met one line algorithms who play better than you!", "Your chances of winning are zero!", "Wrong move!", "That was a misplay.", "Resign now!", "Quit while you stlil can!", "That was the only wrong move you could've made..."};

    //Constructor, initializes player names & state (If they're a computer or not)
    public Game() {
        System.out.println("Please enter your name:");
        name = sc.nextLine();
        System.out.println("Is " + name + " a computer? Please enter 'true' if so.");
        compVal = sc.nextLine();
        //Console feedback to show if input was validated.
        if (compVal.equals("true")) {
            System.out.println(name + " is a computer!");
        } else {
            System.out.println(name + " is not a computer!");
        }
        System.out.println("Welcome to the game " + name + "!\n");
        player1 = new Player(name, compVal);
        System.out.println("Please enter your name:");
        name = sc.nextLine();   
        System.out.println("Is " + name + " a computer? Please enter 'true' if so.");
        compVal = sc.nextLine();
        //Console feedback to show if input was validated.
        if (compVal.equals("true")) {
            System.out.println(name + " is a computer!");
        } else {
            System.out.println(name + " is not a computer!");
        }
        System.out.println("Welcome to the game " + name + "!\n");
        player2 = new Player(name, compVal);
        //Random piece pile size
        numPieces = (10 + (int)(Math.random() * 40) + 1);
        //Random player turn
        if ((int)(Math.random() * 2) == 1) {
            player1Turn = true;
        } else {
            player1Turn = false;
        }   
    }

    //Play again method, resets pile size and sets random player turn.
    public void playAgain() {
        numPieces = (10 + (int)(Math.random() * 40) + 1);
        if ((int)(Math.random() * 2) == 1) {
            player1Turn = true;
        } else {
            player1Turn = false;
        }   
    }

    /* Main game method. 
    Will run a loop asking players to take pieces.
    Once pile size reaches zero, uses player1Turn to determine winner.
    */
    public void play() {
        while (numPieces > 1) {
            System.out.println("There are currently " + numPieces + " left in the pile.");
            //Player 1 Logic
            if (player1Turn) {
                //Computer logic, determines a valid amount to take from pile
                if (player1.getComp().equals("true")){
                    randVal = (int)(Math.random()*(numPieces/2)+1);
                    numPieces -= randVal;
                    //Artificial wait time to add realism and to prevent bot v. bot games from instantly ending.
                    try { 
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //Prints messages stating how many pieces were taken and a random message from the array messages.
                    System.out.println(player1.getName() + " took " + randVal + " pieces.");
                    System.out.println(player1.getName() + ": " + messages[(int)(Math.random() * messages.length)]);
                    player1Turn = false;
                }   
                //Player logic, asks user to input an amount to take from the pile. Will prompt the user again if the input was invalid.
                else{
                    System.out.println(player1.getName() + ", please enter the number of pieces you want to take:");
                    //Input Validation:
                    try {
                        changeVal = sc.nextInt();
                        if (changeVal <= (numPieces/2) && changeVal > 0){
                            numPieces -= changeVal;
                            player1Turn = false;
                        } else {
                            System.out.println("Invalid response, please try again.");
                        } 
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid response, please try again.");
                        sc.nextLine();
                    }
            }
            }
            //Player 2 Logic
            else{
                //Computer logic, determines a valid amount to take from pile
                if (player2.getComp().equals("true")){
                    randVal = (int)(Math.random()*(numPieces/2)+1);
                    numPieces -= randVal;
                    //Artificial wait time to add realism and to prevent bot v. bot games from instantly ending.
                    try { 
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //Prints messages stating how many pieces were taken and a random message from the array messages.
                    System.out.println(player2.getName() + " took " + randVal + " pieces.");
                    System.out.println(player2.getName() + ": " + messages[(int)(Math.random() * messages.length)]);
                    player1Turn = true;
                }  
                //Player logic, asks user to input an amount to take from the pile. Will prompt the user again if the input was invalid.
                else{ 
                    System.out.println(player2.getName() + ", please enter the number of pieces you want to take:");
                    //Input Validation:
                    try {
                        changeVal = sc.nextInt();
                        if (changeVal <= (numPieces/2) && changeVal > 0){
                            numPieces -= changeVal;
                            player1Turn = false;
                        } else {
                            System.out.println("Invalid response, please try again.");
                        } 
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid response, please try again.");
                        sc.nextLine();
                    }
            }
         }
    }
    //Winner logic, if player1Turn is true and there's only one piece in the pile, player2 must have won and vice versa.
    if (player1Turn){
        System.out.println(player2.getName() + " has won!");
    }
    else{
        System.out.println(player1.getName() + " has won!");
    }
    }
}