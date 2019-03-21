/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esstatistiche;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author besan
 */
public class Th2 extends Thread {

    private DatiCondivisi g;

    public Th2(DatiCondivisi g) {

        this.g = g;

    }

    @Override

    public void run() {

        char[] v = g.getV();

        for (int i = 0; i < v.length; i++) {

            try {

                g.s2Wait();

            } catch (InterruptedException ex) {

                Logger.getLogger(Th2.class.getName()).log(Level.SEVERE, null, ex);

            }

            if (v[i] == ' ') {

                g.incrementaSpaziLetti();

            }

            try {

                g.s3Signal();

            } catch (InterruptedException ex) {

                Logger.getLogger(Th2.class.getName()).log(Level.SEVERE, null, ex);

            }

        }
    }
}
