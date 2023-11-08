# University Activity

## Sistema de Pedidos em Restaurante com Padrões GoF e GRASP 🍴

Esse projeto é uma evolução do [projeto anterior](https://github.com/roollf/restaurante-order-system), incorporando princípios de design avançados, como os padrões GoF (Gang of Four) e GRASP (General Responsibility Assignment Software Patterns). Esses padrões foram implementados para melhorar a arquitetura do sistema, tornando-o mais flexível, escalável e fácil de manter.

O projeto agora inclui uma maior abstração e separação de responsabilidades, resultando em uma estrutura mais organizada e coesa. Várias classes foram redesenhadas e reorganizadas para refletir os princípios de design, oferecendo um código mais limpo e legível.

## Padrões de Design Implementados 🏗️

### 1. Controller
O padrão Controller foi aplicado para separar a lógica de negócios da interface do usuário. Agora, o sistema possui um controlador central que gerencia todas as interações dos clientes e controla a execução de pedidos.

### 2. Builder
O padrão Builder é utilizado na criação de pedidos, permitindo a construção passo a passo de pedidos complexos. Os clientes podem adicionar itens do cardápio e especificar quantidades.

### 3. Singleton
A implementação do padrão Singleton garante que apenas uma instância do sistema esteja em execução, garantindo que os dados do cardápio e o histórico de pedidos sejam compartilhados de maneira consistente entre as classes.

### 4. Constructor
O padrão Constructor é aplicado para criar objetos complexos, facilitando a construção de pedidos e notas fiscais de maneira estruturada e eficiente.

## Funcionalidades Aprimoradas ⚙️

- `Realização de Pedidos` Os clientes podem fazer pedidos de forma mais intuitiva, criando pedidos personalizados com a ajuda do padrão Builder.

- `Cálculo de Valor Total do Pedido` O sistema continua a calcular automaticamente o valor total do pedido com base nos itens selecionados, agora de forma mais estruturada.

- `Geração de Nota Fiscal` A geração de notas fiscais foi otimizada com o uso do padrão Constructor, resultando em notas fiscais mais detalhadas e personalizadas.

- `Histórico de Pedidos` O histórico de pedidos é mantido de forma mais organizada e acessível, facilitando a consulta de pedidos anteriores.

## Tecnologias 🛠

- Java.

## Equipe 🎓

- [Rolf Matela](https://github.com/roollf).
- [Karoline Trevizani](https://github.com/KarolTrevizani).
- Dóris Reck.
- [Fernando Custódio](https://github.com/Fcsla).
