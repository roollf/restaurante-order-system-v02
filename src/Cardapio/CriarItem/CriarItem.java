package Cardapio.CriarItem;

import Cardapio.ItemMenu;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

// Instância singleton da classe
public class CriarItem {
    private static CriarItem instance = null;
    private List<ItemDoCardapio> itens;
    private CriarItem() {
        itens = new ArrayList<>();
    }
    public static CriarItem getInstance() {
        if (instance == null) {
            instance = new CriarItem();
        }
        return instance;
    }
    public void addItem(ItemDoCardapio item) {
        itens.add(item);
    }
    public List<ItemDoCardapio> getItens() {
        return Collections.unmodifiableList(itens);
    }
}

// Classe representando um item do cardápio
class ItemDoCardapio extends ItemMenu {
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

// Classe para adicionar novos itens ao cardápio
class AddItemCardapio {
    public static void main(String[] args) {
        CriarItem cardapio = CriarItem.getInstance();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Escreva o tipo do item (1 - Prato Principal, 2 - Cardapio.Bebida, 3 - Cardapio.Sobremesa)");
        int itemTipo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Escreva o nome do item");
        String itemNome = scanner.nextLine();
        System.out.println("Escreva a descrição do item");
        String itemDescricao = scanner.nextLine();
        System.out.println("Escreva o preço do item");
        double preco = scanner.nextDouble();

        // Adicionando item
        cardapio.addItem(new ItemDoCardapio(itemTipo, itemNome, itemDescricao, preco));

        File fileEscrita = new File("Cardápio/Cardapio.txt");
        try {
            FileWriter fileWriter = new FileWriter(fileEscrita, true);
            List<ItemDoCardapio> itens = cardapio.getItens();
            for (ItemDoCardapio item : itens) {
                System.out.println("Nome: " + item.getNome());
                System.out.println("Descrição: " + item.getDescricao());
                System.out.println("Preço: R$" + item.getPreco());
                fileWriter.write(item.getTipo() + "&" + item.getNome() + "&" + item.getDescricao() + "&" + item.getPreco() + "\n");
            }
            fileWriter.close();
        } catch (IOException exception) {
            System.out.println("Escrita não realizada.");
        }
    }
}