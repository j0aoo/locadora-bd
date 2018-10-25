package Modelo;

public class Funcionario {

    //atributos
    private int cod;
    private int cod_filme;
    private String situacao;
    private double preco;
    private String data_compra;
    
    
    //getters e setters
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getCod_filme() {
        return cod_filme;
    }

    public void setCod_filme(int cod_filme) {
        this.cod_filme = cod_filme;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getData_compra() {
        return data_compra;
    }

    public void setData_compra(String data_compra) {
        this.data_compra = data_compra;
    }
    
    
    
}
