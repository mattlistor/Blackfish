 package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.InputStream;

import entity.PlayerPlaceholder;

public class CutSceneManager {
	GamePanel gp;
	Graphics2D g2;
	public int sceneNum;
	public int scenePhase = 0;
	boolean madePlaceholder = false;
	
	public int dialogueBoxHeight = 64*3;
	public int dialogueBoxY = 64; 
	public int highestBoundDialogueBoxY = dialogueBoxY;
	public int lowestBoundDialogueBoxY = dialogueBoxY+10;
	public String dialogueBoxDirection = "down";
	public int dialogueBoxAnimationCounter;
	public int charIndex = 0;
	public String combinedText = "";
	public int currentDialogueIndex = 0;
	public String currentDialogue = "";
	public boolean pauseAfterSentence = false;
	public int pauseAfterSentenceCounter = 0; // one second
	Font dogica; 

	

	
	//Scene Number
	public final int NA = 0;
	public final int brightCrab1 = 1;
	
	
	public CutSceneManager(GamePanel gp) {
		this.gp = gp;
		
		try {
			InputStream is = getClass().getResourceAsStream("/font/dogica.ttf");
			dogica = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}   
	public void draw(Graphics2D g2) {
		this.g2 = g2;
		g2.setFont(dogica);
		switch(sceneNum) {
		case brightCrab1: scene_brightCrab1(); break;
		}
	}
	public void drawCutSceneDialogue() {
		int x = gp.tileSize*3; 
		if(dialogueBoxAnimationCounter > 6) {
			// ADJUST THE DIALOGUE BOX'S Y LEVELS AND DIRECTION;
			if (dialogueBoxDirection == "up") {
				if(dialogueBoxY < highestBoundDialogueBoxY ) {
					dialogueBoxDirection = "down";
				}
			}
			else if (dialogueBoxDirection == "down") {
				if(dialogueBoxY > lowestBoundDialogueBoxY ) {
					dialogueBoxDirection = "up";

				}
			}
			switch(dialogueBoxDirection) {
				case("down"): dialogueBoxY+=1; break;
				case("up"): dialogueBoxY-=1; break;
			}
			dialogueBoxAnimationCounter = 0;
		}	
		dialogueBoxAnimationCounter++;
		
		// WINDOW
		int width = gp.screenWidth - (gp.tileSize*6); 
//		gp.ui.drawSubWindow(x, dialogueBoxY, width, dialogueBoxHeight);

//		g2.setColor(new Color(209, 209, 209));
//		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 14));
//		if(npc.type == npc.type_npc) {
//			g2.setColor(new Color(209, 209, 209));
////			drawDialogueWindow(x, dialogueBoxY-gp.tileSize, width,  40);
//			g2.setColor(Color.white);
//			g2.drawString(npc.name , (gp.tileSize*13)/4, dialogueBoxY-20);
//		}

		
		x = (gp.tileSize*13)/4;
		int speakerBoxY = dialogueBoxY + 36;
		int instructionTextY = dialogueBoxY;
		if(gp.ui.npc.csDialogues[gp.ui.npc.csDialogueSet][gp.ui.npc.csDialogueIndex] != null) {
			char characters[] = gp.ui.npc.csDialogues[gp.ui.npc.csDialogueSet][gp.ui.npc.csDialogueIndex].toCharArray();
			// letter by letter
			if(pauseAfterSentence == true) {
				pauseAfterSentenceCounter++;
				if(pauseAfterSentenceCounter > 30) {
					pauseAfterSentenceCounter = 0;
					pauseAfterSentence = false;
				}
			}
			if(charIndex < characters.length && pauseAfterSentence == false) {
				String s = String.valueOf(characters[charIndex]);	

				if(s.compareTo(".") == 0 || s.compareTo("!") == 0 || s.compareTo("?") == 0) {
					pauseAfterSentence = true;
				}
				gp.playSE(13);
				combinedText = combinedText+s;
				currentDialogue = combinedText;
				charIndex++;
			}

			if (gp.keyH.enterPressed == true) {
				charIndex = 0;
				combinedText = "";
				if(gp.gameState == gp.cutSceneState) {
					// conversation continues
					gp.ui.npc.csDialogueIndex++;
					gp.keyH.enterPressed = false;
				}
			}
		}
		else {
			// conversation is over
			gp.ui.npc.csDialogueIndex = 0;
			if(gp.gameState == gp.dialogueState) {
				gp.gameState = gp.playState;
			}
			if(gp.gameState == gp.cutSceneState) {
				gp.csManager.scenePhase++;
				gp.ui.npc.csDialogueSet++;
			}
		}
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 14F));
		g2.setColor(Color.white);
		for(String line : currentDialogue.split("\n")) {
			g2.drawString(line, x, speakerBoxY);
			speakerBoxY += 30; 
		}
		
//		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 8F));
//		String text = "Press [B] to continue";
//		int textX = getXforCenteredText(text);
//		g2.drawString(text, x, instructionTextY + dialogueBoxHeight - 22);
	}
	public void scene_brightCrab1() {
		if(scenePhase == 0) {
			// player placeholder
			for(int i = 0; i < gp.placeholder[0].length; i++) {
				if(gp.placeholder[gp.currentMap][i] == null && madePlaceholder == false) {
					gp.placeholder[gp.currentMap][i] = new PlayerPlaceholder(gp);
					gp.placeholder[gp.currentMap][i].worldX = gp.player.worldX;
					gp.placeholder[gp.currentMap][i].worldY = gp.player.worldY;
					gp.placeholder[gp.currentMap][i].direction = gp.player.direction;
					madePlaceholder = true;
					break;
				}
			}
			
			gp.player.drawing = false;
			// move camera
			gp.player.worldX += 2;
			// stop camera
			if(gp.player.worldX > gp.tileSize*35) {
				scenePhase++;
			}
		}
		if(scenePhase == 1) {
			if(gp.npc[0][0].name == "Bright Crab") {
				gp.npc[gp.currentMap][0].sleep = false;
				gp.ui.npc = gp.npc[0][0];
				scenePhase++;
			}
		}
		if(scenePhase == 2) {
			drawCutSceneDialogue();
			// scenePhase++ is handled in drawCutSceneDialogue
		}
		if(scenePhase == 3) {
			for(int i = 0; i < gp.placeholder[gp.currentMap].length; i ++) {
				if(gp.placeholder[gp.currentMap][i] != null) {
					if( gp.placeholder[gp.currentMap][i].name == PlayerPlaceholder.npcName) {
						gp.player.worldX = gp.placeholder[gp.currentMap][i].worldX;
						gp.player.worldY = gp.placeholder[gp.currentMap][i].worldY;
						gp.placeholder[gp.currentMap][i] = null;
						break;
					}
				}	
			}
			gp.player.drawing = true;
			sceneNum = NA;
			scenePhase = 0;
			gp.gameState = gp.playState;

		}

	}

	

	
}
