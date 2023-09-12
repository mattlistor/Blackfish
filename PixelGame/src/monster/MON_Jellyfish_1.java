 
package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;

public class MON_Jellyfish_1 extends Entity {
GamePanel gp;
	
	public MON_Jellyfish_1(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_monster;
		name = "Purple Jelly";
		defaultSpeed = 2;
		speed = defaultSpeed;
		maxLife = 4;
		currentLife = maxLife;
		attack = 1;
		defense = 0;
		exp = 2;
		direction = "down";
		
		solidArea.x = 12;
		solidArea.y = 30;
		solidArea.width = 40;
		solidArea.height = 30;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
	}
	public void getImage() {
		up1 = setup("/monster/jellyfish_3_up1", gp.tileSize, gp.tileSize);
		up2 = setup("/monster/jellyfish_3_up2", gp.tileSize, gp.tileSize);	
		up3 = setup("/monster/jellyfish_3_up3", gp.tileSize, gp.tileSize);		
		up4 = setup("/monster/jellyfish_3_up4", gp.tileSize, gp.tileSize);	
		down1 = setup("/monster/jellyfish_3_up1", gp.tileSize, gp.tileSize);
		down2 = setup("/monster/jellyfish_3_up2", gp.tileSize, gp.tileSize);	
		down3 = setup("/monster/jellyfish_3_up3", gp.tileSize, gp.tileSize);		
		down4 = setup("/monster/jellyfish_3_up4", gp.tileSize, gp.tileSize);
		left1 = setup("/monster/jellyfish_3_up1", gp.tileSize, gp.tileSize);
		left2 = setup("/monster/jellyfish_3_up2", gp.tileSize, gp.tileSize);
		left3 = setup("/monster/jellyfish_3_up3", gp.tileSize, gp.tileSize);
		left4 = setup("/monster/jellyfish_3_up4", gp.tileSize, gp.tileSize);
		
		right1 = setup("/monster/jellyfish_3_up1", gp.tileSize, gp.tileSize);
		right2 = setup("/monster/jellyfish_3_up2", gp.tileSize, gp.tileSize);
		right3 = setup("/monster/jellyfish_3_up3", gp.tileSize, gp.tileSize);
		right4 = setup("/monster/jellyfish_3_up4", gp.tileSize, gp.tileSize);

		
	}
	public void setAction() { 
		actionLockCounter++;
		if(actionLockCounter == 240) {
			Random random = new Random();
			int i = random.nextInt(50)+1; // number from 1-100
			
			switch(direction) {
			case "up":
				direction = "down";
				break;
			case "down":
				direction = "up";
				break;
			}
//			if(i > 50 && i <= 75 ) {
//				direction = "up";
//			}
//			if(i > 75 && i <= 100 ) {
//				direction = "down";	
//			}
			actionLockCounter = 0;
		}
	}
	public void damageReaction() {
		actionLockCounter = 0;
//		speed = 2;
//		direction = gp.player.facingDirectoin;
	}
	public void spriteNumAndMovementHandler() {
		if(collisionOn == true) {
			switch(collisionDirection) {
			case "up":
				direction = "down";
				break;
			case "down":
				direction = "up";
				break;
			}
		}
		spriteCounter++;
		if(spriteCounter <= 60) {
			spriteNum = 1;	
		}
		if(spriteCounter > 60  && spriteCounter <= 100) {
			spriteNum = 2;
		}
		if(spriteCounter > 100 && spriteCounter <= 130 ) {
			spriteNum = 3;
			move();
		}
		if(spriteCounter > 130 && spriteCounter <= 180 ) {
			spriteNum = 3;
			moveHalfSpeed();
		}
		if(spriteCounter > 180 && spriteCounter < 240 ) {
			spriteNum = 4;	
			moveHalfSpeed();
		}

		if (spriteCounter >= 240) {
			spriteCounter = 0;
		}
	}
	public void move() {
		if(collisionOn == false ) {
			switch (direction) {
				case "up": worldY -= speed*2; break;
				case "down": worldY += speed*2; break;
				case "left": worldX -= speed*2; break;
				case "right": worldX += speed*2; break;
			}
		}
	}
	public void moveHalfSpeed() {
		if(collisionOn == false ) {
			switch (direction) {
				case "up": worldY -= speed/2; break;
				case "down": worldY += speed/2; break;
				case "left": worldX -= speed/2; break;
				case "right": worldX += speed/2; break;
			}
		}
	}
}
