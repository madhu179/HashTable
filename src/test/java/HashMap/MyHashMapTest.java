package HashMap;

import org.junit.Assert;
import org.junit.Test;

public class MyHashMapTest<K, V> {

	@Test
	public void given3NodesAddingShouldReturnFrequency() {

		String sentence = "to be or not to be";
		String[] words = sentence.split(" ");
		MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
		Integer value;
		for (int i = 0; i < words.length; i++) {
			value = myHashMap.getValue(words[i]);
			if (value == null) {
				value = 1;
				myHashMap.addNode(words[i], value);
			} else {
				myHashMap.addNode(words[i], value + 1);
			}
		}
		myHashMap.printMap();
		Integer frequencyOfWord = myHashMap.getValue("to");
		boolean result = frequencyOfWord.equals(2);
		Assert.assertTrue(result);
	}

	@Test
	public void given3NodesAddingToHashTableShouldReturnFrequency() {

		String sentence = "Paranoids are not paranoid because they're paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
		String[] words = sentence.split(" ");
		MyLinkedHashMap<String, Integer> myLinkedHashMap = new MyLinkedHashMap<>();
		Integer value;
		for (int i = 0; i < words.length; i++) {
			value = myLinkedHashMap.get(words[i]);
			if (value == null) {
				value = 1;
				myLinkedHashMap.addNode(words[i], value);
			} else {
				myLinkedHashMap.addNode(words[i], value + 1);
			}
		}
		myLinkedHashMap.printListedMap();
		Integer frequencyOfWord = myLinkedHashMap.get("paranoid");
		boolean result = frequencyOfWord.equals(3);
		Assert.assertTrue(result);
	}

	@Test
	public void given3NodesRemovingKeyInHashTableShouldPassTest() {

		String sentence = "Paranoids are not paranoid because they're paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
		String[] words = sentence.split(" ");
		MyLinkedHashMap<String, Integer> myLinkedHashMap = new MyLinkedHashMap<>();
		Integer value;
		for (int i = 0; i < words.length; i++) {
			value = myLinkedHashMap.get(words[i]);
			if (value == null) {
				value = 1;
				myLinkedHashMap.addNode(words[i], value);
			} else {
				myLinkedHashMap.addNode(words[i], value + 1);
			}
		}

		Integer size1 = myLinkedHashMap.getSize();
		boolean result3 = size1.equals(15);

		Integer returnedValue = myLinkedHashMap.remove("avoidable");
		boolean result1 = returnedValue.equals(1);

		Integer size2 = myLinkedHashMap.getSize();
		boolean result2 = size2.equals(14);

		boolean result4 = myLinkedHashMap.isEmpty();

		myLinkedHashMap.printListedMap();
		Assert.assertTrue(result1 && result2 && result3 && !result4);
	}

}
