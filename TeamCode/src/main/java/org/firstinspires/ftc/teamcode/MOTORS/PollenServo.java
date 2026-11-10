package org.firstinspires.ftc.teamcode.MOTORS;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class PollenServo {

    private CRServo servo;
    private boolean spinning = false;
    private boolean lastButton = false;

    // Change to -1.0 if it spins the wrong way
    private static final double FULL_POWER = 1.0;

    public void init(HardwareMap hardwareMap) {
        servo = hardwareMap.get(CRServo.class, "pollenservo");
        servo.setPower(0);
    }

    // Call every loop with the button state. Toggles on each new press.
    public void update(boolean button) {
        if (button && !lastButton) {
            spinning = !spinning;
        }
        lastButton = button;

        servo.setPower(spinning ? FULL_POWER : 0);
    }

    public void stop() {
        spinning = false;
        servo.setPower(0);
    }

    public boolean isSpinning() {
        return spinning;
    }
}