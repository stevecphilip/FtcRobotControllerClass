package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TestBench1 {
    private DcMotor test_motor;
    private double ticksPerRev;

    public void init(HardwareMap hwMap) {


        test_motor = hwMap.get(DcMotor.class, "test_motor");
        test_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }


    public void setMotorSpeed(double speed) {
        test_motor.setPower(speed);
    }

}
