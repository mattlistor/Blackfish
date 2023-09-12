package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import environment.Lighting;
import main.GamePanel;
import main.UtilityTool;
import object.OBJ_Sparkle;

public class Entity {
	
	GamePanel gp;	
	public BufferedImage up1, up2, up3, up4, up5, up6, up7, up8, down1, down2, down3, down4, down5, down6, down7, down8, left1, left2, left3, left4, right1, right2, right3, right4;
	public BufferedImage frame1, frame2, frame3, frame4, frame5, frame6, frame7, frame8;
	public BufferedImage dying1, dying2, dying3, dying4;
	public BufferedImage attackUp1, attackUp2, attackUp3, attackUp4, attackUp5, attackUp6, attackUp7, attackUp8, attackDown1, attackDown2, attackDown3, attackDown4, attackDown5, attackDown6, attackDown7, attackDown8, attackLeft1, attackLeft2, attackLeft3, attackLeft4, attackRight1, attackRight2, attackRight3, attackRight4;
	public BufferedImage image, image2, image3;
	public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
	public Rectangle attackArea = new Rectangle(0, 0, 0, 0);
	public int solidAreaDefaultX, solidAreaDefaultY;
	public boolean collision = false;
	public String dialogues[][] = new String[20][20];
	public String csDialogues[][] = new String[20][20];

	public boolean trapMonster = false;
	public boolean knockBack = false;
	public boolean canCreateNewRock = false;
	
	// STATE
	public int worldX, worldY;
	public int originalWorldY, originalWorldX;
	public String direction = "right"; 
	public String facingDirectoin;
	public String collisionDirection; // for diagonal moving entities
	public int spriteNum = 1;
	public int dialogueSet, csDialogueSet = 0;
	public int dialogueIndex, csDialogueIndex = 0;
	public boolean collisionOn = false;
	public boolean invincible = false;
	boolean attacking = false;
	public boolean alive = true;
	public boolean dying = false;
	public boolean hpBarOn = false;
	public boolean sleep = false;
	public boolean drawing = true;
	public boolean pressedButton = false;
	public boolean falling = true;

	
	// COUNTERS
	public int actionLockCounter = 0;
	public int invincibleCounter = 0;
	public int shotAvailableCounter = 0;
	public int spriteCounter = 0;
	public int dyingCounter = 0;
	public int hpBarOnCounter = 0;
	public int charactersFrameCount;
	public int knockBackCounter = 0;

	// CHARACTER ATTRIBUTES
	public String name;
	public int maxLife;
	public int currentLife;
	public int maxMana;
	public int mana;
	public int speed;
	public int level;
	public int biteStrength;
	public int exp;
	public int nextLevelExp;
	public int coin;
	public int attack;
	public int defense;
	public Entity currentWeapon;
	public Entity currentShield;
	public Projectile projectile;
	public Entity laser;
	public int defaultSpeed;
	public String color = "";
	public boolean puzzlePiece = false; // entity doesnt get damage if monster

//	public ArrayList<Entity> list = new ArrayList<>();

	
	// ITEM ATTRIBUTES
	public int attackValue;
	public int defenseValue;
	public String description = "";
	public int useCost;
	
	// TYPE 
	public int type; // 0 = player, 1 = npc, 2 = monster;
	public final int type_player = 0;
	public final int type_npc = 1;
	public final int type_monster = 2;
	public final int type_laser = 3;
	public final int type_bite = 4;
	public final int type_shield = 5;
	public final int type_consumable = 6;
	public final int type_bubble_shoot = 7;
	public final int type_golden_jig = 8;
	public final int type_trap_wall = 9;
	public final int type_placeholder = 10;
	public final int type_rock_push = 11;
	public final int type_button = 12;
	public boolean tileCollision;

	
	public Entity(GamePanel gp) {
		this.gp = gp;
	}
	public void setAction() { };
	public void move(String direction) { };
	public void spriteNumAndMovementHandler() { };
	public void damageReaction() { };
//	public BufferedImage getSparkleImage() {};

