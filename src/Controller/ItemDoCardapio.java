package Cardapio.CriarItem;

import Cardapio.ItemMenu;

public class ItemDoCardapio extends ItemMenu {
    private int tipo;

    public ItemDoCardapio(int tipo, String nome, String descricao, double preco) {
        super(nome, descricao, preco);
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}

