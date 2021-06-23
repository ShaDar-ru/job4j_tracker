package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> nums;

    private EasyStream(List<Integer> list) {
        this.nums = list;
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        var rsl = new ArrayList<Integer>();
        for (int i : this.nums) {
            int x = fun.apply(i);
            rsl.add(x);
        }
        return new EasyStream(rsl);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        var rsl = new ArrayList<Integer>();
        for (int i : this.nums) {
            if (fun.test(i)) {
                rsl.add(i);
            }
        }
        return new EasyStream(rsl);
    }

    public List<Integer> collect() {
        return new ArrayList<>(this.nums);
    }
}