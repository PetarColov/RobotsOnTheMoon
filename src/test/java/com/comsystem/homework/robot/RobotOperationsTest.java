package com.comsystem.homework.robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotOperationsTest {
    @Test
    void testExcavateStonesForDaysHappyPath(){
        RobotOperations robotOperations = new RobotOperations();
        assertEquals(32, robotOperations.excavateStonesForDays(6));
    }

    @Test
    void testDaysRequiredToCollectStones(){
        RobotOperations robotOperations = new RobotOperations();
        assertEquals(10, robotOperations.excavateStonesForDays(5));
    }

}