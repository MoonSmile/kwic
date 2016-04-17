package kwic.es;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

public class WordsIndex implements Observer{
	private LineStorageWrapper lines_;
	private HashMap<String, Integer> wordsindex_ = new HashMap<String, Integer>();
	
	public WordsIndex(LineStorageWrapper lines) {
		lines_=lines;
	}
	public void PrintIndex()
	{
		Set<Entry<String, Integer>> allset = wordsindex_.entrySet();
		Iterator<Entry<String, Integer>> a = allset.iterator();
		  while(a.hasNext())
		  {
			  Map.Entry<String, Integer> mEntry = a.next();
			  System.out.println(mEntry.getKey()+":"+mEntry.getValue());
		  }
	}
	public void update(Observable observable, Object arg) {
		
		LineStorageWrapper lines = (LineStorageWrapper) observable;
		LineStorageChangeEvent event = (LineStorageChangeEvent) arg;
		
		switch(event.getType()){
			case LineStorageChangeEvent.ADD:
				String[] line = lines.getLine(lines.getLineCount() - 1);
				for(int i = 0; i < line.length; i++){
					if(!wordsindex_.containsKey(line[i]))
					{
						wordsindex_.put(line[i], 1);
					}
					else
					{
						wordsindex_.put(line[i], wordsindex_.get(line[i])+1);
					}
      }
      break;
      
    case LineStorageChangeEvent.DELETE:
    	line=event.getArg().split(" ");
    	for(int i = 0; i < line.length; i++){
    		wordsindex_.put(line[i], wordsindex_.get(line[i])-1);
    		if (wordsindex_.get(line[i])==0) {
				wordsindex_.remove(line[i]);
			}
         }
         break;
         
    default:
      break;      
    }
		
	}

}
