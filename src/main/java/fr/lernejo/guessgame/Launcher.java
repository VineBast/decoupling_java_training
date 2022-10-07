package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        Simulation sim = new Simulation(new HumanPlayer());
        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextInt(100);
        sim.initialize((randomNumber));
    }
}
