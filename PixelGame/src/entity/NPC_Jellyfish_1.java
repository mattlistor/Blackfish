package entity;

import java.util.Random;
import main.GamePanel;

public class NPC_Jellyfish_1 extends Entity {

	public NPC_Jellyfish_1(GamePanel gp) {
		super(gp);
		name="Bright Jelly";
		type = type_npc;
		direction = "up";
		speed = 2;
		
		solidArea.x = 14;
		solidArea.y = 10;
		solidArea.width = 40;
		solidArea.height = 30;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		charactersFrameCount = 180;
		
		getImage();
		setDialogue();
	}
	public void getImage() {
		up1 = setup("/monster/jellyfish_up1", gp.tileSize, gp.tileSize);
		up2 = setup("/monster/jellyfish_up2", gp.tileSize, gp.tileSize);	
		up3 = setup("/monster/jellyfish_up3", gp.tileSize, gp.tileSize);		
		up4 = setup("/monster/jellyfish_up4", gp.tileSize, gp.tileSize);	
		down1 = setup("/monster/jellyfish_up1", gp.tileSize, gp.tileSize);
		down2 = setup("/monster/jellyfish_up2", gp.tileSize, gp.tileSize);	
		down3 = setup("/monster/jellyfish_up3", gp.tileSize, gp.tileSize);		
		down4 = setup("/monster/jellyfish_up4", gp.tileSize, gp.tileSize);
		left1 = setup("/monster/jellyfish_up1", gp.tileSize, gp.tileSize);
		left2 = setup("/monster/jellyfish_up2", gp.tileSize, gp.tileSize);
		left3 = setup("/monster/jellyfish_up3", gp.tileSize, gp.tileSize);
		left4 = setup("/monster/jellyfish_up4", gp.tileSize, gp.tileSize);
		right1 = setup("/monster/jellyfish_up1", gp.tileSize, gp.tileSize);
		right2 = setup("/monster/jellyfish_up2", gp.tileSize, gp.tileSize);
		right3 = setup("/monster/jellyfish_up3", gp.tileSize, gp.tileSize);
		right4 = setup("/monster/jellyfish_up4", gp.tileSize, gp.tileSize);
	} 
	public void setDialogue() {
//		if (gp.player.inventoryContains("Bubble Shoot") == false) {
//			dialogues[0][0] = "Blackfish, pleased to meet you.";
//			dialogues[0][1] = "Let me tell you how to use this power\nup... You won't get much farther\nwithout it.";
//			
//		}
//		else if (gp.player.inventoryContains("Bubble Shoot") == true) {
//			dialogues[0][0] = "You can press [B] to spit out\nsome bubbles! This will be good for\nfighting from a distance.";
//			dialogues[0][1] = "Press [Y] to see your inventory,\nthen press [B] to equip what\nweapon you want.";
//			dialogues[0][2] = "I heard this skinner guy loves his\nprized Golden Jig collection, wonder\nhow he feels right now.";
//		}
		dialogues[0][0] = "Hello Blackfish, it's me again. But much\nmore translucent.";
		dialogues[0][1] = "I turn into this state when I feel like\nbeing a bit more... flexible.";
		dialogues[0][2] = "Anyway, there's another Golden Jig around\nhere somewhere. I'd go ahead and push\nthis rock out of the way...\nUnless you'd rather stay put, up to you.";
		dialogues[1][0] = "I heard this skinner guy loves his\nprized Golden Jig collection, wonder\nhow he feels right now.";
		dialogues[1][1] = "You push the rock yet?";



	}
	public void setAction() { 
		actionLockCounter++;
		if(actionLockCounter == charactersFrameCount) {
			Random random = new Random();
			int i = random.nextInt(50)+1; // number from 1-100
			
			if(direction == "right") {
				direction = "down";	
			}
			else if(direction == "down") {
				direction = "left";	
			}
			else if(direction == "left") {
				direction = "up";	
			}
			else if(direction == "up") {
				direction = "right";	
			}
			actionLockCounter = 0;
		}
	}
	public void speak() {
//		facePlayer();
		startDialogue(this, dialogueSet);
//		dialogueSet++;
//		if(dialogues[dialogueSet][0] == null) {
			// option 1: npc rescccets to first set of dialogue
//			dialogueSet = 0;
			// option 2:  npc repeats last set of dialogue
//			dialogueSet--;
//		}
		
//		super.speak();
	}
	
	public void spriteNumAndMovementHandler() {
		spriteCounter++;
		if(spriteCounter <= 60) {
			spriteNum = 1;	
		}
		if(spriteCounter > 60  && spriteCounter <= 100) {
			spriteNum = 2;
		}
		if(spriteCounter > 100 && spriteCounter <= 150 ) {
			spriteNum = 3;
			move();
		}
		if(spriteCounter > 150 && spriteCounter <= 165 ) {
			spriteNum = 3;
			moveHalfSpeed();
		}
		if(spriteCounter > 165 && spriteCounter < 180 ) {
			spriteNum = 4;	
			moveHalfSpeed();
		}

		if (spriteCounter >= charactersFrameCount) {
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
