import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);
    static ArrayList<Conta> contasBanco;

    public static void main(String[] args) {

        contasBanco = new ArrayList<Conta>();
        operacoes();

    }

    public static void operacoes() {
        System.out.println("----------------------------Bem vindo!---------------------------");
        System.out.println("-------------------------------ao--------------------------------");
        System.out.println("-----------------------------ReBank------------------------------");
        System.out.println("----------Digite número da operação que deseja realizar----------");
        System.out.println("------------------------");
        System.out.println("[   1 - Criar Conta    ]");
        System.out.println("[   2 - Depositar      ]");
        System.out.println("[   3 - Sacar          ]");
        System.out.println("[   4 - Transferir     ]");
        System.out.println("[   5 - Exibir         ]");
        System.out.println("[   6 - Sair           ]");

        int operacao = scan.nextInt();

        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                exbirContas();
                break;
            case 6:
                System.out.println("BRIGADA POR REALIZAR OPERAAÇÕES EM NOSSO BANCO");
                System.exit(0);

            default:
                System.out.println("Opção inválida! ");
                operacoes();// chamar o menu de operações novamente
                break;
        }
    }

    public static void criarConta() {
        System.out.println("\nNome: ");
        String nome = scan.next();

        System.out.println("\nCpf: ");
        String cpf = scan.next();

        System.out.println("\nEmail: ");
        String email = scan.next();

        Cliente cliente = new Cliente(nome, cpf, email);

        Conta cc = new ContaCorrente(cliente);
        Conta cp = new ContaPoupanca(cliente);

        contasBanco.add(cp);
        contasBanco.add(cc);
        System.out.println(nome + ", sua conta foi criada com sucesso!");

        operacoes();

    }

    /**
     * Metódo para encontrar conta destino de tranferencia
     */
    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if (contasBanco.size() > 0) {
            for (Conta contaDestino : contasBanco) {
                if (contaDestino.getNumero() == numeroConta)
                    ;
                conta = contaDestino;

            }
        }
        return conta;
    }

    public static void depositar() {
        System.out.println("Digite o número da conta: ");
        int numeroConta = scan.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual valor deseja depositar?");
            Double valorDeposito = scan.nextDouble();
            conta.depositar(numeroConta);
            System.out.println("Valor depositado com sucesso!");
        } else {
            System.out.println("Conta não encontrada...");
            System.out.println(" Tente novamente!");
        }
        operacoes();
    }

    public static void sacar() {
        System.out.print("Digite o número da conta em que deseja sacar: ");
        int numeroConta = scan.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual valor deseja sacar?");
            Double valorSaque = scan.nextDouble();
            conta.sacar(numeroConta);
            System.out.println("Valor sacado com sucesso!");
        } else {
            System.out.println(" Valor não dispoível...");
            System.out.println(" Tente novamente!");
        }
        operacoes();

    }

    public static void transferir() {
        System.out.print("Digite o número de sua conta: ");
        int numeroContaEnvio = scan.nextInt();

        Conta contaEnvio = encontrarConta(numeroContaEnvio);

        if (contaEnvio != null) {
            System.out.println("Qual é número da conta que deseja realizar um transferencia?");
            Double numeroContaRecebimento = scan.nextDouble();

            contaEnvio.transferir(numeroContaRecebimento, contaEnvio);

            System.out.println("Qual valor deseja tranferir?");
            Double valortransferencia = scan.nextDouble();
            System.out.println("Tranferencia realizada com sucesso");
        }

        else {
            System.out.println(" Deculpe, não encontramos essa conta...");
            System.out.println(" Tente novamente!");
        }
        operacoes();

    }

    public static void exbirContas() {
        if (contasBanco.size() > 0) {
            for (Conta conta : contasBanco) {
                System.out.println(conta);
            }
        } else {
            System.out.println("Não há contas cadastradas!");
        }
        operacoes();
    }
}
