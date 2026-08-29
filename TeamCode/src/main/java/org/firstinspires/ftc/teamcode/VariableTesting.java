package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@Disabled
@TeleOp
public class VariableTesting extends OpMode {
    @Override
    public void init() {
        int teamNumber = 20325;
        double motorSpeed = 0.75;
        boolean clawClosed = true;
        String teamName = "Max Rizz";
        int motorAngle = 90;
        telemetry.addData("Name", teamName);
        telemetry.addData("Team Number", teamNumber);
        telemetry.addData("Motor Speed", motorSpeed);
        telemetry.addData("Claw Closed", clawClosed);
        telemetry.addData("motor Angle", motorAngle);
    }

    @Override
    public void loop() {
/*
1. change string var name to team name
 */
    }
}
