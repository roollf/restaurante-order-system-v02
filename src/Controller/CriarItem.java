package Cardapio.CriarItem;
import Views.CriarItemGUI;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import javax.swing.*;
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

// Classe rodar a interface gráfica
class AddItemCardapio {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CriarItemGUI().setVisible(true);
            }
        });
    }
}