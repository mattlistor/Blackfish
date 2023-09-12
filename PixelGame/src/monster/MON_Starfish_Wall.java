
package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;

public class MON_Starfish_Wall extends Entity {
	GamePanel gp;
	Random random = new Random();
	int firstTimeNum = random.nextInt(240)+1;
	boolean firstTime = true;
	
	public MON_Starfish_Wall(GamePanel gp, String c) {
		super(gp);
	
		this.gp = gp;
		
		type = type_monster;
		name = "Starfish";
		speed = 2;
		maxLife = 4;
		currentLife = maxLife;
		attack = 1;
		defense = 100;
		exp = 2;
		if(firstTime == true) { 
			firstTime = false;
			spriteCounter = firstTimeNum;
		}
		direction = "up";
		color = c;
		// when monster has a color (String c), that makes it a puzzle piece 
		puzzlePiece = true;

		
		
		
		solidArea.x = 0;
		solidArea.y = 0;
		solidArea.width = gp.tileSize;
		solidArea.height = gp.tileSize;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
	}
	public MON_Starfish_Wall(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_monster;
		name = "Starfish";
		speed = 2;
		maxLife = 4;
		currentLife = maxLife;
		attack = 1;
		defense = 100;
		exp = 2;
		if(firstTime == true) { 
			firstTime = false;
			spriteCounter = firstTimeNum;
		}
		direction = "up";

		
		
		
		solidArea.x = 0;
		solidArea.y = 0;
		solidArea.width = gp.tileSize;
		solidArea.height = gp.tileSize;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
	}
	public void getImage() {
		switch(color) {
		case("orange"): 
			up1 = setup("/monster/starfish_orange1", gp.tileSize, gp.tileSize);
			up2 = setup("/monster/starfish_orange2", gp.tileSize, gp.tileSize);	
			up3 = setup("/monster/starfish_orange3", gp.tileSize, gp.tileSize);		
			up4 = setup("/monster/starfish_orange4", gp.tileSize, gp.tileSize);	
			down1 = setup("/monster/starfish_orange1", gp.tileSize, gp.tileSize);
			down2 = setup("/monster/starfish_orange2", gp.tileSize, gp.tileSize);	
			down3 = setup("/monster/starfish_orange3", gp.tileSize, gp.tileSize);		
			down4 = setup("/monster/starfish_orange4", gp.tileSize, gp.tileSize);
			left1 = setup("/monster/starfish_orange1", gp.tileSize, gp.tileSize);
			left2 = setup("/monster/starfish_orange2", gp.tileSize, gp.tileSize);
			left3 = setup("/monster/starfish_orange3", gp.tileSize, gp.tileSize);
			left4 = setup("/monster/starfish_orange4", gp.tileSize, gp.tileSize);
			right1 = setup("/monster/starfish_orange1", gp.tileSize, gp.tileSize);
			right2 = setup("/monster/starfish_orange2", gp.tileSize, gp.tileSize);
			right3 = setup("/monster/starfish_orange3", gp.tileSize, gp.tileSize);
			right4 = setup("/monster/starfish_orange4", gp.tileSize, gp.tileSize);
			dying1 = setup("/monster/starfish_orange1_dying1", gp.tileSize, gp.tileSize);
			dying2 = setup("/monster/starfish_orange1_dying2", gp.tileSize, gp.tileSize);
			dying3 = setup("/monster/starfish_orange1_dying3", gp.tileSize, gp.tileSize);
			dying4 = setup("/monster/starfish_orange1_dying4", gp.tileSize, gp.tileSize);

			break;
		case("purple"): 
			up1 = setup("/monster/starfish_purple1", gp.tileSize, gp.tileSize);
			up2 = setup("/monster/starfish_purple2", gp.tileSize, gp.tileSize);	
			up3 = setup("/monster/starfish_purple3", gp.tileSize, gp.tileSize);		
			up4 = setup("/monster/starfish_purple4", gp.tileSize, gp.tileSize);	
			down1 = setup("/monster/starfish_purple1", gp.tileSize, gp.tileSize);
			down2 = setup("/monster/starfish_purple2", gp.tileSize, gp.tileSize);	
			down3 = setup("/monster/starfish_purple3", gp.tileSize, gp.tileSize);		
			down4 = setup("/monster/starfish_purple4", gp.tileSize, gp.tileSize);
			left1 = setup("/monster/starfish_purple1", gp.tileSize, gp.tileSize);
			left2 = setup("/monster/starfish_purple2", gp.tileSize, gp.tileSize);
			left3 = setup("/monster/starfish_purple3", gp.tileSize, gp.tileSize);
			left4 = setup("/monster/starfish_purple4", gp.tileSize, gp.tileSize);
			right1 = setup("/monster/starfish_purple1", gp.tileSize, gp.tileSize);
			right2 = setup("/monster/starfish_purple2", gp.tileSize, gp.tileSize);
			right3 = setup("/monster/starfish_purple3", gp.tileSize, gp.tileSize);
			right4 = setup("/monster/starfish_purple4", gp.tileSize, gp.tileSize);
			dying1 = setup("/monster/starfish_purple1_dying1", gp.tileSize, gp.tileSize);
			dying2 = setup("/monster/starfish_purple1_dying2", gp.tileSize, gp.tileSize);
			dying3 = setup("/monster/starfish_purple1_dying3", gp.tileSize, gp.tileSize);
			dying4 = setup("/monster/starfish_purple1_dying4", gp.tileSize, gp.tileSize);

			break;
		case("yellow"): 
			up1 = setup("/monster/starfish_yellow1", gp.tileSize, gp.tileSize);
			up2 = setup("/monster/starfish_yellow2", gp.tileSize, gp.tileSize);	
			up3 = setup("/monster/starfish_yellow3", gp.tileSize, gp.tileSize);		
			up4 = setup("/monster/starfish_yellow4", gp.tileSize, gp.tileSize);	
			down1 = setup("/monster/starfish_yellow1", gp.tileSize, gp.tileSize);
			down2 = setup("/monster/starfish_yellow2", gp.tileSize, gp.tileSize);	
			down3 = setup("/monster/starfish_yellow3", gp.tileSize, gp.tileSize);		
			down4 = setup("/monster/starfish_yellow4", gp.tileSize, gp.tileSize);
			left1 = setup("/monster/starfish_yellow1", gp.tileSize, gp.tileSize);
			left2 = setup("/monster/starfish_yellow2", gp.tileSize, gp.tileSize);
			left3 = setup("/monster/starfish_yellow3", gp.tileSize, gp.tileSize);
			left4 = setup("/monster/starfish_yellow4", gp.tileSize, gp.tileSize);
			right1 = setup("/monster/starfish_yellow1", gp.tileSize, gp.tileSize);
			right2 = setup("/monster/starfish_yellow2", gp.tileSize, gp.tileSize);
			right3 = setup("/monster/starfish_yellow3", gp.tileSize, gp.tileSize);
			right4 = setup("/monster/starfish_yellow4", gp.tileSize, gp.tileSize);
			dying1 = setup("/monster/starfish_yellow1_dying1", gp.tileSize, gp.tileSize);
			dying2 = setup("/monster/starfish_yellow1_dying2", gp.tileSize, gp.tileSize);
			dying3 = setup("/monster/starfish_yellow1_dying3", gp.tileSize, gp.tileSize);
			dying4 = setup("/monster/starfish_yellow1_dying4", gp.tileSize, gp.tileSize);

			break;
		default:
			up1 = setup("/monster/starfish_orange1", gp.tileSize, gp.tileSize);
			up2 = setup("/monster/starfish_orange2", gp.tileSize, gp.tileSize);	
			up3 = setup("/monster/starfish_orange3", gp.tileSize, gp.tileSize);		
			up4 = setup("/monster/starfish_orange4", gp.tileSize, gp.tileSize);	
			down1 = setup("/monster/starfish_orange1", gp.tileSize, gp.tileSize);
			down2 = setup("/monster/starfish_orange2", gp.tileSize, gp.tileSize);	
			down3 = setup("/monster/starfish_orange3", gp.tileSize, gp.tileSize);		
			down4 = setup("/monster/starfish_orange4", gp.tileSize, gp.tileSize);
			left1 = setup("/monster/starfish_orange1", gp.tileSize, gp.tileSize);
			left2 = setup("/monster/starfish_orange2", gp.tileSize, gp.tileSize);
			left3 = setup("/monster/starfish_orange3", gp.tileSize, gp.tileSize);
			left4 = setup("/monster/starfish_orange4", gp.tileSize, gp.tileSize);
			right1 = setup("/monster/starfish_orange1", gp.tileSize, gp.tileSize);
			right2 = setup("/monster/starfish_orange2", gp.tileSize, gp.tileSize);
			right3 = setup("/monster/starfish_orange3", gp.tileSize, gp.tileSize);
			right4 = setup("/monster/starfish_orange4", gp.tileSize, gp.tileSize);
			break;	
		}

		
	}
	public void setAction() { 
//		actionLockCounter++;
//		if(actionLockCounter == 120) {
//			Random random = new Random();
//			int i = random.nextInt(50)+1; // number from 1-100
//			
//			if(i <= 25) {
//				direction = "up";	
//			}
//			if(i > 25 && i <= 50 ) {
//				direction = "down";	
//			}
////			if(i > 50 && i <= 75 ) {
////				direction = "up";
////			}
////			if(i > 75 && i <= 100 ) {
////				direction = "down";	
////			}
//			actionLockCounter = 0;
//		}

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
		}
		if(spriteCounter > 60  && spriteCounter <= 100) {
			spriteNum = 2;
		}
		if(spriteCounter > 100 && spriteCounter <= 180 ) {
			spriteNum = 3;
		}
		if(spriteCounter > 180 && spriteCounter < 240 ) {
			spriteNum = 4;	
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
