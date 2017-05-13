public class Build_Order_7{

	// project a is dependent on b
	static class Project{
		char pro;
		char dep;
	}

	static class Tree{
		public Node[] nodes;
		class Node{
			public Node(char data){
				this.data = data;
			}
			char data;
			Node[] children;
		}
	}
	public static void main(String[] agrs){
		
		char[] projects = {'a','b','c','d','e','f'};
		Project[] dependencies = new Project[5];
		for(int i=0;i<dependencies.length;i++){
			dependencies[i] = new Project();
		}
		
		dependencies[0].pro = 'd';
		dependencies[0].dep = 'a';
		
		dependencies[1].pro = 'b';
		dependencies[1].dep = 'f';

		dependencies[2].pro = 'd';
		dependencies[2].dep = 'f';

		dependencies[3].pro = 'a';
		dependencies[3].dep = 'f';

		dependencies[4].pro = 'c';
		dependencies[4].dep = 'd';

		Tree tree = new Tree();
		tree.nodes = new Tree.Node[projects.length];
		char c = 'a';
		for(int i=0;i<projects.length;i++){
			tree.nodes[i] = tree.new Node(c);
			tree.nodes[i].children = new Tree.Node[2];
			c++;
		}
		for(int i=0;i<projects.length;i++){
			System.out.print(tree.nodes[i].data);
		}

		tree.nodes[0].children[0] = tree.new Node('f');
		tree.nodes[1].children[0] = tree.new Node('f');
		tree.nodes[2].children[0] = tree.new Node('d');
		tree.nodes[3].children[0] = tree.new Node('a');
		tree.nodes[3].children[1] = tree.new Node('b');
			
		





	}
}