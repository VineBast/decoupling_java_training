package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextInt(100);
        Simulation sim;
        String auto = "-auto";
        String inter = "-interactive";
        if (args.length == 1 && inter.equals(args[0])) {
            sim = new Simulation(new HumanPlayer());
            sim.initialize((randomNumber));
            sim.loopUntilPlayerSucceed(Long.MAX_VALUE);
        }
        else if (args.length == 2 && auto.equals(args[0])) {
            sim = new Simulation(new ComputerPlayer());
            sim.initialize(Long.parseLong(args[1]));
            sim.loopUntilPlayerSucceed(1000);
        }
        else
            System.out.print("Pour déviner soi-même l'âge du capitaine, " +
                "il faut lancer la programme avec le paramètre -interactice. " +
                "Si vous voulez que le programme cherche lui-même l'aĝe du capitaine, " +
                "entrez en paramètres -auto, puis l'âge que vous voulez que cherche l'ordinateur.");
    }
}
