package com.katruk.domain.map;

import java.util.HashMap;
import java.util.Map;

public final class WeekMap {

    private final Integer number;

    public WeekMap(Integer number) {
        this.number = number;
    }

    public Map<Integer, Boolean> toMap() {
        final Map<Integer, Boolean> dayOfWeek = initMap();
        int temp = this.number;
        do {
            int digit = temp % 10;
            temp /= 10;
            dayOfWeek.put(digit, true);
        } while (temp > 0);
        return dayOfWeek;
    }

    private Map<Integer, Boolean> initMap() {
        return new HashMap<Integer, Boolean>() {{
            put(1, false);
            put(2, false);
            put(3, false);
            put(4, false);
            put(5, false);
            put(6, false);
            put(7, false);
        }};
    }

}
