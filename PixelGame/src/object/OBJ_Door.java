package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_Door extends Entity {

	GamePanel gp;

	public OBJ_Door(GamePanel gp) {
		
		super(gp);
		this.gp = gp;
		
		name = "Door";
		down1 = setup("/objects/door", gp.tileSize, gp.tileSize);
		right1 = setup("/objects/door", gp.tileSize, gp.tileSize);

		collision = true;
		solidArea.x = 16;
		solidArea.y = 16; 
		solidArea.width = 32;
		solidArea.height = 32;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		setDialogue();
		
	}
	public void setDialogue() {
//		dialogues[0][0] = "You drink the "+name+".\nYour health has been recovered by 5.";
	}
}
