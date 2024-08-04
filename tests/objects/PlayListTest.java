package tests.objects;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import src.classes.objects.Musica;
import src.classes.objects.PlayList;

public class PlayListTest {
    
    @Test
    public void test() {
        PlayList playlist = new PlayList("Músicas Favoritas");

        playlist.addColaborador("Caique Duarte");
        playlist.addColaborador("Victor Afonso");

        playlist.addMusica(new Musica("Eyes Closed", 192, "Imagine Dragons", "Pop"));
        playlist.addMusica(new Musica("Fearless", 188.4, "Lost Sky", "Eletrônica"));
        playlist.addMusica(new Musica("Glass Heart", 206.4, "Caskets", "Metalcore"));
        playlist.addMusica(new Musica("Love Game", 201.6, "Lady Gaga", "Pop"));

        assertTrue(playlist.getNome().equals("Músicas Favoritas"));
        assertTrue(playlist.getNomeColaboradores().get(0).equals("Caique Duarte"));
        assertTrue(playlist.getNomeColaboradores().get(1).equals("Victor Afonso"));

        assertTrue(playlist.getMusicas().get(0).getNome().equals("Eyes Closed"));
        assertTrue(playlist.getMusicas().get(0).getDuracaoSegundos()==192);
        assertTrue(playlist.getMusicas().get(0).getArtista().equals("Imagine Dragons"));
        assertTrue(playlist.getMusicas().get(0).getGenero().equals("Pop"));

        assertTrue(playlist.getMusicas().get(1).getNome().equals("Fearless"));
        assertTrue(playlist.getMusicas().get(1).getDuracaoSegundos()==188.4);
        assertTrue(playlist.getMusicas().get(1).getArtista().equals("Lost Sky"));
        assertTrue(playlist.getMusicas().get(1).getGenero().equals("Eletrônica"));

        assertTrue(playlist.getMusicas().get(2).getNome().equals("Glass Heart"));
        assertTrue(playlist.getMusicas().get(2).getDuracaoSegundos()==206.4);
        assertTrue(playlist.getMusicas().get(2).getArtista().equals("Caskets"));
        assertTrue(playlist.getMusicas().get(2).getGenero().equals("Metalcore"));

        assertTrue(playlist.getMusicas().get(3).getNome().equals("Love Game"));
        assertTrue(playlist.getMusicas().get(3).getDuracaoSegundos()==201.6);
        assertTrue(playlist.getMusicas().get(3).getArtista().equals("Lady Gaga"));
        assertTrue(playlist.getMusicas().get(3).getGenero().equals("Pop"));
    }
}
