class traversal_morris
{
public:
    void inorder(TreeNode * root)
    {
        TreeNode * curr = root, *prev = nullptr;

        //while curr ptr not empty
        while(curr)
        {
            if(!curr->left)
            {
                std::cout << curr->val << " ";
                curr = curr->right;
            }
            //find predecessor
            else
            {
                prev = curr->left;
                while(prev->right && prev->right != curr) prev = prev->right;

                if(!prev->right)
                {
                    prev->right = curr;
                    curr = curr->left;
                }
                else
                {
                    prev->right = nullptr;
                    std::cout << curr->val << " ";
                    curr = curr->right;
                }
            }
        }

        std::cout << "\n";
    }

    void preorder(TreeNode * root)
    {
        TreeNode * curr = root, *prev = nullptr;

        //while curr ptr not empty
        while(curr)
        {
            if(!curr->left)
            {
                std::cout << curr->val << " ";
                curr = curr->right;
            }
            //find predecessor
            else
            {
                prev = curr->left;
                while(prev->right && prev->right != curr) prev = prev->right;

                if(!prev->right)
                {
                    std::cout << curr->val << " ";
                    prev->right = curr;
                    curr = curr->left;
                }
                else
                {
                    prev->right = nullptr;
                    curr = curr->right;
                }
            }
        }

        std::cout << "\n";
    }

};