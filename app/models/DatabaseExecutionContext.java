package models;

import akka.actor.ActorSystem;
import scala.concurrent.ExecutionContext;
import scala.concurrent.ExecutionContextExecutor;

import javax.inject.Inject;

/**
 * Custom execution context wired to "database.dispatcher" thread pool
 */
public class DatabaseExecutionContext implements ExecutionContextExecutor {

    private static final String name = "database.dispatcher";

    private final ExecutionContext executionContext;

    @Inject
    public DatabaseExecutionContext(ActorSystem actorSystem) {
        this.executionContext = actorSystem.dispatchers().lookup(name);
    }

    @Override
    public void execute(Runnable runnable) {
        executionContext.execute(runnable);
    }

    @Override
    public void reportFailure(Throwable cause) {
        executionContext.reportFailure(cause);
    }

    @Override
    public ExecutionContext prepare() {
        return executionContext.prepare();
    }
}
