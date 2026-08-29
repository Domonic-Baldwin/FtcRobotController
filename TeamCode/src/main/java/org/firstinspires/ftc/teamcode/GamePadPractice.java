package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@Disabled
@TeleOp
public class GamePadPractice extends OpMode {
    @Override
    public void init() {

    }

    @Override
    public void loop() {
        double speedForward = -gamepad1.left_stick_y / 2.0;
        double diff = gamepad1.left_stick_x - gamepad1.right_stick_x;
        double trigSum = gamepad1.left_trigger + gamepad1.right_trigger;


        telemetry.addData("x", gamepad1.left_stick_x);
        telemetry.addData("Y", speedForward);
        telemetry.addData("X button", gamepad1.cross);

        telemetry.addData("x2", gamepad1.right_stick_x);
        telemetry.addData("y2", gamepad1.right_stick_y);
        telemetry.addData("Circle", gamepad1.circle);

        telemetry.addData("Diff", diff);

        telemetry.addData("LeftTrigger", gamepad1.left_trigger);
        telemetry.addData("RightTrigger", gamepad1.right_trigger);
        telemetry.addData("Trigger Sum", trigSum);
    }
}
