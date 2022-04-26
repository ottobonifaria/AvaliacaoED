package domain;

public class Relatorio {

    private String nome;
    private String veiculoAlugado;
    private String dataEmprestimo;
    private String horaEmprestimo;
    private String dataDevolucao;
    private String horaDevolucao;
    private String marca;
    private String modelo;
    private String placa;
    private boolean alugado;

    public Relatorio(String nome, String veiculoAlugado, String dataEmprestimo, String horaEmprestimo,
                     String dataDevolucao, String horaDevolucao, String marca, String modelo, String placa,
                     boolean alugado) {
        this.nome = nome;
        this.veiculoAlugado = veiculoAlugado;
        this.dataEmprestimo = dataEmprestimo;
        this.horaEmprestimo = horaEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.horaDevolucao = horaDevolucao;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.alugado = alugado;
    }

    @Override
    public String toString() {
        return "RelatorioController{" +
                "nome='" + nome + '\'' +
                ", veiculoAlugado='" + veiculoAlugado + '\'' +
                ", dataEmprestimo='" + dataEmprestimo + '\'' +
                ", horaEmprestimo='" + horaEmprestimo + '\'' +
                ", dataDevolucao='" + dataDevolucao + '\'' +
                ", horaDevolucao='" + horaDevolucao + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", placa='" + placa + '\'' +
                '}';
    }
}
