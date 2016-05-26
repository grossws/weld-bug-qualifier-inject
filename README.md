# Demo project for issue in JBoss Weld 2.3.4.Final

JIRA link: [WELD-2161][issue]

## Correct work

```bash
# standalone versions:
mvn clean package -am exec:exec -pl consumer-se
# embedded jetty version:
mvn clean package -am exec:exec -pl consumer-jetty-2.3.3
# webapp versions:
mvn clean package -am jetty:run-war -pl consumer-war-2.3.3
mvn clean package -am jetty:run-war -pl consumer-war-2.3.4
mvn clean package -am tomcat7:run-war -pl consumer-war-2.3.3
mvn clean package -am tomcat7:run-war -pl consumer-war-2.3.4
```

Invoke `curl -v http://localhost:8080/` to check webapp and embedded jetty versions.

## Should fail

```bash
mvn clean package -am exec:exec -pl consumer-jetty-2.3.4
```

Result:

```
org.jboss.weld.exceptions.DeploymentException: WELD-001408: Unsatisfied dependencies for type String with qualifiers @BindingAnnotation
  at injection point [BackedAnnotatedField] @Inject @BindingAnnotation private test.Consumer.s
  at test.Consumer.s(Consumer.java:0)

        at org.jboss.weld.bootstrap.Validator.validateInjectionPointForDeploymentProblems(Validator.java:359)
        at org.jboss.weld.bootstrap.Validator.validateInjectionPoint(Validator.java:281)
        at org.jboss.weld.bootstrap.Validator.validateGeneralBean(Validator.java:134)
        at org.jboss.weld.bootstrap.Validator.validateRIBean(Validator.java:155)
        at org.jboss.weld.bootstrap.Validator.validateBean(Validator.java:518)
        at org.jboss.weld.bootstrap.ConcurrentValidator$1.doWork(ConcurrentValidator.java:68)
        at org.jboss.weld.bootstrap.ConcurrentValidator$1.doWork(ConcurrentValidator.java:66)
        at org.jboss.weld.executor.IterativeWorkerTaskFactory$1.call(IterativeWorkerTaskFactory.java:63)
        at org.jboss.weld.executor.IterativeWorkerTaskFactory$1.call(IterativeWorkerTaskFactory.java:56)
        at java.util.concurrent.FutureTask.run(FutureTask.java:266)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
        at java.lang.Thread.run(Thread.java:745)
```

## License

MIT license, see [LICENSE](LICENSE)

[issue]: https://issues.jboss.org/browse/WELD-2161
