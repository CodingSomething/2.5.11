public class Player {
    //Instance Variables:
    private String name;
    private String computer;

    //Constructor:
    public Player(String a, String b){
        name = a;
        computer = b;
    }

    //Accessor Methods:
    public String getName(){
        return name;
    }
    public String getComp(){
        return computer;
    }

}