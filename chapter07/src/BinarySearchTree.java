// Assume that no two nodes have same number! (for simplicity)

public class BinarySearchTree {
    public static void main(String[] args){
        BST tree = new BST();
        tree.insertNode(45);
        tree.insertNode(10);
        tree.insertNode(7);
        tree.insertNode(12);
        tree.insertNode(90);
        tree.insertNode(50);

        tree.printTree();
        tree.searchTree(50);
        tree.searchTree(90);
        tree.searchTree(12);
        tree.searchTree(30);
        tree.searchTree(70);
    }
}

class TreeNode{
    int value;
    TreeNode leftChild;
    TreeNode rightChild;

    TreeNode(int value){
        this.value = value;
        leftChild = null;
        rightChild = null;
    }
}

class BST{
    TreeNode root;

    BST(){
        this.root = null;
    }

    void insertNode(int value){
        if(root == null){
            root = new TreeNode(value);
            return;
        }

        TreeNode leaf = root;
        while(true){
            if(value < leaf.value){
                if(leaf.leftChild != null) leaf = leaf.leftChild;
                else break;
            } else {
                if(leaf.rightChild != null) leaf = leaf.rightChild;
                else break;
            }
        }

        if(value < leaf.value) leaf.leftChild = new TreeNode(value);
        else leaf.rightChild = new TreeNode(value);
    }

    // for future implementation :)
    void deleteNode(int value){

    }

    private boolean search(int value, TreeNode start){
        if(start == null) return false;
        if(start.value == value) return true;

        boolean inLeft = false, inRight = false;
        if(value < start.value){
            inLeft = search(value, start.leftChild);
        } else {
            inRight = search(value, start.rightChild);
        }

        return inLeft || inRight;
    }

    void searchTree(int value){
        System.out.print("Searching for value " + value + ": ");
        System.out.println(search(value, root));
    }

    private void print(TreeNode start){
        if(start == null) return;

        print(start.leftChild);
        System.out.print(start.value + " ");
        print(start.rightChild);
    }

    void printTree(){
        System.out.print("Printing the BST: ");
        print(root);
        System.out.println();
    }
}
