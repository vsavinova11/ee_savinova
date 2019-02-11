package com.accenture.flowershop.be.entity.order;

import java.io.Serializable;

public enum OrderStatus implements Serializable {
    Created,
    Paid,
    Completed
}
