package com.microservices.core.product.utils;

import lombok.NoArgsConstructor;

import java.time.ZoneId;

@NoArgsConstructor
public final class DateTimeUtils {
    public static final ZoneId DEFAULT_ZONE_ID = ZoneId.of("Europe/Kyiv");
}
