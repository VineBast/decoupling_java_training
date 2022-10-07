package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("player");
    private long previousPreviousGuess = 0;
    private long previousGuess = 100;
    private boolean lowerOrGreater = true;
    @Override
    public long askNextGuess() {
        long guess;
        if (lowerOrGreater) {
            guess = previousGuess / 2;
            this.previousPreviousGuess = previousGuess;
        }
        else {
            guess = (previousGuess + previousPreviousGuess) / 2 ;
        }
        this.previousGuess = guess;
        System.out.println(guess);
        return guess;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        this.lowerOrGreater = lowerOrGreater;
        if (lowerOrGreater)
            logger.log("Lower");
        else
            logger.log("Greater");
    }
}
