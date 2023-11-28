public class Runner {
    public static void main(String[] args) {
        Game g = new Game();
        String the;
        the = g.play();
        while (the.equals("yes")){
            the = g.play();
        }
        
    }
}
