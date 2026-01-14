package org.primeiroprojetocursooo.projetobancodedados2biblioteca;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {

    // Injeta o local do arquivo FXML
    @Value("classpath:/fxml/login.fxml")
    private Resource loginFxml;

    private final ApplicationContext applicationContext;

    // Precisamos do contexto do Spring para injetar os Controllers
    public StageInitializer(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(loginFxml.getURL());

            // Esta linha é mágica: diz ao JavaFX para usar o Spring para criar os controllers
            // Assim, o UsuarioService funciona dentro do LoginController!
            fxmlLoader.setControllerFactory(applicationContext::getBean);

            Parent parent = fxmlLoader.load();
            Stage stage = event.getStage();
            stage.setScene(new Scene(parent, 600, 400));
            stage.setTitle("Login - Biblioteca");
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}