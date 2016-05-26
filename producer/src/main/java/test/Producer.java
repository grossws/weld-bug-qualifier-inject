package test;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class Producer {
  @Produces
  @BindingAnnotation
  public String get() {
    return "test";
  }
}
