package com.katruk.domain.enumeration;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class NumberList {

    final Integer number;

    public NumberList(final Integer number) {
        this.number = number;
    }

    public List<Integer> toList() {
        final List<Integer> numberList = new LinkedList<>();
        int temp = this.number;
        do {
            int digit = temp % 10;
            temp /= 10;
            numberList.add(digit);
        } while (temp > 0);
        Collections.reverse(numberList);
        return numberList;
    }

}
