package main;

import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Golden_Jig;
import object.OBJ_Gulp_Juice;
import object.OBJ_Seaweed;
import object.OBJ_Starfish_Button;
import object.OBJ_Starfish_Wall;
import object.OBJ_Trap_Wall;
import object.OBJ_Weapon_Laser;
import object.OBJ_Bubble_Shoot;
import object.OBJ_Bubble_Shoot_Placeholder;
import entity.Entity;
import entity.NPC_Crab_1;
import entity.NPC_Jellyfish_1;
import entity.NPC_Rock_1;
import entity.Player;
import monster.MON_Crab;
import monster.MON_Crab_2;
import monster.MON_Fluke;
import monster.MON_Jellyfish_1;
import monster.MON_Jellyfish_2;
import monster.MON_Starfish_Wall;
import object.OBJ_Boots;

public class AssetSetter {
	
	GamePanel gp;
	public int monsterIndex = 0;
	public int objectIndex = 0;
	public int projectileIndex = 0;

	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;

	}
	
	public void setObject() {
		int mapNum = 0;
		int i = 0;
		gp.obj[mapNum][0] = gp.jig_1;
		gp.obj[mapNum][0].worldX = 58 * gp.tileSize;
		gp.obj[mapNum][0].worldY = 19 * gp.tileSize;
	
		mapNum++;
		gp.obj[mapNum][i] = new OBJ_Bubble_Shoot_Placeholder(gp);
		gp.obj[mapNum][i].worldX = 11 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 19 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Gulp_Juice(gp);
		gp.obj[mapNum][i].worldX = 16 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 8 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Starfish_Button(gp, "orange");
		gp.obj[mapNum][i].worldX = 17 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 21 * gp.tileSize-8;
		i++;
		gp.obj[mapNum][i] = new OBJ_Starfish_Button(gp, "purple");
		gp.obj[mapNum][i].worldX = 45 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 21 * gp.tileSize-8;
		i++;
		gp.obj[mapNum][i] = new OBJ_Starfish_Button(gp, "yellow");
		gp.obj[mapNum][i].worldX = 58 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 42 * gp.tileSize-8;
		i++;
		
		gp.obj[mapNum][i] = gp.jig_2;
		gp.obj[mapNum][i].worldX = 35 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 39 * gp.tileSize+(gp.tileSize/2);
		i++;
		gp.obj[mapNum][i] = new OBJ_Gulp_Juice(gp);
		gp.obj[mapNum][i].worldX = 28 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 39 * gp.tileSize+(gp.tileSize/2);
		i++;
		mapNum++;
		gp.obj[mapNum][i] = new OBJ_Golden_Jig(gp);
		gp.obj[mapNum][i].worldX = 27 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 17 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Gulp_Juice(gp);
		gp.obj[mapNum][i].worldX = 14 * gp.tileSize + 30;
		gp.obj[mapNum][i].worldY = 2 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Gulp_Juice(gp);
		gp.obj[mapNum][i].worldX = 22 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 17 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Gulp_Juice(gp);
		gp.obj[mapNum][i].worldX = 17 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 7 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Seaweed(gp);
		gp.obj[mapNum][i].worldX = 5 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 3 * gp.tileSize + 15;
		i++;
		gp.obj[mapNum][i] = new OBJ_Seaweed(gp);
		gp.obj[mapNum][i].worldX = 5 * gp.tileSize-35;
		gp.obj[mapNum][i].worldY = 3 * gp.tileSize + 25;
		i++;
		gp.obj[mapNum][i] = new OBJ_Seaweed(gp);
		gp.obj[mapNum][i].worldX = 1 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 3 * gp.tileSize + 15;
		i++;
		gp.obj[mapNum][i] = new OBJ_Seaweed(gp);
		gp.obj[mapNum][i].worldX = 8 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 3 * gp.tileSize + 15;
		i++;
		gp.obj[mapNum][i] = new OBJ_Seaweed(gp);
		gp.obj[mapNum][i].worldX = 12 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 3 * gp.tileSize + 15;
		i++;
		gp.obj[mapNum][i] = new OBJ_Seaweed(gp);
		gp.obj[mapNum][i].worldX = 12 * gp.tileSize+35;
		gp.obj[mapNum][i].worldY = 3 * gp.tileSize + 20;
		i++;
		gp.obj[mapNum][i] = new OBJ_Seaweed(gp);
		gp.obj[mapNum][i].worldX = 18 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 3 * gp.tileSize + 15;
		i++;
		gp.obj[mapNum][i] = new OBJ_Seaweed(gp);
		gp.obj[mapNum][i].worldX = 14 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 8 * gp.tileSize + 15;
		i++;
		gp.obj[mapNum][i] = new OBJ_Seaweed(gp);
		gp.obj[mapNum][i].worldX = 16 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 8 * gp.tileSize + 15;
		i++;	
		gp.obj[mapNum][i] = new OBJ_Seaweed(gp);
		gp.obj[mapNum][i].worldX = 3 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 8 * gp.tileSize + 14;
		i++;
		gp.obj[mapNum][i] = new OBJ_Seaweed(gp);
		gp.obj[mapNum][i].worldX = 2 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 8 * gp.tileSize -10;
		i++;
		gp.obj[mapNum][i] = new OBJ_Seaweed(gp);
		gp.obj[mapNum][i].worldX = 2 * gp.tileSize + 20;
		gp.obj[mapNum][i].worldY = 8 * gp.tileSize + 35;
		i++;
		gp.obj[mapNum][i] = new OBJ_Seaweed(gp);
		gp.obj[mapNum][i].worldX = 2 * gp.tileSize - 20;
		gp.obj[mapNum][i].worldY = 8 * gp.tileSize + 35;
		i++;
		gp.obj[mapNum][i] = new OBJ_Seaweed(gp);
		gp.obj[mapNum][i].worldX = 1 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 8 * gp.tileSize + 17;
		i++;
		gp.obj[mapNum][i] = new OBJ_Seaweed(gp);
		gp.obj[mapNum][i].worldX = 8 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 8 * gp.tileSize + 14;
		i++;
		gp.obj[mapNum][i] = new OBJ_Seaweed(gp);
		gp.obj[mapNum][i].worldX = 8 * gp.tileSize + 20;
		gp.obj[mapNum][i].worldY = 8 * gp.tileSize + 35;
		i++;
		gp.obj[mapNum][i] = new OBJ_Seaweed(gp);
		gp.obj[mapNum][i].worldX = 8 * gp.tileSize - 20;
		gp.obj[mapNum][i].worldY = 8 * gp.tileSize + 35;
		i++;
		gp.obj[mapNum][i] = new OBJ_Seaweed(gp);
		gp.obj[mapNum][i].worldX = 8 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 8 * gp.tileSize + 17;
		i++;
		gp.obj[mapNum][i] = new OBJ_Seaweed(gp);
		gp.obj[mapNum][i].worldX = 6 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 8 * gp.tileSize + 15;
		i++;
		gp.obj[mapNum][i] = new OBJ_Seaweed(gp);
		gp.obj[mapNum][i].worldX = 9 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 8 * gp.tileSize + 14;
		i++;
		gp.obj[mapNum][i] = new OBJ_Seaweed(gp);
		gp.obj[mapNum][i].worldX = 1 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 18 * gp.tileSize + 35;
		i++;
		gp.obj[mapNum][i] = new OBJ_Seaweed(gp);
		gp.obj[mapNum][i].worldX = 23 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 18 * gp.tileSize + 14;
		i++;
		gp.obj[mapNum][i] = new OBJ_Seaweed(gp);
		gp.obj[mapNum][i].worldX = 26 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 18 * gp.tileSize + 14;
		i++;
		gp.obj[mapNum][i] = new OBJ_Starfish_Wall(gp, "right");
		gp.obj[mapNum][i].worldX = 20 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 3 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Starfish_Wall(gp, "right");
		gp.obj[mapNum][i].worldX = 20 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 8 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Starfish_Wall(gp, "right");
		gp.obj[mapNum][i].worldX = 20 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 17 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Starfish_Wall(gp, "left");
		gp.obj[mapNum][i].worldX = 24 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 4 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Starfish_Wall(gp, "left");
		gp.obj[mapNum][i].worldX = 24 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 11 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Starfish_Wall(gp, "left");
		gp.obj[mapNum][i].worldX = 24 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 16 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Starfish_Wall(gp, "right");
		gp.obj[mapNum][i].worldX = 25 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 6 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Starfish_Wall(gp, "left");
		gp.obj[mapNum][i].worldX = 29 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 1 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Starfish_Wall(gp, "left");
		gp.obj[mapNum][i].worldX = 29 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 11 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Starfish_Wall(gp, "left");
		gp.obj[mapNum][i].worldX = 29 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 15 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Weapon_Laser(gp);
		gp.obj[mapNum][i].worldX = 17 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 17 * gp.tileSize;
		i++;

		
//		
//		gp.obj[1] = new OBJ_Golden_Jig(gp);
//		gp.obj[1].worldX = 5 * gp.tileSize;
//		gp.obj[1].worldY = 10 * gp.tileSize;
		
//		gp.obj[2] = new OBJ_Door(gp);
//		gp.obj[2].worldX = 6 * gp.tileSize;
//		gp.obj[2].worldY = 10 * gp.tileSize;
		
//		gp.obj[3] = new OBJ_Chest(gp);
//		gp.obj[3].worldX = 8 * gp.tileSize;
//		gp.obj[3].worldY = 10 * gp.tileSize;
		
//		gp.obj[4] = new OBJ_Boots(gp);
//		gp.obj[4].worldX = 12 * gp.tileSize;
//		gp.obj[4].worldY = 12 * gp.tileSize;
		objectIndex = i;
		
	}
	public void setNPC() {
		int mapNum = 0;
		 gp.npc[mapNum][0] = new NPC_Crab_1(gp);
		 gp.npc[mapNum][0].worldX = gp.tileSize*38;
		 gp.npc[mapNum][0].worldY = gp.tileSize*20+15;
		 mapNum++;
		 gp.npc[mapNum][0] = new NPC_Jellyfish_1(gp);
		 gp.npc[mapNum][0].worldX = gp.tileSize*10;
		 gp.npc[mapNum][0].worldY = gp.tileSize*9;
		 gp.npc[mapNum][1] = new NPC_Rock_1(gp);
		 gp.npc[mapNum][1].worldX = 13 * gp.tileSize + (gp.tileSize/2);
		 gp.npc[mapNum][1].worldY = 8 * gp.tileSize;
		 gp.npc[mapNum][1].originalWorldX = gp.npc[mapNum][1].worldX;
		 gp.npc[mapNum][1].originalWorldY = gp.npc[mapNum][1].worldY;
		 gp.npc[mapNum][2] = new NPC_Rock_1(gp);
		 gp.npc[mapNum][2].worldX = 24 * gp.tileSize;
		 gp.npc[mapNum][2].worldY = 19 * gp.tileSize;
		 gp.npc[mapNum][2].originalWorldX = gp.npc[mapNum][2].worldX;
		 gp.npc[mapNum][2].originalWorldY = gp.npc[mapNum][2].worldY;
		 gp.npc[mapNum][3] = new NPC_Rock_1(gp);
		 gp.npc[mapNum][3].worldX = 62 * gp.tileSize;
		 gp.npc[mapNum][3].worldY = 19 * gp.tileSize;
		 gp.npc[mapNum][3].originalWorldX = gp.npc[mapNum][3].worldX;
		 gp.npc[mapNum][3].originalWorldY = gp.npc[mapNum][3].worldY;
		 mapNum++;
		 gp.npc[mapNum][0] = new NPC_Crab_1(gp);
		 gp.npc[mapNum][0].worldX = gp.tileSize*16;
		 gp.npc[mapNum][0].worldY = gp.tileSize*3+15;
//		 
		 gp.npc[mapNum][1] = new NPC_Jellyfish_1(gp);
		 gp.npc[mapNum][1].worldX = gp.tileSize*10;
		 gp.npc[mapNum][1].worldY = gp.tileSize*8;

	}
	public void setMonster() {
		int mapNum = 0;
		int i = monsterIndex;
		mapNum++;
		gp.monster[mapNum][i] = new MON_Starfish_Wall(gp, "orange");
		gp.monster[mapNum][i].worldX = gp.tileSize*13;
		gp.monster[mapNum][i].worldY = gp.tileSize*18;
		i++;
		gp.monster[mapNum][i] = new MON_Starfish_Wall(gp, "orange");
		gp.monster[mapNum][i].worldX = gp.tileSize*13;
		gp.monster[mapNum][i].worldY = gp.tileSize*19;
		i++;
		gp.monster[mapNum][i] = new MON_Starfish_Wall(gp, "orange");
		gp.monster[mapNum][i].worldX = gp.tileSize*13;
		gp.monster[mapNum][i].worldY = gp.tileSize*20;
		i++;
		
		gp.monster[mapNum][i] = new MON_Starfish_Wall(gp, "purple");
		gp.monster[mapNum][i].worldX = gp.tileSize*47;
		gp.monster[mapNum][i].worldY = gp.tileSize*18;
		i++;
		gp.monster[mapNum][i] = new MON_Starfish_Wall(gp, "purple");
		gp.monster[mapNum][i].worldX = gp.tileSize*47;
		gp.monster[mapNum][i].worldY = gp.tileSize*19;
		i++;
		gp.monster[mapNum][i] = new MON_Starfish_Wall(gp, "purple");
		gp.monster[mapNum][i].worldX = gp.tileSize*47;
		gp.monster[mapNum][i].worldY = gp.tileSize*20;
		i++;
		gp.monster[mapNum][i] = new MON_Starfish_Wall(gp, "yellow");
		gp.monster[mapNum][i].worldX = gp.tileSize*55;
		gp.monster[mapNum][i].worldY = gp.tileSize*38;
		i++;
		gp.monster[mapNum][i] = new MON_Starfish_Wall(gp, "yellow");
		gp.monster[mapNum][i].worldX = gp.tileSize*55;
		gp.monster[mapNum][i].worldY = gp.tileSize*41;
		i++;
		gp.monster[mapNum][i] = new MON_Starfish_Wall(gp, "yellow");
		gp.monster[mapNum][i].worldX = gp.tileSize*55;
		gp.monster[mapNum][i].worldY = gp.tileSize*40;
		i++;
		gp.monster[mapNum][i] = new MON_Starfish_Wall(gp, "yellow");
		gp.monster[mapNum][i].worldX = gp.tileSize*55;
		gp.monster[mapNum][i].worldY = gp.tileSize*39;
		i++;
		gp.monster[mapNum][i] = new MON_Jellyfish_2(gp, "down");
		gp.monster[mapNum][i].worldX = gp.tileSize*14;
		gp.monster[mapNum][i].worldY = gp.tileSize*39;
		i++;
		gp.monster[mapNum][i] = new MON_Jellyfish_1(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*(16);
		gp.monster[mapNum][i].worldY = gp.tileSize*(41);
		i++;
		gp.monster[mapNum][i] = new MON_Jellyfish_2(gp, "up");
		gp.monster[mapNum][i].worldX = gp.tileSize*18;
		gp.monster[mapNum][i].worldY = gp.tileSize*39;
		i++;
		gp.monster[mapNum][i] = new MON_Jellyfish_1(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*(20);
		gp.monster[mapNum][i].worldY = gp.tileSize*(39);
		i++;
		gp.monster[mapNum][i] = new MON_Jellyfish_2(gp, "down");
		gp.monster[mapNum][i].worldX = gp.tileSize*22;
		gp.monster[mapNum][i].worldY = gp.tileSize*39;
		i++;
		gp.monster[mapNum][i] = new MON_Jellyfish_1(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*(24);
		gp.monster[mapNum][i].worldY = gp.tileSize*(41);
		i++;
		gp.monster[mapNum][i] = new MON_Jellyfish_2(gp, "up");
		gp.monster[mapNum][i].worldX = gp.tileSize*26;
		gp.monster[mapNum][i].worldY = gp.tileSize*39;
		i++;
		mapNum++;


		gp.monster[mapNum][i] = new MON_Crab(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*27;
		gp.monster[mapNum][i].worldY = gp.tileSize*9;
		i++;
		gp.monster[mapNum][i] = new MON_Crab(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*27;
		gp.monster[mapNum][i].worldY = gp.tileSize*14;
		i++;
		gp.monster[mapNum][i] = new MON_Crab(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*27;
		gp.monster[mapNum][i].worldY = gp.tileSize*4;
		i++;
		gp.monster[mapNum][i] = new MON_Crab(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*27;
		gp.monster[mapNum][i].worldY = gp.tileSize*7;
		i++;
		gp.monster[mapNum][i] = new MON_Crab(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*27;
		gp.monster[mapNum][i].worldY = gp.tileSize*16;
		i++;
		gp.monster[mapNum][i] = new MON_Crab(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*27;
		gp.monster[mapNum][i].worldY = gp.tileSize*12;
		i++;
		gp.monster[mapNum][i] = new MON_Crab_2(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*7;
		gp.monster[mapNum][i].worldY = gp.tileSize*8+20;
		i++;
		gp.monster[mapNum][i] = new MON_Crab_2(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*11;
		gp.monster[mapNum][i].worldY = gp.tileSize*8+20;
		i++;
	
		gp.monster[mapNum][i] = new MON_Jellyfish_2(gp, "down");
		gp.monster[mapNum][i].worldX = gp.tileSize*11;
		gp.monster[mapNum][i].worldY = gp.tileSize*(1);
		i++;
		
		gp.monster[mapNum][i] = new MON_Jellyfish_1(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*(21);
		gp.monster[mapNum][i].worldY = gp.tileSize*(14);
		i++;
		gp.monster[mapNum][i] = new MON_Jellyfish_1(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*(22);
		gp.monster[mapNum][i].worldY = gp.tileSize*(10);
		i++;
		gp.monster[mapNum][i] = new MON_Jellyfish_2(gp, "down");
		gp.monster[mapNum][i].worldX = gp.tileSize*(23);
		gp.monster[mapNum][i].worldY = gp.tileSize*(1);
		i++;
		gp.monster[mapNum][i] = new MON_Jellyfish_2(gp, "up");
		gp.monster[mapNum][i].worldX = gp.tileSize*(21);
		gp.monster[mapNum][i].worldY = gp.tileSize*(4);
		i++;
		gp.monster[mapNum][i] = new MON_Jellyfish_1(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*(23);
		gp.monster[mapNum][i].worldY = gp.tileSize*(5);
		i++;
		gp.monster[mapNum][i] = new MON_Jellyfish_1(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*(22);
		gp.monster[mapNum][i].worldY = gp.tileSize*(3);
		i++;
		gp.monster[mapNum][i] = new MON_Jellyfish_1(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*(21);
		gp.monster[mapNum][i].worldY = gp.tileSize*(6);
		i++;
		
		gp.monster[mapNum][i] = new MON_Jellyfish_2(gp, "up");
		gp.monster[mapNum][i].worldX = gp.tileSize*9;
		gp.monster[mapNum][i].worldY = gp.tileSize*(3);
		i++;
		
		gp.monster[mapNum][i] = new MON_Jellyfish_1(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*7;
		gp.monster[mapNum][i].worldY = gp.tileSize*(1);
		i++;
		
		gp.monster[mapNum][i] = new MON_Jellyfish_2(gp, "down");
		gp.monster[mapNum][i].worldX = gp.tileSize*5;
		gp.monster[mapNum][i].worldY = gp.tileSize*(1);
		i++;

//		gp.monster[mapNum][i] = new MON_Jellyfish_2(gp);
//		gp.monster[mapNum][i].worldX = gp.tileSize*34;
//		gp.monster[mapNum][i].worldY = gp.tileSize*(2);
//		i++;
//		gp.monster[mapNum][i] = new MON_Fluke(gp);
//		gp.monster[mapNum][i].worldX = gp.tileSize*1;
//		gp.monster[mapNum][i].worldY = (gp.tileSize*18)+20;
//		i++;
//		gp.monster[mapNum][i] = new MON_Fluke(gp);
//		gp.monster[mapNum][i].worldX = gp.tileSize*26;
//		gp.monster[mapNum][i].worldY = (gp.tileSize*18)+20;
//		i++;
//		gp.monster[mapNum][i] = new MON_Fluke(gp);
//		gp.monster[mapNum][i].worldX = gp.tileSize*13;
//		gp.monster[mapNum][i].worldY = (gp.tileSize*18)+20;
//		i++;
//		gp.monster[mapNum][i] = new MON_Starfish_1(gp);
//		gp.monster[mapNum][i].worldX = gp.tileSize*2;
//		gp.monster[mapNum][i].worldY = gp.tileSize*(2);
//		i++;
//		gp.monster[mapNum][i] = new MON_Starfish_1(gp);
//		gp.monster[mapNum][i].worldX = gp.tileSize*15;
//		gp.monster[mapNum][i].worldY = gp.tileSize*(6);
//		i++;
//		gp.monster[mapNum][i] = new MON_Starfish_1(gp);
//		gp.monster[mapNum][i].worldX = gp.tileSize*15;
//		gp.monster[mapNum][i].worldY = gp.tileSize*(7);
//		i++;
//		gp.monster[mapNum][i] = new MON_Starfish_1(gp);
//		gp.monster[mapNum][i].worldX = gp.tileSize*15;
//		gp.monster[mapNum][i].worldY = gp.tileSize*(8);
//		i++;
//		gp.monster[mapNum][i] = new MON_Starfish_1(gp);
//		gp.monster[mapNum][i].worldX = gp.tileSize*22;
//		gp.monster[mapNum][i].worldY = gp.tileSize*(15);
//		i++;
		monsterIndex = i;

	}

	public void setFirstLevelTrap() {
		int mapNum = 0;
		mapNum++;
		mapNum++;


		int i = objectIndex;
		gp.obj[mapNum][i] = new OBJ_Trap_Wall(gp);
		gp.obj[mapNum][i].worldX = gp.tileSize*2;
		gp.obj[mapNum][i].worldY = gp.tileSize*(15);
		i++;
		objectIndex = i;
	}
	public void setFirstLevelTrapMonsters() {
		int mapNum = 0;
		mapNum++;
		mapNum++;

		int i = monsterIndex;
		gp.monster[mapNum][i] = new MON_Fluke(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*1;
		gp.monster[mapNum][i].worldY = (gp.tileSize*18)+20;
		gp.monster[mapNum][i].trapMonster = true;
		i++;
		gp.monster[mapNum][i] = new MON_Fluke(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*26;
		gp.monster[mapNum][i].worldY = (gp.tileSize*18)+20;
		gp.monster[mapNum][i].trapMonster = true;
		i++;
		gp.monster[mapNum][i] = new MON_Crab(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*8;
		gp.monster[mapNum][i].worldY = gp.tileSize*18;
		gp.monster[mapNum][i].trapMonster = true;
		i++;
		gp.monster[mapNum][i] = new MON_Crab(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*10;
		gp.monster[mapNum][i].worldY = gp.tileSize*18;
		gp.monster[mapNum][i].trapMonster = true;
		i++;
		gp.monster[mapNum][i] = new MON_Crab(gp);
		gp.monster[mapNum][i].worldX = gp.tileSize*12;
		gp.monster[mapNum][i].worldY = gp.tileSize*18;
		gp.monster[mapNum][i].trapMonster = true;
		i++;
		monsterIndex = i;
	}

	public void setDoor(int mapNum) {
		if(contains(gp.obj[0],"Door") == false){
			int i = objectIndex;
			gp.obj[0][i] = new OBJ_Door(gp);
			gp.obj[0][i].worldX = gp.tileSize*18;
			gp.obj[0][i].worldY = gp.tileSize*1;
			i++;
			objectIndex = i;	
		}
	}
	
	public void setGoldenJig(int mapNum) {
		if(contains(gp.obj[0],"Golden Jig") == false){
			int i = objectIndex;
			gp.obj[0][i] = new OBJ_Golden_Jig(gp);
			gp.obj[0][i].worldX = gp.tileSize*18;
			gp.obj[0][i].worldY = gp.tileSize*1;
			i++;
			objectIndex = i;	
		}
	}
	
	
	public boolean contains(Entity stuff[], String objectName) {
		for(int i = 0; i < stuff.length; i++) {
			if(stuff[i] != null) {
				if(stuff[i].name == objectName) {
					return true;
				}
			}

		}
		return false;
	}

	public void addProjectile(int worldX, int worldY, String direction, boolean alive, Entity user) {
		int i = projectileIndex;
		OBJ_Bubble_Shoot b = new OBJ_Bubble_Shoot(gp);
		b.set(worldX, worldY,  direction, alive, user);
		gp.projectileList.add(b);

		
//		gp.projectileList.get(i).set(worldX, worldY,  direction, alive, user);
//		
//		gp.projectileList.add(new OBJ_Bubble_Shoot(gp));
//		if(gp.player.facingDirectoin == "left") {
//			gp.projectileList.get(i).worldX = worldX-15;
//		}
//		else if(gp.player.facingDirectoin == "right") {
//			gp.projectileList.get(i).worldX = worldX+50;
//		}
//		gp.projectileList.get(i).worldY = gp.player.worldY+11;
//		gp.projectileList.get(i).direction = direction;
//		gp.projectileList.get(i).alive = true;
//		gp.projectileList.get(i).user = user;
//		gp.projectileList.get(i).currentLife = gp.projectileList.get(i).maxLife;
		
		
		i++;
		projectileIndex = i;
	}
}
