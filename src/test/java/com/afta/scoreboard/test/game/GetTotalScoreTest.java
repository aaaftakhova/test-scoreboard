package com.afta.scoreboard.test.game;

import com.afta.scoreboard.entity.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GetTotalScoreTest {

    private Game game;

    @BeforeEach
    public void setUp() {
        game = new Game("Team A", "Team B");
    }


    @Test
    public void testGetInitialTotalScore() {
        Assertions.assertEquals(0, game.getTotalScore());
    }

    @Test
    public void testGetUpdatedTotalScore() {
        int newHomeScore = 6;
        int newAwayScore = 4;
        game.updateScore(newHomeScore, newAwayScore);
        Assertions.assertEquals(10, game.getTotalScore());
    }
}
