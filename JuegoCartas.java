
package juegocartas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class JuegoCartas {

    public static void main(String[] args) {
         ArrayList<Carta> mazoGeneral = inicializarMazo();
        ArrayList<Carta> mazoJugador1 = new ArrayList<>(mazoGeneral.subList(0, 5));
        ArrayList<Carta> mazoJugador2 = new ArrayList<>(mazoGeneral.subList(5, 10));
        Random random = new Random();

        // Barajar el mazo general
        Collections.shuffle(mazoGeneral);

        // Determinar quién inicia el juego con un dado de 6 caras
        int turno = random.nextInt(2) + 1;
        System.out.println("El jugador " + turno + " inicia el juego.");

        // Iniciar la dinámica del juego
        while (!mazoJugador1.isEmpty() && !mazoJugador2.isEmpty()) {
            System.out.println("\n--- Turno del Jugador " + turno + " ---");

            // Mostrar cartas de cada jugador
            System.out.println("Cartas del Jugador 1: " + mazoJugador1);
            System.out.println("Cartas del Jugador 2: " + mazoJugador2);

            // Elegir cartas para el enfrentamiento
            Carta cartaJugador1 = mazoJugador1.remove(0);
            Carta cartaJugador2 = mazoJugador2.remove(0);

            System.out.println("Jugador 1 selecciona carta: " + cartaJugador1);
            System.out.println("Jugador 2 selecciona carta: " + cartaJugador2);

            // Calcular bonificadores
            int bonificadorAtk = random.nextInt(20) + 1;
            int bonificadorDef = random.nextInt(20) + 1;

            // Calcular bonificadores según el elemento
            if (cartaJugador1.getElemento() == cartaJugador2.getElemento()) {
                bonificadorAtk += 20;
                bonificadorDef += 30;
            }

            // Calcular el resultado del enfrentamiento
            int resultadoAtk = cartaJugador1.getAtk() + bonificadorAtk;
            int resultadoDef = cartaJugador2.getDef() + bonificadorDef;

            System.out.println("Resultado del ataque del Jugador 1: " + resultadoAtk);
            System.out.println("Resultado de la defensa del Jugador 2: " + resultadoDef);

            // Actualizar puntos de vida
            int danio = Math.max(0, resultadoAtk - resultadoDef);
            Jugador jugadorAtacado = (turno == 1) ? new Jugador("Jugador 2", mazoJugador2.size()) : new Jugador("Jugador 1", mazoJugador1.size());
            jugadorAtacado.restarPuntosVida(danio);

            System.out.println("Ataque exitoso " + jugadorAtacado.getNombre() + " pierde " + danio + " puntos de vida.");

            // Cambiar el turno
            turno = (turno == 1) ? 2 : 1;
        }

        // Determinar al ganador
        if (mazoJugador1.isEmpty() && mazoJugador2.isEmpty()) {
            System.out.println("Empate");
        } else if (mazoJugador1.isEmpty()) {
            System.out.println("Jugador 2 gana");
        } else {
            System.out.println("Jugador 1 gana");
        }
    }

    private static ArrayList<Carta> inicializarMazo() {
        ArrayList<Carta> mazo = new ArrayList<>();
        mazo.add(new Carta(500, 600, Elemento.FUEGO));
        mazo.add(new Carta(700, 400, Elemento.AGUA));
        mazo.add(new Carta(600, 500, Elemento.TIERRA));
        mazo.add(new Carta(800, 300, Elemento.VIENTO));
        mazo.add(new Carta(550, 650, Elemento.RAYO));
        mazo.add(new Carta(450, 700, Elemento.FUEGO));
        mazo.add(new Carta(750, 350, Elemento.AGUA));
        mazo.add(new Carta(620, 480, Elemento.TIERRA));
        mazo.add(new Carta(780, 280, Elemento.VIENTO));
        mazo.add(new Carta(600, 600, Elemento.RAYO));
        return mazo;
    }
    }
    
    

