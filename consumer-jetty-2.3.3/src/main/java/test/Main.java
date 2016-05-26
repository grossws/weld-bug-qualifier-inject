package test;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.jboss.weld.environment.servlet.Listener;

public class Main {
  public static void main(String[] args) throws Exception {
    ServletContextHandler handler = new ServletContextHandler();
    handler.addEventListener(new Listener());
    handler.addServlet(Consumer.class, "/*");

    Server server = new Server(8080);
    server.setHandler(handler);
    server.start();
    server.join();
  }
}
