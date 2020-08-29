package com.UTCJ.domotica;

import android.app.Activity;

public class Consumo extends Activity {
    private Double Rele_1;
    private Double Rele_2;
    private Double Rele_3;
    private Double Rele_4;
    private Double Rele_5;
    private Double Rele_6;
    private Double Rele_7;
    private Double Rele_8;

    public Consumo(Double Rele_1, Double Rele_2, Double Rele_3, Double Rele_4, Double Rele_5, Double Rele_6, Double Rele_7, Double Rele_8){
        this.Rele_1 = Rele_1;
        this.Rele_2 = Rele_2;
        this.Rele_3 = Rele_3;
        this.Rele_4 = Rele_4;
        this.Rele_5 = Rele_5;
        this.Rele_6 = Rele_6;
        this.Rele_7 = Rele_7;
        this.Rele_8 = Rele_8;
    }

    public Consumo(){

    }

    public Double getRele_1() {
        return Rele_1;
    }

    public void setRele_1(Double rele_1) {
        Rele_1 = rele_1;
    }

    public Double getRele_2() {
        return Rele_2;
    }

    public void setRele_2(Double rele_2) {
        Rele_2 = rele_2;
    }

    public Double getRele_3() {
        return Rele_3;
    }

    public void setRele_3(Double rele_3) {
        Rele_3 = rele_3;
    }

    public Double getRele_4() {
        return Rele_4;
    }

    public void setRele_4(Double rele_4) {
        Rele_4 = rele_4;
    }

    public Double getRele_5() {
        return Rele_5;
    }

    public void setRele_5(Double rele_5) {
        Rele_5 = rele_5;
    }

    public Double getRele_6() {
        return Rele_6;
    }

    public void setRele_6(Double rele_6) {
        Rele_6 = rele_6;
    }

    public Double getRele_7() {
        return Rele_7;
    }

    public void setRele_7(Double rele_7) {
        Rele_7 = rele_7;
    }

    public Double getRele_8() {
        return Rele_8;
    }

    public void setRele_8(Double rele_8) {
        Rele_8 = rele_8;
    }
}
