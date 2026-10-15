package org.firstinspires.ftc.teamcode.MOTORTEST;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MotorSet {
    private DcMotor motor;

    public void init(HardwareMap hwMap) {

        motor = hwMap.get(DcMotor.class,"backleftmotor");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void setMotorSpeed(double speed){
        //accepts any valid values from -1.0 to 1.0 since it is a double variable
        motor.setPower(speed);
    }
}
