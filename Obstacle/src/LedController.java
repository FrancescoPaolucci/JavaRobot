import lejos.hardware.Button;

//Class used to define the color of the led
public class LedController {
	// Method for the green strobo led
	protected static void ledGreen() {
		Button.LEDPattern(1);
	}

	// Method for the static red led
	protected static void ledRed() {
		Button.LEDPattern(5);
	}

}
