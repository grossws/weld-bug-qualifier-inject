package test;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Main {
  public static void main(String[] args) {
    Weld weld = new Weld();
    WeldContainer container = weld.initialize();

    System.out.println(container.select(Consumer.class).get().t());

    container.shutdown();
  }
}
