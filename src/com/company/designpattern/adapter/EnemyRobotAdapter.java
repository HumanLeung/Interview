package com.company.designpattern.adapter;

/**
 * @author Administrator
 */
public class EnemyRobotAdapter implements EnemyAttacker{
    EnemyRobot theRobot;
    public EnemyRobotAdapter(EnemyRobot newRobot){
        theRobot = newRobot;
    }
    public void fireWeapon() {
        theRobot.smashWithHands();
    }
    public void driveForward() {
        theRobot.walkForward();
    }
    public void assignDriver(String driverName) {
        theRobot.reactToHuman(driverName);
    }
}
