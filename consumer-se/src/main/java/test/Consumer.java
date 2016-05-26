package test;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class Consumer {
  @Inject
  @BindingAnnotation
  private String s;

  public String t() {
    return "test: " + s;
  }
}
