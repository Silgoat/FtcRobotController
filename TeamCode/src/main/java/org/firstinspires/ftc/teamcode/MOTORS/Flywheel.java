package org.firstinspires.ftc.teamcode.MOTORS;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

@SuppressWarnings("unused")
public class Flywheel {
    private DcMotorEx motor;

    public static final double TICKS_PER_REV = 28.0;

    public void init(HardwareMap hardwareMap) {
        motor = hardwareMap.get(DcMotorEx.class, "flywheel");
        motor.setDirection(DcMotor.Direction.FORWARD); // flip to REVERSE if it spins backwards
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    /** 100% full raw power for maximum speed. */
    public void runMax() {
        if (motor != null) {
            motor.setPower(1.0);
        }
    }

    public void stop() {
        if (motor != null) {
            motor.setPower(0);
        }
    }

    /** Returns actual measured RPM using encoder velocity. */
    public double getRPM() {
        if (motor != null) {
            return motor.getVelocity() * 60.0 / TICKS_PER_REV;
        }
        return 0.0;
    }
}
