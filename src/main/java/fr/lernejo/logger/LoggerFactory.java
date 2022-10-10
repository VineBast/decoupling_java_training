package fr.lernejo.logger;

public class LoggerFactory  {
    public static Logger getLogger(String name) {
        return new CompositeLogger( new ConsoleLogger(),
            new ContextualLogger(name, new FileLogger("log.txt")));
    }
}
