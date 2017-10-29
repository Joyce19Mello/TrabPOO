
package tbpoo;

public abstract class Musicas {
    
    private String nome;
    private String duracao;
    private Cantor cantor;

    public Musicas(String nome, String duracao, Cantor cantor) {
        this.nome = nome;
        this.duracao = duracao;
        this.cantor = cantor;
    }

    
    
    public abstract String exibe();
    
    public abstract boolean isNacional();
    
    public String getNome() {
        return nome;
    }

    public String getDuracao() {
        return duracao;
    }

    public Cantor getcantor() {
        return cantor;
    }
    
    @Override
    public String toString(){
        return cantor.getNome() + " : " + nome;
    }
}
