import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	
	private HashMap<String, Node> bGraph;
	private Node root;
	
	public Main() {
		bGraph = new HashMap<>();
	}
	
	// node of graph
	class Node {
		String data;
		Node left;
		Node right;
		
		public Node(String data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	// 노드 생성 + 존재하면 존재하는 노드 반환
	private Node getNode(String data) {
		if (data.equals(".")) return null;
		
		bGraph.putIfAbsent(data, new Node(data));
		return bGraph.get(data);
	}
	
	// 노드 추가
	private void addNode(String data, String left, String right) {
		Node node = getNode(data);
		
		if (root == null) {
			root = node;
		}
		
		node.left = getNode(left);
		node.right = getNode(right);
	}
	
	private void preorder(Node node) {
		if (node != null) {
			System.out.print(node.data);
			preorder(node.left);
			preorder(node.right);
		}
	}
	
	private void inorder(Node node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.data);
			inorder(node.right);
		}
	}
	
	private void postorder(Node node) {
		if (node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.data);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Main sol = new Main();
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			
			sol.addNode(input[0], input[1], input[2]);
		}
		
		sol.preorder(sol.root);
		System.out.println();
		sol.inorder(sol.root);
		System.out.println();
		sol.postorder(sol.root);
	}
}