
import java.util.ArrayList;
import java.util.Collections;

public class MyTrie implements Trie {

	@SuppressWarnings("unused")
	private class TrieNode
	{
		private boolean validString;
		private TrieNode parent;
		private int currentIndex = 0;
		private TrieNode nodes[] = new TrieNode[26];
				
		public TrieNode(boolean validString, TrieNode parent)
		{
			this.validString = validString;
			this.parent = parent;
		}
		
		public boolean isValidString() {
			return validString;
		}

		public TrieNode getParent() {
			return parent;
		}

		public int getCurrentIndex() {
			return currentIndex;
		}

	};
	
	private TrieNode root;
	
	public MyTrie() {
		//root = new TrieNode(false, );
	}
	
	@Override
	public void insert(String insert) {
		// TODO Auto-generated method stub
		if (root == null)
		{
			//Creating root 
			root = new TrieNode(false, null);
		}
		int index;
		TrieNode n = root;
		boolean endOfWord = false;
		for (int i = 0; i < insert.length(); i++)
		{
			index = insert.charAt(i) - 'a';
			if (n.nodes[index] == null)
			{
				if (i == insert.length()-1)
				{
					endOfWord = true;
				}
				
				//Create new TrieNode in n.node[index]
				n.nodes[index] = new TrieNode(endOfWord, n);
				//Move node to the child node 
				n = n.nodes[index];
			}			
		}	
	}

	
	@Override
	public void printTrie() {
		// TODO Auto-generated method stub
		
		printTrie(root);
	}

	private void printTrie(TrieNode n)
	{
		if (n == null)
		{
			return;
		}
		
		
		for (int i = 0; i < n.nodes.length; i++)
		{
			if (n.nodes[i] != null)
			{
				//Getting a char number of the letter and convert the num to letter
				int num = i + 'a';
				char c = (char)num;
					
				if(n.nodes[i].validString) {
					System.out.println(c);
					return;
				}else {
					System.out.print(c);
					printTrie(n.nodes[i]);
				}
					
			}
			/*else if (n.validString)
			{
				int num = i + 'a';
				char c = (char)num;
							
				
				return;
			}*/
			
		}
		
	}
	
	@Override
	public ArrayList<String> sort() {
		// TODO Auto-generated method stub
		String str = "";
		ArrayList<String> list = new ArrayList<>();
		sort(list, root, str);
		Collections.sort(list);
		return list;
	}

	private void sort(ArrayList<String> list, TrieNode n, String str){
		
		for (int i = 0; i < n.nodes.length; i++)
		{
			if (n.nodes[i] != null)
			{
				char c = (char) (i + 'a');
				str += c;
					
				if(n.nodes[i].validString) {
					
					list.add(str);
					return;
				}else {
					sort(list, n.nodes[i], str);
				}				
			}			
		}
	}
	
	@Override
	public ArrayList<String> search(String prefix) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		String str = "";
		search(root, prefix, list, str);
		return list;
	}
	
	private void search(TrieNode n, String prefix, ArrayList<String> list, String str) {
		if (n == null)
		{
			return;
		}
		
		for (int i = 0; i < n.nodes.length; i++)
		{
			if (n.nodes[i] != null && prefix.charAt(i) == (char) i- 'a')
			{
				char c = (char) (i + 'a');
				str += c;
					
				if(n.nodes[i].validString) {
					
					list.add(str);
					return;
				}else {
					sort(list, n.nodes[i], str);
				}				
			}			
		}
	}

	@Override
	public boolean contains(String find) {
		// TODO Auto-generated method stub
		return contain(find, root);
	}

	private boolean contain(String find, TrieNode n) {
		if (n == null)
		{
			return false;
		}
		
		for (int i = 0; i < find.length(); i++)
		{
			char letter = find.charAt(i);
			int num = letter - 'a';
			
			if (n.nodes[num] == null)
			{
				return false;				
			}
			n = n.nodes[num];
		}
		
		return (n != null && n.validString);
	}
}
