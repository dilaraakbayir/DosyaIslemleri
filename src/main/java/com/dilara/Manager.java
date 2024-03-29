package com.dilara;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Manager {
    private String file;
    private String path;

    public Manager(String file) {
        this.file = file;
        this.path = "src/main/resources/" + file;
    }
    public List<Ogrenci> dosyadanVeriOku(String ogretmenIsmi, BufferedReader bufferedReader) throws IOException {
        List<Ogrenci> ogrenciListesi = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {

            String[] parts = line.split(",");
            String isim = parts[0];
            List<String> notlar = new ArrayList<>();
            notlar.add((parts[1]));
            notlar.add((parts[2]));
            notlar.add((parts[3]));

            double ort = ortalamaHesapla(notlar);

            Ogrenci ogrenci = new Ogrenci(isim, ort);
            ogrenciListesi.add(ogrenci);

            System.out.println("Öğretmen: " + ogretmenIsmi + ", " + isim + " adlı öğrencinin notlarını okudu. " +
                    "Öğrenci not ortalaması: "+ort+ "-->  "+ogrenci.getDurum()+"!");

        }
        return ogrenciListesi;
    }

    public double ortalamaHesapla(List<String> notlar){
        double toplam = 0;
        for (String not : notlar) {
            toplam += Double.parseDouble(not);
        }
        return toplam / notlar.size();
    }
    public void ogretmenDosyasiOlustur(List<Ogrenci> ogrenciListesi, String ogretmenIsmi) {
        String dosyaYolu = "src/main/resources/" + ogretmenIsmi + ".txt";
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(dosyaYolu))) {
            outputStream.writeObject(ogrenciListesi);
            System.out.println(ogretmenIsmi + " isimli öğretmenin öğrenci dosyası oluşturuldu.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Ogrenci> ogrencileriGetir(String ogretmenIsmi) {
        String dosyaYolu = "src/main/resources/" + ogretmenIsmi + ".txt";
        List<Ogrenci> ogrenciler = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(dosyaYolu))) {
            ogrenciler = (List<Ogrenci>) inputStream.readObject();
            System.out.println(ogretmenIsmi + " isimli öğretmenin öğrenci dosyası okundu.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ogrenciler;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
