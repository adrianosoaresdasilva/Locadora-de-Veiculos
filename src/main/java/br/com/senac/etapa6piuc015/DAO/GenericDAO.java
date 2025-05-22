package br.com.senac.etapa6piuc015.DAO;

import br.com.senac.etapa6piuc015.Util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe GenericDAO - Responsável por gerenciar as operações de persistência
 * genéricas para qualquer entidade (T).
 */
public class GenericDAO<T> {

    private final Class<T> entidade;

    public GenericDAO(Class<T> entidade) {
        this.entidade = entidade;
    }
    /**
     * Persiste um objeto (entidade) no banco de dados.
     * Inicia uma transação, persiste o objeto e, se tudo ocorrer bem,
     * commita a transação. Em caso de erro, a transação é revertida (rollback).
     * @param objeto O objeto (entidade) do tipo {@code <T>} a ser cadastrado/persistido.
     * @throws RuntimeException Se ocorrer um erro durante a operação de persistência,
     * a transação é revertida e a exceção é relançada.
     */ 
    public void cadastrar(T objeto) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    /**
     * Lista todos os objetos (entidades) do tipo {@code <T>} presentes no banco
     * de dados.
     */
    public List<T> listar() {
        EntityManager em = JPAUtil.getEntityManager();
        List<T> resultados = new ArrayList<>();

        try {
            String jpql = "SELECT o FROM " + entidade.getSimpleName() + " o";
            TypedQuery<T> query = em.createQuery(jpql, entidade);
            resultados = query.getResultList();
            System.out.println("Entidades encontradas (" + entidade.getSimpleName() + "): " + resultados.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return resultados;
    }

    /**
     * Exclui um objeto (entidade) do banco de dados.
     */
    public void excluir(T objeto) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            T entityToRemove = em.merge(objeto);
            em.remove(entityToRemove);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    /**
     * Busca um objeto (entidade) do tipo {@code <T>} no banco de dados pelo seu ID.
     */

    public T buscarPorId(Object id) {
        EntityManager em = JPAUtil.getEntityManager();
        T resultado = null;
        try {
            resultado = em.find(entidade, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return resultado;
    }
}
