package br.com.senac.etapa6piuc015.View;

// Importação dos pacotes necessários para usarmos o List e ArrayList
import br.com.senac.etapa6piuc015.Model.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 * ListaCliente é uma classe utilitária responsável por armazenar uma lista
 * estática de clientes em memória.
 *
 * Essa classe permite adicionar e listar clientes sem a necessidade de
 * persistência em banco de dados, sendo útil para simulações ou armazenamento
 * temporário durante a execução do programa.
 */
public class ListaCliente {
    // Declaração de variáveis

    private static final List<Cliente> lista = new ArrayList<>();

    // Métodos para acessarmos a lista e adicionarmos novos itens
    public static List<Cliente> Listar() {
        return lista;
    }

    public static void Adicionar(Cliente cliente) {
        lista.add(cliente);
    }

}
