public class Bowler
{
	private String firstName;
	private String lastName;
	private int score;

	public Bowler(String firstName ,String lastName ,int score){
		this.firstName = firstName;
		this.lastName = lastName;
		this.score = score;
	}
	public String getFirst(){
		return firstName;
	}
	public String getLast(){
		return lastName;
	}
	public int getScore(){
		return score;
	}
}