package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextInt(100);
        Simulation sim;
        String auto = "-auto";
        String inter = "-interactive";
        if (inter.equals(args[0])) {
            sim = new Simulation(new HumanPlayer());
            sim.initialize((randomNumber));
            sim.loopUntilPlayerSucceed(Long.MAX_VALUE);
        }
        else if (auto.equals(args[0])) {
            sim = new Simulation(new ComputerPlayer());
            sim.initialize(Long.parseLong(args[1]));
            sim.loopUntilPlayerSucceed(1000);
        }
        else
            System.out.print("Explications");
    }
}
