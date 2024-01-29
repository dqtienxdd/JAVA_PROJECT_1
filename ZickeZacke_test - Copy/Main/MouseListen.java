package Main;
import Main.GamePanel;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import org.w3c.dom.events.MouseEvent;

import Octagon.Octagon;
import Octagon.OctagonManager;



public class MouseListen implements MouseListener{
    GamePanel gp;
    UI ui;
    boolean chooseStart, chooseExit;
    public String choose;

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        
        // Octagon[] octagons = OctagonManager.getArray();
        // gp.flip=true;
        // gp.direction=1;
        
        // for(Octagon oct1: octagons)
        // {
        //     if(oct1.collision(e.getX(), e.getY()))
        //     {
        //         gp.selected=oct1.getIndex();
        //     }
        //     gp.count++;
        // }
        // public Rectangle playButton = new Rectangle(261,303, 240, 48);
        // public Rectangle ExitButton = new Rectangle(261,303 + 48, 240, 48);
        // int mx = e.getX();
        // int my = e.getY();
        
        // if(mx >= 261 && mx<= 261+240){
        //     if(my >= 303 && my<= 303+48){
        //         gameState=playState;
        //     }
        // }
        // if(mx >= 261 && mx<= 261+240){
        //     if(my >= 303+48 && my<= 303+48+48){
        //         System.exit(1);
        //     }
        // }
        
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        
    }
}
