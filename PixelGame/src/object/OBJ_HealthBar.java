package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_HealthBar extends Entity {
	
	
	public OBJ_HealthBar(GamePanel gp) {
		super(gp);
		
		name = "HealthBar";
		image = setup("/objects/health_full", gp.tileSize, gp.tileSize);
		image2 = setup("/objects/health_half", gp.tileSize, gp.tileSize);
		image3 = setup("/objects/health_empty", gp.tileSize, gp.tileSize);
	}

}
