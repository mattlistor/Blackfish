package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Shield extends Entity {

	public OBJ_Shield(GamePanel gp) {
		super(gp);	
		type = type_shield;
		name = "Bubble";
		down1 = setup("/object/shield", gp.tileSize, gp.tileSize);
		defenseValue = 1;
		description = "["+name+"]\nBubbly\ndefense power.";
	}
}
