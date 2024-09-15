package com.afta.scoreboard.entity;

import com.afta.scoreboard.util.ScoreboardValidator;

import java.util.*;
import java.util.stream.Collectors;


public class Scoreboard {
    private final ScoreboardValidator validator = new ScoreboardValidator();
    private final LinkedList<Game> activeGames = new LinkedList<>();

    public void startGame(String homeTeam, String awayTeam) {
        Game game = new Game(homeTeam, awayTeam);
        validator.checkIfTeamAlreadyPlays(activeGames, homeTeam);
        validator.checkIfTeamAlreadyPlays(activeGames, awayTeam);
        activeGames.addFirst(game);
    }

    public void finishGame(String homeTeam, String awayTeam) {
        Game game = new Game(homeTeam, awayTeam);
        activeGames.remove(game);
    }

    public List<Game> getActiveGames() {
        return activeGames.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public void updateGameScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        Game game = new Game(homeTeam, awayTeam);
        validator.checkGameExists(activeGames, game);
        activeGames.get(activeGames.indexOf(game)).updateScore(homeScore, awayScore);
    }
}
