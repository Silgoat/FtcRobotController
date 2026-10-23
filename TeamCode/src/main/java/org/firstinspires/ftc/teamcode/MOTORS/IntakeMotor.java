package org.firstinspires.ftc.teamcode.MOTORS;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp
public class IntakeMotor extends LinearOpMode {

    // ---- Change these to match your motor ----
    // Encoder ticks per MOTOR OUTPUT SHAFT revolution:
    //   goBILDA 5202/5203 6000 RPM (1:1)  -> 28
    //   goBILDA 5203 1620 RPM (3.7:1)     -> 103.8
    //   REV HD Hex (no gearbox)           -> 28
    //   REV Core Hex                      -> 288
    private static final double TICKS_PER_REV = 288.0;

    private static final double TARGET_RPM = -3000.0;
    private static final double TARGET_TICKS_PER_SEC = TARGET_RPM / 60.0 * TICKS_PER_REV;

    private DcMotorEx intakeMotor;

    private boolean intakeOn = false;
    private boolean lastA = false;

    @Override
    public void runOpMode() {
        // "intake" must match the motor name in your Robot Configuration
        intakeMotor = hardwareMap.get(DcMotorEx.class, "intake");
        intakeMotor.setDirection(DcMotor.Direction.FORWARD); // flip to REVERSE if it spins the wrong way
        intakeMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        intakeMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER); // required for setVelocity()
        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        telemetry.addLine("Press gamepad1 A to toggle intake on/off");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            // Rising-edge detection: toggle once per press, not every loop while held
            boolean a = gamepad1.a;
            if (a && !lastA) {
                intakeOn = !intakeOn;
            }
            lastA = a;

            intakeMotor.setVelocity(intakeOn ? TARGET_TICKS_PER_SEC : 0);

            double actualRpm = intakeMotor.getVelocity() / TICKS_PER_REV * 60.0;
            telemetry.addData("Intake", intakeOn ? "ON" : "OFF");
            telemetry.addData("Target RPM", TARGET_RPM);
            telemetry.addData("Actual RPM", "%.0f", actualRpm);
            telemetry.update();
        }

        intakeMotor.setVelocity(0);
    }
}