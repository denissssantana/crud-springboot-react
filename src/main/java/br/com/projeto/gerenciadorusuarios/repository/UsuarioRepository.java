
package br.com.projeto.gerenciadorusuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.gerenciadorusuarios.model.Usuario;

/**
 * @Repository - Anotação que indica ao Spring que esta interface é um "Repositorio".
 * Isso a torna um "bean" gerenciado pelo Spring, o que nos permite injetá-la
 * em outras classes, como o nosso futuro Controller.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    // A mágica acontece aqui!
    // Não precisamos de escrever nenhum método por enquanto.
    // Ao estender JpaRepository, já herdamos métodos como:
    // save() -> para salvar ou atualizar um usuário
    // findById() -> para buscar um usuário pelo seu ID
    // findAll() -> para buscar todos os usuários
    // deleteById() -> para apagar um usuário
    // E muitos outros!
}
