package com.afta.scoreboard.util;

public class GameValidator {

    public void checkTeamNameIsValid(String team) {
        if (team == null || team.isEmpty() || team.isBlank()) {
            throw new IllegalArgumentException("Team name may not be null empty or blank!");
        }
    }

    public void checkForSelfGame(String homeTeam, String awayTeam) {
        if (homeTeam.equals(awayTeam)) {
            throw new IllegalArgumentException("Home and away team name may not be equal!");
        }
    }

    public void checkScoreIsValid(int oldScore, int newScore) {
        if (newScore < 0 || newScore < oldScore) {
            throw new IllegalArgumentException("Score may not be negative or smaller than previous score!");
        }
    }
}
