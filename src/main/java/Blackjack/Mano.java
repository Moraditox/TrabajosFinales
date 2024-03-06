package Blackjack;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "mano")
public class Mano extends Mazo{
    @XmlElement(name = "manoJugador")
    ArrayList<Carta> cartas = new ArrayList<>();;

    // Constructor de la clase
    public Mano() {
        // Se crea una lista de cartas vacía
        super(); // No invoca al método de la superclase, pero se puede hacerlo si se requiere algún comportamiento específico
    }

    // Método para pedir una carta al mazo y agregarla a la mano
    public void pedirCarta(Mazo mazo) {
        Carta carta = mazo.solicitarCarta();
        if (carta != null) {
            cartas.add(carta);
        } else {
            System.out.println("El mazo está vacío, no se puede pedir más cartas.");
        }
    }

    // Método para calcular el valor de la mano
    public int valorMano() {
        int valor = 0;
        for (Carta carta : cartas) {
            valor += carta.getValor();
        }
        return valor;
    }

    // Método para verificar si el juego ha terminado (si la mano tiene más de 21 puntos)
    public boolean finDeJuego() {
        return valorMano() > 21;
    }

    // Sobrescritura del método toString para mostrar la puntuación de la mano
    public String toString() {
        return "Puntuación de la mano: " + valorMano() + "\n" + cartas;
    }
}