package com.afta.scoreboard.test.scoreboard;

import com.afta.scoreboard.entity.Game;
import com.afta.scoreboard.entity.Scoreboard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GetActiveGamesTest {

    private final static String TEAM_A = "Team A";
    private final static String TEAM_B = "Team B";
    private final static String TEAM_C = "Team C";
    private final static String TEAM_D = "Team D";
    private final static String TEAM_E = "Team E";
    private final static String TEAM_F = "Team F";

    private Scoreboard scoreboard = new Scoreboard();

    private void setUpScoreboard() {
        scoreboard = new Scoreboard();
        scoreboard.startGame(TEAM_A, TEAM_B);
        scoreboard.startGame(TEAM_C, TEAM_D);
        scoreboard.startGame(TEAM_E, TEAM_F);
    }

    @Test
    public void testGetActiveGamesSortedByTotalScore() {
        setUpScoreboard();
        scoreboard.updateGameScore(TEAM_C, TEAM_D, 2, 3);
        scoreboard.updateGameScore(TEAM_A, TEAM_B, 1, 1);
        scoreboard.updateGameScore(TEAM_E, TEAM_F, 3, 3);

        // Expected order: E - F, C - D, A - B
        List<Game> activeGames = scoreboard.getActiveGames();
        Assertions.assertEquals(TEAM_E, activeGames.get(0).getHomeTeam());
        Assertions.assertEquals(TEAM_C, activeGames.get(1).getHomeTeam());
        Assertions.assertEquals(TEAM_A, activeGames.get(2).getHomeTeam());
    }

    @Test
    public void testGetActiveGamesSortedByStartTime() {
        setUpScoreboard();
        scoreboard.updateGameScore(TEAM_E, TEAM_F, 3, 3);
        scoreboard.updateGameScore(TEAM_C, TEAM_D, 2, 4);
        scoreboard.updateGameScore(TEAM_A, TEAM_B, 5, 1);

        // Expected order: A - B, C - D, E - F
        List<Game> activeGames = scoreboard.getActiveGames();
        Assertions.assertEquals(3, activeGames.size());
        Assertions.assertEquals(TEAM_E, activeGames.get(0).getHomeTeam());
        Assertions.assertEquals(TEAM_C, activeGames.get(1).getHomeTeam());
        Assertions.assertEquals(TEAM_A, activeGames.get(2).getHomeTeam());
    }
}
