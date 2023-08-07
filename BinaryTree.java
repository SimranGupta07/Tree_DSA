package Tree;
import java.util.*;
public class BinaryTree {
	public class Node{
		int data;
		Node left;
		Node right;
	}
private Node root;

public BinaryTree() {
	root=CreateTree();
}

Scanner sc=new Scanner(System.in);

private Node CreateTree() {
	int item=sc.nextInt();
	Node nn=new Node();
	nn.data=item;
	boolean hlc=sc.hasNextBoolean();
	if(hlc==true) {
		nn.left=CreateTree();
	}
	boolean hrc=sc.hasNextBoolean();
	{
		if(hrc==true) {
		nn.right=CreateTree();
		}
	}
	return nn;
}



public void display() {
	display(root);
}
private void display(Node nn) {
	if(nn==null) {
		return ;
	}
	
	String s="";
	s="<-"+nn.data+"->";
	if(nn.left!=null) {
		s=nn.left.data+s;
	}
	else {
		s="."+s;
	}
	if(nn.right!=null) {
		s=s+nn.right.data;
	}
	else {
		s=s+".";
	}
	display(nn.left);
	display(nn.right);
	
}




public int maxnode() {
	return maxnode(root);
}
private int maxnode(Node nn) {
	if(nn==null) {
		return Integer.MIN_VALUE;
	}
	int left=maxnode(nn.left);
	int right=maxnode(nn.right);
	return Math.max(nn.data,Math.max(left, right));
			
}


public boolean find(int item) {
	return find(this.root,item);
}
private boolean find (Node nn,int item) {
	if(nn==null) {
		return false;
	}
	if(nn.data==item) {
		return true;
	}
	
	boolean left=find(nn.left,item);
	boolean right=find(nn.right,item);
	return left||right;
}



public int ht() {
	return ht(this.root);
	
}
private int ht(Node nn) {
	if(nn==null) {
		return -1;
	}
	int lh=ht(nn.left);
	int rh=ht(nn.right);
	return Math.max(lh, rh)+1;
}



public void preorder() {
	preorder(this.root);
	System.out.println();
}
private void preorder(Node nn) {
	if(nn==null) {
		return;
	}
	System.out.print(nn.data+" ");
	preorder(nn.left);
	preorder(nn.right);
}


public void postorder() {
	postorder(this.root);
}
private void postorder(Node nn) {
	if(nn==null) {
		return;
	}
	postorder(nn.left);
	postorder(nn.right);
	System.out.print(nn.data+" ");
}


public void inorder() {
	inorder(this.root);
}
private void inorder(Node nn) {
	if(nn==null) {
		return;
	}
	inorder(nn.left);
	System.out.print(nn.left);
	inorder(nn.right);
}
}
