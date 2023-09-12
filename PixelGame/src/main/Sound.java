package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

	Clip clip;
	URL soundURL[] = new URL[30];
	
	public Sound() {
		
		soundURL[0] = getClass().getResource("/sound/background_firstLevel_v2.wav");
		soundURL[1] = getClass().getResource("/sound/beepbeep.wav");
		soundURL[2] = getClass().getResource("/sound/blingbling.wav");
		soundURL[3] = getClass().getResource("/sound/damage_2.wav");
		soundURL[4] = getClass().getResource("/sound/click.wav");
		soundURL[5] = getClass().getResource("/sound/laser.wav");
		soundURL[6] = getClass().getResource("/sound/golden_jig.wav");
		soundURL[7] = getClass().getResource("/sound/danger (1).wav");
		soundURL[8] = getClass().getResource("/sound/drink.wav");
		soundURL[9] = getClass().getResource("/sound/bubble_shoot.wav");
		soundURL[10] = getClass().getResource("/sound/jellyDamage1.wav");
		soundURL[11] = getClass().getResource("/sound/jellyDamage2.wav");
		soundURL[12] = getClass().getResource("/sound/greenCrabDamage.wav");
		soundURL[13] = getClass().getResource("/sound/speak.wav");
		soundURL[14] = getClass().getResource("/sound/bubble_shoot2.wav");
		soundURL[15] = getClass().getResource("/sound/bubble_shoot3.wav");
		soundURL[16] = getClass().getResource("/sound/bubble_shoot4.wav");
		soundURL[17] = getClass().getResource("/sound/buttonPress.wav");
	}
	
	public void setFile(int i) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
		} catch(Exception e) {
		}
	}
	
	public void play() {
		clip.start();
	}
	
	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);

	}
	
	public void stop() {
		clip.stop();
	}
}
