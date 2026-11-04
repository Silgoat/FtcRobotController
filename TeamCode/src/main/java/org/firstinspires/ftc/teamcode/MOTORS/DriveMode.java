package org.firstinspires.ftc.teamcode.MOTORS;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
@SuppressWarnings("unused")
public class DriveMode extends OpMode {
    private final MecanumDrive drive = new MecanumDrive();
    private final IntakeMotor goon = new IntakeMotor();

    private boolean lastA = false;

    @Override
    public void init() {
        drive.init(hardwareMap);
        goon.init(hardwareMap);
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

        telemetry.addData("Intake Status", goon.isIntakeOn() ? "ON" : "OFF");
        telemetry.addData("Intake Speed", "%.0f%%", Math.abs(goon.getSpeed() * 100.0));
        telemetry.addData("Actual RPM", "%.0f RPM", goon.getActualRpm());
        telemetry.addData("Current Draw", "%.2f A", goon.getCurrentAmps());
        telemetry.update();
    }
}
