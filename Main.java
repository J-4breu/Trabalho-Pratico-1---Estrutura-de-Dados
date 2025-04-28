import java.util.Scanner;

class Cliente {
    String nome;
    String numeroIdentificacao;
    String motivoAtendimento;

    Cliente(String nome, String numeroIdentificacao, String motivoAtendimento) {
        this.nome = nome;
        this.numeroIdentificacao = numeroIdentificacao;
        this.motivoAtendimento = motivoAtendimento;
    }
}

class Solicitacao {
    String idSolicitacao;
    String descricao;
    String dataHora;

    Solicitacao(String idSolicitacao, String descricao, String dataHora) {
        this.idSolicitacao = idSolicitacao;
        this.descricao = descricao;
        this.dataHora = dataHora;
    }
}

class NodeCliente {
    Cliente cliente;
    NodeCliente proximo;

    NodeCliente(Cliente cliente) {
        this.cliente = cliente;
        this.proximo = null;
    }
}

class NodeSolicitacao {
    Solicitacao solicitacao;
    NodeSolicitacao proximo;

    NodeSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
        this.proximo = null;
    }
}

class Fila {
    private NodeCliente frente;
    private NodeCliente tras;

    public Fila() {
        frente = null;
        tras = null;
    }

    public void enfileirar(Cliente cliente) {
        NodeCliente novo = new NodeCliente(cliente);
        if (isEmpty()) {
            frente = novo;
            tras = novo;
        } else {
            tras.proximo = novo;
            tras = novo;
        }
    }

    public Cliente desenfileirar() throws Exception {
        if (isEmpty()) {
            throw new Exception("Fila vazia.");
        }
        Cliente atendido = frente.cliente;
        frente = frente.proximo;
        if (frente == null) {
            tras = null;
        }
        return atendido;
    }

    public boolean isEmpty() {
        return frente == null;
    }

    public void exibirFila() {
        NodeCliente atual = frente;
        while (atual != null) {
            System.out.println(atual.cliente.numeroIdentificacao + " - " + atual.cliente.nome + " - " + atual.cliente.motivoAtendimento);
            atual = atual.proximo;
        }
    }
}

class Pilha {
    private NodeSolicitacao topo;

    public Pilha() {
        topo = null;
    }

    public void push(Solicitacao solicitacao) {
        NodeSolicitacao novo = new NodeSolicitacao(solicitacao);
        novo.proximo = topo;
        topo = novo;
    }

