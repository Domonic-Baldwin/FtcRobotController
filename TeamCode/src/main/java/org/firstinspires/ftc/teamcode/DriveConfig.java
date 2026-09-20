package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechinisms.DriveCode;
import org.firstinspires.ftc.teamcode.mechinisms.TestBot1;

@TeleOp
public class DriveConfig extends OpMode {
    TestBot1 blWheel = new TestBot1("BL");
    TestBot1 tlWheel = new TestBot1("TL");
    TestBot1 brWheel = new TestBot1("BR");
    TestBot1 trWheel = new TestBot1("TR");

    private double speed;
    private double maxSpeed;

    private boolean mode;
    DriveCode drive = new DriveCode();
    double forward, strafe, rotate;


    public DriveConfig() {
        speed = 0.15;
        maxSpeed = 0.25;
        mode = false;

    }

    @Override
    public void init() {
        blWheel.init(hardwareMap);
        tlWheel.init(hardwareMap);
        brWheel.init(hardwareMap);
        trWheel.init(hardwareMap);

        drive.init(hardwareMap);
    }

    @Override
    public void loop() {
        telemetry.addData("D-pad control structure enabled: ", mode);
if (gamepad1.options) {
    if(mode) {
        mode = false;
    } else if (!mode){
        mode = true;
    }
}

        if (mode) {
        /*
        left wheels            right wheels
        negitive = forward     positive = forward
        positive = back          negitive = back
         */

            // holding right trigger sets movement speed to 50% full power
            if (gamepad1.right_trigger != 0) {
                speed = maxSpeed;
            } else if (gamepad1.right_bumper) {
                speed = 0.05;
            } else {
                speed = 0.15;
            }
            // pressing square and left / right turns robot in given direction
            // only d pad inputs moves robot in given direction
            if (gamepad1.square) {
                if (gamepad1.dpad_left) {
                    tlWheel.setMotorSpeed(speed * -1);
                    trWheel.setMotorSpeed(speed);
                    blWheel.setMotorSpeed(speed * -1);
                    brWheel.setMotorSpeed(speed);
                } else if (gamepad1.dpad_right) {
                    tlWheel.setMotorSpeed(speed);
                    trWheel.setMotorSpeed(speed * -1);
                    blWheel.setMotorSpeed(speed);
                    brWheel.setMotorSpeed(speed * -1);
                } else {
                    tlWheel.setMotorSpeed(0.0);
                    trWheel.setMotorSpeed(0.0);
                    blWheel.setMotorSpeed(0.0);
                    brWheel.setMotorSpeed(0.0);
                }
            } else {

                if (gamepad1.dpad_up) {
                    blWheel.setMotorSpeed(speed);
                    tlWheel.setMotorSpeed(speed);
                    brWheel.setMotorSpeed(speed);
                    trWheel.setMotorSpeed(speed);
                } else if (gamepad1.dpad_down) {
                    blWheel.setMotorSpeed(speed * -1);
                    tlWheel.setMotorSpeed(speed * -1);
                    brWheel.setMotorSpeed(speed * -1);
                    trWheel.setMotorSpeed(speed * -1);
                } else if (gamepad1.dpad_left) {
                    blWheel.setMotorSpeed(speed);
                    tlWheel.setMotorSpeed(speed * -1);
                    brWheel.setMotorSpeed(speed * -1);
                    trWheel.setMotorSpeed(speed);
                } else if (gamepad1.dpad_right) {
                    blWheel.setMotorSpeed(speed * -1);
                    tlWheel.setMotorSpeed(speed);
                    brWheel.setMotorSpeed(speed);
                    trWheel.setMotorSpeed(speed * -1);
                } else {
                    blWheel.setMotorSpeed(0.0);
                    tlWheel.setMotorSpeed(0.0);
                    brWheel.setMotorSpeed(0.0);
                    trWheel.setMotorSpeed(0.0);
                }
            }
            telemetry.addData("RT Value: ", gamepad1.right_trigger);
            telemetry.addData("Careful Mode Active: ", gamepad1.right_bumper);
            telemetry.addData("Movement Speed: ", speed * 100 + "%");
        } else
        {
            forward = gamepad1.left_stick_y * -1;
            strafe = gamepad1.left_stick_x ;
            rotate = gamepad1.right_stick_x;

            drive.Drive(forward,strafe,rotate, maxSpeed);
        }

    }
}

