import java.util.Random;

public class Bilhete {
    static final double TARIFA = 5.20;
    long numero;
    double saldo;
//    declaração do objeto como atributo
    Usuario usuario;

    public Bilhete(Usuario usuario) {
     numero = gerarNumero();
     this.usuario = usuario;
    }

    public long gerarNumero(){
//        instanciar objeto random
        Random random = new Random();
        return random.nextLong(1000, 10000);
    }

//    método para carregar o bilhete
    public void carregar(double saldo){
        this.saldo += saldo;
    }
//    método para consultar o saldo do bilhete
//    vai retornar o saldo
    public double consultarSaldo(){
        return saldo;
}
//    método para passar na catraca
//    não precisa passar parâmetros pois já estão todos aqui
    public String passarNaCatraca(){
        double debito = TARIFA / 2;
        if(usuario.perfil.equalsIgnoreCase("comum")){
            debito = TARIFA;
        }
        if(saldo >= debito){
            saldo -= debito;
            return "Catraca LIBERADA!";
        }
        return "Sem Saldo. RECARREGUE seu Bilhete!";
    }


}
