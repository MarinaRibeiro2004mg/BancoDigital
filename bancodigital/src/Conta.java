public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 0001; // como privada não podemos acessar na classe filha? Usando o
                                                    // protected podemos usar em classes filhas
    private static int SEQUENCIAL = 1; // constante = uma classe static é uma informação que tenha relaçao com a classe
                                       // conrta corrente (GERAR UM VALOR SEQUENCIAL)
    private Cliente cliente;

    protected int agencia;
    protected int numero;
    protected double saldo;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++; // para criar um novo numero de agencia diferente do ultimo
    }

    @Override
    public void depositar(double valor) {
        // TODO Auto-generated method stub
        saldo += valor;
    }

    @Override
    public void sacar(double valor) {
        // TODO Auto-generated method stub
        saldo -= valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        // TODO Auto-generated method stub
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void imprimirAtributos() {
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Conta: %d", this.numero));
        System.out.println(String.format("Saldo: %2f", this.saldo));
    }

}
