package Blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Mazo {

    private ArrayList<Carta> cartas = new ArrayList<>();

    // Constructor sin parámetros
    public Mazo() {
        // Generar todas las cartas del mazo
        for (Carta.Palo p : Carta.Palo.values()) {
            for (int i = 1; i <= 13; i++) {
                cartas.add(new Carta(i, p));
            }
        }
    }

    // Método para barajar el mazo de cartas
    public void barajar() {
        Collections.shuffle(cartas);
    }

    // Sobrescritura del método toString para mostrar el mazo de cartas
    public String toString() {
        for (Carta carta : cartas) {
            return cartas.toString();
        }
        return "";
    }

    // Método para solicitar una carta del mazo
    public Carta solicitarCarta() {
        if (cartas.isEmpty()) {
            return null; // Devuelve null si el mazo está vacío
        }
        return cartas.remove(0); // Devuelve y elimina la primera carta del mazo
    }
}