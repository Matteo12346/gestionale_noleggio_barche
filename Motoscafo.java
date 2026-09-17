package com.company;
public class Motoscafo extends Barca {
    public static final double Motos=0.07;
    public Motoscafo(String modello,int lunghezza,Motori motore,int anno_costruzione, int anno_noleggio,int prezzo_vendita){
    super(modello,lunghezza,motore,anno_costruzione,anno_noleggio,prezzo_vendita);


    }
public String getTipo(){return "Motoscafo";}
public double getSconto(){
return Motos;
    }
}
