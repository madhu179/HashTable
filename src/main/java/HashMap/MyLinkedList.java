package HashMap;

public class MyLinkedList<K> {

	public INode<K> head;
	public INode<K> tail;

	public MyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public void addNode(INode<K> newNode) {
		if (tail == null)
			this.tail = newNode;

		if (head == null)
			this.head = newNode;
		else {
			INode<K> tempNode = this.head;
			newNode.setNext(tempNode);
			this.head = newNode;
		}
	}

	public void appendNode(INode<K> newNode) {

		if (head == null)
			this.head = newNode;
		if (tail == null)
			this.tail = newNode;
		else {
			INode<K> tempNode = this.tail;
			tempNode.setNext(newNode);
			this.tail = newNode;
		}
	}

	public void insertNode(INode<K> previousNode, INode<K> newNode) {
		INode<K> tempNode = previousNode.getNext();
		newNode.setNext(tempNode);
		previousNode.setNext(newNode);
	}

	public INode<K> pop() {
		if (this.head.getNext() != null) {
			INode<K> tempfirstNode = this.head;
			INode<K> tempNode = this.head.getNext();
			this.head.setNext(null);
			this.head = tempNode;
			return tempfirstNode;
		} else {
			INode<K> tempfirstNode = this.head;
			this.head = null;
			return tempfirstNode;
		}
	}

	public INode<K> popLast() {
		INode<K> tempNode = this.head;
		INode<K> lastButOneNode = tempNode;
		while (tempNode.getNext() != null) {
			lastButOneNode = tempNode;
			tempNode = tempNode.getNext();
		}
		lastButOneNode.setNext(null);
		this.tail = lastButOneNode;
		return tempNode;
	}

	public INode<K> searchNode(K key) {
		if(this.head != null)
		{
		INode<K> tempNode = this.head;
		while (tempNode.getNext() != null) {
			if (tempNode.getKey().equals(key))
			{
				return tempNode;
			}
			tempNode = tempNode.getNext();
		}
		}
		
		return null;
	}

	public INode<K> deleteSpecificNode(INode<K> seachedNode) {
		INode<K> tempNode = this.head;
		INode<K> lastButOneNode = tempNode;
		while (!((int) tempNode.getKey() == 40)) {
			lastButOneNode = tempNode;
			tempNode = tempNode.getNext();
		}
		lastButOneNode.setNext(tempNode.getNext());
		tempNode.setNext(null);
		this.tail = lastButOneNode.getNext();
		return tempNode;
	}

	public int size() {
		if (this.head == null) {
			return 0;
		}

		INode<K> tempNode = this.head;
		int i = 0;
		while (tempNode.getNext() != null) {
			i += 1;
			tempNode = tempNode.getNext();
		}
		return i + 1;
	}

	public void printNodes() {
		INode<K> tempNode = this.head;
		String nodes = " ";
		while (tempNode.getNext() != null) {
			nodes = nodes + tempNode.getKey();
			if (!tempNode.equals(tail))
				nodes = nodes + "->";
			tempNode = tempNode.getNext();
		}
		nodes = nodes + tempNode.getKey();
		System.out.println("Linked List : " + nodes);
	}
	
}
