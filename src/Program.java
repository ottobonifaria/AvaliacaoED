import controller.ClienteController;
import controller.RelatorioController;
import controller.VeiculoController;
import domain.Cliente;
import domain.Filial;
import domain.Veiculo;

import java.util.*;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        int menu;

        // Filial 1
        Veiculo[] veiculosFilial1 = geraVeiculosFilial1();
        Cliente[] clientesFilial1 = geraClientesFilial1();

        // Filial 2
        Veiculo[] veiculosFilial2 = geraVeiculosFilial2();
        Cliente[] clientesFilial2 = geraClientesFilial2();

        // Controllers
        VeiculoController veiculoController = new VeiculoController();
        ClienteController clienteController = new ClienteController();
        RelatorioController relatorioController = new RelatorioController();

        LinkedList<Cliente> filaDeEsperaFilial1 = new LinkedList<>();
        LinkedList<Cliente> filaDeEsperaFilial2 = new LinkedList<>();

        Filial filial = new Filial();

        do {
            exibirMenu();
            menu = sc.nextInt();
            switch (menu) {

                case 1:
                    System.out.println("\n============================== FIFTCARS ================================== \n Confira nossos modelos\n");
                    System.out.println("===============> LISTA DE VEICULOS CADASTRADOS - FILIAL 01 <================\n");
                    veiculoController.listarVeiculos(veiculosFilial1);
                    System.out.println("");
                    System.out.println("===============> LISTA DE VEICULOS CADASTRADOS - FILIAL 02 <================\n");
                    veiculoController.listarVeiculos(veiculosFilial2);
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("=============== LISTA DE CLIENTES CADASTRADOS - FILIAL 01 ==================\n");
                    clienteController.listarClientes(clientesFilial1);
                    System.out.println("");
                    System.out.println("=============== LISTA DE CLIENTES CADASTRADOS - FILIAL 02 ==================\n");
                    clienteController.listarClientes(clientesFilial2);
                    System.out.println("");
                    break;
                case 3:
                    veiculoController.ordenarVeiculos(veiculosFilial1);
                    veiculoController.ordenarVeiculos(veiculosFilial2);
                    System.out.println("");
                    System.out.println("========> LISTA DE VEICULOS ORDENADOS POR MENOR VALOR - FILIAL 01 <==========\n");
                    veiculoController.listarVeiculos(veiculosFilial1);
                    System.out.println("");
                    System.out.println("========> LISTA DE VEICULOS ORDENADOS POR MENOR VALOR - FILIAL 02 <==========\n");
                    veiculoController.listarVeiculos(veiculosFilial1);
                    System.out.println("");
                    break;
                case 4:
                    System.out.println("=========== LISTA DE VEICULOS DISPONIVEIS PARA ALUGAR - FILIAL 01 ==========\n");
                    veiculoController.listarVeiculosDisponiveis(veiculosFilial1);
                    System.out.println("");
                    System.out.println("=========== LISTA DE VEICULOS DISPONIVEIS PARA ALUGAR - FILIAL 02 ==========\n");
                    veiculoController.listarVeiculosDisponiveis(veiculosFilial2);
                    System.out.println("");
                    break;
                case 5:
                    System.out.println("================= CADASTRANDO LISTA DE ESPERA - FILIAL 01 ===================\n");
                    clienteController.AddListaEspera(filaDeEsperaFilial1, clientesFilial1);
                    relatorioController.imprimeFilaDeEspera(filaDeEsperaFilial1);
                    System.out.println("================= CADASTRANDO LISTA DE ESPERA - FILIAL 02 ===================\n");
                    clienteController.AddListaEspera(filaDeEsperaFilial2, clientesFilial2);
                    relatorioController.imprimeFilaDeEspera(filaDeEsperaFilial2);
                    break;
                case 6:
                    System.out.println("========================= FILA DE ESPERA - FILIAL 01 =======================\n");
                    relatorioController.imprimeFilaDeEspera(filaDeEsperaFilial1);
                    System.out.println("");
                    System.out.println("========================= FILA DE ESPERA - FILIAL 02 =======================\n");
                    relatorioController.imprimeFilaDeEspera(filaDeEsperaFilial2);
                    System.out.println("");
                    break;
                case 7:
                    //Aluga veiculo para o primeiro da lista de espera
                    System.out.println("PARA QUAL FILIAL O VEICULO SER?? ALUGADO? 1 ou 2");
                    int numFilial = sc.nextInt();
                    switch (numFilial) {
                        case 1 -> {
                            filial.setFilialNumero(1);
                            veiculoController.emprestarVeiculo(filaDeEsperaFilial1, clientesFilial1, veiculosFilial1, filial);
                            veiculoController.relatorioLoca????o();
                        }
                        case 2 -> {
                            filial.setFilialNumero(2);
                            veiculoController.emprestarVeiculo(filaDeEsperaFilial2, clientesFilial2, veiculosFilial2, filial);
                            veiculoController.relatorioLoca????o();
                        }
                        default -> System.out.println("Entrada inv??lida");
                    }
                    break;
                case 8:
                    System.out.println("=============================== DEVOLU????O ===================================");
                    System.out.println("PARA QUAL FILIAL O VEICULO SER?? DEVOLVIDO? 1 ou 2");
                    numFilial = sc.nextInt();
                    switch (numFilial) {
                        case 1 -> {
                            filial.setFilialNumero(1);
                            veiculoController.devolverVeiculo(filaDeEsperaFilial1, clientesFilial1, veiculosFilial1, filial);
                            veiculoController.relatorioLoca????o();
                        }
                        case 2 -> {
                            filial.setFilialNumero(2);
                            veiculoController.devolverVeiculo(filaDeEsperaFilial2, clientesFilial2, veiculosFilial2, filial);
                            veiculoController.relatorioLoca????o();
                        }
                        default -> System.out.println("Entrada inv??lida");
                    }
                    break;
                case 9:
                    System.out.println("PARA QUAL FILIAL DESEJA O RELATORIO? 1 ou 2");
                    numFilial = sc.nextInt();
                    switch (numFilial) {
                        case 1 -> {
                            veiculoController.relatorioLoca????o();
                            System.out.println("");
                            System.out.println("====================== RELAT??RIO DE LOCA????O - FILIAL 01 ==============\n");
                            relatorioController.relatorioFiliais(veiculosFilial1, filaDeEsperaFilial1);
                            System.out.println("");
                                               }
                        case 2 -> {
                            veiculoController.relatorioLoca????o();
                            System.out.println("");
                            System.out.println("====================== RELAT??RIO DE LOCA????O - FILIAL 02 ==============\n");
                            relatorioController.relatorioFiliais(veiculosFilial2, filaDeEsperaFilial2);
                            System.out.println("");
                        }
                        default -> System.out.println("Entrada inv??lida");
                    }
                    break;
                case 10:
                    break;
                default:
                    System.out.println("Op????o Inv??lida");
            }
        }
        while (menu != 10);
    }

    private static Veiculo[] geraVeiculosFilial1() {
        Veiculo[] veiculos = new Veiculo[5];
        veiculos[0] = new Veiculo("Ford", "KA", "Preto", "FFF-1234",
                90, false);
        veiculos[1] = new Veiculo("Toyota", "HILUX", "Prata", "BBB-1234",
                500, false);
        veiculos[2] = new Veiculo("VW", "FOX", "Branco", "EEE-1234",
                140, false);
        veiculos[3] = new Veiculo("Ford", "EcoSport", "Cinza", "DDD-1234",
                150, false);
        veiculos[4] = new Veiculo("Renault", "SANDERO", "Prata", "KKK-1234",
                220, false);
        return veiculos;
    }

    private static Veiculo[] geraVeiculosFilial2() {
        Veiculo[] veiculos = new Veiculo[5];
        veiculos[0] = new Veiculo("Fiat", "TORO", "Preta", "AAA-1234",
                300, false);
        veiculos[1] = new Veiculo("GM", "Celta", "Verde", "GGG-1234",
                95, false);
        veiculos[2] = new Veiculo("Hyunday", "HB20", "Branca", "CCC-1234",
                100, false);
        veiculos[3] = new Veiculo("Fiat", "ARGO", "Preto", "III-1234",
                210, false);
        veiculos[4] = new Veiculo("GM", "Cruse", "Preto", "HHH-1234",
                255, false);
        return veiculos;
    }

    private static Cliente[] geraClientesFilial1() {
        Cliente[] clientes = new Cliente[4];
        clientes[0] = (new Cliente("Jorge", "011-2212-4563",
                "Rua do cafe , numero 100, Centro - S??o Paulo", "SANDERO", null));
        clientes[1] = (new Cliente("Joaquim", "011-2222-4563",
                "Rua do A??ucar , numero 2, Centro - S??o Paulo", "HILUX", null));
        clientes[2] = (new Cliente("Marcio", "011-2222-4563",
                "Rua do A??ucar , numero 2, Centro - S??o Paulo", "EcoSport", null));
        clientes[3] = (new Cliente("Mario", "011-2222-4563",
                "Rua do Verde , numero 12, Centro - S??o Paulo", "FOX", null));
        return clientes;
    }

    private static Cliente[] geraClientesFilial2() {
        Cliente[] clientes = new Cliente[4];
        clientes[0] = (new Cliente("Jo??o", "011-1234-5678",
                "Rua um, numero 123, Vila Mimosa- S??o Paulo", "TORO", null));
        clientes[1] = (new Cliente("Maria", "011-3333-5432",
                "Rua dois, numero 321, Vila Cesar - S??o Paulo", "HB20", null));
        clientes[2] = (new Cliente("Beto", "011-2222-4563",
                "Rua vinte , numero 333, Centro - S??o Paulo", "CRUSE", null));
        clientes[3] = (new Cliente("Norberto", "011-2212-4563",
                "Rua do Lirio , numero 90, Centro - S??o Leopoldo", "ARGO", null));
        return clientes;
    }

    static public void exibirMenu() {
        System.out.println("=========================================================================================");
        System.out.println("|                                LOCADORA FIFTCARS                                      |");
        System.out.println("=========================================================================================");
        System.out.println(" 1 - LISTA VEICULOS CADASTRADOS         |   2 - LISTA CLIENTES CADASTRADOS");
        System.out.println(" 3 - ORDENA  VEICULOS PELO MENOR VALOR  |   4 - CONSULTA VEICULO DISPONIVEL PARA ALUGAR");
        System.out.println(" 5 - CADASTRA LISTA DE ESPERA           |   6 - CONSULTA LISTA DE ESPERA");
        System.out.println(" 7 - ALUGA VEICULO                      |   8 - DEVOLVE VEICULO");
        System.out.println(" 9 - RELATORIO DAS FILIAIS              |  10 - SAIR");
        System.out.println("=========================================================================================");
    }
}