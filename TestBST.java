
public class TestBST {
	public static void main(String[] args){
		BinaryTree binaryTree = new BinaryTree(); //Create Tree
		binaryTree.addNode(50,"A"); //addNode
		binaryTree.addNode(20,"B");
		binaryTree.addNode(30,"C");
		binaryTree.addNode(44,"D");
		binaryTree.addNode(12,"E");
		binaryTree.addNode(63,"F");
		System.out.println("inOrder:");
		binaryTree.inOrderTraverseTree(binaryTree.root);
		System.out.println("preorder:");
		binaryTree.preorderTraverseTree(binaryTree.root);
		System.out.println("postOrder:");
		binaryTree.postOrderTraverseTree(binaryTree.root);
	}
}
class BinaryTree{
	Node root;
	
	public void addNode(int key,String name){//Create a new Node 
		Node newNode = new Node(key,name);
		if(root == null){
			// if there is no root this becomes root
			root = newNode;
		}else{
			
			Node foucsNode = root;
			Node parent;
			while(true){
				parent = foucsNode;
				
				if(key < foucsNode.key){
					foucsNode = foucsNode.leftChild;
					// If the left child has no children
					if (foucsNode == null){
						// then place the new node on the left of it
						parent.leftChild = newNode;
						return;
					}
				}else{
					foucsNode = foucsNode.righrChild;
					//If the right child has no children
					if(foucsNode == null){
						// then place the new node on the right of it
						parent.righrChild = newNode;
						return;
					}
				}
			}
		}
	}
	public void inOrderTraverseTree(Node focusNode){ 
		if(focusNode != null){
			inOrderTraverseTree(focusNode.leftChild);
			System.out.println(focusNode);
			inOrderTraverseTree(focusNode.righrChild);
		}
	}
	public void preorderTraverseTree(Node focusNode){ 
		if(focusNode != null){
			System.out.println(focusNode);
			inOrderTraverseTree(focusNode.leftChild);
			inOrderTraverseTree(focusNode.righrChild);
		}
	}
	public void postOrderTraverseTree(Node focusNode){ 
		if(focusNode != null){
			inOrderTraverseTree(focusNode.leftChild);
			inOrderTraverseTree(focusNode.righrChild);
			System.out.println(focusNode);
		}
	}
	
}
class Node{
	int key;
	String name;
	Node leftChild;
	Node righrChild;
	Node(int key , String name){
		this.key = key;
		this.name = name;
	}
	public String toString(){
		return name+" has a key: "+key;
	}
}