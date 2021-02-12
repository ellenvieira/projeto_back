package br.itmnon.itmnon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import br.itmnon.itmnon.model.Usuario;
import br.itmnon.itmnon.repository.UsuarioRepo;

@Controller
@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioRepo userRepo;
    // private UsuarioRepository usuarioRepository;
    // private Seguranca seguranca;

    
    @GetMapping("/login/{racf}/{email}/{senha}")
    public ResponseEntity<Usuario> buscaRacf(@PathVariable String racf, @PathVariable String email,
            @PathVariable String senha) throws Exception {

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] digest = md.digest(senha.getBytes(StandardCharsets.UTF_8));
        senha = DatatypeConverter.printHexBinary(digest).toLowerCase();

        Usuario racfEncontrado = userRepo.findByRacf(racf, email, senha); // findAllById = Busca pela chave primária

        if (racfEncontrado != null) {

            return ResponseEntity.ok(racfEncontrado); // Ok = Status 200

        } else {

            return ResponseEntity.notFound().build(); // notFound = status 404
        }

    }

    @RequestMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody Usuario usuario) throws Exception {

        String senha= usuario.getSenha();
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] digest = md.digest(senha.getBytes(StandardCharsets.UTF_8));
        senha = DatatypeConverter.printHexBinary(digest).toLowerCase();

        Usuario userFound = userRepo.findByEmailOrRacf(usuario.getEmail(), usuario.getRacf());

        if (userFound != null) { // achou o usuário no BD

            if (userFound.getSenha().equals(senha)) {

                userFound.setSenha("***********"); //Mascarar senha
                return ResponseEntity.ok(userFound);
            }

        }

        return ResponseEntity.status(404).build(); // usuário não existe ou senha inválida
    }

}