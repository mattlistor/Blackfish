package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_Starfish_Wall extends Entity {
		
	public OBJ_Starfish_Wall(GamePanel gp, String facing) {
		super(gp);
		if(facing == "right") {
			down1 = setup("/objects/starfish_wall", gp.tileSize, gp.tileSize);
			right1 = setup("/objects/starfish_wall", gp.tileSize, gp.tileSize);
		}
		else if(facing == "left") {
			down1 = setup("/objects/starfish_wall_2", gp.tileSize, gp.tileSize);
			right1 = setup("/objects/starfish_wall_2", gp.tileSize, gp.tileSize);
		}
		
		solidArea.x = 0;
		solidArea.y = 0;
		solidArea.width = 0;
		solidArea.height = 0;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;		
	}
}
