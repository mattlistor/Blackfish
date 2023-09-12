
package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;

public class MON_Jellyfish_2 extends Entity {
GamePanel gp;
	
	public MON_Jellyfish_2(GamePanel gp, String startDirection) {
		super(gp);
		this.gp = gp;
		
		type = type_monster;
		name = "Blue Jelly";
		speed = 2;
		maxLife = 4;
		currentLife = maxLife;
		attack = 1;
		defense = 0;
		exp = 2;
		direction = startDirection;
		
		solidArea.x = 12;
		solidArea.y = 30;
		solidArea.width = 40;
		solidArea.height = 30;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
	}
	public void getImage() {
		up1 = setup("/monster/jellyfish_2_up1", gp.tileSize, gp.tileSize);
		up2 = setup("/monster/jellyfish_2_up2", gp.tileSize, gp.tileSize);	
		up3 = setup("/monster/jellyfish_2_up3", gp.tileSize, gp.tileSize);		
		up4 = setup("/monster/jellyfish_2_up4", gp.tileSize, gp.tileSize);	
		down1 = setup("/monster/jellyfish_2_up1", gp.tileSize, gp.tileSize);
		down2 = setup("/monster/jellyfish_2_up2", gp.tileSize, gp.tileSize);	
		down3 = setup("/monster/jellyfish_2_up3", gp.tileSize, gp.tileSize);		
		down4 = setup("/monster/jellyfish_2_up4", gp.tileSize, gp.tileSize);
		left1 = setup("/monster/jellyfish_2_up1", gp.tileSize, gp.tileSize);
		left2 = setup("/monster/jellyfish_2_up2", gp.tileSize, gp.tileSize);
		left3 = setup("/monster/jellyfish_2_up3", gp.tileSize, gp.tileSize);
		left4 = setup("/monster/jellyfish_2_up4", gp.tileSize, gp.tileSize);
		
		right1 = setup("/monster/jellyfish_2_up1", gp.tileSize, gp.tileSize);
		right2 = setup("/monster/jellyfish_2_up2", gp.tileSize, gp.tileSize);
		right3 = setup("/monster/jellyfish_2_up3", gp.tileSize, gp.tileSize);
		right4 = setup("/monster/jellyfish_2_up4", gp.tileSize, gp.tileSize);

		
	}
	public void setAction() { 
		actionLockCounter++;
		if(actionLockCounter ==220) {
			Random random = new Random();
			int i = random.nextInt(50)+1; // number from 1-100
			
			if(direction == "down") {
				direction = "up";	
			}
			else if(direction == "up") {
				direction = "down";	
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
		spriteCounter++;
		if(spriteCounter <= 20) {
			spriteNum = 1;	
		}
		if(spriteCounter > 20  && spriteCounter <= 80) {
			spriteNum = 2;
		}
		if(spriteCounter > 80 && spriteCounter <= 130 ) {
			spriteNum = 3;
			move();
		}
		if(spriteCounter > 130 && spriteCounter <= 160 ) {
			spriteNum = 3;
			moveHalfSpeed();
		}
		if(spriteCounter > 160 && spriteCounter < 220 ) {
			spriteNum = 4;	
			moveHalfSpeed();
		}

		if (spriteCounter >= 220) {
			spriteCounter = 0;
		}
	}
	public void move() {
		if(collisionOn == false ) {
			switch (direction) {
				case "up": worldY -= speed; break;
				case "down": worldY += speed; break;
				case "left": worldX -= speed; break;
				case "right": worldX += speed; break;
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
