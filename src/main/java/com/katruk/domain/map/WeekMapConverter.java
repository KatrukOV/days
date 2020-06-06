package com.katruk.domain.map;

import com.katruk.domain.Week;

import java.util.Map;

public final class WeekMapConverter implements Week {

    @Override
    public String convert(Integer number) {

        final Map<Integer, Boolean> dayOfWeek = new WeekMap(number).toMap();
        final int mapSize = dayOfWeek.size();
        final StringBuilder builder = new StringBuilder();

        for (int i = 1; i < dayOfWeek.size(); ++i) {
            if (dayOfWeek.get(i)) {
                builder.append(i);
                if (i < mapSize && dayOfWeek.get(i + 1)) {
                    while (i < mapSize && dayOfWeek.get(i + 1)) {
                        i++;
                    }
                    builder.append("-");
                    builder.append(i);
                }
            } else {
                while (i < mapSize) {
                    if (dayOfWeek.get(++i)) {
                        break;
                    }
                }
                if (i < mapSize) {
                    builder.append(",");
                    i--;
                }
            }
        }
        return builder.toString();
    }

}
