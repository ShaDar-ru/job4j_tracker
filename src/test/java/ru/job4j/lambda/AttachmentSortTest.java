package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 06.04.2021
 */
public class AttachmentSortTest {

    @Test
    public void compare() {
        Attachment a1 = new Attachment("image 1", 100);
        Attachment a2 = new Attachment("image 2", 34);
        Attachment a3 = new Attachment("image 3", 13);
        List<Attachment> attachments = Arrays.asList(a3, a2, a1);
        Comparator<Attachment> nameAttachComp = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        attachments.sort(nameAttachComp);
        List<Attachment> exp = Arrays.asList(a1, a2, a3);
        assertThat(attachments, is(exp));
    }

}