package Application;

import java.util.Scanner;

import Entities.Menu;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int op;
        do{
        System.out.println("1. [Consultar média de idade dos pacientes]");
        System.out.println("2. [Consultar internações por ano]");
        System.out.println("3. [Consultar hospitais]");
        System.out.println("4. [Calcular tempo de internação]");
        System.out.println("5. [Determinar tempos de espera na fila]");
        System.out.println("6. [Terminar o programa]");
        op = sc.nextInt();
        Menu menu = new Menu();
        menu.menuExe(op);
        }while(op != 6);
        
        

        sc.close();
    }
}
