package com.afta.scoreboard.entity;

import com.afta.scoreboard.util.StringUtils;

import java.util.Objects;

public class Game implements Comparable<Game> {

    private String homeTeam;
    private String awayTeam;
    private int homeTeamScore;
    private int awayTeamScore;

    public Game(String homeTeam, String awayTeam) {
        if (StringUtils.isNullEmptyOrBlank(homeTeam) || StringUtils.isNullEmptyOrBlank(awayTeam)) {
            throw new IllegalArgumentException("Team name may not be null empty or blank!");
        }
        if (homeTeam.equals(awayTeam)) {
            throw new IllegalArgumentException("Home and away team name may not be equal!");
        }
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
        if (homeTeamScore < 0 || awayTeamScore < 0
                || homeTeamScore < this.homeTeamScore || awayTeamScore < this.homeTeamScore) {
            throw new IllegalArgumentException("Score may not be negative or smaller than previous score!");
        }
        if (homeTeamScore != this.homeTeamScore) {
            this.homeTeamScore = homeTeamScore;
        }
        if (awayTeamScore != this.awayTeamScore) {
            this.awayTeamScore = awayTeamScore;
        }
    }

    public int getTotalScore() {
        return homeTeamScore + awayTeamScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return homeTeamScore == game.homeTeamScore
                && awayTeamScore == game.awayTeamScore
                && Objects.equals(homeTeam, game.homeTeam)
                && Objects.equals(awayTeam, game.awayTeam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeam, awayTeam, homeTeamScore, awayTeamScore);
    }

    @Override
    public int compareTo(Game o) {
        return Integer.compare(this.getTotalScore(), o.getTotalScore());
    }
}