	public void speak() {	};
	public void facePlayer() {
		switch(gp.player.facingDirectoin) {
		case "up":
			direction = "down";
			break;
		case "down":
			direction = "down";
			break;
		case "left":
			direction = "right";
			break;
		case "right":
			direction = "left";
			break;
		}
	}
	public void startDialogue(Entity entity, int setNum) {
		gp.gameState = gp.dialogueState; 
		gp.ui.npc = entity;
		dialogueSet = setNum;
	}
	public void use(Entity entity) {	};
	public void checkCollision() {
		//CHECK COLLISION
		collisionOn = false;
		tileCollision = false;

		gp.cChecker.checkTile(this); 
		int contactObjectIndex = gp.cChecker.checkObject(this, false);
		gp.cChecker.checkEntity(this, gp.npc);
		gp.cChecker.checkEntity(this, gp.monster);
		
		// CHECK PLAYER COLLISION
		boolean contactPlayer = gp.cChecker.checkPlayer(this);
		if(type == type_npc) {
			contactPlayer = false;
		}
		
		if(this.type == type_monster && contactPlayer == true) {
			if(gp.player.invincible == false) {
				// GIVE DAMAGE
				gp.playSE(3);

				
				int damage = attack - gp.player.defense;
				if(damage < 0) {
					damage = 0;
				}
				gp.player.currentLife -= damage;
				gp.player.invincible = true;
			}
		}
		 
		checkToOpenWall(contactObjectIndex);
		checkIfRockIsStuck();

	};
	private void checkIfRockIsStuck() {
		if ((collisionDirection == "left" || collisionDirection == "right") 
				&& type == type_rock_push 
				&& tileCollision == true
				&& falling == false
				&& canCreateNewRock == false) {
			dying = true;
			canCreateNewRock = true;
			resetRockToOriginalPosition();
		}
	}
	private void resetRockToOriginalPosition() {
		for(int j = 0 ; j < gp.npc[gp.currentMap].length; j++) {
			if(gp.npc[gp.currentMap][j] == null && canCreateNewRock == true) {
				gp.npc[gp.currentMap][j] = new NPC_Rock_1(gp);
				gp.npc[gp.currentMap][j].originalWorldX = originalWorldX;
				gp.npc[gp.currentMap][j].originalWorldY = originalWorldY;
				gp.npc[gp.currentMap][j].worldX = originalWorldX;
				gp.npc[gp.currentMap][j].worldY = originalWorldY;
				return;
			}
		}



	}
	private void checkToOpenWall(int i) {
		if(i != 999) {
			if(gp.obj[gp.currentMap][i].type == type_button && this.type == type_rock_push
					&& (gp.obj[gp.currentMap][i].worldX-worldX <= 3 && gp.obj[gp.currentMap][i].worldX-worldX >= -3)) {
				// CHECK WHICH WALL TO OPEN 
				// make list of levels walls (starfish)
				for(int j = 0 ; j < gp.monster[1].length; j++) {
					// filter which monsters is linked to starfish  button (color coded)
					if(gp.monster[gp.currentMap][j] != null) {
						if(gp.monster[gp.currentMap][j].color == gp.obj[gp.currentMap][i].color 
							&& gp.monster[gp.currentMap][j].color != "") {
							// remove rock and starfish wall 
							gp.playSE(17);
							dying = true;
							pressedButton = true;
							gp.monster[gp.currentMap][j].dying = true;
						}
					}

				}	
				// remove starfish button
				gp.obj[gp.currentMap][i] = null;
				
				
			}
		}		
	}
	public void update() {		
		if(sleep == false) {
			if(knockBack == true) {
				checkCollision();
				if(collisionOn == true) {
					knockBackCounter = 0;
					knockBack = false;
					speed = defaultSpeed;
				}
				else if(collisionOn == false) {
					switch(gp.player.facingDirectoin) {
					case "up": worldY -= speed; break;
					case "down": worldY += speed; break;
					case "left": worldX -= speed; break;
					case "right": worldX += speed; break;
					}
				}
	 
				knockBackCounter++;
				if(knockBackCounter == 20) {
					knockBackCounter = 0;
					knockBack = false;
					speed = defaultSpeed;
				}
			}
			else {
				setAction();
				checkCollision();
		
				if(type == type_laser || type == type_npc  || type == type_monster) {
					spriteNumAndMovementHandler();		
				}
				if(type == type_golden_jig || type == type_placeholder || type == type_rock_push) {
					spriteNumAndMovementHandler();		
				}
			}
			if(invincible == true) {
				invincibleCounter++;
				if(invincibleCounter > 40) {
					invincible = false;
					invincibleCounter = 0;
				}
			}
			
		}
		
	};
	public void draw(Graphics2D g2) {
		BufferedImage image = null, sparkleImage = null;
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;

		if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
		   worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
		   worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
		   worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
			
			switch (direction) {
			case "up":
				if (spriteNum == 1) { image = up1; }
				if (spriteNum == 2) { image = up2; }
				if (spriteNum == 3) { image = up3; }
				if (spriteNum == 4) { image = up4; }
				break;
			case "down":
				if (spriteNum == 1) { image = down1; }
				if (spriteNum == 2) { image = down2; }
				if (spriteNum == 3) { image = down3; }
				if (spriteNum == 4) { image = down4; }
				break;
			case "left":
				facingDirectoin = "left";
				if (spriteNum == 1) { image = left1; }
				if (spriteNum == 2) { image = left2; }
				if (spriteNum == 3) { image = left3; }
				if (spriteNum == 4) { image = left4; }
				break;
			case "right":
				facingDirectoin = "right";
				if (spriteNum == 1) { image = right1; }
				if (spriteNum == 2) { image = right2; }
				if (spriteNum == 3) { image = right3; }
				if (spriteNum == 4) { image = right4; }
				break;
			}
			// IF A GOLDEN JIG
			if(type == type_golden_jig || name == "Title Text") {
				if (spriteNum == 1) { image = frame1; }
				if (spriteNum == 2) { image = frame2; }
				if (spriteNum == 3) { image = frame3; }
				if (spriteNum == 4) { image = frame4; }
				if (spriteNum == 5) { image = frame5; }
				if (spriteNum == 6) { image = frame6; }
				if (spriteNum == 7) { image = frame7; }
				if (spriteNum == 8) { image = frame8; }
			}
			// SPARKLE
			sparkleImage = ((OBJ_Sparkle) gp.sparkle).getSparkleImage();
			
			// MONSTER HP BAR
			if(type == type_monster && hpBarOn == true && puzzlePiece == false) { 
				double oneHealthUnitScale = (double)(gp.tileSize*2/3)/maxLife;
				double hpBarValue = oneHealthUnitScale*currentLife;
				g2.setColor(new Color(3, 39, 29));
				g2.fillRect(screenX+(gp.tileSize/3)-7,  screenY-15,  gp.tileSize*2/3 ,  5);
				g2.setColor(new Color(99, 157, 145));
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
				changeAlpha(g2, 0.4f);
			}
			if(dying == true) {
				dyingCounter++;
//				alive = false;

				int i = 5;
				if(dyingCounter <= i) {image = dying1;}
				if(dyingCounter > i && dyingCounter <= i*2) {image = dying2;}
				if(dyingCounter > i*2 && dyingCounter <= i*3) {image = dying3;}
				if(dyingCounter > i*3 && dyingCounter <= i*4) {image = dying4;}
//				if(dyingCounter > i*4 && dyingCounter <= i*5) {image = dying3;}
//				if(dyingCounter > i*5 && dyingCounter <= i*6) {image = dying4;}
//				if(dyingCounter > i*6 && dyingCounter <= i*7) {image = dying3;}
//				if(dyingCounter > i*7 && dyingCounter <= i*8) {image = dying4;}
				if(dyingCounter >= i*4) {
					alive = false;
				}
//				dyingAnimation();
			}
			
			// HANDLES DIFFERENT SIZE IMAGES
			if(type == type_bubble_shoot) {
				g2.drawImage(image, screenX, screenY, gp.tileSize/2, gp.tileSize/2, null);
			}
			else if(type == type_trap_wall) {
				g2.drawImage(image, screenX, screenY, gp.tileSize*2, gp.tileSize, null);
			}
			else if(type == type_npc) {
				g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
				g2.drawImage(sparkleImage, screenX-gp.tileSize/2, screenY-gp.tileSize/2, gp.tileSize*2, gp.tileSize*2, null);
			}
			else {
				g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
			}

//			 DRAW HIT BOXES
			if(gp.drawHitBoxes == true) {
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
				g2.fillRoundRect(screenX+solidArea.x, screenY+solidArea.y, solidArea.width, solidArea.height, 0, 0);
			}
			// Reset alpha
			changeAlpha(g2, 1F);
			
			// GLOW
//			Lighting NPC_Lighting = new Lighting(gp, 600, this);


			

		}
	}
	public void dyingAnimation(Graphics2D g2) {
		dyingCounter++;
//		alive = false;

		int i = 5;
		if(dyingCounter <= i) {image = dying1;}
		if(dyingCounter > i && dyingCounter <= i*2) {image = dying1;}
		if(dyingCounter > i*2 && dyingCounter <= i*3) {image = dying1;}
		if(dyingCounter > i*3 && dyingCounter <= i*4) {image = dying1;}
		if(dyingCounter > i*4 && dyingCounter <= i*5) {image = dying1;}
		if(dyingCounter > i*5 && dyingCounter <= i*6) {image = dying1;}
		if(dyingCounter > i*6 && dyingCounter <= i*7) {}
		if(dyingCounter > i*7 && dyingCounter <= i*8) {image = dying1;}
		if(dyingCounter >= i*8) {
			alive = false;
		}
	}
	private void changeAlpha(Graphics2D g2, float alphaValue) {
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
		
	}
	public BufferedImage setup(String imagePath, int width, int height) {
		UtilityTool uTool = new UtilityTool();
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
			image = uTool.scaleImage(image, width, height);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	public void resetCounter() {
		actionLockCounter = 0;
		invincibleCounter = 0;
		shotAvailableCounter = 0;
		spriteCounter = 0;
		dyingCounter = 0;
		hpBarOnCounter = 0;
	}
	public int getScreenX() {
		return worldX - gp.player.worldX + gp.player.screenX;
	}
	public float getScreenY() {
		return worldY - gp.player.worldY + gp.player.screenY;

	}
	
}
