package Tile;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

import javax.imageio.ImageIO;

import Main.GamePanel;

public class TileManager {
    GamePanel gp;
    Tile[] tile;
    int mapTileNum [] [];
    
    Tile[] egg;
    public static void shuffleArray(Tile[] array) {
        Random random = new Random();
        int n = array.length;
        
        for (int i = 0; i < n; i++) {
            int randomIndex = i + random.nextInt(n - i);
            Tile temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
    }
    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[10];
        egg = new Tile[24];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        
        getTileImage();
        loadMap("/res/Map/map1.txt");
    }
    public void getTileImage(){
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/floor01.png"));

            egg[0] = new Tile();
            egg[0].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/chick.png"));

            egg[1] = new Tile();
            egg[1].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/connhim.png"));

            egg[2] = new Tile();
            egg[2].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/eggs.png"));

            egg[3] = new Tile();
            egg[3].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/feather.png"));

            egg[4] = new Tile();
            egg[4].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/flower.png"));

            egg[5] = new Tile();
            egg[5].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/hotvitlon.png"));

            egg[6] = new Tile();
            egg[6].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/omelette.png"));

            egg[7] = new Tile();
            egg[7].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/rabbit.png"));

            egg[8] = new Tile();
            egg[8].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/sadchick.png"));

            egg[9] = new Tile();
            egg[9].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/snail.png"));

            egg[10] = new Tile();
            egg[10].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/worm.png"));

            egg[11] = new Tile();
            egg[11].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/worm7mau.png"));

            egg[12] = new Tile();
            egg[12].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/chick.png"));

            egg[13] = new Tile();
            egg[13].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/connhim.png"));

            egg[14] = new Tile();
            egg[14].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/feather.png"));

            egg[15] = new Tile();
            egg[15].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/flower.png"));

            egg[16] = new Tile();
            egg[16].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/hotvitlon.png"));

            egg[17] = new Tile();
            egg[17].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/omelette.png"));

            egg[18] = new Tile();
            egg[18].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/rabbit.png"));

            egg[19] = new Tile();
            egg[19].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/sadchick.png"));

            egg[20] = new Tile();
            egg[20].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/snail.png"));

            egg[21] = new Tile();
            egg[21].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/worm.png"));

            egg[22] = new Tile();
            egg[22].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/worm7mau.png"));

            egg[23] = new Tile();
            egg[23].image = ImageIO.read(getClass().getResourceAsStream("/res/Tile/eggs.png"));

            shuffleArray(egg);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadMap(String filePath){
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;
            while(col < gp.maxScreenCol && row < gp.maxScreenRow){
                String line = br.readLine();
                
                while(col < gp.maxScreenCol){
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxScreenCol){
                    col = 0;
                    row++;
                }
                
            }
            br.close();
        } catch (Exception e) {
            
        }
    }
        
    public void draw(Graphics2D g2){
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        int mapX = (gp.screenWidth - gp.maprow*(gp.eggwidth+5)) / 2;
        int mapY = (gp.screenHeight - gp.mapcol*(gp.eggheight+5)) / 2;
        int maprow = 0;
        int mapcol = 0;
        int track = 0;
        while(col < gp.maxScreenCol && row < gp.maxScreenRow){
            int tileNum = mapTileNum[col][row];
            
            g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;

            if(col == gp.maxScreenCol){
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        
        }
        while(maprow < gp.maprow && mapcol < gp.mapcol ){
            g2.drawImage(egg[track].image, mapX, mapY, gp.eggwidth, gp.eggheight, null); 
            track++;
            maprow++;
            mapX += gp.eggwidth + 5;
            if(maprow == gp.maprow){
                while(mapcol < gp.mapcol-1){
                    mapY += gp.eggheight + 5;
                    g2.drawImage(egg[track].image, mapX - gp.eggwidth - 5 , mapY, gp.eggwidth, gp.eggheight, null);
                    mapcol++;
                    track++;
                }
            }  
        }
        if(mapcol == gp.mapcol-1){
            mapX = mapX - gp.eggwidth - 5;
            maprow --;
            while(maprow > 0){
                maprow--;
                mapX = mapX - gp.eggwidth - 5;
                g2.drawImage(egg[track].image, mapX, mapY, gp.eggwidth, gp.eggheight, null);
                track++;
                
            }

        }
        if(maprow == 0){
            mapcol --;
            while(mapcol > 0){
                mapcol--;
                mapY = mapY - gp.eggheight - 5;
                
                g2.drawImage(egg[track].image, mapX, mapY, gp.eggwidth, gp.eggheight, null);
                track++;
            }

        }
        
        
    }
}
