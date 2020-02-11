//This class gives the color ranges for the color detector
public class ColorSelector {
	// Initialising the color variable
	private static String colorDetected = "nulla";

	// Color ranges, obtained by calibration
	public static String detectColor(float[] samples) {

		if ((samples[0] > 0.005) && (samples[0] < 0.065) && (samples[1] > 0.005) && (samples[1] < 0.065)
				&& (samples[2] > 0.005) && (samples[2] < 0.065)) {
			colorDetected = "BLACK";

		} else if (samples[1] > samples[0] && samples[1] > samples[2]) {
			colorDetected = "GREEN";

		} else if (samples[2] > samples[0] && samples[2] > samples[1]) {
			colorDetected = "BLUE";

		} else if (samples[0] > samples[1] && samples[0] > samples[2]) {
			colorDetected = "RED";

		} else {
			colorDetected = "WHITE";
		}

		System.out.println(colorDetected);
		return colorDetected;

	}

}
