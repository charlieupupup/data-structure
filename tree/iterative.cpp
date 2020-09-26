class iterative
{
    public:
    {
        void preorder(TreeNode * root, vector<int> & res)
        {
            stack<TreeNode *> node;
            while(root || !node.empty())
            {
                if(root)
                {
                    res.push_back(root->val);

                    if(root->right) node.push_back(root->right);

                    root = root->left;
                }
                else
                {
                    root = node.top();
                    node.pop();
                }
                
            }
        }
    }
};