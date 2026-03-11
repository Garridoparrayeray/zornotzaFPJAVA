package view;

import view.*;
import controller.Kontrolatzailea;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main {
//	@Override
//    public void start(Stage primaryStage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("/view/FutbolKudeaketa.fxml"));
//
//        primaryStage.setTitle("Futbol Kudeaketa - Dashboard 2026");
//        
//        Scene scene = new Scene(root, 1100, 700);
//        
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
    public static void main(String[] args) {

        LeihoNagusia leihoa = new LeihoNagusia();
        new Kontrolatzailea(leihoa);
        
    }

}