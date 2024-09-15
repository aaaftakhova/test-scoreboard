package com.afta.scoreboard.test;

import com.afta.scoreboard.entity.Scoreboard;
import org.junit.jupiter.api.DisplayName;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

/**
 * Test Suite to run all unit tests for the {@link Scoreboard} class
 */
@Suite
@DisplayName("Scoreboard Tests")
@SelectPackages("com.afta.scoreboard.test.scoreboard")
public class ScoreboardTestSuite {

}
