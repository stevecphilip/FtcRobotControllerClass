package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.JavaUtil;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp (name = "ColorSensorPractice", group = "Program")
public class ColorSensorPractice extends LinearOpMode {
    private ColorSensor color;
    private DistanceSensor distanceSensor;
    ElapsedTime elapsedTime = new ElapsedTime();

    @Override
    public void runOpMode(){
        ColorSensor color = hardwareMap.get(ColorSensor.class, "color_sensor");

        waitForStart();

        while (opModeIsActive()) {
            telemetry.addData("Red", color.red());
            telemetry.addData("Green", color.green());
            telemetry.addData("Blue", color.blue());
            telemetry.addData("Hue", (JavaUtil.colorToHue(color.blue())));
            telemetry.addData("Run Time", elapsedTime.time());
            telemetry.addData("Distance", distanceSensor.getDistance(DistanceUnit.CM));
            telemetry.update();
        }
    }
}