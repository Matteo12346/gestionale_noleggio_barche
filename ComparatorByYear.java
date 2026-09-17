package com.company;import java.util.Comparator;

public class ComparatorByYear implements Comparator<Barca> {
    @Override
    public int compare(Barca o1, Barca o2) {
        int ris = o2.anno_noleggio - o1.anno_noleggio;
        if(ris == 0) {
            ris = o1.anno_costruzione - o2.anno_costruzione;
        }

        return ris;
    }
}