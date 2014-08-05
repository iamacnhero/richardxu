package com.richardxu.datastructure;

/**
 * 二叉树: 使用二叉链表(一个数据域和两个指针域)实现
 * @author <a href="mailto:richardxu@live.cn">xufeng</a>
 * @date 2014-8-5 下午11:29:21
 */
public class BinaryTree<T extends Comparable<T>> {
    private Node root;          // 根结点
    
    class Node {
        T key;                  // 关键字
        String data;            // 数据，任何类型都可以
        Node leftChild;         // 左结点
        Node rightChild;        // 右结点    
    }
    
    public Node getRoot() {
        return root;
    }
    
    public Node find(T key) {
        Node current = root;            // 从根结点开始查找
        while (current.key.equals(key)) {
            if (key.compareTo(current.key) < 0)    // 小于current，从左结点开始查找
                current = current.leftChild;
            else
                current = current.rightChild;       // 大于current，从右结点开始查找
            if (current == null)        // 找不到返回空
                return null;
        }
        return current;         // 找到!
    }
    
    public void insert(T key, String data) {
        Node newNode = new Node();
        newNode.key = key;        // 插入数据
        newNode.data = data;
        if (root == null)
            root = newNode;
        else {
            Node current = root;        // 从root开始
            Node parent;                // 用parent来存储遇到的最后一个不是null的结点，必须存储parent，不然会找不到插入新结点的位置
            while (true) {
                parent = current;
                if (key.compareTo(current.key) < 0) {   // go left 
                    current = current.leftChild;
                    if (current == null) {              // if end of line
                        parent.leftChild = newNode;     // insert on left
                        return ;
                    }
                } else {                                // go right
                    current = current.rightChild;
                    if (current == null) {              // if end of line
                        parent.rightChild = newNode;    // insert on right
                        return ;
                    }
                }
            }
        }
    }

    /*
     * 中序遍历
     * 若树为空，则空操作返回，否则从根结点开始(注意并不是先访问根结点)，中序遍历根结点的左子树，然后是访问根结点，最后中序遍历右子树
     */
    private void inOrderTraverse(Node root) {
        if (root != null) {
            inOrderTraverse(root.leftChild);        // 中序遍历根结点的左子树
            System.out.println("key: " + root.key + " data: " + root.data);     // 访问根结点
            inOrderTraverse(root.rightChild);       // 中序遍历右子树
        }
    }
    
    /*
     * 前序遍历
     * 若二叉树为空，则空操作返回，否则先访问根结点，然后前序遍历左子树，再前序遍历右子树。
     */
    private void preOrderTraverse(Node root) {
        if (root != null) {
            System.out.println("key: " + root.key + " data: " + root.data);     // 先访问根结点
            preOrderTraverse(root.leftChild);           // 前序遍历左子树
            preOrderTraverse(root.rightChild);          // 前序遍历右子树
        }
    }
    
    /*
     * 后序遍历
     * 若树为空，则空操作返回，否则从左到右先叶子后结点的方式访问左右子树，最后访问根结点。
     */
    private void postOrderTraverse(Node root) {
        if (root != null) {
            postOrderTraverse(root.leftChild);           // 后序遍历左子树
            postOrderTraverse(root.rightChild);          // 后序遍历右子树
            System.out.println("key: " + root.key + " data: " + root.data);     // 访问根结点
        }
    }
    
    /*
     * 找节点的最小值
     * 先走到根的左子节点处，然后递归找下一个左子节点，一直到找不到左子节点为止，这个节点就是最小值的节点
     */
    public Node mininum() {
        Node current, last;
        last = current = root;          // 从根结点开始
        while (current != null) {       // until the bottom
            last = current;             // remember node
            current = current.leftChild;    // 继续到左子结点
        }
        return last;
    }
    
    /*
     * 找节点的最大值
     * 先走到根的右子节点处，然后递归找下一个右子节点，一直到找不到右子节点为止，这个节点就是最小值的节点
     */
    public Node maximum() {
        Node current, last;
        last = current = root;          // 从根结点开始
        while (current != null) {       // until the bottom
            last = current;             // remember node
            current = current.rightChild;    // 继续到右子结点
        }
        return last;
    }
    /*
     * 删除节点
     * 删除节点要从查找要删的节点开始入手，方法与find()和insert()相同。找到节点后，这个要删除的节点可能有三种情况：
     * 1. 该节点是叶节点(没有子节点): 只要把该节点的父结点的对应子字段的值改为null即可
     * 2. 该节点有一个子节点
     * 3. 该节点有两个子节点
     */
    public boolean delete(T key) {
        Node current = root;            // 从根结点开始查找
        Node parent = root;
        boolean isLeftChild = true;
        
        while (!current.key.equals(key)) {          // 搜索节点
            parent = current;
            if (key.compareTo(current.key) < 0) {   // go left
                isLeftChild = true;
                current = current.leftChild;
            } else {                                // go right
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null)                    // end of the line,
                return false;                       // didn't find it
        }
        // 找到节点后，检查它是否真的没有子节点。如果没有子节点，还需要检查它是不是根。
        // 如果是根，只需要把它置为null，这样就清空了整棵树。否则，就把父节点的leftChild或rightChild字段置为null，
        // 断开父节点与那个要删除节点的连接
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root)                // if root,
                root = null;                    // tree is empty
            else if (isLeftChild)
                parent.leftChild = null;        // disconnect from parent
            else
                parent.rightChild = null;
        } else if (current.rightChild == null) {        // if no right child, replace with left subtree
            if (current == root)
                root = current.leftChild;
            else if (isLeftChild)           // left child of parent
                parent.leftChild = current.leftChild;
            else
                parent.rightChild = current.leftChild;
        } else if (current.leftChild == null) {     // if no left child, replace with right subtree
            if (current == root)
                root = current.rightChild;
            else if (isLeftChild)                   // left child of parent
                parent.leftChild = current.rightChild;
            else                                    // right child of parent
                parent.rightChild = current.rightChild;
        } else {        // two children, so replace with inorder successor
            // Node successor of node to delete(current)
            Node successor = getSuccessor(current);
            
            // connect parent of current to successor instead
            if (current == root) 
                root = successor;
            else if (isLeftChild)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;
            // connect succesor to current's left child
            successor.leftChild = current.leftChild;
        }
        return true;
    }
    
    // 返回delNode的后继节点(假设delNode有右子节点，因为已经判断过这个要删除的节点有两个子节点)
    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;      // go to right child
        while (current != null) {               // until no more
            successorParent = successor;
            successor = current;
            current = current.leftChild;        // go to left child
        }
        if (successor != delNode.rightChild) {  // right child
            successorParent.leftChild = successor.rightChild;       // make connections
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }
    
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        tree.insert(2, "japan");
        tree.insert(1, "china");
        tree.insert(4, "america");
        tree.insert(3, "russia");
        tree.insert(5, "german");
        
        // 结果为：2 1 4 3 5
        tree.preOrderTraverse(tree.getRoot());
        System.out.println("--------------------");
        // 结果为：1 2 3 4 5
        tree.inOrderTraverse(tree.getRoot());
        System.out.println("--------------------");
        // 结果为：1 3 5 4 2
        tree.postOrderTraverse(tree.getRoot());
        System.out.println("--------------------");
        
        // System.out.println(tree.mininum().key);
        // System.out.println(tree.maximum().key);
        
        tree.delete(3);
        tree.inOrderTraverse(tree.getRoot());
    }
}