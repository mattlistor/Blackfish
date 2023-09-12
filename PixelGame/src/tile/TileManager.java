package tile;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class TileManager {

	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][][];
	
	public TileManager(GamePanel gp) {
		
		this.gp = gp;
		tile = new Tile[50];
		mapTileNum = new int[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage();
		loadMap("/maps/map02.txt", 0);
		loadMap("/maps/map03.txt", 1);
	}
	
	public void getTileImage() {
		setup(0, "transparent", false, "none");
		setup(1, "rock_bottom_2_with_shadow", true, "bottom");
		setup(2, "rock_top_2_with_shadow", true, "top");
		setup(3, "rock_left_2_with_shadow", true, "left");
		setup(4, "rock_right_2_with_shadow", true, "right");
		setup(5, "rock_bottom_left_2_with_shadow", true, "none");
		setup(6, "rock_bottom_right_2_with_shadow", true, "none");
		setup(7, "rock_top_left_2_with_shadow", true, "none");
		setup(8, "rock_top_right_2_with_shadow", true, "none");
		setup(9, "black", true, "none");
		setup(10, "water_seaweed", false, "none");
		setup(11, "rock_top_right_outer_2_with_shadow", true, "none");
		setup(12, "rock_top_left_outer_2_with_shadow", true, "none");
		setup(13, "rock_bottom_right_outer_2_with_shadow", true, "none");
		setup(14, "rock_bottom_left_outer_2_with_shadow", true, "none");
		setup(15, "water_2", false, "none");
}
	
	public void setup(int index, String imageName, boolean collision, String wall) {
		UtilityTool uTool = new UtilityTool();
		
		try {
			tile[index] = new Tile();
			tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + imageName + ".png"));
			tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
			tile[index].collision = collision;
			tile[index].wall = wall;
			
		} catch(IOException e) {
			e.printStackTrace();	
		}
	}
	
	public void loadMap(String filePath, int map) {
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				
				String line = br.readLine();
				
				while(col < gp.maxWorldCol) {
					
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[map][col][row] = num;
					col++;
				}
				if(col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
				
			}
			
		} catch(Exception e) {
			
		}
	}
	
	public void draw(Graphics2D g2, int offsetX) {
		
		int worldCol = 0;
		int worldRow = 0;
	
		
		while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[gp.currentMap][worldCol][worldRow];
			
			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			
			//decides what tiles to draw (in window)
//			g2.drawImage(tile[tileNum].image, screenX, screenY, null);
//
			
			if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
			   worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
			   worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
			   worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
				g2.drawImage(tile[tileNum].image, screenX, screenY, null);

			}
			worldCol++;
			
			if(worldCol == gp.maxWorldCol) {
				worldCol = 0;
				worldRow++;
			}
		}
	}
}
