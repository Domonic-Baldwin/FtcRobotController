package org.firstinspires.ftc.teamcode.mechinisms;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
//@Disabled
public class FieldOrientOPMode extends OpMode {
  DriveCode drive = new DriveCode();
  double forward, strafe, rotate;
  @Override
    public void init() {
drive.init(hardwareMap);
    }

    @Override
    public void loop() {
    forward = gamepad1.left_stick_y * -1;
    strafe = gamepad1.left_stick_x ;
    rotate = gamepad1.right_stick_x;

    drive.driveFieldReletive(forward,strafe,rotate, 0.1);
    }
}
