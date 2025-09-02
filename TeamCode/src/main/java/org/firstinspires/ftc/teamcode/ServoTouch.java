package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class ServoAndTouch extends LinearOpMode {

    double servoPos = 0.75; // Starting at mid-range position (0.0 to 1.0)
    TestBench bench = new TestBench();  // Custom class that contains your hardware
    private ElapsedTime runTime = new ElapsedTime();

    @Override
    public void runOpMode() {

        bench.init(hardwareMap);  // Initialize hardware
        telemetry.addLine("Initialized. Waiting for start...");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            // Check the touch sensor live
            if (bench.TouchValue()) {
                // Touch sensor is pressed — start servo motion loop

                // Move servo in one direction for 3 seconds
                runTime.reset();
                while (opModeIsActive() && runTime.seconds() <= 3 && bench.TouchValue()) {
                    bench.setServoPosition(0.75); // 135 degrees approx
                    servoPos = 0.75;
                    telemetry.addData("Servo", "Moving to 135 degrees");
                    telemetry.update();
                }

                // Move servo in opposite direction for 3 seconds
                runTime.reset();
                while (opModeIsActive() && runTime.seconds() <= 3 && bench.TouchValue()) {
                    bench.setServoPosition(0.25); // ~45 degrees approx
                    servoPos = 0.25;
                    telemetry.addData("Servo", "Moving to 45 degrees");
                    telemetry.update();
                }
            }

            // Always show latest status
            telemetry.addData("Touch Pressed", bench.TouchValue());
            telemetry.addData("Servo Position", servoPos);
            telemetry.update();
        }
    }
}