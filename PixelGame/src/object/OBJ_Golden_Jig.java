package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_Golden_Jig extends Entity {
	
	GamePanel gp;
		
	public OBJ_Golden_Jig(GamePanel gp) {
		super(gp);
		this.gp = gp;
		type = type_golden_jig;
		name = "Golden Jig";
		down1 = setup("/objects/golden_jig", gp.tileSize, gp.tileSize);
		right1 = setup("/objects/golden_jig", gp.tileSize, gp.tileSize);
		description = "["+name+"]\nLegend has it\nthese hold great\npower, do they\nstill work?";
		getImage();

	}
	private void getImage() {
		frame1 = setup("/objects/golden_jig1", gp.tileSize, gp.tileSize);
		frame2 = setup("/objects/golden_jig2", gp.tileSize, gp.tileSize);
		frame3 = setup("/objects/golden_jig3", gp.tileSize, gp.tileSize);
		frame4 = setup("/objects/golden_jig4", gp.tileSize, gp.tileSize);
		frame5 = setup("/objects/golden_jig5", gp.tileSize, gp.tileSize);
		frame6 = setup("/objects/golden_jig6", gp.tileSize, gp.tileSize);
		frame7 = setup("/objects/golden_jig7", gp.tileSize, gp.tileSize);
		frame8 = setup("/objects/golden_jig8", gp.tileSize, gp.tileSize);
	}
	public void spriteNumAndMovementHandler() {
		spriteCounter++;
		if(spriteCounter <= 10) {
			spriteNum = 1;	
		}
		if(spriteCounter > 10 && spriteCounter <= 20 ) {
			spriteNum = 2;
		}
		if(spriteCounter > 20 && spriteCounter <= 30 ) {
			spriteNum = 3;	
		}
		if(spriteCounter > 30 && spriteCounter <= 40 ) {
			spriteNum = 4;	
		}
		if(spriteCounter > 40 && spriteCounter <= 50 ) {
			spriteNum = 5;	
		}
		if(spriteCounter > 50 && spriteCounter <= 60 ) {
			spriteNum = 6;	
		}
		if(spriteCounter > 60 && spriteCounter <= 70 ) {
			spriteNum = 7;	
		}
		if(spriteCounter > 70 && spriteCounter <= 80 ) {
			spriteNum = 8;	
		}
		if (spriteCounter > 80) {
			spriteCounter = 0;
		}
	}
}
