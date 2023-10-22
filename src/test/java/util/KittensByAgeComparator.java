package util;

import java.util.Comparator;

public class KittensByAgeComparator implements Comparator<Kitten> {

    @Override
    public int compare(Kitten one, Kitten other) {
        if (one == other) {
            return 0;
        }

        if (other == null) {
            return 1;
        }

        return Kitten.compareByAge(one.getAge(), other.getAge());
    }
}
