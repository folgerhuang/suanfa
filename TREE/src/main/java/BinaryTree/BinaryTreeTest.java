package BinaryTree;

import javax.swing.tree.TreeNode;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @org.junit.jupiter.api.Test
    void insert() {
        HashMap<Integer, Double> data = new HashMap<Integer, Double>();
        data.put(1, 100d);
        data.put(2, 150d);
        data.put(3, 56d);
        data.put(4, 1000.0);
        BinaryTree binaryTree = new BinaryTree();

        for (int i :
                data.keySet()) {
            binaryTree.insert(i, data.get(i));
        }

        binaryTree.traverse(1);
        binaryTree.traverse(2);
        binaryTree.traverse(3);

    }
}