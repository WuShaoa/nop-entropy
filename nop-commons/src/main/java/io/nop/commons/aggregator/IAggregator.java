package io.nop.commons.aggregator;

public interface IAggregator {
    void aggregate(Object value);

    Object getResult();

    default void reset() {

    }
}
