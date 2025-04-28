# Sistema de Gerenciamento de Atendimento ao Cliente

Este projeto tem como objetivo simular um sistema de gerenciamento de atendimento ao cliente, utilizando duas estruturas de dados fundamentais implementadas manualmente em Java: uma **Fila** (FIFO - First In, First Out) para gerenciar a ordem de atendimento dos clientes, e uma **Pilha** (LIFO - Last In, First Out) para armazenar o histórico de solicitações.

O sistema foi desenvolvido sem utilizar bibliotecas prontas como List, ArrayList, Arrays, StringBuilder, entre outras, respeitando a exigência de criar todas as estruturas de forma manual utilizando nós encadeados.

---

# Funcionamento

O sistema permite o gerenciamento completo tanto da fila de atendimento quanto do histórico de solicitações. Os usuários interagem com o sistema através de um menu no terminal.

**Fila de Atendimento (FIFO):**

A fila é implementada por meio de uma lista encadeada simples.  
Os clientes são adicionados ao final da fila e atendidos a partir da frente da fila, respeitando a ordem de chegada.  
Quando um cliente é atendido, ele é removido da frente da fila.

**Pilha de Histórico de Solicitações (LIFO):**

O histórico de solicitações é implementado através de uma lista encadeada onde as novas solicitações são adicionadas no topo da pilha.  
Quando se deseja remover uma solicitação do histórico, a última que foi adicionada é removida primeiro, seguindo o princípio LIFO.

---

# Estrutura do Código

O código é dividido nas seguintes classes:

**Cliente:**  
Representa um cliente da fila, contendo nome, número de identificação e motivo do atendimento.

**Solicitacao:**  
Representa uma solicitação no histórico, contendo ID, descrição e data/hora da solicitação.

**NodeCliente:**  
Representa um nó da lista encadeada da fila, armazenando um cliente e a referência para o próximo nó.

**NodeSolicitacao:**  
Representa um nó da lista encadeada da pilha, armazenando uma solicitação e a referência para o próximo nó.

**Fila:**  
Implementa a fila de atendimento, com operações de enfileirar, desenfileirar e exibir a fila.

**Pilha:**  
Implementa o histórico de solicitações, com operações de push, pop e exibir o histórico.

**Main:**  
Classe principal, responsável por apresentar o menu e gerenciar as operações de acordo com a escolha do usuário.

---

# Funcionalidades do Sistema

- Exibir a fila de atendimento atual.
- Atender o próximo cliente da fila, removendo-o da frente.
- Adicionar novos clientes à fila de atendimento.
- Exibir o histórico completo de solicitações.
- Adicionar novas solicitações ao histórico.
- Remover a última solicitação registrada no histórico.

Além das funcionalidades principais, o sistema conta com tratamento de erros para impedir operações inválidas, como tentar atender clientes de uma fila vazia ou tentar remover solicitações de uma pilha vazia.

---

# Exemplo de Fluxo

Um cliente chamado "Maria Silva" é adicionado à fila.  
Logo após, um cliente chamado "João Souza" também entra na fila.  
Quando o primeiro atendimento é realizado, "Maria Silva" é atendida e removida da fila, e "João Souza" passa a ser o próximo.

No histórico de solicitações, se forem registradas uma solicitação de "Instalação de software" e depois uma de "Manutenção preventiva", ao remover a última solicitação, será removida "Manutenção preventiva", pois foi a mais recentemente adicionada, seguindo a lógica LIFO.

---

# Observações Importantes

A fila segue o comportamento FIFO (Primeiro a Entrar, Primeiro a Sair), garantindo que o atendimento respeite a ordem de chegada dos clientes.

A pilha segue o comportamento LIFO (Último a Entrar, Primeiro a Sair), garantindo que a solicitação mais recente seja a primeira a ser removida, se necessário.

Todo o sistema foi desenvolvido manualmente, sem o uso de estruturas de dados prontas, para reforçar o aprendizado de conceitos fundamentais de programação e estruturas encadeadas.

---

# Apresentação em Vídeo

O grupo elaborou um vídeo explicativo demonstrando o funcionamento do sistema, disponível no YouTube:  
