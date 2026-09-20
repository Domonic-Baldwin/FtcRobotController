package org.firstinspires.ftc.teamcode.mechinisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
public class TestBot1 {
    private DcMotor motorTL;
    private String motorName;
    private double ticksPerRev; //revolution
public TestBot1(String motorame) {
    motorName = motorame;
}
    public void init(HardwareMap hwMap) {
        // dc motor
        motorTL = hwMap.get(DcMotor.class, motorName);
        motorTL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ticksPerRev = motorTL.getMotorType().getTicksPerRev();
        motorTL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void setMotorSpeed(double speed){
        // accepts val -1.0 to 1.0

        motorTL.setPower(speed);
    }

    public double getMotorRevs() {
        return motorTL.getCurrentPosition() / ticksPerRev; //normalising ticks to revolutions
    }
}
