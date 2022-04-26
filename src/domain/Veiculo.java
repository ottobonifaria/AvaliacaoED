package domain;

public class Veiculo implements Comparable<Veiculo>{

    private String marca;
    private String modelo;
    private String cor;
    private String placa;
    private int valorDaDiaria;
    private boolean alugado;

    public Veiculo(String marca, String modelo, String cor, String placa,
                   int valorDaDiaria, boolean alugado) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
        this.valorDaDiaria = valorDaDiaria;
        this.alugado = alugado;
    }

    public int getValorDaDiaria() {
        return valorDaDiaria;
    }

    public void setValorDaDiaria(int valorDaDiaria) {
        this.valorDaDiaria = valorDaDiaria;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public boolean isAlugado() {
        return alugado;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

    @Override
    public String toString() {
        return  "Marca: " + marca +" | "+
                "Modelo: " + modelo + " | "+
                "Cor: " + cor + " | " +
                "Placa: " + placa + " | " +
                "Valor da Diária R$: " + valorDaDiaria ;
    }

    @Override
    public int compareTo(Veiculo o) {

        if(this.valorDaDiaria < o.valorDaDiaria){
            return -1;
        }
        if(this.valorDaDiaria > o.valorDaDiaria){
            return 1;
        }
        return 0;
    }
}