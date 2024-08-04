package tests.objects;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import src.classes.objects.Episodio;
import src.classes.objects.Podcast;

public class PodcastTest {

    @Test
    public void test() {
        Podcast podcast = new Podcast("O Reino Animal");

        podcast.addApresentador("Gilberto Souza");
        podcast.addApresentador("Lourenzo Silva");

        podcast.addEpisodio(new Episodio("Mistérios das Aranhas", 800, "Aranhas", "José Pinheiro"));
        podcast.addEpisodio(new Episodio("Mistérios das Abelhas", 1000.72, "Abelhas", "Matheus Barbosa"));
        podcast.addEpisodio(new Episodio("Biologia Animal", 650.30, "Biologia", "Richard Rasmussem"));

        assertTrue(podcast.getNome().equals("O Reino Animal"));

        assertTrue(podcast.getNomeApresentadores().get(0).equals("Gilberto Souza"));
        assertTrue(podcast.getNomeApresentadores().get(1).equals("Lourenzo Silva"));

        assertTrue(podcast.getEpisodios().get(0).getNome().equals("Mistérios das Aranhas"));
        assertTrue(podcast.getEpisodios().get(0).getDuracaoSegundos()==800);
        assertTrue(podcast.getEpisodios().get(0).getTema().equals("Aranhas"));
        assertTrue(podcast.getEpisodios().get(0).getNomeConvidado().equals("José Pinheiro"));

        assertTrue(podcast.getEpisodios().get(1).getNome().equals("Mistérios das Abelhas"));
        assertTrue(podcast.getEpisodios().get(1).getDuracaoSegundos()==1000.72);
        assertTrue(podcast.getEpisodios().get(1).getTema().equals("Abelhas"));
        assertTrue(podcast.getEpisodios().get(1).getNomeConvidado().equals("Matheus Barbosa"));

        assertTrue(podcast.getEpisodios().get(2).getNome().equals("Biologia Animal"));
        assertTrue(podcast.getEpisodios().get(2).getDuracaoSegundos()==650.30);
        assertTrue(podcast.getEpisodios().get(2).getTema().equals("Biologia"));
        assertTrue(podcast.getEpisodios().get(2).getNomeConvidado().equals("Richard Rasmussem"));
    }
}
