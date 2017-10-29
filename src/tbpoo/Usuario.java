/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tbpoo;

import java.util.ArrayList;

/**
 *
 * @author joyce
 */
public class Usuario {
    private String nome;
    private String senha;
    private ListaMusicas prediletas = new ListaMusicas();

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }


    public void addPredileta(Musicas m) {
        prediletas.adicionarMusica(m);
    }
    
   public ArrayList<Musicas> getLista(){
       return prediletas.getMusic();
   }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }
   
   
    
    
    
}
