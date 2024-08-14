package org.example;

import java.time.LocalDate;

public class PartySelector {


    public static Parties getPartyForToday() {
        LocalDate currentDate = LocalDate.now();

        int day = currentDate.getDayOfMonth();
        int month = currentDate.getMonthValue();

        if (month == 1 && day == 1) {
            return Parties.NEW_YEAR;
        } else if (month == 3 && day == 8) {
            return Parties.MARCH_8;
        } else if (month == 2 && day == 23) {
            return Parties.FEB_23;
        } else {
            return Parties.NONE;
        }
    }

    public enum Parties {
        NONE,
        NEW_YEAR,
        MARCH_8,
        FEB_23
    }
}
