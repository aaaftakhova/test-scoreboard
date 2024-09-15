package com.afta.scoreboard.entity;

import com.afta.scoreboard.util.GameValidator;

import java.util.Objects;

/**
 * Entity class representing a scoreboard game
 */
public class Game implements Comparable<Game> {

    final private GameValidator validator = new GameValidator();

    private final String homeTeam;
    private final String awayTeam;
    private int homeTeamScore;
    private int awayTeamScore;

    /**
     * Constructor
     * @param homeTeam home team name
     * @param awayTeam away team name
     * @throws IllegalArgumentException if a team name is null, blank or empty
     * @throws IllegalArgumentException if same team name is given for a home & away team
     */
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

    /**
     * Updates the score of the game entity.
     * If score hasn't changed nothing happens
     * @param homeTeamScore new home team score as absolute value
     * @param awayTeamScore new away team score as absolute value
     * @throws IllegalArgumentException if the given score is a negative number or is lower than previous score value
     */
    public void updateScore(int homeTeamScore, int awayTeamScore) {
        validator.checkScoreIsValid(this.homeTeamScore, homeTeamScore);
        validator.checkScoreIsValid(this.awayTeamScore, awayTeamScore);

        if (homeTeamScore != this.homeTeamScore) { this.homeTeamScore = homeTeamScore; }
        if (awayTeamScore != this.awayTeamScore) { this.awayTeamScore = awayTeamScore; }
    }

    /**
     * Getter for the total game score calculated as a sum of home and away teams' scores
     * @return home team score + away team score
     */
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
