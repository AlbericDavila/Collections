//	By Alberic A. Davila Cadilla
//	TreeNode.java
//
//	Class that represents a binary tree node.


package datastructures;

class TreeNode<T> {

	// Package private fields for the data and children of this node
	T data;
	TreeNode<T> left, right;

	// Creates a new node with the given data and children.
	public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	// Returns the data of this node.
	public T getData() {
		return data;
	}

	// Sets the data of this node to the given value.
	public void setData(T data) {
		this.data = data;
	}

	// Returns the left child of this node.
	public TreeNode<T> getLeft() {
		return left;
	}

	// Sets the left child of this node to the given value.
	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	// Returns the right child of this node.
	public TreeNode<T> getRight() {
		return right;
	}

	// Sets the right child of this node to the given value.
	public void setRight(TreeNode<T> right) {
		this.right = right;
	}

	// Returns a string representation of this node.
	@Override
	public String toString() {
		return left + "<--" + data + "-->" + right;
	}

}