package br.com.projeto.gerenciadorusuarios.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @Entity - Anotação que informa ao Spring que esta classe é uma entidade,
 * ou seja, ela representa uma tabela no banco de dados.
 * @Table(name = "usuarios") - Especifica o nome exato da tabela no banco de dados.
 * É uma boa prática usar nomes no plural para tabelas.
 * @Data - Anotação da biblioteca Lombok. Ela cria automaticamente em tempo de compilação
 * todos os métodos básicos: getters, setters, toString, equals e hashCode.
 * Isso deixa nosso código muito mais limpo!
 */
@Entity
@Table(name = "usuarios")
@Data
public class Usuario {

    /**
     * @Id - Marca este campo como a chave primária da tabela.
     * @GeneratedValue(strategy = GenerationType.IDENTITY) - Configura a forma como a
     * chave primária é gerada. 'IDENTITY' significa que o próprio banco de dados
     * (PostgreSQL, neste caso) ficará responsável por gerar e incrementar o valor
     * do ID automaticamente sempre que um novo usuário for inserido.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * @Column(nullable = false) - Indica que esta coluna na tabela do banco de dados
     * não pode ter valores nulos.
     */
    @Column(nullable = false)
    private String nomeCompleto;

    /**
     * @Column(nullable = false, unique = true) - Além de não poder ser nulo,
     * o valor desta coluna deve ser único em toda a tabela. O banco de dados
     * não permitirá que dois usuários tenham o mesmo email.
     */
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private LocalDate dataNascimento;

}