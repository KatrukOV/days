package com.katruk.domain;

import java.util.Arrays;

public enum DayOfWeak {

    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    private final Integer numberOfDay;

    DayOfWeak(final Integer number) {
        this.numberOfDay = number;
    }

    public static DayOfWeak valueOf(final Integer number) {
        return Arrays.stream(DayOfWeak.values())
                .filter(e -> e.numberOfDay.equals(number))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public DayOfWeak prev() {
        return DayOfWeak.values()[this.ordinal() - 1];
    }

    public Integer asNumber() {
        return this.numberOfDay;
    }

}
