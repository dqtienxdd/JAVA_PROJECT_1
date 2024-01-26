package Entity;

public class Player extends Entity {
    String name;
    int position;
    int index;
    public Player(String name, int position, int index){
        this.name = name;
        this.position = position;
        this.index = index;
    }
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}
