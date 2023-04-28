package org.howard.edu.lsp.finals.problem;

import java.util.*;

public class SongsDatabase {

    private Map<String, Set<String>> genreToSongsMap = new HashMap<>();

    public void addSong(String genre, String songTitle) {
        Set<String> songs = genreToSongsMap.get(genre);
        if (songs == null) {
            songs = new HashSet<>();
            genreToSongsMap.put(genre, songs);
        }
        songs.add(songTitle);
    }

    public Set<String> getSongs(String genre) {
        Set<String> songs = genreToSongsMap.get(genre);
        return songs == null ? Collections.emptySet() : new HashSet<>(songs);
    }

    public String getGenreOfSong(String songTitle) {
        for (Map.Entry<String, Set<String>> entry : genreToSongsMap.entrySet()) {
            if (entry.getValue().contains(songTitle)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
