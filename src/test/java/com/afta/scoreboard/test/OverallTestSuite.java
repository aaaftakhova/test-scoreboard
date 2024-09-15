package com.afta.scoreboard.test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

/**
 * Test Suite to run all available unit tests
 */
@Suite
@SuiteDisplayName("Overall Scoreboard Tests")
@SelectClasses({GameTestSuite.class, ScoreboardTestSuite.class})
public class OverallTestSuite {
}
