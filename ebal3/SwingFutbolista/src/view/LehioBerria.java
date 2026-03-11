package view;

import java.io.IOException;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LehioBerria {
	public LehioBerria(Stage stage) {

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/FutbolKudeaketa.fxml"));

			Scene scene = new Scene(root);
			stage.setTitle("Futbol Kudeaketa - 2026 Dashboard");
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			System.err.println("Errorea FXML fitxategia kargatzean: " + e.getMessage());
		}

	}
}
