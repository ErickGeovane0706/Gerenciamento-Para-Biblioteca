package org.primeiroprojetocursooo.projetobancodedados2biblioteca;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class JavaFxApplication extends Application {

    private ConfigurableApplicationContext context;

    @Override
    public void init() {
        // ATENÇÃO AQUI: A classe fonte deve ser a sua classe Main principal
        this.context = new SpringApplicationBuilder()
                .sources(ProjetoBancoDeDados2BibliotecaApplication.class)
                .run(getParameters().getRaw().toArray(new String[0]));
    }

    @Override
    public void start(Stage stage) {
        context.publishEvent(new StageReadyEvent(stage));
    }

    @Override
    public void stop() {
        context.close();
        Platform.exit();
    }
}