/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tbpoo;

/**
 *
 * @author marcos
 */
public class Nacional extends Musicas{
    
   
    
    public Nacional(String nome, String duracao, Cantor cantor) {
        super(nome, duracao, cantor);
    }

    @Override
    public String exibe() {
        return "cantor: " + super.getcantor().getNome() + "\ninicio da carreira: "
                + super.getcantor().getAnoInicioCarreira() +"\nmusica: " + super.getNome() +
                "\nduração: " + super.getDuracao();
    }

    @Override
    public boolean isNacional() {
        return true;
    } 

    
    
}
