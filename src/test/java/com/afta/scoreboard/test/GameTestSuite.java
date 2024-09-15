package com.afta.scoreboard.test;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Game Tests")
@SelectPackages("com.afta.scoreboard.test.game")
public class GameTestSuite {

}
