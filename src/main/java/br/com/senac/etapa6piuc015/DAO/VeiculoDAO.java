package br.com.senac.etapa6piuc015.DAO;

import br.com.senac.etapa6piuc015.Model.Veiculo;
import br.com.senac.etapa6piuc015.Util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe VeiculoDAO - Responsável por gerenciar as operações de persistência
 * específicas para a entidade {@link Veiculo}.
 *
 * @author [Adriano]
 * @version JDK 22.0
 */
public class VeiculoDAO extends GenericDAO<Veiculo> {

    public VeiculoDAO() {
        super(Veiculo.class);
    }

    /**
     * Lista clientes do banco de dados com base em um filtro de nome.
     */
    public List<Veiculo> listarVeiculosComFiltro(String filtro) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Veiculo> resultados = new ArrayList<>();

        try {
            String jpql = "SELECT v FROM Veiculo v";
            if (filtro != null && !filtro.trim().isEmpty()) {
                jpql += " WHERE LOWER(v.placa) LIKE LOWER(:filtro) OR LOWER(v.marcamodelo) LIKE LOWER(:filtro) OR LOWER(v.status) LIKE LOWER(:filtro)";
            }
            TypedQuery<Veiculo> query = em.createQuery(jpql, Veiculo.class);
            if (filtro != null && !filtro.trim().isEmpty()) {
                query.setParameter("filtro", "%" + filtro + "%");
            }
            resultados = query.getResultList();
            System.out.println("Veículos encontrados (filtrados): " + resultados.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return resultados;
    }
}
