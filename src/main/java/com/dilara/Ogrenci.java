package com.dilara;

import java.time.LocalDate;
import java.util.Date;

public class Ogrenci {
    private String isim;
    private double ort;
    private EDurumOgrenci durum;
    private Date dogumTarihi;

    public Ogrenci(String isim, double ort) {
        this.isim = isim;
        this.ort = ort;
        durumBelirle();
    }
    public Ogrenci(String isim) {
        this.isim = isim;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public double getOrt() {
        return ort;
    }

    public void setOrt(double ort) {
        this.ort = ort;
    }

    public EDurumOgrenci getDurum() {
        return durum;
    }

    public void setDurum(EDurumOgrenci durum) {
        this.durum = durum;
    }

    public Date getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(Date dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public void durumBelirle(){
        if (ort >= 60) {
            durum = EDurumOgrenci.GECTI;
        } else {
            durum = EDurumOgrenci.KALDI;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ogrenci{");
        sb.append("isim='").append(isim).append('\'');
        sb.append(", ort=").append(ort);
        sb.append(", durum=").append(durum);
        sb.append(", dogumTarihi=").append(dogumTarihi);
        sb.append('}');
        return sb.toString();
    }
}
