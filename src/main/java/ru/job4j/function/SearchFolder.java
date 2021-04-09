package ru.job4j.function;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 09.04.2021
 */
public class SearchFolder {

    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        List<Folder> rsl = new ArrayList<>();
        for (Folder f : list) {
            if (pred.test(f)) {
                rsl.add(f);
            }
        }
        return rsl;
    }
}
