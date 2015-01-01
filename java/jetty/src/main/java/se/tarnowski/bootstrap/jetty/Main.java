package se.tarnowski.bootstrap.jetty;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class Main {
    public static void main(String[] args) throws Exception
    {
        Server server = new Server(8080);

        // Uncomment to enable a handler that returns a hard coded string
        // server.setHandler(new se.tarnowski.bootstrap.jetty.handler.StaticStringHandler());

        final String pathToWarFile = args[0];
        server.setHandler(new WebAppContext(pathToWarFile, "/webapp"));

        server.start();
        server.join();
    }
}
