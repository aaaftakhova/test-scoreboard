package com.afta.scoreboard.entity;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Scoreboard {
    private final LinkedList<Game> activeGames = new LinkedList<>();

    public void startGame(String homeTeam, String awayTeam) {
        Game game = new Game(homeTeam, awayTeam);
        if (isTeamAlreadyPlaying(homeTeam)) {
            throw new IllegalArgumentException(String.format("Team %s is already playing!", homeTeam));
        }
        if (isTeamAlreadyPlaying(awayTeam)) {
            throw new IllegalArgumentException(String.format("Team %s is already playing!", awayTeam));
        }
        activeGames.addFirst(game);
    }

    public void finishGame(String homeTeam, String awayTeam) {
        Game game = new Game(homeTeam, awayTeam);
        activeGames.remove(game);
    }

    public List<Game> getActiveGames() {
        return activeGames.stream().sorted(
                Comparator.reverseOrder()
        ).collect(Collectors.toList());
    }

    public void updateGameScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        Game game = new Game(homeTeam, awayTeam);

        activeGames.stream().filter(g -> g.equals(game)).findAny()
                .ifPresentOrElse(g -> g.updateScore(homeScore, awayScore),
                        () -> {throw new NoSuchElementException("No such game found in the scoreboard!");});
    }

    private boolean isTeamAlreadyPlaying(String team) {
        return activeGames.stream().flatMap(game -> Stream.of(game.getHomeTeam(), game.getAwayTeam()))
                .anyMatch(t -> t.equals(team));
    }
}
