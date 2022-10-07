package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        //TODO implement me
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        //TODO implement me
        this.numberToGuess = numberToGuess;
        loopUntilPlayerSucceed();
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        //TODO implement me
        long response = player.askNextGuess();
        if (numberToGuess == response) {
            return true;
        } else {
            if (numberToGuess > response)
                player.respond(false);
            else
                player.respond(true);
            return false;
        }
    }

    public void loopUntilPlayerSucceed() {
        //TODO implement me
        boolean response = nextRound();
        while(!response) {
            response = nextRound();
        }
        logger.log("You won !");
    }
}
