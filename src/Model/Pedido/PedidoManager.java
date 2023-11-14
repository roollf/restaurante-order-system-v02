package Pedido;

import Cardapio.ItemMenu;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PedidoManager {
    public static void criarPedido(String nome, String telefone, String endereco, ArrayList<ItemMenu> itensEscolhidos) {
        Pedido pedido = new Pedido(nome, telefone, endereco, itensEscolhidos);

        File fileEscrita = new File("Pedidos/Pedidos.txt");
        try {
            FileWriter fileWriter = new FileWriter(fileEscrita, true);
            fileWriter.write(pedido.toString() + "\n");
            fileWriter.close();
        } catch (IOException exception) {
            System.out.println("Escrita não realizada.");
        }

        System.out.printf("O valor total do pedido foi de R$%.2f.\n", pedido.valorTotal());
    }
}