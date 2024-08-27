package DSA.Tree;


import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    private String data;
    private List<TreeNode> children;

    public TreeNode(String data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode node) {
        children.add(node);
    }

    public String printTree(int level) {
        StringBuilder value;
        value = new StringBuilder(" ".repeat(level) + data + "\n");
        for (TreeNode node : children) {
            value.append(node.printTree(level + 1));

        }
        return value.toString();
    }
}
