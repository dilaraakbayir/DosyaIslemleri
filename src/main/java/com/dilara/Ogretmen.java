package com.dilara;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ogretmen {
    private String ogretmenIsmi;
    private List<Ogrenci> ogrenciler;

    public Ogretmen(String ogretmenIsmi) {
        this.ogretmenIsmi = ogretmenIsmi;
        this.ogrenciler = new ArrayList<>();
    }
    public List<String> notlariOku(BufferedReader bufferedReader) throws IOException {
        List<Ogrenci> ogrenciListesi = new ArrayList<>();
        String line;
        List<String> notlar = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            String[] parts = line.split(",");
            String isim = parts[0];
            notlar.add((parts[1]));
            notlar.add((parts[2]));
            notlar.add((parts[3]));

            Ogrenci ogrenci = new Ogrenci(isim);
            ogrenciListesi.add(ogrenci);

            System.out.println(isim + " adlı öğrencinin notları: " + notlar);
        }
        return notlar;
    }

    public void dosyaOlustur(Manager manager) {
        manager.ogretmenDosyasiOlustur(ogrenciler, ogretmenIsmi);
    }

    public void dosyadanOgrencileriGetir(Manager manager) {
        ogrenciler = manager.ogrencileriGetir(ogretmenIsmi);
        for (Ogrenci ogrenci : ogrenciler) {
            System.out.println(ogrenci);
        }
    }

    public String getOgretmenIsmi() {
        return ogretmenIsmi;
    }

    public void setOgretmenIsmi(String ogretmenIsmi) {
        this.ogretmenIsmi = ogretmenIsmi;
    }

    public List<Ogrenci> getOgrenciler() {
        return ogrenciler;
    }

    public void setOgrenciler(List<Ogrenci> ogrenciler) {
        this.ogrenciler = ogrenciler;
    }
}
