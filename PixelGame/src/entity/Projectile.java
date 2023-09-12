package entity;

import java.util.ArrayList;

import main.GamePanel;
import object.OBJ_Bubble_Shoot;

public class Projectile extends Entity {
	
	public Entity user;
//	public ArrayList<Entity> list = new ArrayList<>();

	public Projectile(GamePanel gp) {
		super(gp);
	}
	public void set(int worldX, int worldY, String direction, boolean alive, Entity user) {
		if(gp.player.facingDirectoin == "left") {
			this.worldX = worldX-15;
		}
		else if(gp.player.facingDirectoin == "right") {
			this.worldX = worldX+50;
		}
		this.worldY = worldY+11;
		this.direction = direction;
		this.alive = alive;
		this.user = user;
		this.currentLife = this.maxLife;
	}
	public void update() {
		
		if(user == gp.player) {
			int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
			if(gp.monster[gp.currentMap][monsterIndex].puzzlePiece == false) {
				gp.player.damageMonster(monsterIndex, this.user.attack);
			}
			alive = false;
			collisionOn = false;
		}
		if(user != gp.player) {
			
		}
		gp.cChecker.checkTile(this);
		if(collisionOn == true) {
			alive = false;
			collisionOn = false;
		}
		if (collisionOn == false) {
			switch (direction) {
			case "up": worldY -= speed; break;
			case "down": worldY += speed; break;
			case "left": worldX -= speed; break;
			case "right": worldX += speed; break;
			}
		}
		currentLife --;
		if(currentLife <= 0) {
			alive = false;
		}
		spriteNumAndMovementHandler();
	}
	public void spriteNumAndMovementHandler() {
		spriteCounter++;
		if (spriteCounter > 8) {
			spriteNum++;
			if (spriteNum > 4) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}	
	}
	
}
