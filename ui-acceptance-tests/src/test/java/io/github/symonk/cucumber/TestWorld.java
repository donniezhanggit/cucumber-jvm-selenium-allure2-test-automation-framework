package io.github.symonk.cucumber;

import io.github.symonk.domain.Order;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TestWorld {

    @Getter @Setter private Order currentOrder;
    @Getter private List<Order> scenarioOrders = new ArrayList<>();


    void cleanUpWorld() {
        scenarioOrders.clear();
    }


}
