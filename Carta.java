
package juegocartas;

enum Elemento {
    FUEGO, VIENTO, RAYO, TIERRA, AGUA
}
public class Carta {
   private int atk;
    private int def;
    private Elemento elemento;

    public Carta(int atk, int def, Elemento elemento) {
        this.atk = atk;
        this.def = def;
        this.elemento = elemento;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public Elemento getElemento() {
        return elemento;
    }

    @Override
    public String toString() {
        return "ATK: " + atk + ", DEF: " + def + ", Elemento: " + elemento;
    }
}

class Jugador {
    private String nombre;
    private int puntosVida;

    public Jugador(String nombre, int puntosVida) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void restarPuntosVida(int cantidad) {
        puntosVida -= cantidad;
    }
}
