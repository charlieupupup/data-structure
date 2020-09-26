class traversal_recursive
{
    public:
    {
        void preorder(TreeNode * root, vector<int> & res)
        {
            if(!root) return;
            res.push_back(root->val);
            preorder(root->left, res);
            preorder(root->right, res);
        }

        void inorder(TreeNode * root)
        {

        }

        void postorder(TreeNode * root)
        {

        }
    }

};