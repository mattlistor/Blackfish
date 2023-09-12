package object;

import entity.Entity;
import entity.Projectile;
import main.GamePanel;

public class OBJ_Bubble_Shoot extends Projectile {

	GamePanel gp;
	public Entity user;
	
	public OBJ_Bubble_Shoot(GamePanel gp) {
		super(gp);
		this.gp = gp;
		type = type_bubble_shoot;
		name = "Bubble Shoot";
		speed = 7;
		maxLife = 80;
		currentLife = maxLife;
		attackValue = 2;
		useCost = 1;
		alive = false;
		description = "["+name+"]\n"+"Spit some bubbles\nand shoot enemies\nfrom a distance!";
		
		
		solidArea.x = 5;
		solidArea.y = 8;
		solidArea.width = 20;
		solidArea.height = 17;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		getImage();

	}
	

	private void getImage() {
		up1 = setup("/projectiles/water_balls_2_1", gp.tileSize, gp.tileSize);
		up2 = setup("/projectiles/water_balls_2_2", gp.tileSize, gp.tileSize);
		up3 = setup("/projectiles/water_balls_2_3", gp.tileSize, gp.tileSize);
		up4 = setup("/projectiles/water_balls_2_4", gp.tileSize, gp.tileSize);
		down1 = setup("/projectiles/water_balls_2_1", gp.tileSize, gp.tileSize);
		down2 = setup("/projectiles/water_balls_2_2", gp.tileSize, gp.tileSize);
		down3 = setup("/projectiles/water_balls_2_3", gp.tileSize, gp.tileSize);
		down4 = setup("/projectiles/water_balls_2_4", gp.tileSize, gp.tileSize);
		left1 = setup("/projectiles/water_balls_2_1", gp.tileSize, gp.tileSize);
		left2 = setup("/projectiles/water_balls_2_2", gp.tileSize, gp.tileSize);
		left3 = setup("/projectiles/water_balls_2_3", gp.tileSize, gp.tileSize);
		left4 = setup("/projectiles/water_balls_2_4", gp.tileSize, gp.tileSize);
		right1 = setup("/projectiles/water_balls_2_1", gp.tileSize, gp.tileSize);
		right2 = setup("/projectiles/water_balls_2_2", gp.tileSize, gp.tileSize);
		right3 = setup("/projectiles/water_balls_2_3", gp.tileSize, gp.tileSize);
		right4 = setup("/projectiles/water_balls_2_4", gp.tileSize, gp.tileSize);
		image = setup("/projectiles/water_balls", gp.tileSize, gp.tileSize);
	}

		public void update() {
		
		if(user == gp.player) {
			int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
			if(monsterIndex != 999 && gp.monster[gp.currentMap][monsterIndex].puzzlePiece == false) {
				gp.player.damageMonster(monsterIndex, this.user.attack);
				alive = false;
				collisionOn = false;
			}
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
		if(spriteCounter <= 8) {
			spriteNum = 1;	
//			worldY +=1;

		}
		if(spriteCounter > 8  && spriteCounter <= 16) {
			spriteNum = 2;
			worldY -=1;
		}
		if(spriteCounter > 16 && spriteCounter <= 24 ) {
			spriteNum = 3;
			worldY +=1;
		}
		if(spriteCounter > 24 && spriteCounter <= 32 ) {
			spriteNum = 4;
//			worldY +=1;
		}
		if (spriteCounter > 32) {
			spriteCounter = 0;
		}	
	}
	public void set(int worldX, int worldY, String direction, boolean alive, Entity user) {
		if(gp.player.facingDirectoin == "left") {
			this.worldX = worldX-5;
		}
		else if(gp.player.facingDirectoin == "right") {
			this.worldX = worldX+35;
		}
		this.worldY = worldY+11;
		this.direction = direction;
		this.alive = alive;
		this.user = user;
		this.currentLife = this.maxLife;
	}


}
