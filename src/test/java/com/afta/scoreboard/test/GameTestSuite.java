package com.afta.scoreboard.test;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
import com.afta.scoreboard.entity.Game;

/**
 * Test Suite to run all unit tests for the {@link Game} class
 */
@Suite
@SuiteDisplayName("Game Tests")
@SelectPackages("com.afta.scoreboard.test.game")
public class GameTestSuite {

}
