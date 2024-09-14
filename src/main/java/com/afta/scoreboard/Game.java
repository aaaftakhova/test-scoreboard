package com.afta.scoreboard;

import java.time.Instant;

public class Game {

    private String homeTeam;
    private String awayTeam;
    private Instant gameStart;
    private int homeTeamScore;
    private int awayTeamScore;


    public Game(String homeTeam, String awayTeam) {
        // TODO validity checks
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.gameStart = Instant.now();
    }

    public void updateScore(int homeTeamScore, int awayTeamScore) {
        // TODO validity checks
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
    }

    public int getTotalScore() {
        return homeTeamScore + awayTeamScore;
    }

}
