package Views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Cardapio.*;
import Pedido.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RestauranteGUI extends JFrame {
    private JComboBox<PratoPrincipal> pratosComboBox;
    private JComboBox<Bebida> bebidasComboBox;
    private JComboBox<Sobremesa> sobremesasComboBox;
    private JTextField nomeField, telefoneField, enderecoField;
    private JButton submitButton;
    private ArrayList<ItemMenu> itensEscolhidos;

    public RestauranteGUI(ArrayList<Cardapio> cardapio) {
        // Initialize JFrame
        setTitle("Restaurante Pedido");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Initialize components
        pratosComboBox = new JComboBox<>();
        bebidasComboBox = new JComboBox<>();
        sobremesasComboBox = new JComboBox<>();
        nomeField = new JTextField(20);
        telefoneField = new JTextField(20);
        enderecoField = new JTextField(20);
        submitButton = new JButton("Finalizar Pedido");
        itensEscolhidos = new ArrayList<>();

        // Populate the ComboBoxes
        populateComboBoxes(cardapio);

        // Add components to the frame
        addComponents();

        // Event listeners
        setupListeners();
    }

    private void populateComboBoxes(ArrayList<Cardapio> cardapio) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Cardápio/Cardapio.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("&");
                int type = Integer.parseInt(parts[0]);
                String name = parts[1];
                String description = parts[2];
                double price = Double.parseDouble(parts[3]);

                switch (type) {
                    case 1:
                        pratosComboBox.addItem(new PratoPrincipal(name, description, price));
                        break;
                    case 2:
                        bebidasComboBox.addItem(new Bebida(name, description, price));
                        break;
                    case 3:
                        sobremesasComboBox.addItem(new Sobremesa(name, description, price));
                        break;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addComponents() {
        // Create Panels for better organization
        JPanel menuPanel = new JPanel();
        JPanel customerDetailsPanel = new JPanel();
        JPanel submitPanel = new JPanel();

        // Setting Layout for Panels
        menuPanel.setLayout(new GridLayout(0, 2, 10, 10)); // 0 rows, 2 columns
        customerDetailsPanel.setLayout(new GridLayout(0, 2, 10, 10));
        submitPanel.setLayout(new FlowLayout());

        // Adding Menu Components
        menuPanel.add(new JLabel("Escolha um Prato Principal:"));
        menuPanel.add(pratosComboBox);
        menuPanel.add(new JLabel("Escolha uma Bebida:"));
        menuPanel.add(bebidasComboBox);
        menuPanel.add(new JLabel("Escolha uma Sobremesa:"));
        menuPanel.add(sobremesasComboBox);

        // Adding Customer Details Components
        customerDetailsPanel.add(new JLabel("Nome:"));
        customerDetailsPanel.add(nomeField);
        customerDetailsPanel.add(new JLabel("Telefone:"));
        customerDetailsPanel.add(telefoneField);
        customerDetailsPanel.add(new JLabel("Endereço:"));
        customerDetailsPanel.add(enderecoField);

        // Adding Submit Button
        submitPanel.add(submitButton);

        // Adding Panels to the JFrame
        add(menuPanel);
        add(customerDetailsPanel);
        add(submitPanel);
    }


    private void setupListeners() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear the previous selections
                itensEscolhidos.clear();

                // Get the selected items from the combo boxes
                ItemMenu pratoSelecionado = (ItemMenu) pratosComboBox.getSelectedItem();
                ItemMenu bebidaSelecionada = (ItemMenu) bebidasComboBox.getSelectedItem();
                ItemMenu sobremesaSelecionada = (ItemMenu) sobremesasComboBox.getSelectedItem();

                // Add the selected items to itensEscolhidos if they are not null
                if (pratoSelecionado != null) {
                    itensEscolhidos.add(pratoSelecionado);
                }
                if (bebidaSelecionada != null) {
                    itensEscolhidos.add(bebidaSelecionada);
                }
                if (sobremesaSelecionada != null) {
                    itensEscolhidos.add(sobremesaSelecionada);
                }

                PedidoManager.criarPedido(nomeField.getText(), telefoneField.getText(), enderecoField.getText(), itensEscolhidos);
                JOptionPane.showMessageDialog(null, "Pedido realizado com sucesso!");
            }
        });
    }
}
