package DSA.Tree;

public class TreeExample {
    public static void main(String[] args) {

        TreeNode drinks = new TreeNode("Drinks");
        TreeNode hotDrinks = new TreeNode("HotDrinks");
        TreeNode coldDrinks = new TreeNode("ColdDrinks");
        TreeNode tea = new TreeNode("tea");
        TreeNode coffee = new TreeNode("coffee");
        TreeNode wine = new TreeNode("wine");
        TreeNode fanta = new TreeNode("fanta");
        hotDrinks.addChild(tea);
        hotDrinks.addChild(coffee);
        coldDrinks.addChild(wine);
        coldDrinks.addChild(fanta);
        drinks.addChild(hotDrinks);
        drinks.addChild(coldDrinks);
        System.out.println(drinks.printTree(0));
        System.out.println(drinks.printTree(1));
    }
}
