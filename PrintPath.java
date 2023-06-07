import java.util.*;
public class PrintPath {
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
    public static void pathRootToLeaf (Node root, ArrayList<Integer> p){
        if(root==null)
        return;
        p.add(root.data);
        if(root.left==null && root.right ==null){
            printPathall(p);
        }
        else{
        pathRootToLeaf(root.left,p);
        pathRootToLeaf(root.right,p);}
        p.remove(p.size()-1);
    }
    public static void printPathall(ArrayList<Integer> p){
        for(int i=0;i<p.size();i++){
            System.out.print(p.get(i)+"-> ");
        }
        System.out.println();;
    }
    public static void main(String[] args) {
        int val[]={8,5,3,6,10,11,12};
        Node root=null;
        for(int i=0;i<val.length;i++)
        root=create(root, val[i]);
        inorder(root);
        System.out.println();
        pathRootToLeaf(root, new ArrayList<>());
    }
}
