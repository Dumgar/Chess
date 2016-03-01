package game;

public class Player {
    String name;
    boolean color;
    boolean check = false;
    boolean mate = false;

    public Player(String name, boolean color) {
        this.name = name;
        this.color = color;
    }
}
