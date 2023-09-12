package entity;

import main.KeyHandler;
import main.UtilityTool;
import object.OBJ_Golden_Jig;
import object.OBJ_Gulp_Juice;
import object.OBJ_Shield;
import object.OBJ_Shield_2;
import object.OBJ_Bubble_Shoot;
import object.OBJ_Weapon_Laser;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.datatransfer.SystemFlavorMap;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Player extends Entity {

	KeyHandler keyH;
	public int screenX;
	public int screenY;
	public boolean attackCanceled = false;
	public ArrayList<Entity> inventory = new ArrayList<>();
	public ArrayList<Entity> playerProjectileList = new ArrayList<>();
	public final int inventorySize = 16;
	public int playerLives = 3;
	public Graphics g;
	public Graphics2D g2;
	public int playerScreenXMovement = 0;
	public int playerScreenYMovement = 0;
	public int gapBetweenScreenEdgeAndMapEdgeRight = 0;
	public int gapBetweenScreenEdgeAndMapEdgeLeft = 0;
	public int gapBetweenScreenEdgeAndMapEdgeUp = 0;
	public int gapBetweenScreenEdgeAndMapEdgeDown = 0;
	public int temp = -1;
	public boolean enteredLeftZone = false;
	public boolean enteredUpZone = false;
	public boolean enteredRightZone = false;
	public boolean enteredDownZone = false;
	public boolean canStartDialogue = false;
	int indexNPCInRange;

	
	public Player(GamePanel gp, KeyHandler keyH) {
		super(gp);
		
		this.keyH = keyH;

		solidArea = new Rectangle(20, 20, gp.tileSize*2/5, gp.tileSize*2/5);

		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		attackArea.width = 50;
		attackArea.height = 36;


		setDefaultValues();
		getPlayerImage();
		getPlayerAttackImage();
		setItems();
		setDialogue();
	}

	public void setDefaultValues() {
		screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
		screenY = gp.screenHeight / 2 - (gp.tileSize / 2);
		
		// STARTING POSITION HANDLER
		playerStartingPositionHandler();
		
		defaultSpeed = 5;
		speed = defaultSpeed;
		direction = "right";
		facingDirectoin = "right";
		
		// PLAYER STATUS
		maxLife = 6;
		currentLife = maxLife;
		
		// DEFAULT STATS
		level = 1;
		biteStrength = 1;
		exp = 0;
		nextLevelExp = exp+5;
		coin = 0;
		currentWeapon = null;
		currentShield = null;
		projectile = new OBJ_Bubble_Shoot(gp);
		laser = new OBJ_Weapon_Laser(gp);
		attack = getAttack();
		defense = getDefense();
		
	}
	private void playerStartingPositionHandler() {
		switch(gp.currentMap) {
		case 0:
			worldX = gp.tileSize * 17;	
			worldY = gp.tileSize * 19;
			break;
		case 1:
			worldX = gp.tileSize * 8;	
			worldY = gp.tileSize * 8;
			break;
	}		
	}

	public void setDialogue() {
		dialogues[0][0] = "Try talking to the Bright Crab by\npressing [B]";
		

	}
	public void setItems() {
//		inventory.add(currentShield);
//		inventory.add(laser);
//		inventory.add(projectile);
//		currentWeapon = projectile;
//		inventory.add(new OBJ_Gulp_Juice(gp));
//		inventory.add(new OBJ_Golden_Jig(gp));
//		inventory.add(new OBJ_Gulp_Juice(gp));

	}
	private int getDefense() {
		if(currentShield != null) {
			return defense = biteStrength * currentShield.defenseValue;
		}
		else return defense = 0;
	}
	private int getAttack() {
		if(currentWeapon != null) {
			return attack = biteStrength * currentWeapon.attackValue;
		}
		else return attack = 0;
	}
	public void getPlayerImage() {
		up1 = setup("/player/tog_right_alt_1", gp.tileSize, gp.tileSize);
		up2 = setup("/player/tog_right_alt_2", gp.tileSize, gp.tileSize);
		up3 = setup("/player/tog_right_alt_3", gp.tileSize, gp.tileSize);
		up4 = setup("/player/tog_right_alt_4", gp.tileSize, gp.tileSize);
		up5 = setup("/player/tog_left_alt_1", gp.tileSize, gp.tileSize);
		up6 = setup("/player/tog_left_alt_2", gp.tileSize, gp.tileSize);
		up7 = setup("/player/tog_left_alt_3", gp.tileSize, gp.tileSize);
		up8 = setup("/player/tog_left_alt_4", gp.tileSize, gp.tileSize);
		down1 = setup("/player/tog_right_alt_1", gp.tileSize, gp.tileSize);
		down2 = setup("/player/tog_right_alt_2", gp.tileSize, gp.tileSize);
		down3 = setup("/player/tog_right_alt_3", gp.tileSize, gp.tileSize);
		down4 = setup("/player/tog_right_alt_4", gp.tileSize, gp.tileSize);
		down5 = setup("/player/tog_left_alt_1", gp.tileSize, gp.tileSize);
		down6 = setup("/player/tog_left_alt_2", gp.tileSize, gp.tileSize);
		down7 = setup("/player/tog_left_alt_3", gp.tileSize, gp.tileSize);
		down8 = setup("/player/tog_left_alt_4", gp.tileSize, gp.tileSize);
		left1 = setup("/player/tog_left_alt_1", gp.tileSize, gp.tileSize);
		left2 = setup("/player/tog_left_alt_2", gp.tileSize, gp.tileSize);
		left3 = setup("/player/tog_left_alt_3", gp.tileSize, gp.tileSize);
		left4 = setup("/player/tog_left_alt_4", gp.tileSize, gp.tileSize);
		right1 = setup("/player/tog_right_alt_1", gp.tileSize, gp.tileSize);
		right2 = setup("/player/tog_right_alt_2", gp.tileSize, gp.tileSize);
		right3 = setup("/player/tog_right_alt_3", gp.tileSize, gp.tileSize);
		right4 = setup("/player/tog_right_alt_4", gp.tileSize, gp.tileSize);
	}
	public void getPlayerAttackImage() {
		if(currentWeapon != null) {
			if(currentWeapon.type == type_laser) {
				attackUp1 = setup("/player/tog_attack_right_1", gp.tileSize*2, gp.tileSize);
				attackUp2 = setup("/player/tog_attack_right_2", gp.tileSize*2, gp.tileSize);
				attackUp3 = setup("/player/tog_attack_right_3", gp.tileSize*2, gp.tileSize);
				attackUp4 = setup("/player/tog_attack_right_4", gp.tileSize*2, gp.tileSize);
				attackUp5 = setup("/player/tog_attack_left_1", gp.tileSize*2, gp.tileSize);
				attackUp6 = setup("/player/tog_attack_left_2", gp.tileSize*2, gp.tileSize);
				attackUp7 = setup("/player/tog_attack_left_3", gp.tileSize*2, gp.tileSize);
				attackUp8 = setup("/player/tog_attack_left_4", gp.tileSize*2, gp.tileSize);
				attackDown1 = setup("/player/tog_attack_right_1", gp.tileSize*2, gp.tileSize);
				attackDown2 = setup("/player/tog_attack_right_2", gp.tileSize*2, gp.tileSize);
				attackDown3 = setup("/player/tog_attack_right_3", gp.tileSize*2, gp.tileSize);
				attackDown4 = setup("/player/tog_attack_right_4", gp.tileSize*2, gp.tileSize);
				attackDown5 = setup("/player/tog_attack_left_1", gp.tileSize*2, gp.tileSize);
				attackDown6 = setup("/player/tog_attack_left_2", gp.tileSize*2, gp.tileSize);
				attackDown7 = setup("/player/tog_attack_left_3", gp.tileSize*2, gp.tileSize);
				attackDown8 = setup("/player/tog_attack_left_4", gp.tileSize*2, gp.tileSize);
				attackLeft1 = setup("/player/tog_attack_left_1", gp.tileSize*2, gp.tileSize);
				attackLeft2 = setup("/player/tog_attack_left_2", gp.tileSize*2, gp.tileSize);
				attackLeft3 = setup("/player/tog_attack_left_3", gp.tileSize*2, gp.tileSize);
				attackLeft4 = setup("/player/tog_attack_left_4", gp.tileSize*2, gp.tileSize);
				attackRight1 = setup("/player/tog_attack_right_1", gp.tileSize*2, gp.tileSize);
				attackRight2 = setup("/player/tog_attack_right_2", gp.tileSize*2, gp.tileSize);
				attackRight3 = setup("/player/tog_attack_right_3", gp.tileSize*2, gp.tileSize);
				attackRight4 = setup("/player/tog_attack_right_4", gp.tileSize*2, gp.tileSize);
			}
			if(currentWeapon.type == type_bubble_shoot) {
				attackUp1 = setup("/player/tog_right_1", gp.tileSize, gp.tileSize);
				attackUp2 = setup("/player/tog_right_2", gp.tileSize, gp.tileSize);
				attackUp3 = setup("/player/tog_right_3", gp.tileSize, gp.tileSize);
				attackUp4 = setup("/player/tog_right_4", gp.tileSize, gp.tileSize);
				attackUp5 = setup("/player/tog_left_1", gp.tileSize, gp.tileSize);
				attackUp6 = setup("/player/tog_left_2", gp.tileSize, gp.tileSize);
				attackUp7 = setup("/player/tog_left_3", gp.tileSize, gp.tileSize);
				attackUp8 = setup("/player/tog_left_4", gp.tileSize, gp.tileSize);
				attackDown1 = setup("/player/tog_right_1", gp.tileSize, gp.tileSize);
				attackDown2 = setup("/player/tog_right_2", gp.tileSize, gp.tileSize);
				attackDown3 = setup("/player/tog_right_3", gp.tileSize, gp.tileSize);
				attackDown4 = setup("/player/tog_right_4", gp.tileSize, gp.tileSize);
				attackDown5 = setup("/player/tog_left_1", gp.tileSize, gp.tileSize);
				attackDown6 = setup("/player/tog_left_2", gp.tileSize, gp.tileSize);
				attackDown7 = setup("/player/tog_left_3", gp.tileSize, gp.tileSize);
				attackDown8 = setup("/player/tog_left_4", gp.tileSize, gp.tileSize);
				attackLeft1 = setup("/player/tog_left_1", gp.tileSize, gp.tileSize);
				attackLeft2 = setup("/player/tog_left_2", gp.tileSize, gp.tileSize);
				attackLeft3 = setup("/player/tog_left_3", gp.tileSize, gp.tileSize);
				attackLeft4 = setup("/player/tog_left_4", gp.tileSize, gp.tileSize);
				attackRight1 = setup("/player/tog_right_1", gp.tileSize, gp.tileSize);
				attackRight2 = setup("/player/tog_right_2", gp.tileSize, gp.tileSize);
				attackRight3 = setup("/player/tog_right_3", gp.tileSize, gp.tileSize);
				attackRight4 = setup("/player/tog_right_4", gp.tileSize, gp.tileSize);
				
			}
		}
	}
	public void update() {
		//	now sprite animates even when key is not pressed
		
		spriteCounter++;
		if(attacking == true) {
			attacking();
		}
		
		//check for key press to change direction  
		if ((keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true
				|| keyH.rightPressed == true || keyH.enterPressed == true)) {
			if(attacking == true) {
				attacking();
			}
			
			if (keyH.upPressed == true) {direction = "up";} 
			else if (keyH.downPressed == true) {direction = "down";} 
			else if (keyH.leftPressed == true) {direction = "left";} 
			else if (keyH.rightPressed == true) {direction = "right";} 
			if (keyH.rightPressed == true && keyH.upPressed == true) {
				direction = "upright";
			}
			if (keyH.rightPressed == true && keyH.downPressed == true) {
				direction = "downright";
			}
			if (keyH.leftPressed == true && keyH.upPressed == true) {
				direction = "upleft";
			}
			if (keyH.leftPressed == true && keyH.downPressed == true) {
				direction = "downleft";
			}

			checkForCollisions();
			
			movePlayer();
		}

		if(attacking == false) {
			if (spriteCounter > 8) {
				spriteNum++;

				if (spriteNum > 4) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}
		
		if(canStartDialogue == true && keyH.enterPressed == true) {
			interactNPC(indexNPCInRange);
		}
		
		//weapon handler
		if(keyH.enterPressed == true && attackCanceled == false && currentWeapon != null) {
			if(currentWeapon.type == type_laser) {
				gp.playSE(5);
				attacking = true;
				spriteNum = 1;
				spriteCounter = 0;	
			}
			else if(currentWeapon.type == type_bubble_shoot) {
				gp.aSetter.addProjectile(worldX, worldY+10, facingDirectoin, true, this);
				playProjectileSound();
			}
			
		}
		
		
		// Counter++ handlers	
		if(invincible == true) {
			invincibleCounter++;
			if(invincibleCounter > 40) {
				invincible = false;
				invincibleCounter = 0;
			}
		}
		if(shotAvailableCounter < 30) {
			shotAvailableCounter++;
		}
		
		// Reset some things
		attackCanceled = false;
		gp.keyH.enterPressed = false;
		
		// playerLives handler
		if(currentLife <= 0) {
			if(playerLives > 1) {
				currentLife = maxLife;
				 playerStartingPositionHandler();
			}
			playerLives--;
		}
		if(playerLives <= 0) {
			gp.gameState = gp.gameOverState;
		}						
	}
	private void playProjectileSound() {
		// random number between 1 and 4 
//		play each sound depending on number
		Random random = new Random();
		int soundRandomNum = random.nextInt(4)+1; // number from 1-100
		switch (soundRandomNum){
		case 1: gp.playSE(9); break;
		case 2: gp.playSE(14); break;
		case 3: gp.playSE(15); break;
		case 4: gp.playSE(16); break;

		}		
	}

	private void movePlayer() {
		// If collision is false, player can move
		if (collisionOn == false && keyH.enterPressed == false ) {
			switch (direction) {
			case "up": worldY -= speed; screenY -= playerScreenYMovement;break;
			case "down": worldY += speed; screenY += playerScreenYMovement;break;
			case "left": worldX -= speed; screenX -= playerScreenXMovement; break;
			case "right": worldX += speed;  screenX += playerScreenXMovement; break;
			
			
			case "upright":
				facingDirectoin = "right";
				direction = "right";
				checkForCollisions();
				if (collisionOn == false && keyH.enterPressed == false ) {
					worldX += speed/(1.4); 
					screenX += playerScreenXMovement/(1.4);

				}
				direction = "up";
				checkForCollisions();
				if (collisionOn == false && keyH.enterPressed == false ) {
					worldY -= speed/(1.4); 
					screenY -= playerScreenXMovement/(1.4);
				}
				break;
			case "downright":
				facingDirectoin = "right";
				direction = "right";
				checkForCollisions();
				if (collisionOn == false && keyH.enterPressed == false ) {
					worldX += speed/(1.4);
					screenX += playerScreenXMovement/(1.4);
				}
				direction = "down";
				checkForCollisions();
				if (collisionOn == false && keyH.enterPressed == false ) {
					worldY += speed/(1.4); 
					screenY += playerScreenXMovement/(1.4);
				}
				break;
			case "upleft": 
				facingDirectoin = "left";
				direction = "left";
				checkForCollisions();
				if (collisionOn == false && keyH.enterPressed == false ) {
					worldX -= speed/(1.4); 
					screenX -= playerScreenXMovement/(1.4);
				}
				direction = "up";
				checkForCollisions();
				if (collisionOn == false && keyH.enterPressed == false ) {
					worldY -= speed/(1.4);
					screenY -= playerScreenXMovement/(1.4);
				}
				break;						
			case "downleft": 
				facingDirectoin = "left";
				direction = "left";
				checkForCollisions();
				if (collisionOn == false && keyH.enterPressed == false ) {
					worldX -= speed/(1.4);
					screenX -= playerScreenXMovement/(1.4);					
				}
				direction = "down";
				checkForCollisions();
				if (collisionOn == false && keyH.enterPressed == false ) {
					worldY += speed/(1.4); 
					screenY += playerScreenXMovement/(1.4);
				}
				break;
			}
//			checkCloseToMovingWindowBorder();
		}		
	}

	public void checkCloseToMovingWindowBorder() {
		int playerScreenX = screenX+solidArea.x;
		int playerScreenY = screenY+solidArea.y;

		int playerWorldX = worldX+solidArea.x;
		int playerWorldY = worldY+solidArea.y;

		gapBetweenScreenEdgeAndMapEdgeLeft = playerWorldX - playerScreenX;
		gapBetweenScreenEdgeAndMapEdgeUp = playerWorldY - playerScreenY;
		gapBetweenScreenEdgeAndMapEdgeDown = gp.maxWorldHeight - (gapBetweenScreenEdgeAndMapEdgeUp+gp.screenHeight);
		gapBetweenScreenEdgeAndMapEdgeRight = (gapBetweenScreenEdgeAndMapEdgeLeft+gp.screenWidth);

		if(gapBetweenScreenEdgeAndMapEdgeLeft <= 0 && enteredLeftZone == false) {
		    playerScreenXMovement = speed;
			enteredLeftZone  = true;
		}
		if(gapBetweenScreenEdgeAndMapEdgeUp <= 0 && enteredUpZone == false) {
		    playerScreenYMovement = speed;
		    enteredUpZone  = true;
		}
		if(gapBetweenScreenEdgeAndMapEdgeDown <= 0 && enteredDownZone == false) {
		    playerScreenYMovement = speed;
		    enteredDownZone  = true;
		}
		if(gapBetweenScreenEdgeAndMapEdgeRight >= gp.maxWorldWidth && enteredRightZone == false) {
			playerScreenXMovement = speed;
		    enteredRightZone  = true;
		}
		if(enteredLeftZone == true && screenX == (gp.screenWidth/2) - (gp.tileSize/2) && direction == "right")  {
			playerScreenXMovement = 0;
			enteredLeftZone  = false;
		}
		if(enteredUpZone == true && screenY == (gp.screenHeight/2) - (gp.tileSize/2) && direction == "down")  {
			playerScreenYMovement = 0;
			enteredUpZone  = false;
		}
		if(enteredRightZone == true && screenX == (gp.screenWidth/2) - (gp.tileSize/2) && direction == "left")  {
			playerScreenXMovement = 0;
			enteredRightZone  = false;
		}
		if(enteredDownZone == true && screenY == (gp.screenHeight/2) - (gp.tileSize/2) && direction == "up")  {
			playerScreenYMovement = 0;
			enteredDownZone  = false;
		}
		
//		if(enteredLeftZone  = true) {
//			 playerScreenXMovement = speed;
//			 temp = screenX;
//		}

//		else if(playerScreenYMovement != 0 && playerScreenY == (gp.screenHeight/2)-(solidArea.height/2) )  {
//			playerScreenYMovement = 0;
//		}
//		else if(playerScreenXMovement != 0 && playerScreenX < (gp.screenHeight/2)-(solidArea.height/2) )  {
//			playerScreenYMovement = 0;
//		}
		
//		|| playerScreenY <= (gp.screenHeight/2)-(solidArea.height/2))

//		 playerScreenMovement = speed;


		// only works for right direction atm
//		int futurePlayerScreenXRight = playerScreenX += playerScreenMovement;
//		int futurePlayerScreenXLeft = playerScreenX -= playerScreenMovement;
//		int futurePlayerWorldXRight = playerWorldX += speed;
//		int futurePlayerWorldXLeft = playerWorldX -= speed;
//
//
//
//		 if(futurePlayerScreenXRight < gp.screenRightBorder) {
//			 playerScreenMovement = speed;
//		 }
//		 if(futurePlayerScreenXRight == gp.screenRightBorder) {
//		  	 playerScreenMovement = 0;
//		 }
//		 if(futurePlayerScreenXRight > gp.screenRightBorder) {
//			 if(futurePlayerWorldXRight > gp.worldRightBorder && futurePlayerWorldXRight < gp.maxWorldWidth) {
//				 playerScreenMovement = speed;
//			 }
//		 }
//		 if(futurePlayerScreenXLeft < gp.screenLeftBorder) {
//			 playerScreenMovement = speed;
//		 }
//		 if(futurePlayerScreenXLeft == gp.screenLeftBorder) {
//		  	 playerScreenMovement = 0;
//		 }
//		 if(futurePlayerScreenXLeft > gp.screenLeftBorder) {
//			 if(futurePlayerWorldXLeft < gp.worldLeftBorder && futurePlayerWorldXLeft > 0) {
//				 playerScreenMovement = speed;
//			 }
//		 }
//			 
			 
			 
			 
				// move tiels and player world position only
				// players screen position
			 
			 
			 
			// shift by offset whatever that mean
			//change worldX AND screenX
//			maxOffsetX
			
//			gp.offsetX += diffX - gp.rightBorder;
//		}
//		else if(futurePlayerScreenXLeft > gp.leftBorder) {
//			gp.offsetX += diffX - gp.leftBorder;
//		}
		
		
		
		
//		if(gp.offsetX > gp.maxOffsetX) {
//			gp.offsetX = gp.maxOffsetX;
//		}
//		else if(gp.offsetX < 0) {
//			gp.offsetX = 0;
//		}
		
	}

	private void checkForCollisions() {
		// Check tile collision
		collisionOn = false;
		gp.cChecker.checkTile(this);

		// Check object collision
		int objIndex = gp.cChecker.checkObject(this, true);
		if(objIndex != 999) {
			if(gp.obj[gp.currentMap][objIndex].type != type_trap_wall) {
				pickUpObject(objIndex);
			}
		}
		// Check npc collision
		int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
		interactNPC(npcIndex);

		// Check monster collision
		int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);	
		contactMonster(monsterIndex);
		
		// Check event
		gp.eHandler.checkEvent();		
	}

	public void attacking() {
		if(spriteCounter <= 3) {
			spriteNum = 1;
		}
		if(spriteCounter > 3 && spriteCounter <= 6) {
			spriteNum = 2;
		}
		if(spriteCounter > 6 && spriteCounter <= 9) {
			spriteNum = 3;
		}
		if(spriteCounter > 9 && spriteCounter <= 25) {
			spriteNum = 4;
		}
		if(spriteCounter > 25) {
			spriteNum = 1;
			spriteCounter = 0;
			attacking = false;
		}
		if(spriteCounter > 6 && spriteCounter <= 25) {
			// Save current worldX, worldY, solidArea
			int currentWorldX = worldX;
			int currentWorldY = worldY;
			int solidAreaWidth = solidArea.width;
			int solidAreaHeight = solidArea.height;
			
			// Adjust player's worldX/Y for the attackArea
			switch(direction) {
				case "up": 
					if(facingDirectoin == "right") {
						worldX += attackArea.width; 
					}
					if(facingDirectoin == "left") {
						worldX -= attackArea.width; 
					}
					break;
				case "down": 
					if(facingDirectoin == "right") {
						worldX += attackArea.width; 
					}
					if(facingDirectoin == "left") {
						worldX -= attackArea.width; 
					}
					break;				
				case "left": worldX -= attackArea.width; break;
				case "right": worldX += attackArea.width; break;
			}
			// attackArea becomes solidArea
			solidArea.width = attackArea.width;
			solidArea.height = attackArea.height;
//			 DRAW HIT BOXES
			if(gp.drawHitBoxes == true) {
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
				g2.fillRoundRect(screenX+solidArea.x, screenY+solidArea.y, solidArea.width, solidArea.height, 0, 0);
			}

			// Check monster collision with the updated worldX, worldY and solidArea
			int monsterIndex = gp.cChecker.checkEntity(this,  gp.monster);
			
			// Damage monster only if not a puzzle piece
			if(monsterIndex != 999 && gp.monster[gp.currentMap][monsterIndex].puzzlePiece == false) {
				System.out.println("attack"+attack);
				damageMonster(monsterIndex, attack);
			}
			// After checking collision, reset the original data for solidArea
			worldX = currentWorldX;
			worldY = currentWorldY;
			solidArea.width = solidAreaWidth;
			solidArea.height = solidAreaHeight;	
		}
	}
	public void pickUpObject(int i) {
		if (i != 999) {
			
			String text = "";
			if(inventory.size() != inventorySize) {
				switch(gp.obj[gp.currentMap][i].name) {
					case("Golden Jig"): {
						inventory.add(gp.obj[gp.currentMap][i]);
						text = "You got a "+gp.obj[gp.currentMap][i].name+".";	
						handleGoldenJigSE();
						gp.obj[gp.currentMap][i] = null;
						// GOLDEN JIG TELEPORT
						switch(gp.currentMap) {
						case(0): 
							gp.eHandler.teleport(1,  8, 8);
							break;
						}
						break;
					}
					case("Gulp! Juice"): {
						inventory.add(gp.obj[gp.currentMap][i]);
						text = "You got a "+gp.obj[gp.currentMap][i].name+".";	
						gp.playSE(8);
						gp.obj[gp.currentMap][i] = null;
						break;
					}
					case("Laser"):  {
						inventory.add(gp.obj[gp.currentMap][i]);
						text = "You got a "+gp.obj[gp.currentMap][i].name+".";	
						gp.stopMusic();
						gp.playMusic(7);
						gp.aSetter.setFirstLevelTrap();
						gp.aSetter.setFirstLevelTrapMonsters();
						gp.obj[gp.currentMap][i] = null;
						break;
					}
					case("Door"):  {
						break;
					}
					case("Bubble Shoot Placeholder"):  {
						inventory.add(projectile);
						startDialogue(gp.obj[gp.currentMap][i], 0);
						gp.obj[gp.currentMap][i] = null;
						gp.playSE(9);
						if(currentWeapon == null) {
							currentWeapon = projectile;
						}
						gp.player.attack = gp.player.getAttack();
						break;
					}
				}
			}
			else {
				text = "You cannot carry any more!";
			}
			gp.ui.addMessage(text);
		}
	}
	private void handleGoldenJigSE() {
		gp.stopMusic();
		gp.pauseMusicGoldenJig = true;
		gp.pauseMusicGoldenJigCounter = 0;
		// background music handler 
		gp.playSE(6);
	}

	public void interactNPC(int i) {
		if(i != 999) {
			if(gp.keyH.enterPressed == true) {
				attackCanceled = true;
				gp.npc[gp.currentMap][i].speak();
			}
			else {
				// PUSH ROCK
				gp.npc[gp.currentMap][i].move(direction);
			}
		}
	}
	public void interactNPCEventHandler() {
		if(gp.ui.npc != null && gp.ui.npc.name != null) {
			switch(gp.ui.npc.name) {
			case "Bright Jelly":{
				if (gp.currentSpeaker.dialogueIndex == 2 && inventory.contains(projectile) == false) {
					inventory.add(projectile); 
					if(currentWeapon == null) {
						currentWeapon = projectile;
					}
					gp.playSE(9);

				}			
				break;
			}
			case "Bright Crab":{
//				if(gp.ui.npc.dialogueIndex == 1 && gp.ui.npc.dialogueSet == 0) {
//					gp.darkness = false;
//					gp.playSE(9);
//					gp.eManager.setUp();
//
//				}
				if (inventoryContains("Golden Jig") == true) {
//					gp.playSE(1);
					gp.aSetter.setDoor(gp.currentMap);
				}			
				break;
				
			}
			}
		};
	}
	public void contactMonster(int i) {
		if(i != 999) {
			if (invincible == false && gp.monster[gp.currentMap][i].dying == false) {
				
				gp.playSE(3);

//				int damage = gp.monster[gp.currentMap][i].attack - defense;
				int damage = gp.monster[gp.currentMap][i].attack;

				if(damage < 0) {
					damage = 0;
				}
				currentLife -= damage;
		 		invincible = true;
			}
		}
	}
	public void damageMonster(int i, int attack) {
		if (i !=999) {
			if(gp.monster[gp.currentMap][i].invincible == false) {
				switch(gp.monster[gp.currentMap][i].name) {
				case("Blue Jelly"):
					gp.playSE(11);
					break;
				case("Purple Jelly"):
					gp.playSE(10);
					break;
				case("Green Crab"):
					gp.playSE(12);
					break;
				default: gp.playSE(3);
				break;
				
				}
//				knockBack(gp.monster[gp.currentMap][i]);
				int damage = attack - gp.monster[gp.currentMap][i].defense;
				if(damage < 0) {
					damage = 0;
				}
				// DAMAGE MONSTER
				gp.monster[gp.currentMap][i].currentLife -= damage;
				gp.ui.addMessage(damage + " damage!");
//				if
				gp.monster[gp.currentMap][i].invincible = true;
				gp.monster[gp.currentMap][i].damageReaction();
				if(gp.monster[gp.currentMap][i].currentLife <= 0) {
					// MONSTER DIES
					gp.monster[gp.currentMap][i].dying = true;
					gp.ui.addMessage("Killed the " + gp.monster[gp.currentMap][i].name + "");
//					gp.ui.addMessage("+" + gp.monster[gp.currentMap][i].exp + " exp");
//					NO EXP ADDED VVVV
//					exp += gp.monster[gp.currentMap][i].exp;
					checkLevelUp();
				}
			}
		}
		else {
//			System.out.aprintln("Miss!");
		}
	}
	private void checkLevelUp() {
		if( exp >= nextLevelExp) {
			level++;
			nextLevelExp = nextLevelExp*2;
			maxLife += 2;
			biteStrength++;
			attack = getAttack();
			defense = getDefense();
			gp.playSE(2);
//			gp.gameState = gp.dialogueState;
//			gp.ui.currentDialogue = "You are level " + level + " now!\n"
//					+ "You feel stronger!";
		}
	}
	public void selectItem() {
		int itemIndex = gp.ui.getItemIndexOnSlot();
		
		if(itemIndex < inventory.size()) {
			Entity selectedItem = inventory.get(itemIndex);
	
			if(selectedItem.type == type_laser || selectedItem.type == type_bubble_shoot) {
				currentWeapon = selectedItem;
				attack = getAttack();
				getPlayerAttackImage();
			}
			if(selectedItem.type == type_shield) {
				currentShield = selectedItem;
				defense = getDefense();
			}
			if(selectedItem.type == type_consumable) {
				selectedItem.use(this);
				inventory.remove(itemIndex);
			}
		}
	}
	public boolean inventoryContains(String objectName) {
		for(int i = 0; i < gp.player.inventory.size(); i++) {
			if(gp.player.inventory.get(i).name == objectName) {
				return true;
			}
		}
		return false;
	}
	public void knockBack(Entity entity) {
		if(entity.puzzlePiece == false) { // don't want to move puzzle pieces with knockBack
			entity.direction = direction;
			entity.speed += 20;
			entity.knockBack = true;
		}
	}
	public void draw(Graphics2D g2) {

		BufferedImage image = null;
		int tempScreenX = screenX;
		int tempScreenY = screenY;

		switch (direction) {
		case "up":
			if(attacking == false) {
				if (spriteNum == 1) {
					image = up1;
					if(facingDirectoin == "left") {
						image = up5;
					}
				}
				if (spriteNum == 2) {
					image = up2;
					if(facingDirectoin == "left") {
						image = up6;
					}
				}
				if (spriteNum == 3) {
					image = up3;
					if(facingDirectoin == "left") {
						image = up7;
					}
				}
				if (spriteNum == 4) {
					image = up4;
					if(facingDirectoin == "left") {
						image = up8;
					}
				}
			}
			if(attacking == true) {
				if (spriteNum == 1) {
					image = attackUp1;
					if(facingDirectoin == "left") {
						tempScreenX = screenX - gp.tileSize;
						image = attackUp5;
					}
				}
				if (spriteNum == 2) {
					image = attackUp2;
					if(facingDirectoin == "left") {
						tempScreenX = screenX - gp.tileSize;
						image = attackUp6;
					}
				}
				if (spriteNum == 3) {
					image = attackUp3;
					if(facingDirectoin == "left") {
						tempScreenX = screenX - gp.tileSize;
						image = attackUp7;
					}
				}
				if (spriteNum == 4) {
					image = attackUp4;
					if(facingDirectoin == "left") {
						tempScreenX = screenX - gp.tileSize;
						image = attackUp8;
					}
				}
			}
			break;
		case "down":
			if(attacking == false) {
				if (spriteNum == 1) {
					image = down1;
					if(facingDirectoin == "left") {
						image = down5;
					}
				}
				if (spriteNum == 2) {
					image = down2;
					if(facingDirectoin == "left") {
						image = down6;
					}
				}
				if (spriteNum == 3) {
					image = down3;
					if(facingDirectoin == "left") {
						image = down7;
					}
				}
				if (spriteNum == 4) {
					image = down4;
					if(facingDirectoin == "left") {
						image = down8;
					}
				}
			}
			if(attacking == true) {
				if (spriteNum == 1) {
					image = attackDown1;
					if(facingDirectoin == "left") {
						tempScreenX = screenX - gp.tileSize;
						image = attackDown5;
					}
				}
				if (spriteNum == 2) {
					image = attackDown2;
					if(facingDirectoin == "left") {
						tempScreenX = screenX - gp.tileSize;
						image = attackDown6;
					}
				}
				if (spriteNum == 3) {
					image = attackDown3;
					if(facingDirectoin == "left") {
						tempScreenX = screenX - gp.tileSize;
						image = attackDown7;
					}
				}
				if (spriteNum == 4) {
					image = attackDown4;
					if(facingDirectoin == "left") {
						tempScreenX = screenX - gp.tileSize;
						image = attackDown8;
					}
				}
			}
			break;
		case "left":
			facingDirectoin = "left";
			if(attacking == false) {
				if (spriteNum == 1) {
					image = left1;
				}
				if (spriteNum == 2) {
					image = left2;
				}
				if (spriteNum == 3) {
					image = left3;
				}
				if (spriteNum == 4) {
					image = left4;
				}
			}
			if(attacking == true) {
				tempScreenX = screenX - gp.tileSize;
				if (spriteNum == 1) {
					image = attackLeft1;
				}
				if (spriteNum == 2) {
					image = attackLeft2;
				}
				if (spriteNum == 3) {
					image = attackLeft3;
				}
				if (spriteNum == 4) {
					image = attackLeft4;
				}
			}
			break;
		case "right":
			facingDirectoin = "right";
			if(attacking == false) {
				if (spriteNum == 1) {
					image = right1;
				}
				if (spriteNum == 2) {
					image = right2;
				}
				if (spriteNum == 3) {
					image = right3;
				}
				if (spriteNum == 4) {
					image = right4;
				}
			}
			if(attacking == true) {
				if (spriteNum == 1) {
					image = attackRight1;
				}
				if (spriteNum == 2) {
					image = attackRight2;
				}
				if (spriteNum == 3) {
					image = attackRight3;
				}
				if (spriteNum == 4) {
					image = attackRight4;
				}
			}
			break;
		case "upright":
			facingDirectoin = "right";
			if(attacking == false) {
				if (spriteNum == 1) {
					image = right1;
				}
				if (spriteNum == 2) {
					image = right2;
				}
				if (spriteNum == 3) {
					image = right3;
				}
				if (spriteNum == 4) {
					image = right4;
				}
			}
			if(attacking == true) {
				if (spriteNum == 1) {
					image = attackRight1;
				}
				if (spriteNum == 2) {
					image = attackRight2;
				}
				if (spriteNum == 3) {
					image = attackRight3;
				}
				if (spriteNum == 4) {
					image = attackRight4;
				}
			}
			break;
		case "downright":
			facingDirectoin = "right";
			if(attacking == false) {
				if (spriteNum == 1) {
					image = right1;
				}
				if (spriteNum == 2) {
					image = right2;
				}
				if (spriteNum == 3) {
					image = right3;
				}
				if (spriteNum == 4) {
					image = right4;
				}
			}
			if(attacking == true) {
				if (spriteNum == 1) {
					image = attackRight1;
				}
				if (spriteNum == 2) {
					image = attackRight2;
				}
				if (spriteNum == 3) {
					image = attackRight3;
				}
				if (spriteNum == 4) {
					image = attackRight4;
				}
			}
			break;
		case "upleft":
			facingDirectoin = "left";
			if(attacking == false) {
				if (spriteNum == 1) {
					image = left1;
				}
				if (spriteNum == 2) {
					image = left2;
				}
				if (spriteNum == 3) {
					image = left3;
				}
				if (spriteNum == 4) {
					image = left4;
				}
			}
			if(attacking == true) {
				if (spriteNum == 1) {
					image = attackLeft1;
				}
				if (spriteNum == 2) {
					image = attackLeft2;
				}
				if (spriteNum == 3) {
					image = attackLeft3;
				}
				if (spriteNum == 4) {
					image = attackLeft4;
				}
			}
			break;
		case "downleft":
			facingDirectoin = "left";
			if(attacking == false) {
				if (spriteNum == 1) {
					image = left1;
				}
				if (spriteNum == 2) {
					image = left2;
				}
				if (spriteNum == 3) {
					image = left3;
				}
				if (spriteNum == 4) {
					image = left4;
				}
			}
			if(attacking == true) {
				if (spriteNum == 1) {
					image = attackLeft1;
				}
				if (spriteNum == 2) {
					image = attackLeft2;
				}
				if (spriteNum == 3) {
					image = attackLeft3;
				}
				if (spriteNum == 4) {
					image = attackLeft4;
				}
			}
			break;
		}

		
		
		
		// PLAYER HP BAR
		if(hpBarOn == true) { 
			double oneHealthUnitScale = (double)(gp.tileSize*2/3)/maxLife;
			double hpBarValue = oneHealthUnitScale*currentLife;
			g2.setColor(new Color(3, 39, 29));
			g2.fillRect(screenX+(gp.tileSize/3)-7,  screenY-15,  gp.tileSize*2/3 ,  5);
			g2.setColor(new Color(213, 197, 190));
			g2.fillRect(screenX+(gp.tileSize/3)-7,  screenY-15,  (int)hpBarValue,  5);
			hpBarOnCounter++;
			
			if(hpBarOnCounter > 300) {
				hpBarOnCounter = 0;
				hpBarOn = false;
			}
		}
		
		if(invincible == true) {
			hpBarOn = true;
			hpBarOnCounter = 0;
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));

		}
		if(drawing == true) {
			g2.drawImage(image, tempScreenX, tempScreenY, null);
		}
