package HashMap;

public class MyMapNode<K , V> implements INode<K> {
	
	K key;
	V value;
	MyMapNode<K , V> next;
	
	MyMapNode(K key,V value)
	{
		this.key = key;
		this.value = value;
		this.next = null;
	}
	
	public void setKey(K key)
	{
		this.key = key;
	}
	
	public void setValue(V value)
	{
		this.value = value;
	}
	
	public void setNext(INode<K> next)
	{
		this.next = (MyMapNode<K , V>)next;
	}

	public K getKey() {
		return this.key;
	}
	
	public V getValue()
	{
		return value;
	}
	
	public INode<K> getNext() {
		
		return this.next;
	}
	
}
