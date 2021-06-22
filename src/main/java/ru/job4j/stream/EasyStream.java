package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> nums;

    private EasyStream() {
        this.nums = new ArrayList<>();
    }

    public static EasyStream of(List<Integer> source) {
        var rsl = new EasyStream();
        rsl.nums.addAll(source);
        return rsl;
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        var rsl = new EasyStream();
        for (int i : this.nums) {
            int x = fun.apply(i);
            rsl.nums.add(x);
        }
        return rsl;
    }

    public EasyStream filter(Predicate<Integer> fun) {
        var rsl = new EasyStream();
        for (int i : this.nums) {
            if (fun.test(i)) {
                rsl.nums.add(i);
            }
        }
        return rsl;
    }

    public List<Integer> collect() {
        return new ArrayList<>(this.nums);
    }
}