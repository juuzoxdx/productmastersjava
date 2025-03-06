package six.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

    public class NumberList {
        private List<Double> numbers;

        public NumberList(List<Double> numbers) {
            if (numbers == null || numbers.isEmpty()) {
                throw new IllegalArgumentException("Список чисел не может быть пустым.");
            }
            this.numbers = new ArrayList<>(numbers);
        }


        public double getMin() {
            return Collections.min(numbers);
        }


        public double getMax() {
            return Collections.max(numbers);
        }


        public List<Double> sortAscending() {
            List<Double> sorted = new ArrayList<>(numbers);
            Collections.sort(sorted);
            return sorted;
        }


        public List<Double> sortDescending() {
            List<Double> sorted = new ArrayList<>(numbers);
            sorted.sort(Collections.reverseOrder());
            return sorted;
        }


        public boolean contains(double number) {
            return numbers.contains(number);
        }


        public List<Double> filterGreaterThan(double value) {
            List<Double> filtered = new ArrayList<>();
            for (double num : numbers) {
                if (num > value) {
                    filtered.add(num);
                }
            }
            return filtered;
        }


        public double getSum() {
            double sum = 0;
            for (double num : numbers) {
                sum += num;
            }
            return sum;
        }

        @Override
        public String toString() {
            return "NumberList{" + "numbers=" + numbers + '}';
        }
    }

