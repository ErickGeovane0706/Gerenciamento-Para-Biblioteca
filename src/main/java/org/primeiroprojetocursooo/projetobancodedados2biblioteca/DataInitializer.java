package org.primeiroprojetocursooo.projetobancodedados2biblioteca;

import org.primeiroprojetocursooo.projetobancodedados2biblioteca.Repository.UsuarioRepository;
import org.primeiroprojetocursooo.projetobancodedados2biblioteca.entity.Usuario;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // Importação Nova

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {
        long conta = usuarioRepository.count();

        if (conta == 0) {
            // Instancia o encriptador
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            Usuario admin = new Usuario();
            admin.setNome("Administrador Sistema");
            admin.setEmail("admin@email.com");

            // AQUI ESTÁ A MUDANÇA: Criptografa a senha antes de salvar
            String senhaCriptografada = passwordEncoder.encode("123456");
            admin.setSenha(senhaCriptografada);

            // Se tiver outros campos obrigatórios na sua entidade, preencha aqui
            // admin.setTipo("ADMIN");

            usuarioRepository.save(admin);

            System.out.println("---------------------------------");
            System.out.println("USUÁRIO ADMIN CRIADO (COM SENHA CRIPTOGRAFADA)!");
            System.out.println("Login: admin@email.com");
            System.out.println("Senha: 123456");
            System.out.println("---------------------------------");
        } else {
            System.out.println("Banco de dados já contém usuários. Pulei a criação.");
        }
    }
}