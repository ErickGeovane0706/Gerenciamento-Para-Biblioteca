package org.primeiroprojetocursooo.projetobancodedados2biblioteca;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        Stage stage = event.getStage();

        // Tela de teste provisória
        Label label = new Label("Funcionou! Spring + JavaFX conectados.");
        StackPane root = new StackPane(label);
        Scene scene = new Scene(root, 600, 400);

        stage.setScene(scene);
        stage.setTitle("Biblioteca");
        stage.show();
    }
}
