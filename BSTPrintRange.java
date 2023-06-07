public class BSTPrintRange {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
    public static Node create(Node root, int val){
        if(root==null){
            return root=new Node(val);
        }
        if(root.data>val){
            root.left=create(root.left, val);
        }
        else
        root.right=create(root.right, val);
        return root;
    }
    public static void inorder(Node root){
        if(root==null)
        return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void printRange(Node root, int X, int Y){
        if(root==null)
        return;
        if(root.data>=X && root.data<=Y){
        printRange(root.left, X, Y);
        System.out.print(root.data+" ");
        printRange(root.right, X, Y);
        }
        else if(root.data>=Y)
        printRange(root.left, X, Y);
        else if(root.data<=Y)
        printRange(root.right, X, Y);
    }
    public static void main(String[] args) {
        int val[]={10,8,6,5,7,9,12,50};
        Node root=null;
        for(int i=0;i<val.length;i++)
        root=create(root, val[i]);
        inorder(root);
        System.out.println("\nPrint numbers in range: ");
        printRange(root, 2, 9);
    }
}
