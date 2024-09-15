package com.afta.scoreboard.test.scoreboard;

import com.afta.scoreboard.entity.Game;
import com.afta.scoreboard.entity.Scoreboard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

/**
 * JUnit test to test the start game functionality of the {@link Scoreboard} class
 */
public class StartGameTest {
    final static String TEAM_A = "Team A";
    final static String TEAM_B = "Team B";

    private Scoreboard scoreboard;

    @BeforeEach
    public void setUp() {
        scoreboard = new Scoreboard();
    }

    @Test
    public void testStartGameSuccessfully() {
        scoreboard.startGame(TEAM_A, TEAM_B);
        List<Game> activeGames = scoreboard.getActiveGames();

        Assertions.assertFalse(activeGames.isEmpty());
        Assertions.assertEquals(1, activeGames.size());
        Assertions.assertEquals(TEAM_A, activeGames.get(0).getHomeTeam());
        Assertions.assertEquals(TEAM_B, activeGames.get(0).getAwayTeam());
    }

    @Test
    public void testStartGameForPlayingTeam() {
        scoreboard.startGame(TEAM_A, TEAM_B);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> scoreboard.startGame(TEAM_B, "Team C"));
    }
}
