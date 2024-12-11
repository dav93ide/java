/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg16_mezzitrasporto;

/**
 *
 * @author adrianobotteon
 */
public class impiegato {
    int matricola;
    String nome;
    String cognome;    
    boolean patB, patC, patD;
    
    public impiegato (int m, String n, String c, boolean pB, boolean pC, boolean pD) {
        matricola = m;
        nome = n;
        cognome = c;
        patB = pB;
        patC = pC;
        patD = pD;
    }
    
}
