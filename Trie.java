import java.util.ArrayList;

public interface Trie {

	
	
	/**
	adds a new string to the trie.

	@param insert the string to add to the trie.
	@return No return value
	*/
	void insert(String insert);
	/**
	adds a new string to the trie.

	@param insert the string to add to the trie.
	@return No return value
	*/
	 void printTrie();
	/**
	returns a vector containing all the strings in the trie.
	In order is a sorted ArrayList  
	@param order the order in which to Traverse the trie.
	@return An ArrayList that contains the strings in the trie.
	*/
	 ArrayList<String> sort( ); 

	/**
	returns a vector with all the possible words
	that start with prefix
	@param prefix the string to look for in the trie.
	@return vector with the strings in it.
	*/
	 ArrayList<String> search(String prefix);

	/**
	returns true if the string is in the trie.
	@param find the string to look for in the trie.
	@return true if the strings in the trie.
	*/
	boolean contains(String find);
}
