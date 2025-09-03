package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class ServoAndTouch extends LinearOpMode {
    private Servo testServo = null;
    private TouchSensor touchSensor = null;

    @Override
    public void runOpMode() {
        testServo = hardwareMap.get(Servo.class, "test_servo");
        touchSensor = hardwareMap.get(TouchSensor.class, "touch_sensor");

        telemetry.addLine("Initialized -Press Start");
        telemetry.update();

        waitForStart();
        ElapsedTime timer = new ElapsedTime()
                boolean forward = true;
    }
}