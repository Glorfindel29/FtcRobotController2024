package org.firstinspires.ftc.teamcode.AprilTags;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.Controller.MechanicalDriveBase;

@Autonomous(name = "AprilTag", group = "AprilTag")
public class AprilTagOpMode extends LinearOpMode
{
    MechanicalDriveBase mechanicalDriveBase;
    DetectAprilTag detectAprilTag;
    DriveToTag driveToTag;
    int target = -1;

    @Override
    public void runOpMode() throws InterruptedException
    {
        target = 6;
        mechanicalDriveBase = new MechanicalDriveBase(hardwareMap);
//        detectAprilTag = new DetectAprilTag(hardwareMap);
        driveToTag = new DriveToTag(hardwareMap, telemetry, mechanicalDriveBase);

        waitForStart();
        start();

        while (opModeIsActive())
        {
//            detectAprilTag.detectTags(telemetry);
//            telemetry.addData("get One", detectAprilTag.getDetectionID());
            driveToTag.findTag(telemetry,1);
        }

        stop();
        detectAprilTag.closeAprilTags();
    }

//    class ThreadDetector extends Thread
//    {
//        public ThreadDetector()
//        {
//            while (opModeIsActive())
//            {
//                detectAprilTag.detectTags(telemetry);
//                telemetry.addData("Thread get", detectAprilTag.getDetectionID());
//            }
//        }
//    }

    class ThreadDetector extends Thread
    {
        public ThreadDetector()
        {
            while (opModeIsActive())
            {
                mechanicalDriveBase.driveBaseTelemetry(telemetry);
            }
        }
    }
}









