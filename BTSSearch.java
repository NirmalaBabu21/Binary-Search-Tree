public class BTSSearch {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static Node Create(Node root, int val){
        if(root==null){
            return root=new Node(val);
        }
        if(root.data>val){
            root.left=Create(root.left, val);
        }
        else
        root.right=Create(root.right, val);
        return root;
    }
    public static void inOrder(Node root){
        if(root==null)
        return ;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static boolean Search (Node root, int k){
        if (root==null)
        return false;
        if(root.data>k)
        return Search(root.left, k);
        else if(root.data==k)
        return true;
        else
        return Search(root.right, k);
    }
    public static void main(String args[]){
        int val[]={120,7,8,1,2,3,4,5,0};
        Node root=null;
        for (int i=0;i<val.length;i++){
            root=Create(root, val[i]);
        }
        inOrder(root);
        System.out.println();
        System.out.println(Search(root, 3));
        
    }
    
}
