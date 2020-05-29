package com.katruk.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class WeekConverter implements Week {

    @Override
    public String convert(final Integer number) {
        final List<Integer> numberList = toNumberList(number);
        Collections.reverse(numberList);
        StringBuilder builder = new StringBuilder();
        numberList.forEach(e ->
            convertToNumber(builder, e));
        return builder.toString();
    }

    private void convertToNumber(final StringBuilder builder, final Integer e) {
        DayOfWeak dayOfWeak = DayOfWeak.valueOf(e);
        if (builder.length() == 0) {
            builder.append(dayOfWeak.asNumber());
        } else {
            if (comparePrevious(builder, dayOfWeak)) {
                if (builder.length() > 2 && containsHyphen(builder)) {
                    builder.deleteCharAt(builder.length() - 1);
                } else {
                    builder.append("-");
                }
            } else {
                builder.append(",");
            }
            builder.append(dayOfWeak.asNumber());
        }
    }

    private boolean containsHyphen(final StringBuilder builder) {
        return builder.substring(builder.length() - 2, builder.length())
                .contains("-");
    }

    private boolean comparePrevious(final StringBuilder builder, final DayOfWeak dayOfWeak) {
        return dayOfWeak.prev().asNumber()
                .equals(
                        Integer.valueOf(
                                builder.substring(builder.length() - 1)
                        )
                );
    }

    private List<Integer> toNumberList(final Integer number) {
        final List<Integer> numberList = new LinkedList<>();
        int temp = number;
        do {
            int digit = temp % 10;
            temp /= 10;
            numberList.add(digit);
        }
        while (temp > 0);
        return numberList;
    }

}
