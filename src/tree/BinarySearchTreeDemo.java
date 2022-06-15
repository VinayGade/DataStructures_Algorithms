package tree;

//Java program to demonstrate
//insert operation in binary
//search tree
class BinarySearchTree {

	/* Class containing left
	and right child of current node
	 * and key value*/

	// Root of BST
	Node root;

	class Node{
		int key;
		Node left, right, parent;

		public Node(int item){
			key = item;
			left = right = null;
		}

		public Node(int key, Node parent){
			this.key = key;
			left = null;
			right = null;
			this.parent = parent;
		}
	}

	// Constructor
	BinarySearchTree(){
		root = null;
	}

	BinarySearchTree(int key){
		this.root = new Node(key);
	}

	// This method mainly calls insertRec()
	void insert(int key){
		root = insertRec(root, key);
	}

	/* A recursive function to insert a new key in BST */
	Node insertRec(Node root, int key){

		/* If the tree is empty, return a new node */
		if (root == null)
		{
			root = new Node(key);
			return root;
		}

		/* Otherwise, recur down the tree */
		if (key < root.key)
			root.left = insertRec(root.left, key);

		else if (key > root.key)
			root.right = insertRec(root.right, key);

		/* return the (unchanged) node pointer */
		return root;
	}

	// This method mainly calls InorderRec()
	void traversal(int flag){
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
	void inorder(Node root){
		if (root != null) {
			inorder(root.left);
			System.out.println(root.key);
			inorder(root.right);
		}
	}

	// A utility function to
	// do inorder traversal of BST
	void preorder(Node root){
		if (root != null) {
			System.out.println(root.key);
			preorder(root.left);
			preorder(root.right);
		}
	}

	// A utility function to
	// do inorder traversal of BST
	void postorder(Node root){
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.println(root.key);			
		}
	}

	// A utility function to search a given key in BST
	public Node search(Node root, int key){
		// Base Cases : root is null or key is present at root
		if (root == null || root.key == key)
			return root;

		// Key is greater than root's key
		if (root.key < key)
			return search(root.right, key);

		// Key is smaller than root's key
		return search(root.left, key);
	}

	// This method mainly calls deleteRec()
	void deleteKey(int key) { 
		root = deleteRec(root, key); 
	}

	/* A recursive function to delete an existing key in BST
	 */
	Node deleteRec(Node root, int key){
		/* Base Case: If the tree is empty */
		if (root == null)
			return root;

		/* Otherwise, recur down the tree */
		if (key < root.key)
			root.left = deleteRec(root.left, key);
		else if (key > root.key)
			root.right = deleteRec(root.right, key);

		// if key is same as root's
		// key, then This is the
		// node to be deleted
		else {
			// node with only one child or no child
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			// node with two children: Get the inorder
			// successor (smallest in the right subtree)
			root.key = minValue(root.right);

			// Delete the inorder successor
			root.right = deleteRec(root.right, root.key);
		}

		return root;
	}

	int minValue(Node root){
		int minv = root.key;
		while (root.left != null)
		{
			minv = root.left.key;
			root = root.left;
		}
		return minv;
	}

	int maxValue(Node root){
		int max = root.key;
		while (root.right != null)
		{
			max = root.right.key;
			root = root.right;
		}
		return max;
	}

	int maxDepth(Node node){
		if (node == null)
			return 0;
		else
		{
			/* compute the depth of each subtree */
			int lDepth = maxDepth(node.left);
			int rDepth = maxDepth(node.right);

			/* use the larger one */
			if (lDepth > rDepth)
				return (lDepth + 1);
			else
				return (rDepth + 1);
		}
	}

	// Recursive function to calculate the height of a given binary tree
	public static int height(Node root){
		// Base case: empty tree has a height of 0
		if (root == null) {
			return 0;
		}

		// recur for the left and right subtree and consider maximum depth
		return 1 + Math.max(height(root.left), height(root.right));
	}

	// Recursive function to calculate the size of a binary tree
	public static int getSize(Node root){
		// Base case: empty tree has size 0
		if (root == null) {
			return 0;
		}
		// recur for the left and right subtree
		return 1 + getSize(root.left) + getSize(root.right);
	}

	// Function to check if each node of a binary tree has exactly one child
	public static boolean isSkewedTree(Node root) {
		return getSize(root) == height(root);
	}

	// Recursive function to find the
	// parent of the given node
	static void findParent(Node node, int val, int parent){
		if (node == null)
			return;

		// If current node is the required node
		if (node.key == val)
		{

			// Print its parent
			System.out.print(parent);
		}
		else
		{

			// Recursive calls for the children
			// of the current node
			// Current node is now the new parent
			findParent(node.left, val, node.key);
			findParent(node.right, val, node.key);
		}
	}

	//Method to find right sibling
	Node findRightSibling(Node node, int level){
		if (node == null || node.parent == null)
			return null;

		// GET Parent pointer whose right child is not
		// a parent or itself of this node. There might
		// be case when parent has no right child, but,
		// current node is left child of the parent
		// (second condition is for that).
		while (node.parent.right == node
				|| (node.parent.right == null
				&& node.parent.left == node)) {
			if (node.parent == null)
				return null;

			node = node.parent;
			level--;
		}

		// Move to the required child, where right sibling
		// can be present
		node = node.parent.right;

		// find right sibling in the given subtree(from current
		// node), when level will be 0
		while (level < 0) {

			// Iterate through subtree
			if (node.left != null)
				node = node.left;
			else if (node.right != null)
				node = node.right;
			else

				// if no child are there, we cannot have right
				// sibling in this path
				break;

			level++;
		}

		if (level == 0)
			return node;

		// This is the case when we reach 9 node in the tree,
		// where we need to again recursively find the right
		// sibling
		return findRightSibling(node, level);
	}

}

public class BinarySearchTreeDemo {

	public static void main(String[] args) {

		BinarySearchTree tree = new BinarySearchTree();

		/* 
		 * 
		 Let us create following BST
			   50
		    /	  \
		   30	   70
		  / \      / \
	     20 40    60 80 

		 */

		System.out.println(" * * * * * Binary Search Tree : Insert * * * * * ");

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		// print inorder traversal of the BST (0 = inorder,  1 = pre,  2 = post)

		System.out.println(" * * * * * Binary Search Tree : Inorder Traversal * * * * * ");
		tree.traversal(0);

		System.out.println(" * * * * * Binary Search Tree : Preorder Traversal * * * * * ");
		tree.traversal(1);

		System.out.println(" * * * * * Binary Search Tree : Postorder Traversal * * * * * ");
		tree.traversal(2);

		// tree.search(, 60);

	}
}