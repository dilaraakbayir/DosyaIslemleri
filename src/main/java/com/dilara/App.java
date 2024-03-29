package com.dilara;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Manager manager = new Manager("ogrenciler.txt");
        Ogretmen ogretmen = new Ogretmen("Dilara");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(manager.getPath()))) {
            List<Ogrenci> ogrenciler = manager.dosyadanVeriOku(ogretmen.getOgretmenIsmi(), bufferedReader);
            ogretmen.dosyaOlustur(manager);
            ogretmen.dosyadanOgrencileriGetir(manager);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader bufferedReader2 = new BufferedReader(new FileReader(manager.getPath()))) {
            ogretmen.notlariOku(bufferedReader2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
