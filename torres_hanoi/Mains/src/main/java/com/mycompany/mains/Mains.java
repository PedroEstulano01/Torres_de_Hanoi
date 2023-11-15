/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mains;

import java.util.concurrent.TimeUnit;

public class Mains {

    static long movimentos = 0;

    public static void main(String[] args) {
        long[] discos = {41L};
        for (long n : discos) {
            movimentos = 0;
            long inicio = System.currentTimeMillis();
            hanoi(n, 'A', 'B', 'C');
            long fim = System.currentTimeMillis();
            long duracao = fim - inicio;
            String tempo = String.format("%02d:%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(duracao),
                    TimeUnit.MILLISECONDS.toMinutes(duracao) % TimeUnit.HOURS.toMinutes(1),
                    TimeUnit.MILLISECONDS.toSeconds(duracao) % TimeUnit.MINUTES.toSeconds(1),
                    TimeUnit.MILLISECONDS.toMillis(duracao) % TimeUnit.SECONDS.toMillis(1)
            );
            System.out.println("Número de discos: " + n);
            System.out.println("Movimentos: " + movimentos);
            System.out.println("Tempo de execução: " + tempo);
            System.out.println("-----------------------------");
        }
    }

    public static void hanoi(long n, char origem, char destino, char auxiliar) {
        if (n > 0) {
            hanoi(n - 1, origem, auxiliar, destino);
            movimentos++;
            hanoi(n - 1, auxiliar, destino, origem);
        }
    }
}
