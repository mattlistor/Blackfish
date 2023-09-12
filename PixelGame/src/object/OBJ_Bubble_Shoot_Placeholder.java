package object;

import entity.Entity;
import entity.Projectile;
import main.GamePanel;

public class OBJ_Bubble_Shoot_Placeholder extends Entity{

	GamePanel gp;
	public Entity user;
	
	public OBJ_Bubble_Shoot_Placeholder(GamePanel gp) {
		super(gp);
		this.gp = gp;
		type = type_consumable;
		name = "Bubble Shoot Placeholder";
		right1 = setup("/projectiles/water_balls", gp.tileSize, gp.tileSize);
		down1 = setup("/projectiles/water_balls", gp.tileSize, gp.tileSize);
		image = setup("/projectiles/water_balls", gp.tileSize, gp.tileSize);
		
		solidArea.x = 20;
		solidArea.y = 20;
		solidArea.width = 25;
		solidArea.height = 30;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		setDialogue();
		
	}
	public void setDialogue() {
		dialogues[0][0] = "You got Bubble Shoot! Press [Start] to\nview your inventory.";
	}
}

