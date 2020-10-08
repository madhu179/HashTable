package HashMap;


public class MyHashMap<K, V> {

	MyLinkedList<K> myLinkedList;
	
	MyHashMap()
	{
		this.myLinkedList = new MyLinkedList<K>();
	}
	
	public void addNode(K key,V value)
	{
		MyMapNode<K , V> node = (MyMapNode<K , V>) this.myLinkedList.searchNode(key);
		if(node==null)
		{
			this.myLinkedList.appendNode(new MyMapNode<>(key,value));
		}
		else
		{
			node.setValue(value);
		}
	}

	public V getValue(K key) {

		MyMapNode<K , V> node = (MyMapNode<K , V>) this.myLinkedList.searchNode(key);
		if(node==null)
		{
			return null;
		}
		else
		{
			return node.getValue();
		}
	}
	
	public int getSize()
	{
		Integer size = myLinkedList.size();
		return size;
	}

	public void printMap() {
		INode<K> tempNode = myLinkedList.head;
		MyMapNode<K , V> myMapNode =(MyMapNode<K , V> )tempNode;
		String nodes = "";
		while (tempNode.getNext() != null) {
			nodes = nodes+"{K="+myMapNode.getKey()+" V="+myMapNode.getValue()+"}";
			nodes = nodes+"->";
			tempNode = tempNode.getNext();
			myMapNode =(MyMapNode<K , V> )tempNode;
		}
		nodes = nodes +"{K="+myMapNode.getKey()+" V="+myMapNode.getValue()+"}";
		System.out.println("HashMap Nodes : " + nodes);
	}
	
}
