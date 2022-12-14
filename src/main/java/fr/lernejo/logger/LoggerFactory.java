package fr.lernejo.logger;

import java.util.function.Predicate;

public class LoggerFactory  {
    public static Logger getLogger(String name) {
        Predicate<String> condition = message -> message.contains("simulation");
        return new CompositeLogger( new ConsoleLogger(),
            new ContextualLogger(name, new FilteredLogger(new FileLogger("log.txt"), condition)));
    }
}
