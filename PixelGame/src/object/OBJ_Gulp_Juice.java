package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Gulp_Juice extends Entity {
	
	GamePanel gp;
	int value = 5;

	public OBJ_Gulp_Juice(GamePanel gp) {
		super(gp);
		this.gp = gp;
		type = type_consumable;
		name = "Gulp! Juice";
		right1 = setup("/objects/gulp_juice", gp.tileSize, gp.tileSize);
		down1 = setup("/objects/gulp_juice", gp.tileSize, gp.tileSize);
		description = "["+name+"]\nHeals you by five.";
		
		solidArea.x = 20;
		solidArea.y = 20;
		solidArea.width = 25;
		solidArea.height = 30;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		setDialogue();
	}
	public void setDialogue() {
		dialogues[0][0] = "You drink the "+name+".\nYour health has been recovered by 5.";
	}
	public void use(Entity entity) {
		entity.currentLife += value;
		if(gp.player.currentLife > gp.player.maxLife) {
			gp.player.currentLife = gp.player.maxLife;			
		}
		startDialogue(this, 0);
		gp.playSE(8);
	}

}
