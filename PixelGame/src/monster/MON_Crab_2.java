package monster;

import java.util.Random;
import entity.Entity;
import main.GamePanel;

public class MON_Crab_2 extends Entity {
	
	GamePanel gp;
	
	public MON_Crab_2(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_monster;
		name = "Green Crab";
		speed = 1;
		maxLife = 4;
		currentLife = maxLife;
		attack = 1;
		defense = 0;
		exp = 2;
		
		solidArea.x = 12;
		solidArea.y = 10;
		solidArea.width = 40;
		solidArea.height = 30;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
	}
	public void getImage() {
		up1 = setup("/monster/green_crab_right1", gp.tileSize, gp.tileSize);
		up2 = setup("/monster/green_crab_right2", gp.tileSize, gp.tileSize);	
		up3 = setup("/monster/green_crab_right3", gp.tileSize, gp.tileSize);		
		up4 = setup("/monster/green_crab_right4", gp.tileSize, gp.tileSize);	
		down1 = setup("/monster/green_crab_right1", gp.tileSize, gp.tileSize);
		down2 = setup("/monster/green_crab_right2", gp.tileSize, gp.tileSize);
		down3 = setup("/monster/green_crab_right3", gp.tileSize, gp.tileSize);
		down4 = setup("/monster/green_crab_right4", gp.tileSize, gp.tileSize);
		right1 = setup("/monster/green_crab_right1", gp.tileSize, gp.tileSize);
		right2 = setup("/monster/green_crab_right2", gp.tileSize, gp.tileSize);	
		right3 = setup("/monster/green_crab_right3", gp.tileSize, gp.tileSize);		
		right4 = setup("/monster/green_crab_right4", gp.tileSize, gp.tileSize);		
		left1 = setup("/monster/green_crab_right1", gp.tileSize, gp.tileSize);
		left2 = setup("/monster/green_crab_right2", gp.tileSize, gp.tileSize);
		left3 = setup("/monster/green_crab_right3", gp.tileSize, gp.tileSize);
		left4 = setup("/monster/green_crab_right4", gp.tileSize, gp.tileSize);

	}
	public void setAction() { 
		actionLockCounter++;
		if(actionLockCounter == 120) {
			Random random = new Random();
			int i = random.nextInt(50)+1; // number from 1-100
			
			if(i <= 25) {
				direction = "left";	
			}
			if(i > 25 && i <= 50 ) {
				direction = "right";	
			}
			actionLockCounter = 0;
		}
	}
	public void damageReaction() {
		actionLockCounter = 0;
		speed = 1;
		direction = gp.player.facingDirectoin;
	}
	public void spriteNumAndMovementHandler() {
		
		if(collisionOn == false ) {
			switch (direction) {
				case "up": {worldY -= speed;} break;
				case "down": {worldY += speed;} break;
				case "left": {worldX -= speed;} break;
				case "right": {worldX += speed;} break;
			}
		}
		
		spriteCounter++;
		if(spriteCounter <= 20) {
			spriteNum = 1;	
		}
		if(spriteCounter > 20 && spriteCounter <= 40 ) {
			spriteNum = 2;
		}
		if(spriteCounter > 40 && spriteCounter <= 60 ) {
			spriteNum = 3;	
		}
		if(spriteCounter > 60 && spriteCounter < 80 ) {
			spriteNum = 4;	
		}

		if (spriteCounter >= 80) {
			spriteCounter = 0;
		}
		
	}

}
