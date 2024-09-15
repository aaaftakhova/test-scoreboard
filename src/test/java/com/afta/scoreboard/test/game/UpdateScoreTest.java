package com.afta.scoreboard.test.game;

import com.afta.scoreboard.entity.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * JUnit test to test the update score functionality of the {@link Game} class
 */
public class UpdateScoreTest {

    private Game game;

    @BeforeEach
    public void setUp() {
        game = new Game("Team A", "Team B");
    }

    @Test
    public void testUpdateScoreSuccessfully() {
        Assertions.assertEquals(0, game.getHomeTeamScore());
        Assertions.assertEquals(0, game.getAwayTeamScore());

        game.updateScore(6, 4);

        Assertions.assertEquals(6, game.getHomeTeamScore());
        Assertions.assertEquals(4, game.getAwayTeamScore());
    }

    @ParameterizedTest(name = "homeScore: {0}, awayScore: {1}")
    @CsvSource({"-1,2", "4,-1", "-4,-5"})
    public void testUpdateScoreNegative(int homeScore, int awayScore) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> game.updateScore(homeScore, awayScore));
    }

    @ParameterizedTest(name = "homeScore: {0}, awayScore: {1}")
    @CsvSource({"3,5", "5,2", "1,1"})
    public void testUpdateScoreLowered(int homeScore, int awayScore) {
        game.updateScore(5,5);
        Assertions.assertThrows(IllegalArgumentException.class, () -> game.updateScore(homeScore, awayScore));
    }
}
