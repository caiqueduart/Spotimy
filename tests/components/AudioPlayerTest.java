package tests.components;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import src.classes.components.AudioPlayer;
import src.classes.objects.Musica;
import src.classes.objects.Episodio;

public class AudioPlayerTest {

    @Test
    public void testPlayMusic() {
        Musica musica = new Musica("Eyes Closed", 192, "Imagine Dragons", "Pop");
        
        try {
            AudioPlayer.playMusic(musica);
            assertTrue(true);
        } catch (Exception e) {
            fail("O método lançou uma exceção: " + e.getMessage());
        }
    }

    @Test
    public void testPlayEpisodio() {
        Episodio episodio = new Episodio("Introduction to AI", 3600, "John Doe", "Artificial Intelligence");
        
        try {
            AudioPlayer.playEpisodio(episodio);
            assertTrue(true);
        } catch (Exception e) {
            fail("O método lançou uma exceção: " + e.getMessage());
        }
    }
}
