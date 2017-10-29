package tbpoo;

import java.util.ArrayList;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Principal {

//    static void imprimir (Musicas m){
//        System.out.printf("%s\n\n", m.exibe());
//    }
    
    
    static Usuario login(ListaUsuarios l){
        
        Usuario usuario;
        do{
            
            
            Scanner ler = new Scanner(System.in);
            String nome = JOptionPane.showInputDialog(null, "digite usuario", "login", JOptionPane.INFORMATION_MESSAGE);

            usuario = l.procuraUsuario(nome);

            if (usuario == null) JOptionPane.showMessageDialog(null, "usuario não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
           
        }while(usuario == null);
        
        String senha;
        do{
           senha = JOptionPane.showInputDialog(null, "digite a senha", "login", JOptionPane.INFORMATION_MESSAGE);
           if(!senha.equals(usuario.getSenha()))JOptionPane.showMessageDialog(null, "senha incorreta", "Erro", JOptionPane.ERROR_MESSAGE); 
        
        }while(!senha.equals(usuario.getSenha()));
        
        return usuario;
    }
    
    
    static int menu(Usuario u){
        int opcao;
        String resposta = JOptionPane.showInputDialog(null,
                "Olá " + u.getNome() + "\n\n1 - adicionar prediletas\n2 - ver prediletas \n3 - sair\n4 - trocar usuario\nEscolha uma opção:",
                "cadastro de musicas",
                JOptionPane.INFORMATION_MESSAGE);
            opcao = Integer.parseInt(resposta);
            
        return opcao;
    }
    
    static Musicas selecionaPrediletas(ArrayList<Musicas> l){
        
        Object[] musicasExibidas = l.toArray(); // transforma a lista num Array pra exibir na comobox
        
        Musicas m = (Musicas)JOptionPane.showInputDialog(null, "Informe a música que deseja favoritar",
                "Músicas", JOptionPane.INFORMATION_MESSAGE, null,
                musicasExibidas, musicasExibidas[0]);//exibe comobox
        
        
        return m; //retorna a musica selecionada
        
        
    }
    
    static void exibePrediletas(ArrayList<Musicas> l){
        
        Object[] musicasExibidas = l.toArray(); //passa a lista pra um Array pra exibir na comobox
        Musicas m;
        do{
            m = (Musicas)JOptionPane.showInputDialog(null, "escolha uma musica para ver os detalhes",
                    "Prediletas", JOptionPane.INFORMATION_MESSAGE, null,
                    musicasExibidas, musicasExibidas[0]);//exibe comobox
        
                
            if (m != null) JOptionPane.showMessageDialog(null, m.exibe()); //exibe informaçoes de uma musica selecionada
        
        }while(m != null);
    }
    
    public static void main(String[] args){
        
       
        // lista onde serão armazenadas todas as musicas
        ListaMusicas listaMusica = new ListaMusicas();
        
        ListaUsuarios listaUsuario = new ListaUsuarios();
        
        listaUsuario.adicionarUsuario(new Usuario("Joyce","1"));
        listaUsuario.adicionarUsuario(new Usuario("Rafaella","2"));
        listaUsuario.adicionarUsuario(new Usuario("Marcos","3"));
        listaUsuario.adicionarUsuario(new Usuario("Daniel","4"));
        
        
        Usuario  usuario = login(listaUsuario);
          
        
        //innserção de musicas nacionais
        listaMusica.adicionarMusica(new Nacional("menino da proteira", "04:05",new Cantor("Daniel",1990)));
        listaMusica.adicionarMusica(new Nacional("deixa que ela decide", "04:27",new Cantor("Pedro Paulo e Alex",2005)));
        listaMusica.adicionarMusica(new Nacional("Eu e Você", "04:01",new Cantor("Zezé de Camargo e Luciano", 1985)));
        listaMusica.adicionarMusica(new Nacional("Deixa Brilhar", "03:27",new Cantor("Fernando e Sorocaba",2000)));
        listaMusica.adicionarMusica(new Nacional("Modo Modão", "02:55",new Cantor("Gabriel Gava",2010)));
        listaMusica.adicionarMusica(new Nacional("Novinha Vai no Chão", "03:37",new Cantor("Safadão",2012)));
        //inserção de musicas internacionais
        listaMusica.adicionarMusica(new Internacional("Tanzandia","How can i go on", "03:27",new Cantor("Freddie Mercury",1970)));
        listaMusica.adicionarMusica(new Internacional("Estados Unidos","Patiente", "03:27",new Cantor("Guns N' Roses",1973)));
        listaMusica.adicionarMusica(new Internacional("Alemanha","You And I", "03:27",new Cantor("Scorpions",1988)));
        listaMusica.adicionarMusica(new Internacional("Estados Unidos","Misunderstood", "03:27",new Cantor("Bon Jovi",1990)));
        listaMusica.adicionarMusica(new Internacional("Coreia do Sul","Gangnam Style", "03:27",new Cantor("PSY",2011)));
        
        
        int op; //controle do switch
      
        do {
            op = menu(usuario); //recebe uma opção do menu
            switch (op) {
                case 1: // add musica às prediletas
                    Musicas a;
                    do{ 
                        a = selecionaPrediletas(listaMusica.getMusic());//coloca dentro de "a" uma musica selecionada
                        if(a != null){//se a musica não for null, adiciona musica
                            if(a.isNacional() == true) usuario.addPredileta(a); // se musica for nacional, add às nacionais
                            else usuario.addPredileta(a); // senão, add às internacionais
                        }
                    }while(a != null);//enquanto nao cancelar ou fechar a janelinha
                    break;
                case 2: //exibe lista de prediletas e informaçoes sobre uma musica escolhida
                    exibePrediletas(usuario.getLista());
                    break;
                case 3://sair(adeus)
                    JOptionPane.showMessageDialog(null, "volte sempre " + usuario.getNome() + "!", "Cadastro de Músicas", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 4:
                    usuario = login(listaUsuario);
                    break;
                default://erro, digite outra opção
                    JOptionPane.showMessageDialog(null, "Opção inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (op != 3); // enqto nao digitar a opção 3(sair) o looop não para
    }
    
}
