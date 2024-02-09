package Entity;

public class MapCoordinate {
    public int x=0;
    public int y =0;
    
    public MapCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void setCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void setX(int x)
    {
        this.x=x;
    }
    public void setY(int y)
    {
        this.y=y;
    }
    public int getX() {
        return x;
    }
 
    public int getY() {
        return y;
    }
}
