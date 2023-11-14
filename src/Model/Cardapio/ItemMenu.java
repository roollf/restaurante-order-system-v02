package Cardapio;

public abstract class ItemMenu implements Cardapio {
    private String nome;
    private String descricao;
    private double preco;

    public ItemMenu() {
    }

    public ItemMenu(String nome, String descricao, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    @Override
    public void mostrarInfo() {
        System.out.println(this.nome);
        System.out.println(this.descricao);
        System.out.println(this.preco);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return this.nome + " " + this.preco;
    }
}
