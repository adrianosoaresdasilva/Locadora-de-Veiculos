package br.com.senac.etapa6piuc015.View;

import br.com.senac.etapa6piuc015.Model.Veiculo;
import java.util.ArrayList;
import java.util.List;

/**
 * ListaVeiculo é uma classe utilitária responsável por armazenar uma lista
 * estática de veiculos em memória.
 *
 * Essa classe permite adicionar e listar veiculos sem a necessidade de
 * persistência em banco de dados, sendo útil para simulações ou armazenamento
 * temporário durante a execução do programa.
 */
public class ListaVeiculo {

    // Declaração de variáveis
    private static final List<Veiculo> lista = new ArrayList<>();

    // Métodos para acessarmos a lista e adicionarmos novos itens
    public static List<Veiculo> Listar() {
        return lista;
    }

    public static void Adicionar(Veiculo veiculo) {
        lista.add(veiculo);
    }

}
