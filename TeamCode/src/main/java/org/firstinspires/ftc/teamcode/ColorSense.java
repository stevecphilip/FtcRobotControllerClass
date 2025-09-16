package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp (name = "ColorSense", group = "Program")
public class ColorSense extends LinearOpMode {
    private ColorSensor color;
    private DistanceSensor distanceSensor;
    ElapsedTime elapsedTime = new ElapsedTime();
    float[] hsv = new float[3];


    @Override
    public void runOpMode(){
        DcMotor dcMotor = hardwareMap.get(DcMotor.class, "test_motor");
        ColorSensor color = hardwareMap.get(ColorSensor.class, "color_sensor");
        DistanceSensor distance = hardwareMap.get(DistanceSensor.class, "color_sensor");
        waitForStart();

        while (opModeIsActive()) {
            int red = color.red();
            int green = color.green();
            int blue = color.blue();
            android.graphics.Color.RGBToHSV(red, green, blue, hsv);
            float hue = hsv[0];
            float sat = hsv[1];
            float val = hsv[2];
            double dist = distance.getDistance(DistanceUnit.MM);

            telemetry.addData("Red", color.red());
            telemetry.addData("Green", color.green());
            telemetry.addData("Blue", color.blue());
            telemetry.addData("Hue", hue);
            telemetry.addData("Saturation", sat);
            telemetry.addData("Value", val);
            telemetry.addData("Run Time", elapsedTime.time());
            telemetry.addData("Distance (MM)", dist);
            telemetry.update();

            if (val >= 165) {
                dcMotor.setPower(0.8);
                telemetry.addLine("White");
            }
            else if (dist > 50 || dist < 35) {
                dcMotor.setPower(0.0);
                telemetry.addLine("No Color Detected");
            }
            else if(hue <= 45 || hue >= 300) {
                dcMotor.setPower(1.0);
                telemetry.addLine("Red");
            } else if (hue <= 180 && hue >= 145) {
                dcMotor.setPower(0.4);
                telemetry.addLine("Dark Green");
            } else if (hue >= 101 && hue <= 299) {
                dcMotor.setPower(0.2);
                telemetry.addLine("Blue");
            } else if (hue >= 144 && hue <= 190) {
                dcMotor.setPower(0.3);
                telemetry.addLine("Yellow");
            } else if (hue <= 144 && hue >= 111) {
                dcMotor.setPower(-0.6);
                telemetry.addLine("Light Green");
            }
        }
    }
}
