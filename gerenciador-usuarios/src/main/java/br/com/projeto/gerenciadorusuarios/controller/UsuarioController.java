package br.com.projeto.gerenciadorusuarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.gerenciadorusuarios.model.Usuario;
import br.com.projeto.gerenciadorusuarios.repository.UsuarioRepository;

/**
 * @RestController - Combina @Controller e @ResponseBody. Indica que esta classe é um
 * controller e que os retornos dos seus métodos devem ser convertidos para JSON
 * e enviados no corpo da resposta HTTP.
 * * @RequestMapping("/api/usuarios") - Define um prefixo de URL para todos os endpoints
 * deste controller. Ou seja, todos os caminhos começarão com "/api/usuarios".
 * * @CrossOrigin("*") - Lembra que falamos sobre o CORS? Esta anotação é a forma mais
 * simples de resolver. Ela permite que requisições de qualquer origem (qualquer URL,
 * como o nosso frontend React rodando em http://localhost:3000) possam chamar
 * os endpoints deste controller.
 */
@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    /**
     * @Autowired - Este é o mecanismo de Injeção de Dependência do Spring.
     * Em vez de nós mesmos criarmos uma instância com 'new UsuarioRepository()',
     * pedimos ao Spring para "injetar" uma instância gerenciada por ele.
     * O Spring encontra o "bean" do tipo UsuarioRepository e o disponibiliza para nós.
     */
    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * @PostMapping("/cadastrar") - Mapeia requisições HTTP do tipo POST para o caminho
     * "/api/usuarios/cadastrar". Usamos POST para criar novos recursos.
     * * @RequestBody Usuario usuario - Indica que o corpo (body) da requisição HTTP
     * (que virá em formato JSON do frontend) deve ser convertido para um objeto
     * da nossa classe 'Usuario'. O Spring faz essa conversão automaticamente.
     * * @return - O método retorna o próprio objeto 'usuario' após ser salvo.
     * O Spring irá convertê-lo para JSON na resposta. O cliente receberá o usuário
     * criado, agora incluindo o 'id' gerado pelo banco de dados.
     */
    @PostMapping("/cadastrar")
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
