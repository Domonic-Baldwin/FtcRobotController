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
        


            forward = gamepad1.left_stick_y * -1;
            strafe = gamepad1.left_stick_x ;
            rotate = gamepad1.right_stick_x;

            drive.driveFieldReletive(forward,strafe,rotate, maxSpeed);


    }
}

