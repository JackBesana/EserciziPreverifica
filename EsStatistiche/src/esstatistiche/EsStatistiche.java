/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esstatistiche;

import java.util.Scanner;

/**
 *
 * @author besan
 */
public class EsStatistiche {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         java.io.BufferedReader console = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

        Scanner input = new Scanner(System.in);

        

        boolean finito = false;

        int tempo;

        DatiCondivisi d = new DatiCondivisi();

        

        System.out.println("quanti caratteri devo generare?");

        tempo= input.nextInt();

        

        Th1 th1 = new Th1(d,tempo);

        Th2 th2=new Th2(d);

        Th3 th3=new Th3(d);

        //Th4 th4=new Th4(d);



        th1.start();

        th2.start();

        th3.start();

        //th4.start();

        

        

       /* System.out.println("il numero di spazi inseriti e': "+d.getNumSpaziInseriti());

        System.out.println("------------------");

        System.out.println("il numero di spazi letti e': "+d.getNumSpaziLetti());

        System.out.println("------------------");

        System.out.println("il numero di punti inseriti e': "+d.getNumPuntiInseriti());

        System.out.println("------------------");

        System.out.println("il numero di punti letti e': "+d.getNumPuntiLetti());*/

    }
    }
    

