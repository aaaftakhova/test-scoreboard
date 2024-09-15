package com.afta.scoreboard.test.scoreboard;

import com.afta.scoreboard.entity.Game;
import com.afta.scoreboard.entity.Scoreboard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit test to test the finish game functionality of the {@link Scoreboard} class
 */
public class FinishGameTest {
    final static String TEAM_A = "Team A";
    final static String TEAM_B = "Team B";

    private Scoreboard scoreboard;

    @BeforeEach
    public void setUp() {
        scoreboard = new Scoreboard();
        scoreboard.startGame(TEAM_A, TEAM_B);
        scoreboard.startGame("One Team", "Other Team");
    }

    @Test
    public void testFinishGameSuccessfully() {
        scoreboard.finishGame(TEAM_A, TEAM_B);
        Assertions.assertTrue(scoreboard.getActiveGames().stream().noneMatch(
                game -> game.getHomeTeam().equals(TEAM_A) &&
                        game.getAwayTeam().equals(TEAM_B)));
    }

    @Test
    public void testFinishGameNotFound() {
        Assertions.assertDoesNotThrow(()-> scoreboard.finishGame("Unknown", "NonExistent"));
    }
}
