package Blackjack;

public class Carta {
    enum Palo{
        TREBOL,
        DIAMANTES,
        CORAZONES,
        PICAS
    }

    private int numCarta;
    private Palo palo;

    public Carta(int numCarta, Palo palo){
        if (numCarta > 0 && numCarta <= 13){
            this.numCarta = numCarta;
            this.palo = palo;
        }else{
            System.out.println("Tienes que introducir un numero entre 1 y 12.");
        }
    }

    public void setNumCarta(int numCarta) {
        if (numCarta > 0 && numCarta <= 13){
            this.numCarta = numCarta;
        }else{
            System.out.println("Tienes que introducir un numero entre 1 y 12.");
        }
    }

    public void setPalo(Palo palo) {
        this.palo = palo;
    }

    public int getNumCarta() {
        return numCarta;
    }

    public Palo getPalo() {
        return palo;
    }

    public int getValor(){
        if (numCarta == 1) {
            return 11; // Valor de AS en Blackjack
        } else if (numCarta >= 10) {
            return 10; // Valor de figuras (J, Q, K) en Blackjack
        } else {
            return numCarta; // Valor correspondiente para el resto de las cartas
        }
    }

    public String mostrarNumero(){

        if (1 == numCarta){
            return "AS";
        }else if (11 == numCarta) {
            return "J";
        }else if (12 == numCarta) {
            return "Q";
        }else if (13 == numCarta) {
            return "K";
        }else{
            return String.valueOf(numCarta);
        }
    }

    public String toString(){
        return "["+ mostrarNumero() +" - "+ palo +"]";
    }
}