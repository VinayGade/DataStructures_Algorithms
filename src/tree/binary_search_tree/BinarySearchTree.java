package tree.binary_search_tree;

public class BinarySearchTree {

	TreeNode root;

	public BinarySearchTree(){
		root = null;
	}

	public BinarySearchTree(int data){
		this.root = new TreeNode(data);
	}

	/* Tree Traversal Algorithms : (recursive, iterative)
	   1. Inorder Tree Walk  
	   2. Preorder 
	   3. Postorder
	 */
	// This method mainly calls InorderRec()
	public void traversal(int flag){
		switch(flag){
		case 0: 
			inorder(root); 
			break;

		case 1:
			preorder(root);
			break;

		case 2:
			postorder(root);
			break;
		}
	}

	// A utility function to
	// do inorder traversal of BST
	public void inorder(TreeNode root){
		if (root != null) {
			inorder(root.left);
			System.out.println(root.data);
			inorder(root.right);
		}
	}

	// A utility function to
	// do inorder traversal of BST
	public void preorder(TreeNode root){
		if (root != null) {
			System.out.println(root.data);
			preorder(root.left);
			preorder(root.right);
		}
	}

	// A utility function to
	// do inorder traversal of BST
	public void postorder(TreeNode root){
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.println(root.data);			
		}
	}


	/* Tree Search
	   1. Recursive search
	   2. Iterative search
	 * */

	// 1. Recursive search
	public TreeNode search(TreeNode root, int key){
		// Base Cases : root is null or key is present at root
		if (root == null || root.data == key)
			return root;

		// Key is greater than root's key
		if (root.data < key)
			return search(root.right, key);

		// Key is smaller than root's key
		return search(root.left, key);
	}

	public TreeNode iterativeSearch(TreeNode node, int key) {
		while(node != null && key != node.data) {
			if(key < node.data)
				node = node.left;
			else
				node = node.right;
		}
		return node;
	}

	// search : Robert Lafore: DSA book
	public TreeNode find(int key) {

		TreeNode current = root;
		if(current == null)
			throw new IllegalArgumentException();
		while(current.data != key) {

			if(current.data < key)
				current = current.left;
			else
				current = current.right;
		}
		return current;
	}

	/* Tree Insert
	   1. Iterative
	   2. Recursive
	 * */

	// 1. Recursive
	public TreeNode insertRec(TreeNode root, int key){

		/* If the tree is empty, return a new node */
		if (root == null)
		{
			root = new TreeNode(key);
			return root;
		}

		/* Otherwise, recur down the tree */
		if (key < root.data)
			root.left = insertRec(root.left, key);

		else if (key > root.data)
			root.right = insertRec(root.right, key);

		return root;
	}

	public TreeNode minimum(TreeNode root) {
		TreeNode min = root;
		while(min.left != null)
			min = min.left;
		return min;
	}

	//Recursive min
	private TreeNode min(TreeNode x) { 
		if (x.left == null) 
			return x; 
		else                
			return min(x.left); 
	} 

	public TreeNode maximum(TreeNode root) {
		TreeNode max = root;
		while(max.right != null)
			max = max.right;
		return max;
	}

	//Recursive max
	private TreeNode max(TreeNode x) {
		if (x.right == null) 
			return x; 
		else                 
			return max(x.right); 
	}

	/*
	TreeNode parent(TreeNode node, int val, TreeNode parent) {
		if (node.data == val)
		{
			return parent;
		}
		else
		{

			// Recursive calls for the children
			// of the current node
			// Current node is now the new parent
			parent(node.left, val, node.data);
			parent(node.right, val, node.data);
		}
	}
	 */

	public TreeNode parentNode(int key) {
		TreeNode parent = root;
		if(root.left ==null && root.right==null)
			System.out.println("Tree has only 1node i.e. Root node is parent of tree.");

		while(parent != null) {
			TreeNode leftNode = parent.left;
			TreeNode rightNode = parent.right;
			if(leftNode.data == key || rightNode.data == key)
				break;
			else if(key < leftNode.data)
				parent = leftNode;
			else parent = rightNode;	
		}
		return parent;
	}

	/*
	TreeNode findParent(int key) {


			if(root.left.data == key || root.right.data == key)
				return root;
			else if(key < root.left.data)
				return findParent(root.left.data);
			else 
				return findParent(root.right.data);

	}
	 */

	public TreeNode sibling(TreeNode root, int key) {
		TreeNode parent = parentNode(key);
		TreeNode leftNode = parent.left;
		TreeNode rightNode = parent.right;
		if(key == leftNode.data)
			return rightNode;
		else if(key == rightNode.data)
			return leftNode;
		else throw new IllegalArgumentException();
	}

	public TreeNode successor(TreeNode root) {
		TreeNode successor = root;
		if(successor.right != null)
			return minimum(successor.right);
		TreeNode temp = parentNode(successor.data);
		while(temp != null && successor == temp.right) {
			successor = temp;
			temp = parentNode(temp.data);
		}
		return temp;
	}

	private int height(TreeNode root) {
		if (root == null) 
			return -1;
		return 1 + Math.max(height(root.left), height(root.right));
	}

	public void insert(int data) {
		//iterative approach to insert node

		TreeNode node = new TreeNode(data);
		if(root == null)
			root = node;
		else {
			TreeNode current = root; 
			TreeNode parent = null;
			while(current!=null)
			{
				parent = current;
				if(data < current.data) {
					current = current.left;
					/*
					if(current == null) {
						parent.left = node;
						return;
					}*/
				}else {
					current = current.right;
					/*
					if(current == null) {
						parent.right = node;
						return;
					}*/
				}
			}
			if (data < parent.data) 
				parent.left = new TreeNode(data);
			
			else 
				parent.right = new TreeNode(data);
			
		}
	}

	public boolean delete(int key) {
		//iterative approach to delete node

		TreeNode current = root;
		TreeNode parent = root;
		boolean isLeftChild = true;

		while(current.data != key) {
			parent = current; 
			if(key < current.data)
			{
				isLeftChild = true;
				current = current.left; 
			}else {
				isLeftChild = false;
				current = current.right; 
			}
			if(current == null) 
				// throw Element not found Exception
				return false;
		}
		if(current.left == null && current.right == null) {
			if(current == null)
				root = null;
			else if(isLeftChild)
				parent.left = null;
			else 
				parent.right = null;
		}
		else if(current.right == null) {
			if(current == root)
				root = current.left;
			else if(isLeftChild)
				parent.left = current.left;
			else 
				parent.right = current.right;
		}
		else if(current.left == null) {
			if(current == root)
				root = current.right;
			else if(isLeftChild)
				parent.left = current.right;
			else 
				parent.right = current.right;
		}

		else {
			// two children, so replace with inorder successor {
			// get successor of node to delete (current)

			TreeNode successor = getSuccessor(current);
			// connect parent of current to successor instead 
			if(current == root)
				root = successor; 
			else if(isLeftChild)
				parent.left = successor; 
			else
				parent.right = successor;
			// connect successor to current’s left child 
			successor.left = current.left;
		} // end else two children
		// (successor cannot have a left child
		return true; // success
	}

	// -------------------------------------------------------------
	// returns node with next-highest value after delNode
	// goes to right child, then right child’s left descendents 
	private TreeNode getSuccessor(TreeNode delNode)
	{
		TreeNode successorParent = delNode; 
		TreeNode successor = delNode;
		TreeNode current = delNode.right; 
		while(current != null)
		{
			successorParent = successor; 
			successor = current;
			current = current.left; 
		}
		if(successor != delNode.right) {
			// go to right child 
			// until no more
			// left children,
			// go to left child
			// if successor not 
			// right child,
			// make connections
			successorParent.left = successor.right; 
			successor.right = delNode.right;
		}
		return successor;
	}

	public TreeNode deleteNode(TreeNode root, int key) {
		if(root == null) return null;

		if(key > root.data) 
			root.right =  deleteNode(root.right , key);

		else if(key < root.data) 
			root.left = deleteNode(root.left , key);

		else {
			if(root.right == null) 
				return root.left;

			else if (root.left == null) 
				return root.right;

			root.data = minValue(root.right);
			root.right = deleteNode(root.right , root.data);
		}
		return root;
	}

	public static int minValue(TreeNode root) {
		int minV = root.data;
		while(root.left != null) {
			minV = root.left.data;
			root = root.left;
		}
		return minV;
	}

	public void LevelOrderTraversal()
	{
		int h = heightLevelOrder(root);
		int i;
		for (i=1; i<=h; i++)
			CurrentLevel(root, i);
	}

	public int heightLevelOrder(TreeNode root) {
		if (root == null)
			return -1; 
		else {
			int lheight = heightLevelOrder(root.left);
			int rheight = heightLevelOrder(root.right);
			if (lheight > rheight)
				return(lheight+1);
			else return(rheight+1);
		}
	}

	public void CurrentLevel(TreeNode root ,int level) {
		if (root == null)
			return;	
		if (level == 1)
			System.out.print(root.data + " ");
		else if (level > 1) {
			CurrentLevel(root.left, level-1);
			CurrentLevel(root.right, level-1);
		}
	}

}