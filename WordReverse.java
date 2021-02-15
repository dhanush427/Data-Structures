public class WordReverse extends Word {
	public WordReverse(String word2) {
        super(word2);
    
    }

    @Override
    public int compareTo(Word word2) {
        return -toString().toLowerCase().compareTo(word2.toString().toLowerCase());
    }

}