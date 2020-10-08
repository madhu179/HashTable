package HashMap;

public interface INode<K> {

	void setKey(K key);

	K getKey();

	INode<K> getNext();

	void setNext(INode<K> next);

}
