//importando um método estático
import  static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class Util {

    private Bilhete[] bilhete = new Bilhete[5];
    private int index = 0;

    public void menu(){
    String aux = "Escolha uma opção\n";
    aux += "1 - emitir bilhete\n";
    aux += "2 - carregar bilhete\n";
    aux += "3 - consultar saldo\n";
    aux += "4 - Passar na catraca\n";
    aux += "5 - finalizar";
    int opcao;

    while(true){
    opcao = parseInt(showInputDialog(aux));
    if(opcao == 5){
        break;
    }
    if(opcao < 1 || opcao > 5){
        showMessageDialog(null, "Opção inválida");
    }
    else{
        switch(opcao){
            case 1:
                emitirBilhete();
                break;
        }
    }

    }

    }

    public void emitirBilhete(){
        String nome = showInputDialog("Nome:");
        String perfil = showInputDialog("Perfil --> comum, estudante ou professor");
        long cpf = parseLong(showInputDialog("CPF:"));
//        precisa criar o objeto usuário pq para o Bilhete eu preciso do parâmetro usuário
        Usuario usuario = new Usuario(nome, cpf, perfil);
        bilhete[index] = new Bilhete(usuario);
        index++;
    }



}
