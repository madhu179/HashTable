package HashMap;

import org.junit.Assert;
import org.junit.Test;

public class MyHashMapTest <K,V>{
	
	@Test
	public void given3NodesAddingShouldReturnFrequency()
	{
		
		String sentence = "to be or not to be";
		String[] words = sentence.split(" ");
		MyHashMap<String,Integer> myHashMap = new MyHashMap<>();
		Integer value;
		for(int i=0;i<words.length;i++)
		{
			value = myHashMap.getValue(words[i]);
			if(value==null)
			{
				value = 1;
				myHashMap.addNode(words[i],value);
			}
			else
			{
				myHashMap.addNode(words[i],value+1);
			}
		}
		myHashMap.printMap();
		Integer frequencyOfWord =  myHashMap.getValue("to");
		boolean result = frequencyOfWord.equals(2);
		Assert.assertTrue(result);
	}

}
