package com.afta.scoreboard.util;

import com.afta.scoreboard.entity.Game;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class ScoreboardValidator {
    public void checkIfTeamAlreadyPlays(List<Game> games, String team) {
        if (games.stream().flatMap(game -> Stream.of(game.getHomeTeam(), game.getAwayTeam()))
                .anyMatch(t -> t.equals(team))) {
            throw new IllegalArgumentException(String.format("Team '%s' is already playing!", team));
        }
    }

    public void checkGameExists(List<Game> games, Game game) {
        if (!games.contains(game)) {
            throw new NoSuchElementException("No such game found in the scoreboard!");
        }
    }

}
