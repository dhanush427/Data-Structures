import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FantasyFootBallGame{
	public static void main(String[] args) {
		Player player = new Player();
		List<Player> playersToSort = player.initialize();
		
		playersToSort = player.sort(playersToSort);
		
		for(Player p:playersToSort) {
			System.out.println(p.getName()+ "\t\t\t" + p.getPos() + ":" + p.getTeam()+ ":" +p.getHighRd() + ":" + p.getLowRd() + ":" + p.getDiffRd());
		}
		
	}
}

class Player implements Comparable<Player>
{
	public double getPick() {
		return pick;
	}

	public void setPick(double pick) {
		this.pick = pick;
	}

	public double getOverall() {
		return overall;
	}

	public void setOverall(double overall) {
		this.overall = overall;
	}

	public double getStdDiv() {
		return stdDiv;
	}

	public void setStdDiv(double stdDiv) {
		this.stdDiv = stdDiv;
	}

	public double getHighRd() {
		return highRd;
	}

	public void setHighRd(double highRd) {
		this.highRd = highRd;
	}

	public double getLowRd() {
		return lowRd;
	}

	public void setLowRd(double lowRd) {
		this.lowRd = lowRd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getBye() {
		return bye;
	}

	public void setBye(int bye) {
		this.bye = bye;
	}

	public int getTimesDrafted() {
		return timesDrafted;
	}

	public void setTimesDrafted(int timesDrafted) {
		this.timesDrafted = timesDrafted;
	}

	public double getDiffRd() {
		return diffRd;
	}

	public void setDiffRd(double diffRd) {
		this.diffRd = diffRd;
	}
	
	public double pick, overall, stdDiv, highRd, lowRd,diffRd;
	public String name, pos, team;
	public int bye, timesDrafted ;
	
	public List<Player> initialize() {
		File filename = new File("C:\\\\Users\\\\dhanu\\\\eclipse-workspace\\\\Datastructures\\\\data\\\\fantasyfootball.txt");
		List<Player> players = new ArrayList<Player>();
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(filename));
			String text = new String();
			Player player = null;
			input.readLine();
			while((text=input.readLine())!=null)
			{
				//System.out.println(text);
				try
				{
					String[] playerData = text.split(";");
					player = new Player();
					player.setPick(Double.parseDouble(playerData[0]));
					player.setName(playerData[1]);
					player.setPos(playerData[2]);
					player.setTeam(playerData[3]);
					player.setBye(Integer.parseInt(playerData[4]));
					player.setOverall(Double.parseDouble(playerData[5]));
					player.setStdDiv(Double.parseDouble(playerData[6]));
					player.setHighRd(Double.parseDouble(playerData[7]));
					player.setLowRd(Double.parseDouble(playerData[8]));
					player.setTimesDrafted(Integer.parseInt(playerData[9]));
					diffRd=calDiff(Double.parseDouble(playerData[7]),Double.parseDouble(playerData[8]));
					player.setDiffRd(diffRd);
					players.add(player);
					player = null;
					
				}catch(NumberFormatException e )
				{
				}
			}
		}catch(IOException e)
		{
			System.out.println("File not found.");
		}
		return players;
	}
	
	public List<Player> sort(List<Player> list){
		for(int x = 0; x < list.size()-1;x++) {
			int y = x; 
			
			while ((y >= 0) && (list.get(y).compareTo(list.get(y+1)))>0) {
				list.add(y, list.remove(y+1));
				y--;
			}
		}
		return list;
	}
	

	public Player(){
				
	}
	
	private int calDiff(double highRd, double lowRd) {
		
		//Matt Gay:14.02:15.11:3.0
		
		int leftHighRd = (int)highRd; //14
		int rightHighRd = (int)(highRd*100)%100; //02
		
		int leftLowRd = (int)lowRd;//15
		int rightLowRd = (int)(lowRd*100)%100; //11	
		
		return (leftLowRd - leftHighRd)*12 + (rightLowRd-rightHighRd);
	}
	
	@Override
	public int compareTo(Player o) {
		int rdDiff = Integer.compare((int)this.getDiffRd(), (int)o.getDiffRd());
		if(rdDiff == 0) {
			return Integer.compare((int)this.getOverall(), (int)o.getOverall());
		}
		else return rdDiff;
	}
}
	
	
	

	
	
	
	
