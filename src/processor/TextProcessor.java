package processor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class TextProcessor
{
	private String text="";
	public Map<String, Integer> freq;
	public TreeMap<String, Integer> words;
	public TextProcessor(String text)
	{
		this.text=text;
	}
	
	public void process()
	{
		text=text.replace("’s ", " ");
		text=text.replace("'s ", " ");
		text=text.replace("’d ", " ");
		text=text.replace("'d ", " ");
		text=text.replace("’re ", " ");
		text=text.replace("'re ", " ");
		text=text.replace(",", " ");
		text=text.replace(".", " ");
		text=text.replace(":", " ");
		text=text.replace('"', ' ');
		text=text.replace("!", " ");
		text=text.replace(";", " ");
		text=text.replace("@", " ");
		text=text.replace("#", " ");
		text=text.replace("$", " ");
		text=text.replace("%", " ");
		text=text.replace("^", " ");
		text=text.replace("&", " ");
		text=text.replace("*", " ");
		text=text.replace("-", " ");
		text=text.replace("_", " ");
		text=text.replace("=", " ");
		text=text.replace("+", " ");
		text=text.replace("(", " ");
		text=text.replace(")", " ");
		text=text.replace("[", " ");
		text=text.replace("]", " ");
		text=text.replace("{", " ");
		text=text.replace("}", " ");
		text=text.replace("1", " ");
		text=text.replace("2", " ");
		text=text.replace("3", " ");
		text=text.replace("4", " ");
		text=text.replace("5", " ");
		text=text.replace("6", " ");
		text=text.replace("7", " ");
		text=text.replace("8", " ");
		text=text.replace("9", " ");
		text=text.replace("0", " ");
		text=text.replace('\n', ' ');
		text=text.trim().replaceAll("\\s{2,}", " ");
		text=text.toLowerCase();
		
        ArrayList<String> arr = new ArrayList<String>();
        String[] sentarr = text.split(" ");
        freq = new HashMap<String, Integer>();
        for (String word : sentarr)
        {
        	if (word.length()>1)
        	{
        		boolean f = true;
        		try(BufferedReader br = new BufferedReader(new FileReader(new File ("dictionary.dat")))) {
        			for(String line; (line = br.readLine()) != null; )
        				if (line.equals(word))
        				{
        					f=false;
        					break;
        				}
        		}catch (FileNotFoundException e){} catch (IOException e){}
        	
        		if (f)
        			arr.add(word);
        	}
        }
        for (String word : arr)
        {
            int count = Collections.frequency(arr, word);
            freq.put(word, count);
        }
        
        ValueComparator bvc = new ValueComparator(freq);
        words = new TreeMap<String, Integer>(bvc);
        words.putAll(freq);
    }
	
	class ValueComparator implements Comparator<String> {
	    Map<String, Integer> base;

	    public ValueComparator(Map<String, Integer> base) {
	        this.base = base;
	    }

	    // Note: this comparator imposes orderings that are inconsistent with
	    // equals.
	    public int compare(String a, String b) {
	        if (base.get(a) >= base.get(b)) {
	            return -1;
	        } else {
	            return 1;
	        } // returning 0 would merge keys
	    }
	}
}
