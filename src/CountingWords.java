import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class CountingWords {
	
	static <K,V extends Comparable<? super V>> 
    	List<Entry<K, V>> entriesSortedByValues(Map<K,V> map) {

		List<Entry<K,V>> sortedEntries = new ArrayList<Entry<K,V>>(map.entrySet());

		Collections.sort(sortedEntries, 
				new Comparator<Entry<K,V>>() {
					@Override
					public int compare(Entry<K,V> e1, Entry<K,V> e2) {
						return e2.getValue().compareTo(e1.getValue());
					}
				}
			);

		return sortedEntries;
	}
	public static void main(String[] args) {
		
		File file = new File("input.txt");		
		
		FileReader fReader = null;
		BufferedReader bReader = null ;
		
		Map<String, Integer> map = new TreeMap<String,Integer>();
		try {
			fReader = new FileReader(file);
			bReader = new BufferedReader(fReader);
			String line ="";
			String[] words = null;
			while((line=bReader.readLine()) != null)
			{
				words= line.split("\\s|\\.|\\,");
				for (String string : words) {
					if (!map.containsKey(string)) {  // first time we've seen this string
					      map.put(string, 1);
					    }
					    else {
					      int count = map.get(string);
					      map.put(string, count + 1);
					    }
				}
			}
			
			System.out.println(entriesSortedByValues(map));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
