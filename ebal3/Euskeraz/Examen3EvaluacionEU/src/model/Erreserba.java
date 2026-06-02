package model;

import java.time.LocalDate;

public class Erreserba {

    private int idErreserba;
    private int idBezeroa;
    private LocalDate data;
    private int idKlasea;

    // TAULAN BISTARATZEKO (JOIN)
    private String bezeroIzena;
    private String klaseIzena;

    // =========================
    // KONSTRUKTORE HUTSA
    // =========================
    public Erreserba() {
    }

    // =========================
    // GETTERS ETA SETTERS
    // =========================
    public int getIdErreserba() {
        return idErreserba;
    }

    public void setIdErreserba(int idErreserba) {
        this.idErreserba = idErreserba;
    }

    public int getIdBezeroa() {
        return idBezeroa;
    }

    public void setIdBezeroa(int idBezeroa) {
        this.idBezeroa = idBezeroa;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getIdKlasea() {
        return idKlasea;
    }

    public void setIdKlasea(int idKlasea) {
        this.idKlasea = idKlasea;
    }

    public String getBezeroIzena() {
        return bezeroIzena;
    }

    public void setBezeroIzena(String bezeroIzena) {
        this.bezeroIzena = bezeroIzena;
    }

    public String getKlaseIzena() {
        return klaseIzena;
    }

    public void setKlaseIzena(String klaseIzena) {
        this.klaseIzena = klaseIzena;
    }

    // =========================
    // TO STRING
    // =========================
    @Override
    public String toString() {
        return "Erreserba{" +
                "idErreserba=" + idErreserba +
                ", idBezeroa=" + idBezeroa +
                ", data=" + data +
                ", idKlasea=" + idKlasea +
                ", bezeroIzena='" + bezeroIzena + '\'' +
                ", klaseIzena='" + klaseIzena + '\'' +
                '}';
    }
}