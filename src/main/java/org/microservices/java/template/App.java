package org.microservices.java.template;

import java.io.IOException;
import java.net.URI;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.glassfish.grizzly.http.server.*;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;


public class App {

    private static final URI BASE_URI = URI.create("http://0.0.0.0:8080");
    
    public static HttpServer createServer() {
        // scan for JAX-RS resources and providers
        final ResourceConfig rc = new ResourceConfig().packages("org.microservices.java.template");
        return GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
    }

    public static void main(String[] args) throws IOException  {
        // Log everything from grizzly
        Logger l = Logger.getLogger("org.glassfish.grizzly.http.server");
        l.setLevel(Level.FINE);
        l.setUseParentHandlers(false);
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.ALL);
        l.addHandler(ch);

        final HttpServer server = createServer();

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                server.shutdownNow();
            }
        }));
        server.start();
    }
}
