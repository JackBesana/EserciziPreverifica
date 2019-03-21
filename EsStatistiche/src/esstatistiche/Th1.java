/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esstatistiche;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author besan
 */
public class Th1 extends Thread {

    private String sequenza;

    private int SIZE;

    private int tempo;

    private DatiCondivisi g;

    public Th1(DatiCondivisi d, int tempo) {

        sequenza = "abcdefghijklmnoprstuvwxyz .,";

        SIZE = sequenza.length();

        g = d;

        this.tempo = tempo;

    }

    public Th1() {

        sequenza = "abcdefghijklmnoprstuvwxyz .,";

        SIZE = sequenza.length();

    }

    @Override

    public void run() {

        Random r = new Random();

        int i = 0;

        while (i < tempo) {

            try {

                g.s1Wait();

            } catch (InterruptedException ex) {

                Logger.getLogger(Th1.class.getName()).log(Level.SEVERE, null, ex);

            }

            char t = sequenza.charAt(r.nextInt(SIZE));

            if (t == ' ') {

                g.incrementaSpaziInseriti();

            }

            if (t == '.') {

                g.incrementaPuntiInseriti();

            }

            g.inserisci(t);

            i++;

            try {

                g.s2Signal();

            } catch (InterruptedException ex) {

                Logger.getLogger(Th1.class.getName()).log(Level.SEVERE, null, ex);

            }

        }

    }
}
