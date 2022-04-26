package controller;

import domain.Cliente;
import domain.Veiculo;
import java.util.LinkedList;
public class RelatorioController {

    public void imprimeFilaDeEspera(LinkedList<Cliente> filial){

        for (Cliente cliente: filial){
            System.out.println("Nome: " + cliente.getNome() + " Modelo: " + cliente.getVeiculoDesejado());
        }
    }
    public void relatorioFiliais(Veiculo[] veiculos, LinkedList<Cliente> filaDeEspera){
        int contaAlugado=0;
        int valorTotalDiaria =0;
        System.out.println("Quantidade de Veiculos: " + veiculos.length);
        for (int i = 0; i < veiculos.length; i++) {
            if (veiculos[i] != null && veiculos[i].isAlugado() == true) {
                contaAlugado ++;
                valorTotalDiaria += veiculos[i].getValorDaDiaria();
            }
        }
        System.out.println("Quantidade de Veiculos Alugados: " + contaAlugado);
        System.out.println("Quantidade Clientes na lista de espera: "  + filaDeEspera.size());
        System.out.println("Valor Total de Diarias: R$ "+ valorTotalDiaria);
    }

}