    public Solicitacao pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Histórico vazio.");
        }
        Solicitacao removido = topo.solicitacao;
        topo = topo.proximo;
        return removido;
    }

    public boolean isEmpty() {
        return topo == null;
    }

    public void exibirHistorico() {
        NodeSolicitacao atual = topo;
        while (atual != null) {
            System.out.println(atual.solicitacao.idSolicitacao + " - " + atual.solicitacao.descricao + " - " + atual.solicitacao.dataHora);
            atual = atual.proximo;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pilha historico = new Pilha();
        Fila filaAtendimento = new Fila();

        // Inserir dados fixos iniciais
        carregarDadosFila(filaAtendimento);
        carregarDadosPilha(historico);

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- Sistema de Atendimento ao Cliente ---");
            System.out.println("1 - Exibir Fila de Atendimento (FIFO)");
            System.out.println("2 - Atender Próximo Cliente (Remover da Fila)");
            System.out.println("3 - Adicionar Novo Cliente à Fila");
            System.out.println("4 - Exibir Histórico de Solicitações (Pilha - LIFO)");
            System.out.println("5 - Adicionar Nova Solicitação ao Histórico");
            System.out.println("6 - Remover Última Solicitação do Histórico (POP)");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Entrada inválida.");
                continue;
            }

            try {
                switch (opcao) {
                    case 1:
                        filaAtendimento.exibirFila();
                        break;
                    case 2:
                        Cliente cliente = filaAtendimento.desenfileirar();
                        System.out.println("Atendendo cliente: " + cliente.numeroIdentificacao + " - " + cliente.nome + " - " + cliente.motivoAtendimento);
                        break;
                    case 3:
                        System.out.print("Nome do Cliente: ");
                        String nome = scanner.nextLine();
                        System.out.print("Número de Identificação: ");
                        String numeroIdentificacao = scanner.nextLine();
                        System.out.print("Motivo do Atendimento: ");
                        String motivo = scanner.nextLine();
                        filaAtendimento.enfileirar(new Cliente(nome, numeroIdentificacao, motivo));
                        System.out.println("Cliente adicionado à fila.");
                        break;
                    case 4:
                        historico.exibirHistorico();
                        break;
                    case 5:
                        System.out.print("ID da Solicitação: ");
                        String idSolicitacao = scanner.nextLine();
                        System.out.print("Descrição da Solicitação: ");
                        String descricaoSolicitacao = scanner.nextLine();
                        System.out.print("Data e Hora (ex: 2025-04-27 14:30): ");
                        String dataHoraSolicitacao = scanner.nextLine();
                        historico.push(new Solicitacao(idSolicitacao, descricaoSolicitacao, dataHoraSolicitacao));
                        System.out.println("Solicitação adicionada ao histórico.");
                        break;
                    case 6:
                        Solicitacao solicitacaoRemovida = historico.pop();
                        System.out.println("Solicitação removida do histórico: " + solicitacaoRemovida.idSolicitacao + " - " + solicitacaoRemovida.descricao);
                        break;
                    case 0:
                        System.out.println("Encerrando o sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida. Escolha novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static void carregarDadosFila(Fila fila) {
        fila.enfileirar(new Cliente("Maria Silva", "CLI001", "Dúvida sobre produto"));
        fila.enfileirar(new Cliente("João Souza", "CLI002", "Reclamação de serviço"));
        fila.enfileirar(new Cliente("Ana Costa", "CLI003", "Solicitação de reembolso"));
        fila.enfileirar(new Cliente("Pedro Alves", "CLI004", "Informações de entrega"));
        fila.enfileirar(new Cliente("Carla Dias", "CLI005", "Agendamento de visita"));
        fila.enfileirar(new Cliente("Lucas Martins", "CLI006", "Alteração de pedido"));
        fila.enfileirar(new Cliente("Patrícia Rocha", "CLI007", "Cancelamento de contrato"));
        fila.enfileirar(new Cliente("Rafael Lima", "CLI008", "Renovação de assinatura"));
        fila.enfileirar(new Cliente("Fernanda Gomes", "CLI009", "Suporte para instalação"));
        fila.enfileirar(new Cliente("Carlos Eduardo", "CLI010", "Pedido de orçamento"));
    }

    private static void carregarDadosPilha(Pilha pilha) {
        pilha.push(new Solicitacao("REQ001", "Instalação de software", "2024-08-20 10:30"));
        pilha.push(new Solicitacao("REQ002", "Manutenção preventiva", "2024-08-20 11:00"));
        pilha.push(new Solicitacao("REQ003", "Atualização de sistema", "2024-08-20 11:30"));
        pilha.push(new Solicitacao("REQ004", "Suporte técnico", "2024-08-20 12:00"));
        pilha.push(new Solicitacao("REQ005", "Troca de equipamento", "2024-08-20 12:30"));
        pilha.push(new Solicitacao("REQ006", "Consulta de garantia", "2024-08-20 13:00"));
        pilha.push(new Solicitacao("REQ007", "Reparo de impressora", "2024-08-20 13:30"));
        pilha.push(new Solicitacao("REQ008", "Configuração de rede", "2024-08-20 14:00"));
        pilha.push(new Solicitacao("REQ009", "Restauração de dados", "2024-08-20 14:30"));
        pilha.push(new Solicitacao("REQ010", "Consulta técnica", "2024-08-20 15:00"));
    }
}