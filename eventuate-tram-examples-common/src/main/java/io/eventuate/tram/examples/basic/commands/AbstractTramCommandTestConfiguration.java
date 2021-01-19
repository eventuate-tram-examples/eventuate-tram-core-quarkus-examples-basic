package io.eventuate.tram.examples.basic.commands;

import io.eventuate.tram.commands.consumer.CommandDispatcher;
import io.eventuate.tram.commands.consumer.CommandDispatcherFactory;

import javax.inject.Singleton;

@Singleton
public class AbstractTramCommandTestConfiguration {

  @Singleton
  public AbstractTramCommandTestConfig abstractTramCommandTestConfig() {
    return  new AbstractTramCommandTestConfig();

  }

  @Singleton
  public TramCommandTestCommandHandler abstractTramCommandTestTarget(AbstractTramCommandTestConfig config) {
    return new TramCommandTestCommandHandler(config.getCommandChannel());
  }

  @Singleton
  public CommandDispatcher commandDispatcher(CommandDispatcherFactory commandDispatcherFactory,
                                             AbstractTramCommandTestConfig config,
                                             TramCommandTestCommandHandler target) {
    return commandDispatcherFactory.make(config.getCommandDispatcheId(), target.getCommandHandlers());
  }
}
