package org.firstinspires.ftc.teamcode.MOTORS;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

@SuppressWarnings("unused")
public class IntakeMotor {

    // ====================================================================
    // INTAKE SPEED CONFIGURATION
    // Change this value directly to adjust your intake motor speed in code:
    //   -1.0 = 100% Max Speed (Full Intake)
    //   -0.8 = 80% Speed
    //   -0.5 = 50% Speed
    //    0.0 = Stopped
    //   +1.0 = Full Speed Reverse (Eject)
    // ====================================================================
    public static double INTAKE_SPEED = -1.0;

    // Encoder ticks per revolution (e.g. 28.0 for 1:1 goBILDA 6000 RPM, 288.0 for REV Core Hex)
    private static final double TICKS_PER_REV = 28.0;

    private DcMotorEx intakeMotor;
    private boolean intakeOn = false;

    /**
     * Initializes the intake motor.
     */
    public void init(HardwareMap hwMap) {
        // "intake" must match the motor name in your Robot Configuration
        intakeMotor = hwMap.get(DcMotorEx.class, "intake");
        intakeMotor.setDirection(DcMotor.Direction.FORWARD);
        
        // Use RUN_WITHOUT_ENCODER for maximum direct power control
        intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    /**
     * Toggles the intake motor on or off using the INTAKE_SPEED set above.
     */
    public void toggleIntakeMotor() {
        intakeOn = !intakeOn;
        if (intakeMotor != null) {
            intakeMotor.setPower(intakeOn ? INTAKE_SPEED : 0.0);
        }
    }

    /**
     * Explicitly turns the intake on or off.
     */
    public void setIntakeOn(boolean on) {
        intakeOn = on;
        if (intakeMotor != null) {
            intakeMotor.setPower(intakeOn ? INTAKE_SPEED : 0.0);
        }
    }

    /**
     * Adjust or set speed programmatically in code (-1.0 to 1.0).
     */
    public void setSpeed(double speed) {
        INTAKE_SPEED = speed;
        if (intakeOn && intakeMotor != null) {
            intakeMotor.setPower(INTAKE_SPEED);
        }
    }

    /**
     * Returns the configured intake speed setting.
     */
    public double getSpeed() {
        return INTAKE_SPEED;
    }

    /**
     * Sets custom motor power directly (-1.0 to 1.0).
     */
    public void setPower(double power) {
        intakeOn = (power != 0.0);
        if (intakeMotor != null) {
            intakeMotor.setPower(power);
        }
    }

    public boolean isIntakeOn() {
        return intakeOn;
    }

    /**
     * Returns actual estimated RPM from encoder velocity.
     */
    public double getActualRpm() {
        if (intakeMotor != null) {
            return intakeMotor.getVelocity() / TICKS_PER_REV * 60.0;
        }
        return 0.0;
    }

    /**
     * Returns motor current draw in Amps.
     */
    public double getCurrentAmps() {
        if (intakeMotor != null) {
            return intakeMotor.getCurrent(CurrentUnit.AMPS);
        }
        return 0.0;
    }
}
