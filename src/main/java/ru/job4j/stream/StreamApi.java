package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class StreamApi {

    public static void main(String[] args) {
        Random rnd = new Random();
        List<Integer> nums = new ArrayList<>();
        int i = 0;
        while (i < 100) {
            nums.add(rnd.nextInt(100) * (rnd.nextInt(3) - 1));
            i++;
        }
        //TODO разобраться с ::
        nums.forEach(System.out::println);
        System.out.println("==" + nums.size() + "==");
        List<Integer> positiveNums = nums.stream()
                .filter(integer -> integer > 0)
                .collect(Collectors.toList());
        positiveNums.forEach(System.out::println);
        System.out.println("==" + positiveNums.size() + "==");
    }
}
