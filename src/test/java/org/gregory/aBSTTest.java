package org.gregory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.MatcherAssert.*;

class aBSTTest {
    aBST tree;

    @BeforeEach
    void setUp() {
        tree = new aBST(3);
    }

    @AfterEach
    void tearDown() {
        tree = null;
    }

    void fillingTree() {
        try {
            Field field = tree.getClass().getDeclaredField("Tree");
            field.setAccessible(true);
            field.set(tree, new Integer[]{50, 25, 75, null, 37, 62, 84, null, null, 31, 43, 55, null, null, 92});
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Test
    void findKeyIndex_index6() {
        fillingTree();
        assertThat(tree.FindKeyIndex(84), is(6));
    }

    @Test
    void findKeyIndex_index0() {
        fillingTree();
        assertThat(tree.FindKeyIndex(50), is(0));
    }

    @Test
    void findKeyIndex_noExist_return13() {
        fillingTree();
        assertThat(tree.FindKeyIndex(77), is(-13));
    }

    @Test
    void addKey_addRoot() {
        assertThat(tree.AddKey(5), is(0));
    }

    @Test
    void addKey_addElementExist() {
        fillingTree();
        assertThat(tree.AddKey(37), is(-1));
    }

    @Test
    void addKey_returnIndex13() {
        fillingTree();
        assertThat(tree.AddKey(77), is(13));
    }

}