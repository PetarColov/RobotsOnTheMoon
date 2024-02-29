package com.comsystem.homework.robot;


import com.comsystem.homework.model.RobotAction;
import com.comsystem.homework.model.RobotPlan;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RobotOperations {

    /**
     * An algorithm that converts a number of days into an action plan.
     * @param days the number of days that the robot can work
     * @return The action plan <em>must maximize</em> the number of stones that the robot will dig. In other words, this
     *         algorithm must try to achieve the highest value of {@link RobotPlan#numberOfStones} possible for the
     *         number of provided days. The value of {@link RobotPlan#numberOfDays} is equal to the input
     *         days parameter
     * @see RobotPlan
     */
    public RobotPlan excavateStonesForDays(int days) {
        //10 days
        BigDecimal excavatedStones = new BigDecimal(0);
        int daysCount = 0;
        BigDecimal numberOfRobots = new BigDecimal(1);
        List<RobotAction> actionList = new ArrayList<>();

        //clone the robots everyday except on the last day
        for (int i = 0; i < days - 1; i++) {
            numberOfRobots.multiply(new BigDecimal(2));
            daysCount += 1;
            actionList.add(RobotAction.CLONE);
        }

        //let the robots dig stones the last day
        daysCount += 1;
        actionList.add(RobotAction.DIG);
        return new RobotPlan(daysCount , numberOfRobots.intValue(), actionList);
    }

    /**
     * An algorithm that converts a number of stones into an action plan. Essentially this algorithm is the inverse of
     * {@link #excavateStonesForDays(int)}.
     * @param numberOfStones the number of stones the robot has to collect
     * @return The action plan <em>must minimize</em> the number of days necessary for the robot to dig the
     *         provided number of stones. In other words, this algorithm must try to achieve the lowest value of
     *         {@link RobotPlan#numberOfDays} possible for the number of provided stones. The value of
     *         {@link RobotPlan#numberOfStones} is equal to the numberOfStones parameter
     * @see RobotPlan
     */
    public RobotPlan daysRequiredToCollectStones(int numberOfStones) {
        int daysCount = 0;
        int numberOfRobots = 1;
        List<RobotAction> actionList = new ArrayList<>();

        while(numberOfRobots < numberOfStones){
            actionList.add(RobotAction.CLONE);
            numberOfRobots *= 2;
            daysCount++;
        }

        actionList.add(RobotAction.DIG);
        daysCount++;

        return new RobotPlan(daysCount , numberOfRobots, actionList);
    }

}
