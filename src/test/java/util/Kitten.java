package util;

import java.util.Objects;

public class Kitten implements Comparable<Kitten> {

    private final String name;
    private final Integer age;

    public Kitten(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kitten kitten = (Kitten) o;

        if (!Objects.equals(name, kitten.name)) return false;
        return Objects.equals(age, kitten.age);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Kitten{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    // Compare by name then by age
    @Override
    public int compareTo(Kitten other) {
        if (this == other) {
            return 0;
        }

        if (other == null) {
            return 1;
        }

        int nameComparison = compareByName(this.name, other.name);

        if (nameComparison != 0) {
            return nameComparison;
        }

        return compareByAge(this.age, other.age);
    }

    public static int compareByName(String one, String other) {
        if (one == null && other == null) {
            return 0;
        } else if (one == null) {
            return -1;
        } else if (other == null) {
            return 1;
        } else {
            return one.compareTo(other);
        }
    }

    public static int compareByAge(Integer one, Integer other) {
        if (one == null && other == null) {
            return 0;
        } else if (one == null) {
            return -1;
        } else if (other == null) {
            return 1;
        } else {
            return one.compareTo(other);
        }
    }
}
