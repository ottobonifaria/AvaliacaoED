package domain;

public class Cliente {

    private String nome;
    private String telefone;
    private String endereco;
    private  String veiculoDesejado;
    private String veiculoAlugado;

    public Cliente() {

    }

    public Cliente(String nome, String telefone, String endereco, String veiculoDesejado,
                   String veiculoAlugado) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.veiculoDesejado = veiculoDesejado;
        this.veiculoAlugado = veiculoAlugado;
    }


    public String getVeiculoAlugado() {
        return veiculoAlugado;
    }

    public void setVeiculoAlugado(String veiculoAlugado) {
        this.veiculoAlugado = veiculoAlugado;
    }

    public String getNome() {
        return nome;
    }

    public String getVeiculoDesejado() {
        return veiculoDesejado;
    }

    @Override
    public String toString() {

        return  "(Nome = " + nome + ")  " +
                "(Telefone = " + telefone + ")  " +
                "(Endereco = " + endereco + ")" +
                "(VeiculoDesejado = " + veiculoDesejado + ")";
    }
}