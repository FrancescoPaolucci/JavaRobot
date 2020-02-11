import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

//Class to use the ultrasonic sensor
public class UltrasonicSensor {

	// Giving the port number to the robot
	private static EV3UltrasonicSensor us2 = new EV3UltrasonicSensor(SensorPort.S2);

	float distanceValue = 0;

//calling the method for detecting distance
	public static void ultraSonicDetection(float distanceValue) {
		final SampleProvider sp = us2.getDistanceMode();

		final int iteration_threshold = 100;

		// Infinitive for loop which will break after the first time an object will be
		// detected
		for (int i = 0; i <= iteration_threshold; i++) {

			float[] sample = new float[sp.sampleSize()];
			sp.fetchSample(sample, 0);
			distanceValue = (float) sample[0];
			MovementController.movingForward();

			// If the object is closer than 30cm it will be detected
			if (distanceValue <= 0.3) {
				MovementController.stopMoving();
				Motor.B.rotate(360);
				MovementController.movingForward();
				Delay.msDelay(3000);
				break;
			}

			Delay.msDelay(800);
		}

	}

}