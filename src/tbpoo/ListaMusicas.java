package tbpoo;

import java.util.ArrayList;
import java.util.List;

public class ListaMusicas {
    
    private ArrayList<Musicas> music;

    public ListaMusicas() {
        music = new ArrayList<Musicas>();
    }
    
    public void adicionarMusica(Musicas m) {
        music.add(m);
    }
    

    public ArrayList<Musicas> getMusic() {
        return music;
    }
    
    
}
