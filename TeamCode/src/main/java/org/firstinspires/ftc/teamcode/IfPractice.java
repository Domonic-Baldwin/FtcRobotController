package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class IfPractice extends OpMode {
    @Override
    public void init(){

    }
    @Override
    public void loop() {
        boolean xButton = gamepad1.cross; // pressed is true else false

        if (xButton) {
            telemetry.addData("X Button", "pressed");
        } else {
            telemetry.addData("X Button", "Not Pressed");
        }
       telemetry.addData("X Button State", xButton);

    }
}
