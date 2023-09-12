package entity;

import java.util.Random;
import main.GamePanel;

public class NPC_Crab_1 extends Entity {

	public NPC_Crab_1(GamePanel gp) {
		super(gp);
		name="Bright Crab";
		type = 1;
		direction = "left";
		speed = 1;
		sleep = false; 
		
		solidArea.x = 14;
		solidArea.y = 25;
		solidArea.width = 40;
		solidArea.height = 10;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		dialogueSet = 0;
		
		charactersFrameCount = 75;
		
		getImage();
		setDialogue();
		setCutSceneDialogue();
	}
	public void getImage() {
		up1 = setup("/npc/crab", gp.tileSize, gp.tileSize);
		up2 = setup("/npc/crab", gp.tileSize, gp.tileSize);
		down1 = setup("/npc/crab", gp.tileSize, gp.tileSize);
		down2 = setup("/npc/crab", gp.tileSize, gp.tileSize);
		left1 = setup("/npc/crab_left1", gp.tileSize, gp.tileSize);
		left2 = setup("/npc/crab_left2", gp.tileSize, gp.tileSize);
		left3 = setup("/npc/crab_left3", gp.tileSize, gp.tileSize);
		right1 = setup("/npc/crab_right2", gp.tileSize, gp.tileSize);
		right2 = setup("/npc/crab_right3", gp.tileSize, gp.tileSize);
		right3 = setup("/npc/crab_right4", gp.tileSize, gp.tileSize);

	} 
	public void setCutSceneDialogue() {
		csDialogues[0][0] = "Hey Blackfish, I'm over here!\n";
		csDialogues[0][1] = "Come find me! I need your help!";
	}
	public void setDialogue() {
//		if(gp.player.inventoryContains("Golden Jig") == false) {			
			dialogues[0][0] = "Blackfish, its just terrible! Skinner has\nlost his Golden Jig collection.";
			dialogues[0][1] = "I have one right here, but the rest are\nstill missing!";
			dialogues[0][2] = "Go ahead and grab this one and head\nover to the next nevel for me.";
			dialogues[0][3] = "Anybody who is bright like me can\nhelp you. Sometimes even give you\nsome useful items.";
			dialogues[0][4] = "Good luck, Blackfish. I'll be around\nif you need more help.";
			



//			
//			dialogues[2][0] = "If you go find the first one for me,\nI'll show you a way out of here!";


//		}
//		else if(gp.player.inventoryContains("Golden Jig") == true){
//			dialogues[0][0] = "You got the Golden Jig!";
//		}


	}
	public void setAction() { 
		actionLockCounter++;
		if(actionLockCounter == charactersFrameCount * 3) {
			Random random = new Random();
			int i = random.nextInt(100)+1; // number from 1-100
		
			
			if(direction == "left") {
				direction = "right";	
			}
			else {
				direction = "left";	
			}
			actionLockCounter = 0;
		}
	}
	public void speak() {
		facePlayer();
//		dialogueSet++;

		startDialogue(this, dialogueSet);
//		if(dialogues[dialogueSet][0] == null) {
//			// option 1: npc resets to first set of dialogue
//			dialogueSet = 0;
//			// option 2:  npc repeats last set of dialogue
////			dialogueSet--;
//		}
		
//		super.speak();
	}
	public void spriteNumAndMovementHandler() {
		spriteCounter++;
		if(spriteCounter <= 35) {
			spriteNum = 1;	
		}
		if(spriteCounter > 35 && spriteCounter <= 50 ) {
			spriteNum = 2;
			if(collisionOn == false ) {
				switch (direction) {
				case "left": worldX -= speed; break;
				case "right": worldX += speed; break;
				}
			}
		}
		if(spriteCounter > 50 && spriteCounter <= charactersFrameCount ) {
			spriteNum = 3;	
		}

		if (spriteCounter >= charactersFrameCount) {
			spriteCounter = 0;
		}
	}
}
