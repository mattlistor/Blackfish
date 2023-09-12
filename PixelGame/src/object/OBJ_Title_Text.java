package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_Title_Text extends Entity {
	
	GamePanel gp;
		
	public OBJ_Title_Text(GamePanel gp) {
		
		super(gp);
		this.gp = gp;
		name = "Title Text";

		getImage();
	}
	private void getImage() {
		frame1 = setup("/title_text/title_text1", gp.tileSize*8, gp.tileSize*1);
		frame2 = setup("/title_text/title_text2", gp.tileSize*8, gp.tileSize*1);
		frame3 = setup("/title_text/title_text3", gp.tileSize*8, gp.tileSize*1);
		frame4 = setup("/title_text/title_text4", gp.tileSize*8, gp.tileSize*1);
		frame5 = setup("/title_text/title_text5", gp.tileSize*8, gp.tileSize*1);
		frame6 = setup("/title_text/title_text6", gp.tileSize*8, gp.tileSize*1);
		frame7 = setup("/title_text/title_text7", gp.tileSize*8, gp.tileSize*1);
		frame8 = setup("/title_text/title_text8", gp.tileSize*8, gp.tileSize*1);
	}
	public void spriteNumAndMovementHandler() {
		spriteCounter++;
		if(spriteCounter <= 10) {
			spriteNum = 1;	
		}
		if(spriteCounter > 10 && spriteCounter <= 20 ) {
			spriteNum = 2;
		}
		if(spriteCounter > 40 && spriteCounter <= 50) {
			spriteNum = 3;	
		}
		if(spriteCounter > 50 && spriteCounter <= 55 ) {
			spriteNum = 4;	
		}
		if(spriteCounter > 55 && spriteCounter <= 60 ) {
			spriteNum = 5;	
		}
		if(spriteCounter > 60 && spriteCounter <= 65 ) {
			spriteNum = 6;	
		}
		if(spriteCounter > 65 && spriteCounter <= 70 ) {
			spriteNum = 7;	
		}
		if(spriteCounter > 70 && spriteCounter <= 160 ) {
			spriteNum = 8;	
		}
		if (spriteCounter > 160) {
			spriteCounter = 0;
		}
	}
}
