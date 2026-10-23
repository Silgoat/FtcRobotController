package org.firstinspires.ftc.teamcode.MOTORS;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class DriveMode extends OpMode {
    MecanumDrive drive = new MecanumDrive();
    IntakeMotor goon = new IntakeMotor();

    double forward, strafe, rotate;
    boolean lastA = false;

    @Override
    public void init() {
        drive.init(hardwareMap);
        goon.init(hardwareMap);
    }

    @Override
    public void loop() {
        forward = gamepad1.left_stick_y;
        strafe = gamepad1.left_stick_x;
        rotate = gamepad1.right_stick_x;

        drive.driveFieldRelative(forward, strafe, rotate);

        // Toggle intake with A button
        if (gamepad1.a && !lastA) {
            goon.toggleIntakeMotor();
        }
        lastA = gamepad1.a;
    }
}