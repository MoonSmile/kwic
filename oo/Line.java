package kwic.oo;

import java.util.ArrayList;

public class Line {
	private ArrayList<String> words_ = new ArrayList<String>();
	
	public Line() {
		this(new ArrayList<String>());
	}
	public Line(ArrayList<String> w){
		words_=w;
	}
	public void setChar(char c,int position,int word){
		String current_word = words_.get(word);
    	char[] chars=current_word.toCharArray();
    	chars[position] = c;
    	words_.set(word, new String(chars));
	}
	public char getChar(int position,int word){
		return words_.get(word).charAt(position);
	}
	public void addChar(char c,int word){
		String current_word = words_.get(word);
		char[] chars = new char[current_word.length() + 1];
		current_word.getChars(0, chars.length - 1, chars, 0);
		chars[chars.length - 1] = c;
		current_word = new String(chars);
		words_.set(word, current_word);
	}
	public void deleteChar(int position,int word){
		String current_word = words_.get(word);
	    char[] chars = new char[current_word.length() - 1];
	    current_word.getChars(0, position, chars, 0);
	    current_word.getChars(position + 1, chars.length + 1, chars, position);
	    current_word = new String(chars);
	    words_.set(word, current_word);    
	}
	public int getCharCount(int word){
		return words_.get(word).length();
	}
	public void setWord(char[] w,int word){
		words_.set(word, new String(w));
	}
	public void setWord(String w,int word){
		words_.set(word, w);
	}
	public String getWord(int word){
		return words_.get(word);
	}
	public void addWord(char[] w){
		words_.add(new String(w));
	}
	public void addWord(String w){
		words_.add(w);
	}
	public void addEmptyWord(){
		words_.add("");
	}
	public void deleteWord(int word){
		words_.remove(word);
	}
	public int getWordCount(){
		return words_.size();
	}
	

}
