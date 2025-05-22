package br.com.senac.etapa6piuc015.Model;

/**
 * Representa um usuário do sistema.
 *
 * Essa classe armazena informações básicas sobre um usuário, incluindo sua
 * identificação, nome, login, senha e tipo de usuário.
 *
 * * @author [Adriano]
 * @version JDK 22.0
 */
public class Usuario {

    /**
     * Identificador único do usuário (atributo privado).
     */
    private int id;

    /**
     * Nome do usuário (atributo privado).
     */
    private String nome;

    /**
     * Login de acesso do usuário (atributo privado).
     */
    private String login;

    /**
     * Senha do usuário (atributo privado).
     */
    private String senha;

    /**
     * Tipo de usuário (por exemplo, Administrador, Operador, Usuário) (atributo
     * privado).
     */
    private String tipo;

    /**
     * Retorna o identificador único do usuário.
     *
     * @return O valor do atributo `id`.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador único do usuário.
     *
     * @param id O novo valor para o atributo `id`.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o nome do usuário.
     *
     * @return O valor do atributo `nome`.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do usuário.
     *
     * @param nome O novo valor para o atributo `nome`.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o login de acesso do usuário.
     *
     * @return O valor do atributo `login`.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Define o login de acesso do usuário.
     *
     * @param login O novo valor para o atributo `login`.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Retorna a senha do usuário.
     *
     * **Observação:** Por motivos de segurança, é comum não retornar a senha
     * diretamente. Poderíamos retornar `null` ou um hash da senha.
     *
     * @return O valor do atributo `senha`.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define a senha do usuário.
     *
     * @param senha O novo valor para o atributo `senha`.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Retorna o tipo de usuário (por exemplo, Administrador, Operador,
     * Usuário).
     *
     * @return O valor do atributo `tipo`.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define o tipo de usuário (por exemplo, Administrador, Operador, Usuário).
     *
     * @param tipo O novo valor para o atributo `tipo`.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
