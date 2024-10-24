package DZ3.Z1.Z3;

public class Pair2<T, U> {
    private T first;
    private U second;

    public Pair2(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Pair2{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    // Новый метод для отображения значений
    public void displayValues() {
        System.out.println("First: " + first);
        System.out.println("Second: " + second);
    }
}

