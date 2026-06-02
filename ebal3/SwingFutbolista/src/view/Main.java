package view;

import view.LeihoNagusia;
import controller.Kontrolatzailea;

public class Main {

    public static void main(String[] args) {

        LeihoNagusia leihoa = new LeihoNagusia();
        new Kontrolatzailea(leihoa);
    }
}