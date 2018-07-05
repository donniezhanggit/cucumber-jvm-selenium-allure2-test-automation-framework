package io.github.symonk.datamanagement;

import io.github.symonk.common.enums.OrderOptions;
import io.github.symonk.common.enums.Puppy;
import io.github.symonk.domain.Order;

public class OrderProvider {

    public Order getRandomOrder() {
        return new Order(Puppy.BROOK, OrderOptions.CHEW_TOY);
    }
}
