package com.afta.scoreboard.entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Scoreboard {
    private final List<Game> activeGames = new LinkedList<>();

    public void startGame(String homeTeam, String awayTeam) {
        // TODO implement
    }

    public void finishGame(String homeTeam, String awayTeam) {
        // TODO implement
    }

    public List<Game> getActiveGames() {
        // TODO implement
        return activeGames;
    }

    public void updateGameScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        // TODO implement

    }
}
