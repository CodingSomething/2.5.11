public class Player {
    private String name;
    private boolean win = false;

    public Player(String a){
        name = a;
    }
    public String getName(){
        return name;
    }
    public boolean getWinVal(){
        return win;
    }
    public void winLoss(boolean b){
        win = b;
    }
}
