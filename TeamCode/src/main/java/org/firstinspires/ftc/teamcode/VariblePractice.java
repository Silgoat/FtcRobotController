package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class VariblePractice extends OpMode {
    @Override
    public void init() {
        int teamNumber = 14924;
        double motorSpeed = 0.75;
        boolean clawClosed = true;
        String name = "Coach Pratt";

        telemetry.addData("Team Number",teamNumber);
        telemetry.addData("motorSpeed",motorSpeed);
        telemetry.addData("clawClosed",clawClosed);
        telemetry.addData("Name",name);
    }

    @Override
    public void loop() {

    }
}
