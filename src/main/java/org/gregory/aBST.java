package org.gregory;

import java.util.*;

class aBST {
    public Integer Tree[]; // массив ключей
    private int tree_size;

    public aBST(int depth) {
        // правильно рассчитайте размер массива для дерева глубины depth:
        tree_size = (int) Math.pow(2, depth + 1) - 1;
        Tree = new Integer[tree_size];
        for (int i = 0; i < tree_size; i++) Tree[i] = null;
    }

    public Integer FindKeyIndex(int key) {
        return recursiveTreeCrawler(key, 0);
    }

    private Integer recursiveTreeCrawler(int key, int index) {
        Integer result = null;
        if (index >= tree_size) {
            return null;
        }
        if (Tree[index] == null) {
            return -index;
        }
        if (Tree[index] > key) {
            result = recursiveTreeCrawler(key, 2 * index + 1);
        }
        if (Tree[index] == key) {
            return index;
        }
        if (Tree[index] < key) {
            result = recursiveTreeCrawler(key, 2 * index + 2);
        }
        return result;
    }

    public int AddKey(int key) {
        Integer findKeyMeth = FindKeyIndex(key);
        if (findKeyMeth == null || findKeyMeth > 0) {
            return -1;
        }
        findKeyMeth = -findKeyMeth;
        Tree[findKeyMeth] = key;
        return findKeyMeth;
    }

}
