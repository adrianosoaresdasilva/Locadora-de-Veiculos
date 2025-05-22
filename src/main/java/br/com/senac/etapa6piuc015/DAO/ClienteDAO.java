package br.com.senac.etapa6piuc015.DAO;

import br.com.senac.etapa6piuc015.Model.Cliente;
import br.com.senac.etapa6piuc015.Util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe ClienteDAO - Responsável por gerenciar as operações de persistência
 * específicas para a entidade {@link Cliente}.
 *
 * @author [Adriano]
 * @version JDK 22.0
 */
public class ClienteDAO extends GenericDAO<Cliente> {

    public ClienteDAO() {
        super(Cliente.class);
    }

    /**
     * Lista clientes do banco de dados com base em um filtro de nome.
     */
    public List<Cliente> listarClientesComFiltro(String filtro) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Cliente> resultados = new ArrayList<>();

        try {
            String jpql = "SELECT c FROM Cliente c";
            if (filtro != null && !filtro.trim().isEmpty()) {
                jpql += " WHERE LOWER(c.nome) LIKE LOWER(:nome)";
            }
            TypedQuery<Cliente> query = em.createQuery(jpql, Cliente.class);
            if (filtro != null && !filtro.trim().isEmpty()) {
                query.setParameter("nome", "%" + filtro + "%");
            }
            resultados = query.getResultList();
            System.out.println("Clientes encontrados (filtrados): " + resultados.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return resultados;
    }

    /**
     * Busca um cliente no banco de dados pelo seu número de CPF.
     */
    public Cliente buscarPorCpf(String cpf) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            String jpql = "SELECT c FROM Cliente c WHERE c.cpf = :cpf";
            TypedQuery<Cliente> query = em.createQuery(jpql, Cliente.class);
            query.setParameter("cpf", cpf);
            return query.getSingleResult();
        } catch (jakarta.persistence.NoResultException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            em.close();
        }
    }
}
