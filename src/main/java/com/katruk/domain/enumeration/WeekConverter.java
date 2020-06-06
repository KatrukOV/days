package com.katruk.domain.enumeration;

import com.katruk.domain.Week;

import java.util.List;

public final class WeekConverter implements Week {

    @Override
    public String convert(final Integer number) {
        final List<Integer> numberList = new NumberList(number).toList();
        StringBuilder builder = new StringBuilder();
        numberList.forEach(e ->
                convertToNumber(builder, e));
        return builder.toString();
    }

    private void convertToNumber(final StringBuilder builder, final Integer e) {
        DayOfWeak dayOfWeak = DayOfWeak.valueOf(e);
        if (builder.length() != 0) {
            if (comparePrevious(builder, dayOfWeak)) {
                if (builder.length() > 2 && containsHyphen(builder)) {
                    builder.deleteCharAt(builder.length() - 1);
                } else {
                    builder.append("-");
                }
            } else {
                builder.append(",");
            }
        }
        builder.append(dayOfWeak.asNumber());
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

}
