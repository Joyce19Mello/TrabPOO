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
public class ListaUsuarios {
    private ArrayList<Usuario> listUser;

    public ListaUsuarios() {
        listUser = new ArrayList<Usuario>();
    }

    public ArrayList<Usuario> getUsuario() {
        return listUser;
    }
    
    public void adicionarUsuario(Usuario u) {
        listUser.add(u);
    }
    
    public Usuario procuraUsuario(String n){
    
    int i;
    for(i = 0; i < listUser.size(); i++) {
       if(listUser.get(i).getNome().equals(n))
           return listUser.get(i);
    }
    return null;
    }
    
}


