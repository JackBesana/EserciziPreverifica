/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esstatistiche;

import java.util.concurrent.Semaphore;

/**
 *
 * @author besan
 */
public class DatiCondivisi {

    private char[] v = new char[100000];

    private Semaphore s1, s2, s3, s4;

    private int elementiPresenti, numSpaziInseriti, numPuntiInseriti, numSpaziLetti, numPuntiLetti;

    public DatiCondivisi() {

        numSpaziInseriti = 0;

        elementiPresenti = 0;

        numPuntiInseriti = 0;

        numSpaziLetti = 0;

        numPuntiLetti = 0;

        s1 = new Semaphore(1);

        s2 = new Semaphore(0);

        s3 = new Semaphore(0);

        s4 = new Semaphore(0);

    }

    public void s1Wait() throws InterruptedException {

        s1.acquire();

    }

    public void s2Wait() throws InterruptedException {

        s2.acquire();

    }

    public void s3Wait() throws InterruptedException {

        s3.acquire();

    }

    public void s4Wait() throws InterruptedException {

        s4.acquire();

    }

    public void s1Signal() throws InterruptedException {

        s1.release();

    }

    public void s2Signal() throws InterruptedException {

        s2.release();

    }

    public void s3Signal() throws InterruptedException {

        s3.release();

    }

    public void s4Signal() throws InterruptedException {

        s4.release();

    }

    public synchronized char[] getV() {

        return v;

    }

    public int getNumSpaziInseriti() {

        return numSpaziInseriti;

    }

    public int getNumPuntiInseriti() {

        return numPuntiInseriti;

    }

    public int getElementiPresenti() {

        return elementiPresenti;

    }

    public int getNumSpaziLetti() {

        return numSpaziLetti;

    }

    public int getNumPuntiLetti() {

        return numPuntiLetti;

    }

    public void incrementaPuntiInseriti() {

        numPuntiInseriti++;

    }

    public void incrementaSpaziInseriti() {

        numSpaziInseriti++;

    }

    public void incrementaPuntiLetti() {

        numPuntiLetti++;

    }

    public void incrementaSpaziLetti() {

        numSpaziLetti++;

    }

    public synchronized void inserisci(char c) {

        v[elementiPresenti] = c;

        elementiPresenti++;

    }

    public synchronized void visualizza() {

        for (int i = 0; i < this.elementiPresenti; i++) {

            System.out.println(v[i]);

        }

    }
}
