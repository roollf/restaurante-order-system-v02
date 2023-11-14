package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Model.Cardapio.Cardapio;

public class MainGUI extends JFrame {
    private JButton createItemButton;
    private JButton makePedidoButton;

    public MainGUI(ArrayList<Cardapio> cardapio) {
        // Initialize JFrame
        setTitle("Restaurante Opções");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Initialize buttons
        createItemButton = new JButton("Criar Item do Cardápio");
        makePedidoButton = new JButton("Fazer Pedido");

        // Add buttons to the frame
        add(createItemButton);
        add(makePedidoButton);

        // Event listeners
        createItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CriarItemGUI().setVisible(true);
            }
        });

        makePedidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RestauranteGUI(cardapio).setVisible(true);
            }
        });
    }

}

