package main;

import java.awt.Rectangle;

import entity.Entity;

public class EventHandler {
	
	GamePanel gp;
	EventRect eventRect[][][];
	int previousEventX, previousEventY;
	boolean canTouchEvent = true;
	boolean canTouchTriggerEvent = true;
	int tempMap, tempCol, tempRow;
	Entity eventMaster;
	
	public EventHandler(GamePanel gp) {
		this.gp = gp;
		
		eventMaster = new Entity(gp);
		
		eventRect = new EventRect[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];
		int map = 0;
		int col = 0;
		int row = 0;
		
		while(map < gp.maxMap && col < gp.maxWorldCol && row < gp.maxWorldRow) {
			eventRect[map][col][row] = new EventRect();
			eventRect[map][col][row].x = 5;
			eventRect[map][col][row].y = 5;
			eventRect[map][col][row].width = 16;
			eventRect[map][col][row].height = 16;
			eventRect[map][col][row].eventRectDefaultX = eventRect[map][col][row].x;
			eventRect[map][col][row].eventRectDefaultY = eventRect[map][col][row].y;
			
			col++;
			if(col == gp.maxWorldCol) {
				col = 0;
				row++;
				if(row == gp.maxWorldRow) {
					row = 0;
					map++;
				}
			}
			
		}
		setDialogue();
	}
	public void setDialogue() {
		eventMaster.dialogues[0][0] = "Teleport!";
	}
	public void checkEvent() {
		
		// CHECK IF PLAYER IS MORE THAN 1 TILE AWAY FROM LAST EVENT
		int xDistance = Math.abs(gp.player.worldX - previousEventX);
		int yDistance = Math.abs(gp.player.worldY - previousEventY);
		int distance = Math.max(xDistance, yDistance);
		if(distance > gp.tileSize) {
			canTouchEvent = true;
		}

		if(canTouchEvent == true) {
//			if(hit(10, 12, "any") == true) damageTile(10, 12, gp.dialogueState);
//			if(hit(12, 12, "any") == true) teleport(gp.dialogueState);
//			if(hit(9, 12, "any") == true) healingPool(9, 12, gp.dialogueState);
//			if(hit(2, 16, "any") == true) triggerTrap(2, 16, gp.gameState);
//			if(hit(3, 16, "any") == true) triggerTrap(3, 16, gp.gameState);
//			if(hit(3, 17, "any") == true) triggerTrap(3, 17, gp.gameState);
			if(hit(0, 5, 19, "any") == true) teleport(1, 15, 5);
//			else if(hit(1, 15, 5, "any") == true) teleport(0, 18, 1);
			
//			if(hit(0, 18, , "any") == true) teleport(1, 15, 5);



		}

	}
	public boolean hit(int map, int col, int row, String reqDirection) {
		boolean hit = false;
		if(map == gp.currentMap) {
			gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x; 
			gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
			eventRect[map][col][row].x = col * gp.tileSize + eventRect[map][col][row].x;
			eventRect[map][col][row].y = row * gp.tileSize + eventRect[map][col][row].y;
			
			if(gp.player.solidArea.intersects(eventRect[map][col][row]) && eventRect[map][col][row].eventDone == false) {
				if(gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
					hit = true;
					previousEventX = gp.player.worldX;
					previousEventY = gp.player.worldY;
				}
			}

			gp.player.solidArea.x = gp.player.solidAreaDefaultX;
			gp.player.solidArea.y = gp.player.solidAreaDefaultY;
			eventRect[map][col][row].x = eventRect[map][col][row].eventRectDefaultX;
			eventRect[map][col][row].y = eventRect[map][col][row].eventRectDefaultY;
			
		}



		return hit;
	}
	public void teleport(int map, int col, int row) {
		eventMaster.startDialogue(eventMaster, 0);
		gp.gameState = gp.levelTransitionState;
		tempMap = map;
		tempCol = col;
		tempRow = row;
		canTouchEvent = false;

	}
	public void triggerBrightCrabCutScene() {
		gp.csManager.sceneNum = gp.csManager.brightCrab1;
	}

	public void damageTile(int col, int row, int gameState) {
		gp.gameState = gameState;
//		gp.ui.currentDialogue = "You got damage!";
		gp.player.currentLife -= 1;
		canTouchEvent = false;
	}
	public void healingPool(int col, int row, int gameState) {
		if(gp.keyH.enterPressed == true) {
			gp.gameState = gameState;
			gp.player.attackCanceled = true;
			gp.playSE(2);
//			gp.ui.currentDialogue = "You are healed!";
			gp.player.currentLife = gp.player.maxLife;
		}
	}
	public void triggerTrap(int col, int row, int gameState) {
		gp.gameState = gameState;
		if(canTouchTriggerEvent) {
			gp.stopMusic();
			gp.playMusic(7);
			gp.aSetter.setFirstLevelTrap();
			gp.aSetter.setFirstLevelTrapMonsters();
			canTouchTriggerEvent = false;
		}
		canTouchTriggerEvent = false;
	}
	public void speedUp(int gameState) {
		gp.gameState = gameState;
		gp.player.speed = 10;
		canTouchEvent = false;

	}



}
