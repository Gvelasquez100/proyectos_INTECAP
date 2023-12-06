/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea_3;

/**
 *
 * @author German Velasquez
 */
public class Tarea_3 {


    public static void main(String[] args) {
        
        for (int i = 1; i <= 10; i++) {
            
            if (i% 2 ==0){
                System.out.println("numeros pares:"+i);
            }
          
        }
        
        for (int j = 1; j <= 10; j++) {
            if (j%2 != 0){
                System.out.println("estos numeros son impares:"+j);
            }
     
        }
               System.out.println("---------------\n");
        int numeros5 [] = new int [10];
        for (int k = 0; k < 10; k++) {
            numeros5 [k] = (k+1)*5;
        }
        for (int k = 0; k < 10; k++) {
            System.out.println("numeros de 5 en 5:\n"+numeros5[k]);
        }
        System.out.println("----------------Tablas de multiplicar\n");
        
        int m = 1;
        while(m <= 10){
            
         int n = 1;
            while (n <=10) {                
                int resultado = m *n ;
                System.out.println(m + "x" +n+"="+ resultado);
                n++;
            }
            m++; 
            System.out.println("-------------------");
        }
        
String nombre = "*";   
for (int i = 0; i < 10; i++) {     
    System.out.println(nombre);   
    nombre +="*"; 
    
}

//int multiplos [] = {1,2,3,4,5,6,7,8,9};
//multiplos [2] = 7;
       // System.out.println(multiplos [1]*5);
    }
    
    
}
