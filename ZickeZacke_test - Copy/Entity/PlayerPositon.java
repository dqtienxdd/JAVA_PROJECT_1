package Entity;

import java.awt.Point;
import java.awt.geom.Point2D;

import Main.GamePanel;
import Octagon.Octagon;

public class PlayerPositon {
    GamePanel gp;
    int x,y;
    public MapCoordinate[] xy;
    public PlayerPositon(GamePanel gp){
        this.gp = gp;
        xy = new MapCoordinate[24];
    }
    public void getPlayerPosition(){
        for(int i=0; i<12; i++){
            xy[i] = new MapCoordinate(i,i);
        }
        xy[0].setX(100);
        xy[0].setY(20);
    }  
}
    
