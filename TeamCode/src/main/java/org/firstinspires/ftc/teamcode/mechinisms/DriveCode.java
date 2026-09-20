package org.firstinspires.ftc.teamcode.mechinisms;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;


public class DriveCode {
private DcMotor TopLeft, TopRight, BottomLeft, BottomRight;

private IMU imu;

public void init(HardwareMap hwMap) {
        TopLeft = hwMap.get(DcMotor.class, "TL");
    BottomLeft = hwMap.get(DcMotor.class, "BL");
    TopRight = hwMap.get(DcMotor.class, "TR");
    BottomRight = hwMap.get(DcMotor.class, "BR");

    TopLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    BottomLeft.setDirection(DcMotorSimple.Direction.REVERSE);

    TopLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    BottomLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    TopRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    BottomRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

//    imu = hwMap.get(IMU.class, "IMU");
//
//    RevHubOrientationOnRobot RevOrient = new RevHubOrientationOnRobot(
//            RevHubOrientationOnRobot.LogoFacingDirection.UP,
//            RevHubOrientationOnRobot.UsbFacingDirection.LEFT);
//
//    imu.initialize(new IMU.Parameters(RevOrient));
}


public void Drive(double forward, double strafe, double rotate, double maxS) {
    double frontLeftPower = forward +  strafe + rotate;
    double backLeftPower = forward -  strafe + rotate;
    double frontRightPower = forward -  strafe - rotate;
    double backRightPower = forward +  strafe - rotate;

    double maxPower = 1.0;
    double maxSpeed = maxS;

    maxPower = Math.max(maxPower, Math.abs(frontLeftPower));
    maxPower = Math.max(maxPower, Math.abs(backLeftPower));
    maxPower = Math.max(maxPower, Math.abs(frontRightPower));
    maxPower = Math.max(maxPower, Math.abs(backRightPower));

    TopLeft.setPower(maxSpeed * (frontLeftPower / maxPower));
    BottomLeft.setPower(maxSpeed * (backLeftPower / maxPower));
    TopRight.setPower(maxSpeed * (frontRightPower / maxPower));
    BottomRight.setPower(maxSpeed * (backRightPower / maxPower));
}
//public void driveFieldReletive(double forward, double strafe, double rotate){
//    double theta = Math.atan2(forward, strafe);
//    double r = Math.hypot(strafe, forward);
//
//    theta = AngleUnit.normalizeDegrees(theta -
//            imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS));
//
//        double newForward = r * Math.sin(theta);
//        double newStrafe = r * Math.cos(theta);
//
//        this.Drive(newForward, newStrafe,rotate);
//}
}

