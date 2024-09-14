package com.afta.scoreboard.entity;

import com.afta.scoreboard.util.StringUtils;

public class Game {

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

}
