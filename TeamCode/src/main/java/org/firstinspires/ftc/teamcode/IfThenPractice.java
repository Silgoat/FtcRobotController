package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class IfThenPractice extends OpMode {

    @Override
    public void init() {

    }

    @Override
    public void loop() {
        boolean aButton = gamepad1.a; // press true, not pressing then FALSE since it is a boolean value
        // true or false
        if (aButton) {
            telemetry.addData("A Button ", "Pressed!");

        }
        telemetry.addData("A Button State",aButton);
    }
}
