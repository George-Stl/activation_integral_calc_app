package com.activation.integral.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class ActivationIntegralApp extends Application {

	private ConfigurableApplicationContext springContext;
	private Parent root;

	@Override
	public void init() throws IOException {
		springContext = new SpringApplicationBuilder(ActivationIntegralApp.class).run();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ActivationIntegral.fxml"));
		loader.setControllerFactory(springContext::getBean);
		root = loader.load();
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Расчет активационных интегралов");
		primaryStage.setScene(new Scene(root, 800, 600));
		primaryStage.setMinWidth(600);
		primaryStage.setMinHeight(400);
		primaryStage.show();
	}

	@Override
	public void stop() {
		springContext.close();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
