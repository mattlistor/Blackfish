package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_Seaweed extends Entity {
		
	public OBJ_Seaweed(GamePanel gp) {
		super(gp);
		down1 = setup("/objects/water_seaweed", gp.tileSize, gp.tileSize);
		right1 = setup("/objects/water_seaweed", gp.tileSize, gp.tileSize);
		
		solidArea.x = 0;
		solidArea.y = 0;
		solidArea.width = 0;
		solidArea.height = 0;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;		
	}
}
