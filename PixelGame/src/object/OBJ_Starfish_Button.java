package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Starfish_Button extends Entity {

	public OBJ_Starfish_Button(GamePanel gp, String c) {
		super(gp);
		switch(c) {
		case("orange"): 
			down1 = setup("/objects/starfish_button_orange", gp.tileSize, gp.tileSize);
			right1 = setup("/objects/starfish_button_orange", gp.tileSize, gp.tileSize);
			break;
		case("purple"): 
			down1 = setup("/objects/starfish_button_purple", gp.tileSize, gp.tileSize);
			right1 = setup("/objects/starfish_button_purple", gp.tileSize, gp.tileSize);
			break;
		case("yellow"): 
			down1 = setup("/objects/starfish_button_yellow", gp.tileSize, gp.tileSize);
			right1 = setup("/objects/starfish_button_yellow", gp.tileSize, gp.tileSize);
			break;
		default:
			down1 = setup("/objects/starfish_button_orange", gp.tileSize, gp.tileSize);
			right1 = setup("/objects/starfish_button_orange", gp.tileSize, gp.tileSize);
			break;	
		}

		name = "Starfish Button";
		color = c;
		type = type_button;

		
		solidArea.x = gp.tileSize/2-gp.tileSize/12;
		solidArea.y = 0;
		solidArea.width = gp.tileSize/6;
		solidArea.height = gp.tileSize/4;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;		
	}

}
