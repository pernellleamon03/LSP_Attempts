package org.howard.edu.lsp.finals.problem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class SongsDatabaseTest {

    private SongsDatabase db;

    @Before
    public void setUp() {
        db = new SongsDatabase();
        db.addSong("Hip Hop", "In da Club");
        db.addSong("Hip Hop", "Big Pimpin");
        db.addSong("Jazz", "Take Five");
    }

    @Test
    public void testAddSong() {
        System.out.println("Testing addSong method...");
        db.addSong("Hip Hop", "New Hip Hop Song");
        Set<String> hipHopSongs = db.getSongs("Hip Hop");

        assertEquals(3, hipHopSongs.size());
        assertEquals(true, hipHopSongs.contains("In da Club"));
        assertEquals(true, hipHopSongs.contains("Big Pimpin"));
        assertEquals(true, hipHopSongs.contains("New Hip Hop Song"));
        System.out.println("New song successfully added to the database.");
    }

    @Test
    public void testGetSongs() {
        System.out.println("Testing getSongs method...");
        Set<String> hipHopSongs = db.getSongs("Hip Hop");
        assertEquals(2, hipHopSongs.size());
        assertEquals(true, hipHopSongs.contains("In da Club"));
        assertEquals(true, hipHopSongs.contains("Big Pimpin"));

        Set<String> jazzSongs = db.getSongs("Jazz");
        assertEquals(1, jazzSongs.size());
        assertEquals(true, jazzSongs.contains("Take Five"));

        Set<String> popSongs = db.getSongs("Pop");
        assertEquals(0, popSongs.size());
        System.out.println("All songs in the database have been successfully retrieved.");
    }

    @Test
    public void testGetGenreOfSong() {
        System.out.println("Testing getGenreOfSong method...");
        assertEquals("Hip Hop", db.getGenreOfSong("In da Club"));
        assertEquals("Jazz", db.getGenreOfSong("Take Five"));
        assertNull(db.getGenreOfSong("Stairway to Heaven"));
        System.out.println("Genre of a song has been successfully retrieved.");
    }
    
    @Test
    public void testAddSongToNewGenre() {
        System.out.println("Testing adding a song to a new genre...");
        db.addSong("Rock", "Bohemian Rhapsody");
        Set<String> rockSongs = db.getSongs("Rock");

        assertEquals(1, rockSongs.size());
        assertEquals(true, rockSongs.contains("Bohemian Rhapsody"));
        System.out.println("New genre and song have been successfully added to the database.");
    }

    @Test
    public void testGetSongsForNonexistentGenre() {
        System.out.println("Testing getSongs for a nonexistent genre...");
        Set<String> countrySongs = db.getSongs("Country");
        assertEquals(0, countrySongs.size());
        System.out.println("Songs for a nonexistent genre have been successfully retrieved.");
    }

    @Test
    public void testGetGenreOfNonexistentSong() {
        System.out.println("Testing getGenreOfSong for a nonexistent song...");
        assertNull(db.getGenreOfSong("Purple Rain"));
        System.out.println("Genre of a nonexistent song has been successfully retrieved.");
    }

}
