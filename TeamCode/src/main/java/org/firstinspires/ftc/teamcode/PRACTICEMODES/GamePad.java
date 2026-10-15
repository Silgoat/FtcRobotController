package org.firstinspires.ftc.teamcode.PRACTICEMODES;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class GamePad extends OpMode {

    @Override
    public void init() {

    }

    @Override
    public void loop() {
        //runs like 50 times pr sec
        double speedForward = -gamepad1.left_stick_y / 2.0;
        // does my GitHub work?
        telemetry.addData("x",gamepad1.left_stick_x);
        telemetry.addData("y",speedForward);
        telemetry.addData("a button",gamepad1.a);
    }
}
