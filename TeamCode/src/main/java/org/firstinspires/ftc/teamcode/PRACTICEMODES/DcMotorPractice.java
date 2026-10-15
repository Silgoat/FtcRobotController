package org.firstinspires.ftc.teamcode.PRACTICEMODES;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.MotorSet;

@TeleOp
public class DcMotorPractice extends OpMode {

    MotorSet bench = new MotorSet();

    @Override
    public void init() {
        bench.init(hardwareMap);

    }

    @Override
    public void loop() {

        bench.setMotorSpeed(0.2);
    }
}
