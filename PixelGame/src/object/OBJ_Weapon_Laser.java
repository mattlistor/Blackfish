package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Weapon_Laser extends Entity {
	
	public OBJ_Weapon_Laser(GamePanel gp) {
		super(gp);
		type = type_laser;
		name = "Laser";
		down1 = setup("/object/laser", gp.tileSize, gp.tileSize);
		right1 = setup("/object/laser", gp.tileSize, gp.tileSize);

		attackValue = 1;
		description = "["+name+"]\nIt's laser\ntime baby. Zap.";
		
		solidArea.x = 10;
		solidArea.y = 27;
		solidArea.width = 50;
		solidArea.height = 15;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
	}

}
