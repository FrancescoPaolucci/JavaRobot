import lejos.hardware.Sound;

//Different types of sound which will be called during catwalk
public class SoundController {
	public static void buttonSound() {
		Sound.playNote(Sound.PIANO, 500, 1000);
	}

	public static void finalSound() {
		Sound.playNote(Sound.PIANO, 1000, 1000);
	}

}
