/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eslotto;

import java.util.Random;

/**
 *
 * @author besan
 */
public class ThEstrai extends Thread {

    private final DatiCondivisi ptrDati;

    public ThEstrai(DatiCondivisi ptrDati) {

        this.ptrDati = ptrDati;

    }

    @Override

    public void run() {

        Random ran = new Random();

        int est = ptrDati.getnEstrazioni();

        Ruota ru = ptrDati.getR();

        int maxElem = ptrDati.getMaxElem();

        int i = 1;

        while (i <= est) {

            int estratti[] = new int[maxElem];

            for (int j = 0; j < maxElem; j++) {

                estratti[j] = ran.nextInt(90) + 1;

                int k = 0;

                while (k < j) {

                    if (estratti[k] == estratti[j]) {

                        estratti[j] = ran.nextInt(90) + 1;

                        k = 0;

                    }

                    k++;

                }

            }

            ru.setEstratti(estratti);

            i++;

            ptrDati.signalSem1();

            ptrDati.signalSem2();

            ptrDati.waitSem3();

            ptrDati.waitSem3();

            ptrDati.controllaVincita();

        }

        ptrDati.signalSem4();

    }
}
