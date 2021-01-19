package io.eventuate.tram.examples.basic.events;

import io.eventuate.tram.events.subscriber.DomainEventDispatcher;
import io.eventuate.tram.events.subscriber.DomainEventDispatcherFactory;

import javax.inject.Singleton;

@Singleton
public class AbstractTramEventTestConfiguration {

  @Singleton
  public AbstractTramEventTestConfig abstractTramEventTestConfig() {
    return new AbstractTramEventTestConfig();
  }

  @Singleton
  public DomainEventDispatcher domainEventDispatcher(AbstractTramEventTestConfig config,
                                                     TramEventTestEventConsumer target,
                                                     DomainEventDispatcherFactory domainEventDispatcherFactory) {
    return domainEventDispatcherFactory.make("eventDispatcherId" + config.getUniqueId(), target.domainEventHandlers());
  }

  @Singleton
  public TramEventTestEventConsumer tramEventTestTarget(AbstractTramEventTestConfig config) {
    return new TramEventTestEventConsumer(config.getAggregateType());
  }
}
