public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void imprimirExtraro() {

        System.out.println("Extrato conta poupança: ");
        super.imprimirAtributos();
    }

}
