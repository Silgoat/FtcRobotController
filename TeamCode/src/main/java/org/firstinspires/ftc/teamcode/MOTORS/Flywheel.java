package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Flywheel {
    private DcMotorEx motor;

    public static final double TICKS_PER_REV = 28.0;
    public static final double MAX_RPM = 6000.0;
    public static final double MAX_TICKS_PER_SEC = TICKS_PER_REV * MAX_RPM / 60.0; // 2800

    public void init(HardwareMap hardwareMap) {
        motor = hardwareMap.get(DcMotorEx.class, "flywheel");
        motor.setDirection(DcMotor.Direction.FORWARD); // flip to REVERSE if it spins backwards
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    /** Full power. With RUN_USING_ENCODER, this targets the motor's max velocity. */
    public void runMax() {
        motor.setPower(1.0);
    }

    /** Alternative: command max velocity directly in ticks/sec. */
    public void runMaxVelocity() {
        motor.setVelocity(MAX_TICKS_PER_SEC);
    }

    public void stop() {
        motor.setPower(0);
    }

    public double getRPM() {
        return motor.getVelocity() * 60.0 / TICKS_PER_REV;
    }
}