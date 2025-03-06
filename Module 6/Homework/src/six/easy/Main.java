package six.easy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        NumberList myNumbers = new NumberList(Arrays.asList(10.0, 20.0, 5.0, 7.0, 30.0));


        System.out.println("Минимальное число: " + myNumbers.getMin());
        System.out.println("Максимальное число: " + myNumbers.getMax());

        System.out.println("Сортировка по возрастанию: " + myNumbers.sortAscending());
        System.out.println("Сортировка по убыванию: " + myNumbers.sortDescending());


        System.out.println("Содержит ли число 20? " + myNumbers.contains(20.0));


        System.out.println("Числа больше 10: " + myNumbers.filterGreaterThan(10.0));


        System.out.println("Сумма чисел: " + myNumbers.getSum());
    }
}
