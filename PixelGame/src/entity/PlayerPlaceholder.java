package entity;

import main.GamePanel;

public class PlayerPlaceholder extends Entity {
	
	public static final String npcName = "Placeholder";

	public PlayerPlaceholder(GamePanel gp) {
		super(gp);
		// TODO Auto-generated constructor stub
		name = npcName;
		type = type_placeholder;
		getImage();
	}
	public void getImage() {
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
