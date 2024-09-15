package com.afta.scoreboard.entity;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Scoreboard {
    private final Map<Integer, Game> activeGames = new LinkedHashMap<>();

    public void startGame(String homeTeam, String awayTeam) {
        Game game = new Game(homeTeam, awayTeam);
        if (isTeamAlreadyPlaying(homeTeam) || isTeamAlreadyPlaying(awayTeam)) {
            throw new IllegalArgumentException("Multiple simultaneous matches are not allowed for the same team!");
        }
        activeGames.put(game.hashCode(), game);
    }

    public void finishGame(String homeTeam, String awayTeam) {
        Game game = new Game(homeTeam, awayTeam);
        activeGames.remove(game.hashCode());
    }

    public List<Game> getActiveGames() {
        return activeGames.values().stream().sorted(
                Comparator.reverseOrder()
        ).collect(Collectors.toList());
    }

    public void updateGameScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        Game game = new Game(homeTeam, awayTeam);

        Optional.ofNullable(activeGames.get(game.hashCode()))
                .ifPresentOrElse(g -> g.updateScore(homeScore, awayScore),
                        () -> {throw new NoSuchElementException("No such game found in the scoreboard!");});
    }

    private boolean isTeamAlreadyPlaying(String team) {
        return activeGames.values().stream().flatMap(game -> Stream.of(game.getHomeTeam(), game.getAwayTeam()))
                .anyMatch(t -> t.equals(team));
    }
}
