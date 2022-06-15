package tree.binary_search_tree;

import java.util.Scanner;

public class BinarySearchTreeOperations {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		BinarySearchTree bst = new BinarySearchTree();
		System.out.println("\n Binary Search Tree Operations :\n");

		while(true) {
			System.out.println("\n Enter your choice :\n"); 
			System.out.println("\n1. Traversal");
			System.out.println("\n2. Search");
			//System.out.println("\n3. Insert");
			System.out.println("\n4. Minimum");
			System.out.println("\n5. Maximum");
			System.out.println("\n6. Parent");
			System.out.println("\n7. Sibling");
			System.out.println("\n8. Height");
			System.out.println("\n9. Insert");
			System.out.println("\n10. Delete");
			System.out.println("\n11. Level Order Traversal");

			int ch = scanner.nextInt();

			switch(ch) {

			case 1:
				System.out.println("Enter Traversal Choice :");
				System.out.println("\n1. Inorder");
				System.out.println("\n2. Preorder");
				System.out.println("\n3. Postorder");
				int tc = scanner.nextInt();
				bst.traversal(tc);
				break;

			case 2:
			/*
			System.out.println("Enter Search Choice :");
			System.out.println("\n1. Recursive");
			System.out.println("\n2. Iterative");
			System.out.println("\n3. find");
			int sc = scanner.nextInt();
			*/
				System.out.println("Enter Search key :");
				int key = scanner.nextInt();
				bst.find(key);
				break;

			case 4:

				break;

			case 5:
				break;

			case 6:
				break;

			case 7:
				break;

			case 8:
				break;

			case 9:
				System.out.println("Enter Insert key :");
				int ikey = scanner.nextInt();
				bst.insert(ikey);
				break;

			case 10:
				System.out.println("Enter Delete key :");
				int dkey = scanner.nextInt();
				bst.delete(dkey);
				break;

			case 11:
				System.out.println("\nLevel order traversal :");
				bst.LevelOrderTraversal();
				break;

			case 12:
				System.exit(0);
				break;
				
			default: 
				break;

			}			
		}
	}
}
