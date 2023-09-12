package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_Trap_Wall extends Entity {

	public OBJ_Trap_Wall(GamePanel gp) {
		super(gp);
		
		name = "Trap Wall";
		type = type_trap_wall;
		down1 = setup("/objects/trap_wall_horizontal", gp.tileSize, gp.tileSize);
		right1 = setup("/objects/trap_wall_horizontal", gp.tileSize, gp.tileSize);

		collision = true;
		solidArea.x = 0;
		solidArea.y = gp.tileSize/3; 
		solidArea.width = gp.tileSize*2;
		solidArea.height = gp.tileSize/2;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;

		
	}
}
