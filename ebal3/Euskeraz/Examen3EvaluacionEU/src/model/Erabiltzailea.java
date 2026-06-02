package model;

public class Erabiltzailea {

    private int idErabiltzailea;
    private String izena;
    private String pasahitza;
    private String rola;

    public Erabiltzailea() {}

    public Erabiltzailea(int idErabiltzailea, String izena, String pasahitza, String rola) {
        this.idErabiltzailea = idErabiltzailea;
        this.izena = izena;
        this.pasahitza = pasahitza;
        this.rola = rola;
    }

    public int getIdErabiltzailea() {
        return idErabiltzailea;
    }

    public void setIdErabiltzailea(int idErabiltzailea) {
        this.idErabiltzailea = idErabiltzailea;
    }

    public String getIzena() {
        return izena;
    }

    public String getPasahitza() {
        return pasahitza;
    }

    public String getRola() {
        return rola;
    }
}
