package Views;
import Cardapio.CriarItem.CriarItem;
import Cardapio.CriarItem.ItemDoCardapio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class CriarItemGUI extends JFrame {
    private JTextField tipoField, nomeField, descricaoField, precoField;
    private JButton addButton;

    public CriarItemGUI() {
        // Setting up the frame
        setTitle("Adicionar Item do Cardápio");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Initialize components
        tipoField = new JTextField(10);
        nomeField = new JTextField(10);
        descricaoField = new JTextField(10);
        precoField = new JTextField(10);
        addButton = new JButton("Adicionar");

        // Add components to frame
        add(new JLabel("Tipo:"));
        add(tipoField);
        add(new JLabel("Nome:"));
        add(nomeField);
        add(new JLabel("Descrição:"));
        add(descricaoField);
        add(new JLabel("Preço:"));
        add(precoField);
        add(addButton);

        // Event Listener for Add Button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tipo = Integer.parseInt(tipoField.getText());
                String nome = nomeField.getText();
                String descricao = descricaoField.getText();
                double preco = Double.parseDouble(precoField.getText());

                CriarItem cardapio = CriarItem.getInstance();
                cardapio.addItem(new ItemDoCardapio(tipo, nome, descricao, preco));
                // Adicionar no arquivo
                File fileEscrita = new File("Cardápio/Cardapio.txt");
                try {
                    FileWriter fileWriter = new FileWriter(fileEscrita, true);
                    List<ItemDoCardapio> itens = cardapio.getItens();
                    for (ItemDoCardapio item : itens) {
                        fileWriter.write(item.getTipo() + "&" + item.getNome() + "&" + item.getDescricao() + "&" + item.getPreco() + "\n");
                    }
                    fileWriter.close();
                } catch (IOException exception) {
                    System.out.println("Escrita não realizada.");
                }
                JOptionPane.showMessageDialog(null, "Item Adicionado!");
            }
        });
    }
}
