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
public class Internacional extends Musicas{
    
    
    private String pais;
    

    public Internacional(String pais, String nome, String duracao, Cantor cantor) {
        super(nome, duracao, cantor);
        this.pais = pais;
    }

    @Override
    public String exibe() {
        return "cantor: " + super.getcantor().getNome() + "\ninicio da carreira: "
                + super.getcantor().getAnoInicioCarreira() + "\nmusica: " + super.getNome() +
                "\nduração: " + super.getDuracao() + "\nPaís: " + pais;
    }
    
    public String getPais() {
        return pais;
    }
    
    @Override
    public boolean isNacional() {
        return false;
    }

    
}
