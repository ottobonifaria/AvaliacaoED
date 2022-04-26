package domain;

public class Filial {
    private int filialNumero;
    private int quantidadeTotalVeiculos;
    private int quantidadeVeiculosAlugados;
    private int quantidadeClientesFilaEspera;
    private int valorTotalDeDiarias;


    public Filial() {
    }

    public int getFilialNumero() {
        return filialNumero;
    }

    public void setFilialNumero(int filialNumero) {
        this.filialNumero = filialNumero;
    }

    public int getQuantidadeTotalVeiculos() {
        return quantidadeTotalVeiculos;
    }

    public void setQuantidadeTotalVeiculos(int quantidadeTotalVeiculos) {
        this.quantidadeTotalVeiculos = quantidadeTotalVeiculos;
    }

    public int getQuantidadeVeiculosAlugados() {
        return quantidadeVeiculosAlugados;
    }

    public void setQuantidadeVeiculosAlugados(int quantidadeVeiculosAlugados) {
        this.quantidadeVeiculosAlugados = quantidadeVeiculosAlugados;
    }

    public int getQuantidadeClientesFilaEspera() {
        return quantidadeClientesFilaEspera;
    }

    public void setQuantidadeClientesFilaEspera(int quantidadeClientesFilaEspera) {
        this.quantidadeClientesFilaEspera = quantidadeClientesFilaEspera;
    }

    public int getValorTotalDeDiarias() {
        return valorTotalDeDiarias;
    }

    public void setValorTotalDeDiarias(int valorTotalDeDiarias) {
        this.valorTotalDeDiarias = valorTotalDeDiarias;
    }
}
