package com.afta.scoreboard.entity;

import com.afta.scoreboard.util.ScoreboardValidator;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Entity class representing the scoreboard
 */
public class Scoreboard {
    private final ScoreboardValidator validator = new ScoreboardValidator();
    private final LinkedList<Game> activeGames = new LinkedList<>();

    /**
     * Starts a new game and adds it to the scoreboard
     * @param homeTeam home team name
     * @param awayTeam away team name
     * @throws IllegalArgumentException if team name is null, blank or empty
     * @throws IllegalArgumentException if there already exists a game where one of the named teams is playing
     */
    public void startGame(String homeTeam, String awayTeam) {
        Game game = new Game(homeTeam, awayTeam);
        validator.checkIfTeamAlreadyPlays(activeGames, homeTeam);
        validator.checkIfTeamAlreadyPlays(activeGames, awayTeam);
        activeGames.addFirst(game);
    }

    /**
     * Finishes and removes a game from the scoreboard.
     * If the game is not found nothing happens.
     * @param homeTeam home team name
     * @param awayTeam away team name
     */
    public void finishGame(String homeTeam, String awayTeam) {
        Game game = new Game(homeTeam, awayTeam);
        activeGames.remove(game);
    }

    /**
     * Provides sorted running scoreboard games list
     *
     * @return list of scoreboard games sorted by their total score (highest on top) and actuality (most recent on top)
     */
    public List<Game> getActiveGames() {
        return activeGames.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    /**
     * Updates the score of the running game in the score board
     * @param homeTeam of the game
     * @param awayTeam of the game
     * @param homeScore new home team score as absolute value
     * @param awayScore new away team score as absolute value
     * @throws NoSuchElementException if no running game is found for the given team names
     * @throws IllegalArgumentException if the given score is a negative number or is lower than previous score value
     */
    public void updateGameScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        Game game = new Game(homeTeam, awayTeam);
        validator.checkGameExists(activeGames, game);
        activeGames.get(activeGames.indexOf(game)).updateScore(homeScore, awayScore);
    }
}
