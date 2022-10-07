package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public void loopUntilPlayerSucceed(long maxI) {
        //TODO implement me
        long timerStart = System.currentTimeMillis();
        boolean response = nextRound();
        long i = 0;

        while((!response) && (maxI > i)) {
            response = nextRound();
            i++;
        }
        long timerEnd = System.currentTimeMillis();
        long finalSec = timerEnd - timerStart;
        DateFormat simple = new SimpleDateFormat("mm:ss:SSS");
        Date result = new Date(finalSec);
        logger.log(simple.format(result));
        if (response)
            logger.log("You won !");
        else
            logger.log("You lose noob !");
    }
}
