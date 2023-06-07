public class BSTDelete {
    static class Node{
        int data;
        Node left;
        Node right;
        Node (int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static Node Create(Node root, int val){
        if(root==null)
        return root=new Node(val);
        if(root.data>val)
        root.left=Create(root.left, val);
        else
        root.right=Create(root.right, val);
        return root;
    }
    public static void Inorder(Node root){
        if(root==null)
        return;
        Inorder(root.left);
        System.out.print(root.data+" ");
        Inorder(root.right);
    }
    public static Node delete(Node root, int n){
        if(root.data>n)
        root.left=delete(root.left, n);
        else if(root.data<n)
        root.right=delete(root.right, n);
        else{
            //case 1- no child
            if(root.left==null && root.right==null)
            return null;
            //case 2- one child
            else if(root.right == null)
            return root.left;
            else if(root.left==null)
            return root.right;
            //case 3 - two child
            Node IS= InOrderSuccessor(root.right);
            root.data=IS.data;
            root.right=delete(root.right, IS.data);
        }
    return root;
}
    public static Node InOrderSuccessor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    public static void main(String args[]){
        int val[]={10,8,6,5,7,9,12,50};
        Node root=null;
        for(int i=0;i<val.length;i++)
        root=Create(root, val[i]);
        Inorder(root);
        // System.out.println("\nDeleting leaf node with no child-9");
        // Inorder(delete(root, 9));
        // System.out.println("\nDeleting leaf node with one child-12");
        // Inorder(delete(root, 12));
        System.out.println("\nDeleting leaf node with two child-8");
        Inorder(delete(root, 8));

    }
}
