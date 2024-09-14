package com.afta.scoreboard.test.scoreboard;

import com.afta.scoreboard.entity.Game;
import com.afta.scoreboard.entity.Scoreboard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class UpdateGameScoreTest {

    private final static String TEAM_A = "Team A";
    private final static String TEAM_B = "Team B";

    private Scoreboard scoreboard;

    @BeforeEach
    public void setUp() {
        scoreboard = new Scoreboard();
        scoreboard.startGame(TEAM_A, TEAM_B);
    }

    @Test
    public void updateGameScoreSuccessfully() {
        scoreboard.updateGameScore(TEAM_A, TEAM_B, 3, 1);

        Assertions.assertFalse(scoreboard.getActiveGames().isEmpty());
        Game updatedGame = scoreboard.getActiveGames().get(0);
        Assertions.assertEquals(3, updatedGame.getHomeTeamScore());
        Assertions.assertEquals(1, updatedGame.getAwayTeamScore());
    }

    @Test
    public void updateGameScoreGameNotExists() {
        Assertions.assertThrows(NoSuchElementException.class,
                () -> scoreboard.updateGameScore(TEAM_A, "Team C", 3,0));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t", "\n"})
    public void updateGameScoreInvalidHomeTeam(String homeTeam) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> scoreboard.updateGameScore(homeTeam, TEAM_B, 1, 1));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t", "\n"})
    public void updateGameScoreInvalidAwayTeam(String awayTeam) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> scoreboard.updateGameScore(TEAM_A, awayTeam, 1, 1));
    }


    @ParameterizedTest(name = "Team A: {0} - Team B: {1}")
    @CsvSource({"0,0", "0,-1", "-5,10"})
    public void updateGameScoreInvalidScore(int homeScore, int awayScore) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> scoreboard.updateGameScore(TEAM_A, TEAM_B, homeScore, awayScore));
    }

}
