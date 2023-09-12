
package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;

public class MON_Fluke extends Entity {
	GamePanel gp;
	Random random = new Random();
	int firstTimeNum = random.nextInt(80)+1;
	boolean firstTime = true;
	
	public MON_Fluke(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_monster;
		name = "Fluke";
		speed = 2;
		maxLife = 2;
		currentLife = maxLife;
		attack = 1;
		defense = 0;
		exp = 2;
		if(firstTime == true) { 
			firstTime = false;
			spriteCounter = firstTimeNum;
		}
		direction = "right";
		
		solidArea.x = 0;
		solidArea.y = 30;
		solidArea.width = gp.tileSize;
		solidArea.height = 5;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
	}
	public void getImage() {
		left1 = setup("/monster/fluke_left1", gp.tileSize, gp.tileSize);
		left2 = setup("/monster/fluke_left2", gp.tileSize, gp.tileSize);
		left3 = setup("/monster/fluke_left3", gp.tileSize, gp.tileSize);
		left4 = setup("/monster/fluke_left4", gp.tileSize, gp.tileSize);
		
		right1 = setup("/monster/fluke1", gp.tileSize, gp.tileSize);
		right2 = setup("/monster/fluke2", gp.tileSize, gp.tileSize);
		right3 = setup("/monster/fluke3", gp.tileSize, gp.tileSize);
		right4 = setup("/monster/fluke4", gp.tileSize, gp.tileSize);

		
	}
	public void setAction() { 
		actionLockCounter++;
		if(actionLockCounter == 240) {
			Random random = new Random();
			int i = random.nextInt(50)+1; // number from 1-100
			
			if(i <= 25) {
				direction = "left";	
			}
			if(i > 25 && i <= 50 ) {
				direction = "right";	
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
		speed = 2;
		direction = gp.player.facingDirectoin;
	}
	public void spriteNumAndMovementHandler() {
		spriteCounter++;
		if(spriteCounter <= 60) {
			spriteNum = 1;	
			move();
		}
		if(spriteCounter > 60  && spriteCounter <= 100) {
			spriteNum = 2;
			moveHalfSpeed();
		}
		if(spriteCounter > 100 && spriteCounter <= 180 ) {
			spriteNum = 3;
			moveHalfSpeed();

		}
		if(spriteCounter > 180 && spriteCounter < 240 ) {
			spriteNum = 4;	
			move();

		}

		if (spriteCounter >= 240) {
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
