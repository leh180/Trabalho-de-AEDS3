package controller;
import java.util.*;
import model.*;
import view.*;

/**
 * A classe 'ControleLista' é responsável por gerenciar toda a lógica de negócio
 * relacionada às listas, atuando como o intermediário entre as classes de modelo (dados)
 * e as classes de visão (interface com o usuário).
 */
public class ControleLista {

    // ------------------------------------------ Atributos da Classe ------------------------------------------
    
    private CRUDLista crudLista;
    private VisaoLista visaoLista;
    private VisaoUsuario visaoUsuario;

    // ------------------------------------------ Construtores ------------------------------------------
    
    public ControleLista() throws Exception {
        this.crudLista = new CRUDLista();
        this.visaoLista = new VisaoLista();
        this.visaoUsuario = new VisaoUsuario();
    }

    public ControleLista(CRUDLista crudLista) {
        this.crudLista = crudLista;
        this.visaoLista = new VisaoLista();
        this.visaoUsuario = new VisaoUsuario();
    }

    // ------------------------------------------ Métodos de Menu ------------------------------------------
    
    /**
     * Menu principal para um utilizador gerir as suas próprias listas.
     * Este método é o ponto de entrada para a gestão de listas pessoais.
     * Ele lê todas as listas do usuário, as exibe de forma ordenada e
     * direciona para as ações de criação ou gerenciamento de uma lista específica.
     * @param usuarioLogado O utilizador que está com a sessão ativa.
     */
    public void menuMinhasListas(Usuario usuarioLogado) {
        String opcao;
        do {
            try {
                List<Lista> minhasListas = crudLista.readAllByUser(usuarioLogado.getID());
                Collections.sort(minhasListas, Comparator.comparing(Lista::getNome, String.CASE_INSENSITIVE_ORDER));
                opcao = visaoLista.mostrarListas(minhasListas, usuarioLogado.getNome());

                if (opcao.equalsIgnoreCase("N")) {
                    criarNovaLista(usuarioLogado);
                } else if (!opcao.equalsIgnoreCase("R")) {
                    try {
                        int indice = Integer.parseInt(opcao) - 1;
                        if (indice >= 0 && indice < minhasListas.size()) {
                            // Se o utilizador escolheu uma lista válida, mostra o menu de detalhes
                            menuDetalhesLista(minhasListas.get(indice), usuarioLogado);
                        } else {
                            System.out.println("\nERRO: Opção numérica inválida!");
                            visaoUsuario.pausa();
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("\nERRO: Opção inválida! Tente novamente.");
                        visaoUsuario.pausa();
                    }
                }
            } catch (Exception e) {
                System.err.println("\nERRO ao gerir as listas: " + e.getMessage());
                e.printStackTrace();
                opcao = "R"; // Força a saída em caso de erro grave
            }
        } while (!opcao.equalsIgnoreCase("R"));
    }

    /**
     * Menu para ver os detalhes de uma lista específica e geri-la.
     * Este método exibe os detalhes de uma lista e oferece opções
     * para alteração ou exclusão, além de um espaço para futuras funcionalidades.
     * @param lista A lista selecionada.
     * @param usuarioLogado O utilizador dono da lista.
     */
    private void menuDetalhesLista(Lista lista, Usuario usuarioLogado) {
        String opcao;
        do {
            opcao = visaoLista.mostrarDetalhesLista(lista, usuarioLogado.getNome(), true); // true = mostrar menu de gestão
            
            switch (opcao) {
                case "1":
                    System.out.println("\nFuncionalidade a ser implementada no Trabalho Prático 2.");
                    visaoUsuario.pausa();
                    break;
                case "2":
                    alterarLista(lista);
                    break;
                case "3":
                    if (excluirLista(lista)) {
                        return; // Retorna para o menu "Minhas Listas"
                    }
                    break;
                case "R":
                    break; // Retorna para o menu "Minhas Listas"
                default:
                    System.out.println("\nOpção inválida!");
                    visaoUsuario.pausa();
                    break;
            }

        } while (!opcao.equalsIgnoreCase("R"));
    }

    /**
     * Fluxo para procurar uma lista pública usando o seu código.
     * Este método solicita um código de lista ao usuário e busca por
     * uma lista correspondente no sistema, exibindo seus detalhes se encontrada.
     */
    public void menuProcurarLista() {
        String codigo = visaoLista.pedirCodigo();
        try {
            Lista lista = crudLista.readByCodigo(codigo);
            if (lista != null) {
                visaoLista.mostrarDetalhesLista(lista, "Pública", false);
            } else {
                System.out.println("\nNenhuma lista encontrada com o código \"" + codigo + "\".");
            }
        } catch (Exception e) {
            System.err.println("\nERRO ao procurar a lista: " + e.getMessage());
        }
        visaoUsuario.pausa();
    }

    // ------------------------------------------ Métodos de Ação (CRUD) ------------------------------------------

    /**
     * Realiza o processo de criação de uma nova lista.
     * Pede os dados da nova lista ao usuário, associa-a ao usuário logado e
     * salva a lista no sistema.
     * @param usuarioLogado O utilizador que está criando a lista.
     */
    private void criarNovaLista(Usuario usuarioLogado) {
        try {
            Lista novaLista = visaoLista.lerDadosNovaLista();
            novaLista.setIdUsuario(usuarioLogado.getID()); // Associa a lista ao utilizador logado
            
            int id = crudLista.create(novaLista);
            System.out.println("\nLista \"" + novaLista.getNome() + "\" criada com sucesso! (ID: " + id + ")");
        } catch (Exception e) {
            System.err.println("\nERRO ao criar a lista: " + e.getMessage());
        }
        visaoUsuario.pausa();
    }

    /**
     * Realiza o processo de alteração de uma lista existente.
     * Pede os novos dados ao usuário, atualiza a lista no sistema e
     * informa o resultado da operação.
     * @param lista A lista a ser alterada.
     */
    private void alterarLista(Lista lista) {
        try {
            Lista dadosAlterados = visaoLista.lerDadosAlteracaoLista(lista);
            
            lista.setNome(dadosAlterados.getNome());
            lista.setDescricao(dadosAlterados.getDescricao());
            lista.setDataLimite(dadosAlterados.getDataLimite());

            if (crudLista.update(lista)) {
                System.out.println("\nLista alterada com sucesso!");
            } else {
                System.out.println("\nFalha ao alterar a lista.");
            }
        } catch (Exception e) {
            System.err.println("\nERRO ao alterar a lista: " + e.getMessage());
        }
        visaoUsuario.pausa();
    }

    /**
     * Realiza o processo de exclusão de uma lista.
     * Solicita a confirmação do usuário e, se confirmada,
     * tenta excluir a lista do sistema.
     * @param lista A lista a ser excluída.
     * @return `true` se a lista foi excluída com sucesso, `false` caso contrário.
     */
    private boolean excluirLista(Lista lista) {
        if (visaoLista.confirmarExclusao(lista.getNome())) {
            try {
                if (crudLista.delete(lista.getID())) {
                    System.out.println("\nLista \"" + lista.getNome() + "\" excluída com sucesso.");
                    visaoUsuario.pausa();
                    return true;
                } else {
                    System.out.println("\nFalha ao excluir a lista.");
                }
            } catch (Exception e) {
                System.err.println("\nERRO ao excluir a lista: " + e.getMessage());
            }
        }
        visaoUsuario.pausa();
        return false;
    }

    /**
     * Fecha as ligações com os ficheiros de dados geridos por este controlador.
     */
    public void close() throws Exception {
        crudLista.close();
    }
}

