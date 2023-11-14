package Model.Pedido;

import Model.Cardapio.ItemMenu;

import java.util.ArrayList;

public class Pedido {
    private Cliente cliente;
    private ArrayList<ItemMenu> itens;

    public Pedido() {
    }

    public Pedido(String nome, String telefone, String endereco, ArrayList<ItemMenu> itens) {
        this.cliente = new Cliente(nome, telefone, endereco);
        this.itens = itens;
    }

    public double valorTotal() {
        double holdSoma = 0.0;
        for (ItemMenu item: itens) {
            holdSoma += item.getPreco();
        }
        return holdSoma;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<ItemMenu> getItem() {
        return itens;
    }

    public void setItem(ArrayList<ItemMenu> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return this.cliente.getNomeCliente() + " " + this.cliente.getTelefoneCliente() + " " + this.cliente.getEnderecoCliente() + " " + this.itens.toString() + " " + this.valorTotal();
    }
}
