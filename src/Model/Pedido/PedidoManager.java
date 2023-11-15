package Model.Pedido;

import Model.Cardapio.ItemMenu;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class PedidoManager {
    public static void criarPedido(String nome, String telefone, String endereco, ArrayList<ItemMenu> itensEscolhidos) {
        Pedido pedido = new Pedido(nome, telefone, endereco, itensEscolhidos);

        String jsonPedido = convertPedidoToJson(pedido);
        sendPostRequest(jsonPedido);
    }

    private static String convertPedidoToJson(Pedido pedido) {
        StringBuilder jsonBuilder = new StringBuilder();

        jsonBuilder.append("{\"name\": \"").append(pedido.getCliente().getNomeCliente())
                .append("\", \"phone\": \"").append(pedido.getCliente().getTelefoneCliente())
                .append("\", \"address\": \"").append(pedido.getCliente().getEnderecoCliente())
                .append("\", \"itens\": [");

        // Iterate over itensEscolhidos and convert each item to JSON
        ArrayList<ItemMenu> itensEscolhidos = pedido.getItem();
        for (int i = 0; i < itensEscolhidos.size(); i++) {
            ItemMenu item = itensEscolhidos.get(i);
            jsonBuilder.append("{\"nome\": \"").append(item.getNome())
                    .append("\", \"descricao\": \"").append(item.getDescricao())
                    .append("\", \"preco\": ").append(item.getPreco());

            if (i < itensEscolhidos.size() - 1) {
                jsonBuilder.append("},");
            } else {
                jsonBuilder.append("}");
            }
        }

        jsonBuilder.append("]}");

        return jsonBuilder.toString();
    }


    private static void sendPostRequest(String jsonInputString) {
        try {
            URL url = new URL("https://pcuphpfochzhcbonmnvu.supabase.co/rest/v1/restaurant-orders");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("apikey", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InBjdXBocGZvY2h6aGNib25tbnZ1Iiwicm9sZSI6InNlcnZpY2Vfcm9sZSIsImlhdCI6MTcwMDAwMjUzNywiZXhwIjoyMDE1NTc4NTM3fQ.35V3pPJN8LNvspxa7-jGbmA6VinRTijkzNpLHHt9hUU"); // Replace with your API key
            connection.setDoOutput(true);

            try(OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            try(BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response.toString());
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
