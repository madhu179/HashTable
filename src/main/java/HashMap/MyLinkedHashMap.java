package HashMap;

import java.util.*;

public class MyLinkedHashMap<K, V> {

	private int bucketLength = 0;
	ArrayList<MyLinkedList> myBucketList;

	MyLinkedHashMap() {
		bucketLength = 10;
		myBucketList = new ArrayList<MyLinkedList>(bucketLength);
		for (int i = 0; i < bucketLength; i++)
			myBucketList.add(null);
	}

	public int getIndex(K key) {
		int hash = Math.abs(key.hashCode());
		return hash % bucketLength;
	}

	public void addNode(K key, V value) {
		int indx = getIndex(key);
		MyLinkedList<K> myLinkedList = myBucketList.get(indx);
		if (myLinkedList == null) {
			myLinkedList = new MyLinkedList<>();
			myBucketList.set(indx, myLinkedList);
		}
		MyMapNode<K, V> newMapNode = (MyMapNode<K, V>) myLinkedList.searchNode(key);
		if (newMapNode != null) {
			newMapNode.setValue(value);
		} else {
			newMapNode = new MyMapNode<K, V>(key, value);
			myLinkedList.appendNode(newMapNode);

		}
	}

	public V get(K key) {
		int indx = getIndex(key);
		MyLinkedList<K> myLinkedList = myBucketList.get(indx);
		if (myLinkedList != null) {
			MyMapNode<K, V> newMapNode = (MyMapNode<K, V>) myLinkedList.searchNode(key);
			if (newMapNode != null)
				return newMapNode.getValue();
		}
		return null;
	}

	public Integer remove(K key) {
		int indx = getIndex(key);
		MyLinkedList<K> myLinkedList = myBucketList.get(indx);
		if (myLinkedList != null) {
			MyMapNode<K, V> newMapNode = (MyMapNode<K, V>) myLinkedList.searchNode(key);
			if (newMapNode != null) {
				myLinkedList.deleteSpecificNode(newMapNode);
				return (Integer) newMapNode.getValue();
			}

		}
		return null;
	}

	public Integer getSize() {
		Integer size = 0;
		for (int i = 0; i <= 9; i++) {
			MyLinkedList<K> myLinkedList = myBucketList.get(i);
			if (myLinkedList != null && myLinkedList.head != null) {
				size += myLinkedList.size();
			}
		}
		return size;
	}

	public boolean isEmpty() {
		return this.getSize() == 0 ? true : false;
	}

	public void printListedMap() {
		System.out.println("HashTable : ");
		for (int i = 0; i <= 9; i++) {
			MyLinkedList<K> myLinkedList = myBucketList.get(i);
			if (myLinkedList != null && myLinkedList.head != null) {
				INode<K> tempNode = myLinkedList.head;
				MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) tempNode;
				String nodes = "";
				while (tempNode.getNext() != null) {
					nodes = nodes + "{K=" + myMapNode.getKey() + " V=" + myMapNode.getValue() + "}";
					nodes = nodes + "->";
					tempNode = tempNode.getNext();
					myMapNode = (MyMapNode<K, V>) tempNode;
				}
				nodes = nodes + "{K=" + myMapNode.getKey() + " V=" + myMapNode.getValue() + "}";
				System.out.println("LinkedList at index " + i + " : " + nodes);
			}
		}
	}

}
