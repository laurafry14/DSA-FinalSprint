package com.keyin;

import com.keyin.BinarySearchTree.BinaryNode;
import com.keyin.BinarySearchTree.BinarySearchTree;
import com.keyin.BinarySearchTree.BinaryTreeService;
import com.keyin.BinarySearchTree.Tree;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {

    @Test
    void setInputNumbers() {
        Tree t1 = new Tree();
        t1.setInputNumbers("1,2,3,4");
        assertEquals("1,2,3,4", t1.getInputNumbers());
    }

    @Test
    void getTreeStructure() {
        Tree t2 = new Tree();
        t2.setTreeStructure("{\"value\":1,\"left\":null,\"right\":{\"value\":2,\"left\":null,\"right\":{\"value\":3,\"left\":null,\"right\":{\"value\":4,\"left\":null,\"right\":null}}}}");
        assertEquals("{\"value\":1,\"left\":null,\"right\":{\"value\":2,\"left\":null,\"right\":{\"value\":3,\"left\":null,\"right\":{\"value\":4,\"left\":null,\"right\":null}}}}", t2.getTreeStructure());
    }

    @Test
    void insert() {
        BinarySearchTree bst1 = new BinarySearchTree();
        BinaryNode root = bst1.insert(null,5);

        assertEquals(5, root.value);
    }
}
