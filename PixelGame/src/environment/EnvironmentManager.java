package environment;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class EnvironmentManager {
	
	GamePanel gp;
	Lighting lighting;
	Lighting npcLighting[] = new Lighting[100];
	
	public EnvironmentManager(GamePanel gp) {
		this.gp = gp;
				
	}
	public void setUp() {
		lighting = new Lighting(gp, 1200);
		for(int i = 0; i < gp.npc.length; i++) {
			if(gp.npc[i] != null) {
//				npcLighting[i] = new Lighting(gp, 600, (gp.npc[i].worldX - gp.player.worldX + gp.player.screenX), (gp.npc[i].worldX - gp.player.worldX + gp.player.screenX), gp.npc[i]);

			}
		}
		
	}
	public void draw(Graphics2D g2) {
		if(lighting != null) {
			lighting.draw(g2);
		}
		for(int i = 0; i < npcLighting.length; i++) {
			if(npcLighting[i] != null) {
//				npcLighting[i].draw(g2);

			}
		}
	}
	
}
