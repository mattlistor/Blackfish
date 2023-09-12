package entity;

import java.util.Random;

import main.GamePanel;

public class NPC_Rock_1 extends Entity{
	
	public static final String npcName = "Big Rock";

	public NPC_Rock_1(GamePanel gp) {
		super(gp);
		name="Rock";
		type = type_rock_push;
		direction = "down";
		speed = gp.player.speed+1;
		sleep = false; 
		
		solidArea.x = 12;
		solidArea.y = 12;
		solidArea.width = 40;
		solidArea.height = 40;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		dialogueSet = 0;
		
		charactersFrameCount = 75;
		
		getImage();

	}
	public void getImage() {
		up1 = setup("/objects/rock_push", gp.tileSize, gp.tileSize);
		up2 = setup("/objects/rock_push", gp.tileSize, gp.tileSize);
		down1 = setup("/objects/rock_push", gp.tileSize, gp.tileSize);
		down2 = setup("/objects/rock_push", gp.tileSize, gp.tileSize);
		left1 = setup("/objects/rock_push", gp.tileSize, gp.tileSize);
		left2 = setup("/objects/rock_push", gp.tileSize, gp.tileSize);
		left3 = setup("/objects/rock_push", gp.tileSize, gp.tileSize);
		right1 = setup("/objects/rock_push", gp.tileSize, gp.tileSize);
		right2 = setup("/objects/rock_push", gp.tileSize, gp.tileSize);
		right3 = setup("/objects/rock_push", gp.tileSize, gp.tileSize);
		dying1 = setup("/objects/rock_push_dying2_1", gp.tileSize, gp.tileSize);
		dying2 = setup("/objects/rock_push_dying2_2", gp.tileSize, gp.tileSize);
		dying3 = setup("/objects/rock_push_dying2_3", gp.tileSize, gp.tileSize);
		dying4 = setup("/objects/rock_push_dying2_4", gp.tileSize, gp.tileSize);

	} 
	public void move(String d) {
		this.direction = d;
		checkCollision();
		if(collisionOn == false) {
			switch(direction) {
			case "up": worldY -= speed;break;
			case "down": worldY += speed; break;				
			case "left": worldX -= speed; break;
			case "right": worldX += speed; break;
		}
		}
		this.direction = "down";	
	}


	public void spriteNumAndMovementHandler() {
		// FALLING
		if(collisionOn == false && direction == "down") {
			falling = true;
			worldY += 3;
		}
		else if(collisionOn == true && direction == "down") {
			falling = false;
		}
	}
	public void resetToOriginalPosition() {
		
	}

}
