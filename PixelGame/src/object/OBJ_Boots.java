
package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_Boots extends Entity {

	
	public OBJ_Boots(GamePanel gp) {
		super(gp);
		type = 3;
		name = "Boots";
		right1 = setup("/objects/boots", gp.tileSize, gp.tileSize);
	}
}
