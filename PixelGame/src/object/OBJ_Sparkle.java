package object;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_Sparkle extends Entity {
	
	GamePanel gp;
		
	public OBJ_Sparkle(GamePanel gp) {
		super(gp);
		this.gp = gp;
		name = "Sparkle";
		down1 = setup("/objects/sparkle1", gp.tileSize, gp.tileSize);
		right1 = setup("/objects/sparkle2", gp.tileSize, gp.tileSize);
		description = "["+name+"]\nLegend has it\nthese hold great\npower, do they\nstill work?";
		getImage();

	}
	private void getImage() {
		frame1 = setup("/objects/sparkle1", gp.tileSize*2, gp.tileSize*2);
		frame2 = setup("/objects/sparkle2", gp.tileSize*2, gp.tileSize*2);
		frame3 = setup("/objects/sparkle3", gp.tileSize*2, gp.tileSize*2);
		frame4 = setup("/objects/sparkle4", gp.tileSize*2, gp.tileSize*2);
		frame5 = setup("/objects/sparkle5", gp.tileSize*2, gp.tileSize*2);
		frame6 = setup("/objects/sparkle6", gp.tileSize*2, gp.tileSize*2);
		frame7 = setup("/objects/sparkle7", gp.tileSize*2, gp.tileSize*2);
		frame8 = setup("/objects/sparkle8", gp.tileSize*2, gp.tileSize*2);
	}
	
	public BufferedImage getSparkleImage() {
		spriteCounter++;
		if(spriteCounter <= 20) {
			return frame1;	
		}
		if(spriteCounter > 20 && spriteCounter <= 40 ) {
			return frame2;	
		}
		if(spriteCounter > 40 && spriteCounter <= 60 ) {
			return frame3;	
		}
		if(spriteCounter > 60 && spriteCounter <= 80 ) {
			return frame4;	
		}
		if(spriteCounter > 80 && spriteCounter <= 120 ) {
			return frame5;	
		}
		if(spriteCounter > 120 && spriteCounter <= 140 ) {
			return frame6;	
		}
		if(spriteCounter > 140 && spriteCounter <= 160 ) {
			return frame7;	
		}
		if(spriteCounter > 160 && spriteCounter <= 180 ) {
			return frame8;	
		}
		if (spriteCounter > 180) {
			spriteCounter = 0;
		}
		return frame8;	

	}
	
}
