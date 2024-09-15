package com.afta.scoreboard.entity;

import com.afta.scoreboard.util.GameValidator;

import java.util.Objects;

public class Game implements Comparable<Game> {

    final private GameValidator validator = new GameValidator();

    private final String homeTeam;
    private final String awayTeam;
    private int homeTeamScore;
    private int awayTeamScore;

    public Game(String homeTeam, String awayTeam) {
        validator.checkTeamNameIsValid(homeTeam);
        validator.checkTeamNameIsValid(awayTeam);
        validator.checkForSelfGame(homeTeam, awayTeam);
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }


    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public void updateScore(int homeTeamScore, int awayTeamScore) {
        validator.checkScoreIsValid(this.homeTeamScore, homeTeamScore);
        validator.checkScoreIsValid(this.awayTeamScore, awayTeamScore);

        if (homeTeamScore != this.homeTeamScore) { this.homeTeamScore = homeTeamScore; }
        if (awayTeamScore != this.awayTeamScore) { this.awayTeamScore = awayTeamScore; }
    }

    public int getTotalScore() {
        return homeTeamScore + awayTeamScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(homeTeam, game.homeTeam)
                && Objects.equals(awayTeam, game.awayTeam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeam, awayTeam);
    }

    @Override
    public int compareTo(Game o) {
        return Integer.compare(this.getTotalScore(), o.getTotalScore());
    }
}
