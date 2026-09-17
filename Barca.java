package com.company;
public abstract class Barca implements Comparable<Barca>{
    public static final int IBRIDO=100;
    static int counter=0;
    int id;
    String modello;
    public enum Motori{BENZINA,DIESEL,IBRIDO};
    Motori motore;
int lugnhezza;
int anno_costruzione;
int prezzo_vendita;
int anno_noleggio;

public Barca(String modello,int lunghezza,Motori motore,int anno_costruzione, int anno_noleggio,int prezzo_vendita){
this.id=++counter;
this.modello=modello;
this.lugnhezza=lunghezza;
this.motore=motore;
this.anno_costruzione=anno_costruzione;
this.anno_noleggio=anno_noleggio;
this.prezzo_vendita=prezzo_vendita;

}
public abstract String getTipo();
public  String toString(){
String res;
res="Id: "+id+"\n";
res+="tipologia: "+getTipo()+"\n";
res+="modello: "+modello+"\n";
res+="lunghezza: "+lugnhezza+"\n";
res+="motore: "+motore+"\n";
res+="anno di costruzione: "+anno_costruzione+"\n";
res+="anno di primo noleggio: "+anno_noleggio+"\n";
res+="prezzo vendita: "+prezzo_vendita+"$\n";
res+="prezzo noleggio: "+getNoleggio()+"$\n";
return res;
}
public double getNoleggio(){
double noleggio=prezzo_vendita*0.1*(1-getSconto());
if(motore==Motori.IBRIDO){
noleggio-=IBRIDO;
}
return noleggio;
}
public abstract double getSconto();

public int compareTo(Barca barca){
return Integer.compare(this.id,barca.id);
}

}
