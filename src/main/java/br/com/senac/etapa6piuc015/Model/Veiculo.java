package br.com.senac.etapa6piuc015.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

/**
 * Representa um veículo no sistema.
 *
 * Essa classe mapeia a entidade `Veiculo` para a persistência de dados em um
 * banco de dados relacional utilizando o JPA (Java Persistence API).
 *
 * @author [Adriano]
 * @version JDK 22.0
 */

@Entity
@Table(name = "veiculos")  
public class Veiculo {

      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;
    private int ano; 
    private String marcamodelo;
    private String cor;
    private double valordiaria;
    private String status;

    /**
     * Construtor padrão exigido pelo JPA.
     */
    public Veiculo() {
        // Construtor padrão sem argumentos
    }

    // Opcional: Construtor com todos os argumentos para conveniência
    public Veiculo(String placa, int ano, String marcamodelo, String cor, double valordiaria, String status) {
        this.placa = placa;
        this.ano = ano;
        this.marcamodelo = marcamodelo;
        this.cor = cor;
        this.valordiaria = valordiaria;
        this.status = status;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() { 
        return ano;
    }

    public void setAno(int ano) { 
        this.ano = ano;
    }

    public String getMarcamodelo() {
        return marcamodelo;
    }

    public void setMarcamodelo(String marcamodelo) {
        this.marcamodelo = marcamodelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getValordiaria() {
        return valordiaria;
    }

    public void setValordiaria(double valordiaria) {
        this.valordiaria = valordiaria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // equals() e hashCode() gerados com base no 'id'
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Veiculo other = (Veiculo) obj;
        return Objects.equals(this.id, other.id);
    }

    // toString() para melhor depuração
    @Override
    public String toString() {
        return "Veiculo{" + "id=" + id + ", placa=" + placa + ", ano=" + ano + ", marcamodelo=" + marcamodelo + ", cor=" + cor + ", valordiaria=" + valordiaria + ", status=" + status + '}';
    }
}