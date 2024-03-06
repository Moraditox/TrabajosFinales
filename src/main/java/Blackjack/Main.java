package Blackjack;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Mazo mazo = new Mazo();
        mazo.barajar();

        Mano manoJugador = new Mano();
        manoJugador.pedirCarta(mazo);
        System.out.println("Mano del jugador:");
        System.out.println(manoJugador);

        while (!manoJugador.finDeJuego()) {
            System.out.println("¿Desea otra carta? (s/n)");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            if (respuesta.equals("s")) {
                manoJugador.pedirCarta(mazo);
                System.out.println("Mano del jugador:");
                System.out.println(manoJugador);
            } else if (respuesta.equals("n")) {
                break;
            } else {
                System.out.println("Respuesta inválida. Por favor, responda 's' para sí o 'n' para no.");
            }
        }

        if (manoJugador.finDeJuego()) {
            System.out.println("El jugador se ha pasado de 21. ¡Ha perdido!");
        } else {
            System.out.println("El jugador se ha plantado con una puntuación de " + manoJugador.valorMano());
        }

        scanner.close();

        try {
            // Crear un contexto JAXB para la clase Mazo
            JAXBContext jaxbContext = JAXBContext.newInstance(Mano.class);

            // Crear un marshaller
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Marshalling y escritura a un archivo XML
            marshaller.marshal(manoJugador, new File("salida.xml"));

            System.out.println("Archivo XML generado exitosamente.");
        } catch (JAXBException e){
            e.printStackTrace();
        }
    }
}