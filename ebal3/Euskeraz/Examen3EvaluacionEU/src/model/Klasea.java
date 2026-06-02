package model;

public class Klasea {

    private int idKlasea;
    private String izena;
    private String instruktorea;
    private String ordutegia;

    // =========================
    // KONSTRUKTORE HUTSA
    // =========================
    public Klasea() {
    }

    // =========================
    // KONSTRUKTORE OSOA
    // =========================
    public Klasea(int idKlasea, String izena, String instruktorea, String ordutegia) {
        this.idKlasea = idKlasea;
        this.izena = izena;
        this.instruktorea = instruktorea;
        this.ordutegia = ordutegia;
    }

    // =========================
    // GETTERS ETA SETTERS
    // =========================
    public int getIdKlasea() {
        return idKlasea;
    }

    public void setIdKlasea(int idKlasea) {
        this.idKlasea = idKlasea;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getInstruktorea() {
        return instruktorea;
    }

    public void setInstruktorea(String instruktorea) {
        this.instruktorea = instruktorea;
    }

    public String getOrdutegia() {
        return ordutegia;
    }

    public void setOrdutegia(String ordutegia) {
        this.ordutegia = ordutegia;
    }

    // =========================
    // TO STRING (aukerakoa)
    // =========================
    @Override
    public String toString() {
        return "Klasea{" +
                "idKlasea=" + idKlasea +
                ", izena='" + izena + '\'' +
                ", instruktorea='" + instruktorea + '\'' +
                ", ordutegia='" + ordutegia + '\'' +
                '}';
    }
}