//		 DRAW PLAYER HITBOXES
		if(gp.drawHitBoxes == true) {
			g2.setColor(Color.red);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
			g2.fillRoundRect(screenX+solidArea.x, screenY+solidArea.y, solidArea.width, solidArea.height, 0, 0);
			g2.setFont(new Font("Arial", Font.PLAIN, 20));
			g2.setColor(Color.white);
			g2.drawString(gp.player.worldX/gp.tileSize+", "+gp.player.worldY/gp.tileSize, 50, 400);
			g2.drawString(gp.player.worldX+", "+gp.player.worldY, 50, 420);
			g2.drawString(gp.player.screenX+", "+gp.player.screenY, 50, 440);
			g2.drawString("Right Gap: "+gapBetweenScreenEdgeAndMapEdgeRight+"", 50, 460);
			g2.drawString("ScreenX "+screenX+" "+"ScreenY "+screenY, 50, 480);
			g2.drawString(gp.gameState+"", 50, 500);
			g2.drawString(playerScreenYMovement+"", 50, 520);
		}

//		 Reset alpha
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
	}

	public void checkIfCloseToNPC() {
		//loop through all npc's in curerntMap
		for (int i = 0; i < gp.npc[gp.currentMap].length; i++) {
			if(gp.npc[gp.currentMap][i] != null && gp.npc[gp.currentMap][i].type != type_rock_push) {
				// if any npcs are less than a tile away from player 
				switch(facingDirectoin) {
				case("right"):
					//check if npc is to the right of player 
					if(gp.player.screenX - gp.npc[gp.currentMap][i].getScreenX() < 0) {
						if(gp.npc[gp.currentMap][i].getScreenX() - gp.player.screenX < gp.tileSize*(2)) {
							canStartDialogue = true;
							indexNPCInRange = i;
						}
					}
					else {
						canStartDialogue = false;
					}
					break;
				case("left"):
					//check if npc is to the left of player 
					if(gp.player.screenX - gp.npc[gp.currentMap][i].getScreenX() > 0) {
						if(gp.player.screenX - gp.npc[gp.currentMap][i].getScreenX() < gp.tileSize*(2)) {
							canStartDialogue = true;
							indexNPCInRange = i;
						}
					}
					else {
						canStartDialogue = false;
					}
					break;
				}
				//player is above npc
				if(gp.player.screenY - gp.npc[gp.currentMap][i].getScreenY() < 0) {
					if(gp.npc[gp.currentMap][i].getScreenY() - gp.player.screenY > gp.tileSize*(2)) {
						canStartDialogue = false;
					}
				}
				//player is below npc
				if(gp.player.screenY - gp.npc[gp.currentMap][i].getScreenY() > 0) {
					if(gp.player.screenY - gp.npc[gp.currentMap][i].getScreenY() > gp.tileSize*(2) ) {
						canStartDialogue = false;
					}
				}

			}
		}		
	}
}
