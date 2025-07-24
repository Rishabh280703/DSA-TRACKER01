
class Solution {
    public  TreeNode pre(TreeNode root){

        TreeNode temp=root.left;
        while(temp.right!=null){
            temp=temp.right;
        }
        return temp;
    }
    public   TreeNode parent(TreeNode root, TreeNode pred){
        if(root.left==pred || root.right==pred)return root;

        TreeNode temp=root.left;
        while(temp.right!=pred){
            temp=temp.right;

        }
        return temp;
    }
    // Function to delete a node from BST.
    public  TreeNode deleteNode(TreeNode root, int X) {
        if(root==null)return null;
        if(root.val==X){
            if(root.left==null && root.right==null){
                return null;

            }
            else if(root.left==null || root.right==null){
                if(root.left==null)return root.right;
                else return root.left;
            }
            else{
                TreeNode pred= pre(root);
                TreeNode predp=parent(root,pred);
                if(predp==root){
                    pred.right=root.right;
                    return pred;
                }

                    predp.right=pred.left;
                    pred.left=root.left;
                    pred.right=root.right;
                    return pred;



            }

        }
        else if(root.val >X){
            root.left=deleteNode(root.left,X);
        }
        else{
            root.right=deleteNode(root.right,X);
        }
        return root;
        // code here.
    }
}
