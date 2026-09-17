package com.company;
public class AVela extends Barca{
    public static final double SCONTO=0.01;
    public static final int ANNO=2026;



     public AVela(String modello,int lunghezza,Motori motore,int anno_costruzione, int anno_noleggio,int prezzo_vendita){
    super(modello,lunghezza,motore,anno_costruzione,anno_noleggio,prezzo_vendita);


    }
  public String getTipo()  {return "barca a vela";}
  public double getSconto(){
  int c=ANNO-anno_noleggio;
  if(c<7){
  return c*SCONTO;}else
      {return SCONTO*7;}

     }

}
