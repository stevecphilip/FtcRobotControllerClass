package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Gamepad;

import java.lang.annotation.ElementType;

@TeleOp
public class touchServo extends LinearOpMode {
    private Servo servo;
    private TouchSensor touchsensor;
    private boolean flop = false;


    @Override
    public void runOpMode() throws InterruptedException {
        double runtime = getRuntime();
        servo = hardwareMap.get(Servo.class, "test_servo");
        touchsensor = hardwareMap.get(TouchSensor.class, "touch_sensor");
        ElapsedTime elapsedTime = new ElapsedTime();

        double time = elapsedTime.time();

        waitForStart();

        while (opModeIsActive()) {
            if (touchsensor.isPressed()) {
                if (flop) {
                    servo.setPosition(0);
                    double current = elapsedTime.time();
                    while (elapsedTime.time() - current < 1) {

                    }
                    flop = false;
                } else {
                    servo.setPosition(1.0);
                    double current = elapsedTime.time();
                    while (elapsedTime.time() - current < 1) {

                    }
                    flop = true;
                }

            } else {
                servo.setPosition(servo.getPosition());
            }


            telemetry.addData("Runtime", runtime);
            telemetry.addData("Servo Position", servo.getPosition());
            telemetry.addData("Touch Sensor Value", touchsensor.isPressed());
            telemetry.update();
        }


    }
}


