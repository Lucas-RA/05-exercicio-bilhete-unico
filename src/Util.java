//importando um método estático
import  static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;

public class Util {
//    possui uma alocação de memória estática - não vai aumentar nem diminuir
//    antes de inserir, verifique se existe espaço
    private Bilhete[] bilhete = new Bilhete[3];
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
            case 2:
                carregarBilhete();
                break;
            case 3:
                consultarSaldo();
                break;
            case 4:
                passarNaCatraca();


        }
    }

    }

    }

    public void emitirBilhete(){
//        verificar se o vetor possui espaço
        if(index < bilhete.length){
            String nome = showInputDialog("Nome:");
            String perfil = showInputDialog("Perfil --> comum, estudante ou professor");
            long cpf = parseLong(showInputDialog("CPF:"));
//        precisa criar o objeto usuário pq para o Bilhete eu preciso do parâmetro usuário
            Usuario usuario = new Usuario(nome, cpf, perfil);
            bilhete[index] = new Bilhete(usuario);
            index++;
        }
        else{
            showInputDialog(null, "Bilhete não emitido");
        }
    }

    public void carregarBilhete(){
        int posicao = pesquisa();
        if(posicao != -1){
            double valor = parseDouble(showInputDialog(null, "Insira o valor para carregar o Bilhete: "));
            bilhete[posicao].carregar(valor);

            showMessageDialog(null, "Carregado com sucesso");
        }
        else{
            showMessageDialog(null, "CPF não encontrado");
        }

    }

    public void consultarSaldo(){
    int posicao = pesquisa();
    if(posicao == -1){
        showMessageDialog(null, "CPF não encontrado");
    }
    else{
        showMessageDialog(null, bilhete[posicao].consultarSaldo());
    }
    }

public void passarNaCatraca(){
        int posicao = pesquisa();
        if (posicao != -1){
            showMessageDialog(null, bilhete[posicao].passarNaCatraca());
        }

}

    public int pesquisa(){
        long cpf = parseLong(showInputDialog("CPF para pesquisa:"));
        for(int i = 0; i < index; i++){
            if(bilhete[i].usuario.cpf == cpf){
                return i;
            }
        }
        return -1;
    }
}
