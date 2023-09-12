package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Shield_2 extends Entity {

	public OBJ_Shield_2(GamePanel gp) {
		super(gp);	
		type = type_shield;
		name = "Bubble 2";
		down1 = setup("/object/shield_2", gp.tileSize, gp.tileSize);
		defenseValue = 1;
		description = "["+name+"]\nBubblier\ndefense power.";
	}
}
