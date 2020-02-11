import lejos.hardware.Sound;
import lejos.hardware.motor.Motor;
import lejos.utility.Delay;

//Class that makes the Robot move
public class MovementController {

	// Method which makes the robot move forward
	protected static void movingForward() {
		Motor.A.setSpeed(100);
		Motor.B.setSpeed(100);
		Motor.A.forward();
		Motor.B.forward();
	}

	// Method which stops the robot
	protected static void stopMoving() {
		Motor.B.stop();
		Motor.A.stop();
	}

	// rotate for shot
	private static void chargeTheShoot() {
		Motor.B.rotate(330);
	}

	// Shooting

	private static void shoot() {
		Motor.A.setSpeed(2000);
		Motor.B.setSpeed(2000);

		Motor.A.rotate(600);
	}

	// The shooting movements all together
	public static void shootingMovement() {
		MovementController.chargeTheShoot();
		MovementController.shoot();
	}

	// Making the robot move or stop based on the color detected
	public static void movingByColor(String colorDetected) {
		// The WHITE and BLUE are included since the color detector does not always work
		// properly with the type of paper we have
		if (colorDetected == "WHITE") {
			LedController.ledGreen();
			MovementController.movingForward();

		} else if (colorDetected == "BLUE") {
			LedController.ledGreen();
			MovementController.movingForward();
		}
		// If the color is red the robot will stop moving
		else if (colorDetected == "RED") {
			LedController.ledRed();
			MovementController.stopMoving();
		}
		// If the color line is green the robot will rotate to the right
		else if (colorDetected == "GREEN") {
			LedController.ledRed();
			MovementController.stopMoving();
			Motor.B.rotate(30);
			// If the color detected is black the robot will rotate to the left
		} else if (colorDetected == "BLACK") {
			LedController.ledRed();
			MovementController.stopMoving();
			Motor.A.rotate(30);
		}
	}
}
