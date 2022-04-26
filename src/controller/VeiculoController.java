package controller;

import domain.Cliente;
import domain.Filial;
import domain.Veiculo;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class VeiculoController {
    public static Stack<String> logEmprestimos = new Stack<>();
    public void listarVeiculos(Veiculo[] veiculos) {
        for (int i = 0; i < veiculos.length; i++) {
            if (veiculos[i] != null) {
                System.out.println(" Veiculo: " + (i + 1) + " --> " + veiculos[i].toString());
            }
        }
    }
    public void ordenarVeiculos(Veiculo[] veiculos) {
        Arrays.sort(veiculos);
    }
    public void listarVeiculosDisponiveis(Veiculo[] veiculos) {

        for (int i = 0; i < veiculos.length; i++) {
            if (veiculos[i] != null && veiculos[i].isAlugado() == false) {
                System.out.println(" Veiculo: " + (i + 1) + " --> " + veiculos[i].toString());
            }
        }
    }
    public void emprestarVeiculo(LinkedList<Cliente> filaDeEspera, Cliente[] clientes, Veiculo[] veiculos, Filial filial) {

        for (int i = 0; i < 4; i++) {
            if (filaDeEspera.getFirst().getNome().equals(clientes[i].getNome())) {
                for (Veiculo veiculo : veiculos) {
                    if ((veiculo.getModelo().equals(clientes[i].getVeiculoDesejado())) && veiculo.isAlugado() == false) {
                        veiculo.setAlugado(true);
                        clientes[i].setVeiculoAlugado(veiculo.getModelo());
                        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy à's' HH:mm:ss");
                        logEmprestimos.push(dateFormat.format(Calendar.getInstance().getTime()) + ": Carro " +
                                veiculo.getMarca() + ", " + veiculo.getModelo() + ", " + veiculo.getPlaca()
                                + ", foi EMPRESTADO para " + filaDeEspera.getFirst().getNome() + " Pela filial " + filial.getFilialNumero());
                    }
                }
                filaDeEspera.removeFirst();
                break;
            }
        }
    }
    public void devolverVeiculo(LinkedList<Cliente> filaDeEspera, Cliente[] clientes, Veiculo[] veiculos, Filial filial) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Digite o nome do cliente");
        String nome = sc.next();

        for (int i = 0; i < 4; i++) {
            try {
                if (nome.equals(clientes[i].getNome())) {
                    for (Veiculo veiculo : veiculos) {
                        if ((clientes[i].getVeiculoAlugado().equals(veiculo.getModelo())) && (veiculo.isAlugado()) == true) {
                            veiculo.setAlugado(false);
                            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy à's' HH:mm:ss"); //formatar a data como 12/04/2022 às 16:37:15
                            logEmprestimos.push(dateFormat.format(Calendar.getInstance().getTime()) + ": Carro " +
                                    veiculo.getMarca() + ", " + veiculo.getModelo() + ", " + veiculo.getPlaca()
                                    + ", foi DEVOLVIDO por " + nome + " Pela filial " + filial.getFilialNumero());
                        }
                    }
                    filaDeEspera.addLast(clientes[i]);
                    break;
                }
            }catch (NullPointerException e){
                System.out.printf("LISTA VAZIA\n");
            };
        }
    }
    public void relatorioLocação() {
        System.out.println("============================== LOG DE LOCAÇÃO ===============================");
        logEmprestimos.forEach(System.out::println);
    }

}