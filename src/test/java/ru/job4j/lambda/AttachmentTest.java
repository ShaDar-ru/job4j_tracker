package ru.job4j.lambda;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 06.04.2021
 */
public class AttachmentTest {

    @Test
    public void getName() {
        Attachment attch = new Attachment("asd", 12);
        assertThat(attch.getName(), is("asd"));
    }

    @Test
    public void getSize() {
        Attachment attch = new Attachment("asd", 12);
        assertThat(attch.getSize(), is(12));
    }
}