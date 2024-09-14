package com.afta.scoreboard.test.game;

import com.afta.scoreboard.entity.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class CreateGameTest {

    private final static String TEAM_A = "Team A";
    private final static String TEAM_B = "Team B";

    @Test
    public void testCreateGameSuccessfully() {
        Game game = new Game(TEAM_A, TEAM_B);

        Assertions.assertEquals(TEAM_A, game.getHomeTeam());
        Assertions.assertEquals(TEAM_B, game.getAwayTeam());
        Assertions.assertNotNull(game.getGameStart());
    }

    @Test
    public void testCreateSecondGameStartTime() {
        Game game1 = new Game(TEAM_A, TEAM_B);
        Game game2 = new Game(TEAM_A, TEAM_B);

        System.out.println(game1.getGameStart());
        System.out.println(game2.getGameStart());
        Assertions.assertTrue(game2.getGameStart().isAfter(game1.getGameStart()));
    }

    @Test
    public void testCreateSelfGame() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Game(TEAM_A, TEAM_A));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t", "\n"})
    public void testCreateHomeTeamIsInvalid(String homeTeam) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Game(homeTeam, TEAM_B));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    public void testCreateAwayTeamIsInvalid(String awayTeam) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Game(TEAM_A, awayTeam));
    }
}
