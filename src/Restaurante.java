import Cardapio.*;
import Views.CriarItemGUI;
import Views.MainGUI;
import Views.RestauranteGUI;
import javax.swing.*;
import java.util.ArrayList;

public class Restaurante {
    public static void main(String[] args) {
        ArrayList<Cardapio> cardapio = CardapioLoader.carregarCardapio("Cardápio/Cardapio.txt");
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainGUI(cardapio).setVisible(true);
            }
        });
    }
}