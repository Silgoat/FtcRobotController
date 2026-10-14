package org.firstinspires.ftc.teamcode;

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
        telemetry.addData("x",gamepad1.left_stick_x);
        telemetry.addData("y",gamepad1.left_stick_y);
        telemetry.addData("a button",gamepad1.a);
    }
}
