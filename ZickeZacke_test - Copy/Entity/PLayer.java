package Entity;
import Main.GamePanel;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;



public class PLayer extends Entity {
    GamePanel gp;
    

    public PLayer(GamePanel gp ){
        this.gp = gp;
        

        setDefaultValue();
        getPlayerImage();
    }
    public void setDefaultValue(){
        
    }
    public void getPlayerImage(){
        try{
           
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void update(){
        
    }
    public void draw(Graphics2D g2){
        BufferedImage image = null;
       
       
        
    
    }
}
