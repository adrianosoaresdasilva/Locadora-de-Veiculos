package br.com.senac.etapa6piuc015.DAO;

import br.com.senac.etapa6piuc015.Model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe UsuarioDAO - Responsável por realizar operações de banco de dados
 * relacionadas à entidade Usuário.
 *
 * Essa classe fornece um método para validar o login de um usuário no sistema
 * utilizando JDBC direto.
 *
 * @author [Adriano]
 * @version JDK 22.0
 */
public class UsuarioDAO {

    /**
     * Valida o login de um usuário no sistema.
     *
     * O método verifica se o login e senha fornecidos pelo usuário correspondem
     * a um registro válido na tabela `usuario` do banco de dados.
     *
     * @param usuario O objeto Usuario contendo login e senha para validação.
     * @return O objeto Usuario se as credenciais forem válidas, ou null caso
     * contrário.
     */
    public Usuario validarUsuario(Usuario usuario) {
        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
        Usuario usuarioEncontrado = null;

        // Usando try-with-resources para garantir que Connection, PreparedStatement e ResultSet sejam fechados automaticamente
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/locadora", "root", "*#1908Ad"); PreparedStatement statement = conexao.prepareStatement(sql)) {

            statement.setString(1, usuario.getLogin());
            statement.setString(2, usuario.getSenha());

            try (ResultSet rs = statement.executeQuery()) { 
                if (rs.next()) { 
                    usuarioEncontrado = new Usuario();
                    usuarioEncontrado.setId(rs.getInt("id"));
                    usuarioEncontrado.setNome(rs.getString("nome"));
                    usuarioEncontrado.setLogin(rs.getString("login"));
                    usuarioEncontrado.setSenha(rs.getString("senha"));
                    usuarioEncontrado.setTipo(rs.getString("tipo"));
                }
            } // rs é fechado automaticamente aqui

        } catch (SQLException ex) {
            System.err.println("Erro de SQL ao validar usuário: " + ex.getMessage()); // Use System.err para erros
            ex.printStackTrace(); // Imprime o stack trace completo para depuração

        }
        // As conexões (conexao e statement) são fechadas automaticamente aqui
        return usuarioEncontrado;
    }
}
