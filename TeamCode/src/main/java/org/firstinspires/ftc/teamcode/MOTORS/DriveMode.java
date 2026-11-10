package org.firstinspires.ftc.teamcode.MOTORS;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
@SuppressWarnings("unused")
public class DriveMode extends OpMode {
    private final MecanumDrive drive = new MecanumDrive();
    private final IntakeMotor goon = new IntakeMotor();
    private final Flywheel flywheel = new Flywheel();
    private final PollenServo pollenservo = new PollenServo();   // POLLEN

    private boolean lastA = false;
    private boolean flywheelOn = false;
    private boolean lastLeftBumper = false;

    @Override
    public void init() {
        drive.init(hardwareMap);
        goon.init(hardwareMap);
        flywheel.init(hardwareMap);
        pollenservo.init(hardwareMap);                           // POLLEN
    }

    @Override
    public void loop() {
        double forward = gamepad1.left_stick_y;
        double strafe = gamepad1.left_stick_x;
        double rotate = gamepad1.right_stick_x;

        drive.driveFieldRelative(forward, strafe, rotate);

        // Toggle intake with A button
        if (gamepad1.a && !lastA) {
            goon.toggleIntakeMotor();
        }
        lastA = gamepad1.a;

        // Toggle flywheel with Left Bumper
        if (gamepad1.left_bumper && !lastLeftBumper) {
            flywheelOn = !flywheelOn;
        }
        lastLeftBumper = gamepad1.left_bumper;

        if (flywheelOn) {
            flywheel.runMax();
        } else {
            flywheel.stop();
        }

        // Toggle pollenservo with B button
        pollenservo.update(gamepad1.b);                          // POLLEN

        telemetry.addData("Intake Status", goon.isIntakeOn() ? "ON" : "OFF");
        telemetry.addData("Intake Speed", "%.0f%%", Math.abs(goon.getSpeed() * 100.0));
        telemetry.addData("Actual Intake RPM", "%.0f RPM", goon.getActualRpm());
        telemetry.addData("Flywheel Status", flywheelOn ? "RUNNING" : "STOPPED");
        telemetry.addData("Flywheel RPM", "%.0f RPM", flywheel.getRPM());
        telemetry.addData("Pollenservo", pollenservo.isSpinning() ? "SPINNING" : "STOPPED"); // POLLEN
        telemetry.update();
    }

    @Override
    public void stop() {                                         // POLLEN
        pollenservo.stop();
    }
}