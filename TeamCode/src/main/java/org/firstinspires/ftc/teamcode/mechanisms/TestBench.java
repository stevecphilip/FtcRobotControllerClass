package org.firstinspires.ftc.teamcode.mechanisms;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TestBench {

    private DigitalChannel touchSensor;


    public void init(HardwareMap hwMap) {
        touchSensor = hwMap.get(DigitalChannel.class, "touch_sensor");
        touchSensor.setMode(DigitalChannel.Mode.INPUT);
        test_motor = hwMap.get(DcMotor.class, "test_motor");
        test_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        ticksPerRev = test_motor.getMotorType().getTicksPerRev();
        test_motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        test_motor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public boolean isTouchSensorPressed() {
        return !touchSensor.getState();
    }

    public boolean isTouchSensorReleased() {
        return touchSensor.getState();
    }


    private DcMotor test_motor;
    private double ticksPerRev;



    public void setMotorSpeed(double speed) {
        test_motor.setPower(speed);
    }


    public double getMotorRevs() {
        return test_motor.getCurrentPosition() / ticksPerRev;
    }

}