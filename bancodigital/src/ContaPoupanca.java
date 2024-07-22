public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void imprimirExtraro() {
        // TODO Auto-generated method stub
        System.out.println("Extrato conta poupança: ");
        super.imprimirAtributos();
    }
}
