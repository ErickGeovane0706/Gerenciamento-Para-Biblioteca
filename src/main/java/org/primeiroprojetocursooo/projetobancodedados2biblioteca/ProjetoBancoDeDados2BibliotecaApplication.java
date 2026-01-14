package org.primeiroprojetocursooo.projetobancodedados2biblioteca;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoBancoDeDados2BibliotecaApplication {

    public static void main(String[] args) {
        // Inicia a aplicação JavaFX, que depois inicia o Spring
        Application.launch(JavaFxApplication.class, args);
    }
}