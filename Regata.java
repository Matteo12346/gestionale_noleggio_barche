package com.company;

public class Regata extends Barca{

    String accessori;
     public Regata(String modello,int lunghezza,Motori motore,int anno_costruzione, int anno_noleggio,int prezzo_vendita,String a){
    super(modello,lunghezza,motore,anno_costruzione,anno_noleggio,prezzo_vendita);
this.accessori=a;

    }

    public String getTipo(){
    return "Da regata ";
     }
    public double getSconto(){ return 0;}

    public String toString(){
         String res=super.toString();

    res+="accessori: "+ accessori;
    return res;

     }
}
