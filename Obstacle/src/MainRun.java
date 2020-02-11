import java.rmi.RemoteException;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.Sounds;
import lejos.hardware.motor.Motor;
import lejos.remote.ev3.RMISampleProvider;
import lejos.remote.ev3.RemoteEV3;
import lejos.robotics.SampleProvider;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;
import lejos.utility.Delay;

public class MainRun {
	// static MovePilot pilot;

	public static void main(String[] args) {
		// Main class in which there is part of the color detection tool, since a try
		// catch and a finally which closes the port is needed
		RMISampleProvider sampleProvider = null;

		try {
			// Declaring the robot
			RemoteEV3 ev3 = new RemoteEV3("10.0.1.1");
			
			// Declaring the port the type of sensor and the type of detection
			sampleProvider = ev3.createSampleProvider("S1", "lejos.hardware.sensor.EV3ColorSensor", "RGB");
			
			// Creating an array which contains the RGB values
			float[] samples = new float[3];
			
			// Main while loop with all the calls inside
			while (Button.ESCAPE.isUp()) {
				// Assigning to the array the fetched color
				samples = sampleProvider.fetchSample();
				
				// Calling the classes and methods
				// The movement controller has as argument the color detected
				MovementController.movingByColor(ColorSelector.detectColor(samples));

			}
			
			//Playing the initial sound
			SoundController.buttonSound();
						
			//movements to destroy the castle
			MovementController.shootingMovement();
			
			//Giving time to start the ultrasonic
			Delay.msDelay(2000);
			
			//Starting the ultrasonic
			UltrasonicSensor.ultraSonicDetection(0);
			
			//Playing the final sound
			SoundController.finalSound();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Closing the port, this is VERY IMPORTANT!!
				sampleProvider.close();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}

}
