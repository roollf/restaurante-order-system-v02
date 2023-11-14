package Model.Cardapio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CardapioLoader {
    public static ArrayList<Cardapio> carregarCardapio(String nomeArquivo) {
        ArrayList<Cardapio> cardapio = new ArrayList<Cardapio>();
        File fileLeitura = new File("Cardápio/Cardapio.txt");

        try {
            Scanner scanner = new Scanner(fileLeitura);
            while (scanner.hasNext()) {
                // Desestruturação de cada linha do arquivo .txt em um vetor de String.
                String linha = scanner.nextLine();
                String elementos[] = linha.split("&");
                int tipo = Integer.parseInt(elementos[0]);
                if (tipo == 1) {
                    String nome = elementos[1];
                    String descricao = elementos[2];
                    Double preco = Double.parseDouble(elementos[3]);
                    cardapio.add(new PratoPrincipal(nome, descricao, preco));
                } else if (tipo == 2) {
                    String nome = elementos[1];
                    String descricao = elementos[2];
                    Double preco = Double.parseDouble(elementos[3]);
                    cardapio.add(new Bebida(nome, descricao, preco));
                } else if (tipo == 3) {
                    String nome = elementos[1];
                    String descricao = elementos[2];
                    Double preco = Double.parseDouble(elementos[3]);
                    cardapio.add(new Sobremesa(nome, descricao, preco));
                }
            }
            scanner.close();
        } catch (FileNotFoundException exception) {
            System.out.println("Arquivo não existe!");
        }

        return cardapio;
    }
}
