package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp (name = "ColorSensorPractice", group = "Program")
public class ColorSensorPractice extends LinearOpMode {
    private ColorSensor color;
    private DistanceSensor distanceSensor;
    ElapsedTime elapsedTime = new ElapsedTime();


    @Override
    public void runOpMode(){
        DcMotor dcMotor = hardwareMap.get(DcMotor.class, "test_motor");
        ColorSensor color = hardwareMap.get(ColorSensor.class, "color_sensor");
        DistanceSensor distance = hardwareMap.get(DistanceSensor.class, "color_sensor");
        float[] hsv = new float[3];
        waitForStart();
        int red = color.red();
        int green = color.green();
        int blue = color.blue();
        android.graphics.Color.RGBToHSV(red, green, blue, hsv);
        float hue = hsv[0];
        float sat = hsv[1];
        float val = hsv[2];
        while (opModeIsActive()) {
            telemetry.addData("Red", red);
            telemetry.addData("Green", green);
            telemetry.addData("Blue", blue);
            telemetry.addData("Hue", hue);
            telemetry.addData("Saturation", sat);
            telemetry.addData("Value", val);
            telemetry.addData("Run Time", elapsedTime.time());
            telemetry.addData("Distance", distance.getDistance(DistanceUnit.MM));
            telemetry.update();
        }
    }
}
