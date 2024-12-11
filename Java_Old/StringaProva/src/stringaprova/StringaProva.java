/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringaprova;

public class StringaProva {

    public static void main(String[] args) {
        String str1 = "ciao";
        String str2 = "buongiorno";
        char[] array = {'c','i','a','o'};
        String str3 = new String(array);
        String str4 = " d dddd            ".trim();     // .trim elimina caratteri di spazio nella stringa.
        System.out.print(str1);
        System.out.print(
                "'"+ str2 +"'\n" +
                "'"+ str3 +"'\n");
    }
    
}
