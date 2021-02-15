
public class Citizen implements Comparable<Citizen>{
	
	private String first;
	private String last;
    private String streetName;
    private int streetNumber;
    private String relation;
    private String rentOwn;
    private double valueProp;
    private String gender;
    private double age;
    private String maritalStatus;
    private int ageFirstMarriage;
    private boolean attendSchool;
    private boolean canRead;
    private String birthplace;
    private String fathersBirthplace;
    private String mothersBirthplace;
    private String mothertongue;
    private int yearImmigrated;
    private String occupation;
    private String industry;
    private String transcibedRemarks;
    
    public Citizen(String first, String last, String streetName, String streetNumber, String relation, String rentOwn, String valueProp,String gender, String age,String maritalStatus,String ageFirstMarriage,String attendSchool, String canRead,String birthplace,String fathersBirthplace,String mothersBirthplace,String mothertongue,String yearImmigrated,String occupation,String industry,String transcibedRemarks) {
    	this.first = first;
    	this.last = last;
    	this.streetName = streetName;
    	try {
    		this.streetNumber = Integer.parseInt(streetNumber);
    	}catch(NumberFormatException e)
    	{
    		this.streetNumber =-1;
    	}
    	this.relation = relation;
    	this.rentOwn = rentOwn.substring(0,1);
    	if(valueProp.charAt(0) == '$')
    		valueProp = valueProp.substring(1);
    	
    	try {
    		this.valueProp = Double.parseDouble(valueProp);
    	}catch(NumberFormatException e) {
    		if(valueProp.contains("/"))
    		{
    			String whole = valueProp.substring(0, valueProp.indexOf(" "));
    			String numer = valueProp.substring(valueProp.indexOf(" ")+1,valueProp.indexOf("/"));
    			String denom = valueProp.substring(valueProp.indexOf("/")+1);
    			this.valueProp = Double.parseDouble(whole) + Double.parseDouble(numer)/Double.parseDouble(denom);
    		}
    	}
    	this.gender = gender;
    	try{
    		this.age = Double.parseDouble(age);
    	}catch(NumberFormatException e) {
    		if(age.charAt(0) == '.' || age.equals("un"))
    			this.age = -1;
    		else if (age.charAt(1) == ' ' && age.contains(" "))
    		{
    			String whole = age.substring(0,age.indexOf(" "));
    			double dec;
    			if(age.substring(age.indexOf(" ") + 1, age.indexOf("/")).contains("*"))
    				dec = 0.5;
				else 
				{
					String numer = age.substring(age.indexOf(" ")+1, age.indexOf("/"));
    				String denom = age.substring(age.indexOf("/")+1);
    				dec = Double.parseDouble(numer)/Double.parseDouble(denom);
				}
    			this.age = Double.parseDouble(whole)+dec;
    		}
    		else if (age.contains("*")) {
    			this.age = Double.parseDouble(age.substring(0,age.indexOf("*")));
    		}
    		else {
    			String numer = age.substring(0,age.indexOf("/"));
    			String denom = age.substring(age.indexOf("/")+1);
    			this.age = Double.parseDouble(numer)/Double.parseDouble(denom);
    		}
    	}
    	this.maritalStatus = maritalStatus; 
    	try {
    		this.ageFirstMarriage = Integer.parseInt(ageFirstMarriage);
    	}catch(NumberFormatException e) {
    		this.ageFirstMarriage=-1;
    	}
    	if(attendSchool.equals("Yes"))
    		this.attendSchool = true;
    	else 
    		this.attendSchool = false;
    	
    	if(canRead.equals("Yes"))
    		this.canRead = true;
    	
    	else 
    		this.canRead = false;
    	
    	this.birthplace = birthplace;
    	this.fathersBirthplace = fathersBirthplace;
    	this.mothersBirthplace = mothersBirthplace;
    	this.mothertongue = mothertongue;
    	try {
    		this.yearImmigrated = Integer.parseInt(yearImmigrated);
    	}catch(NumberFormatException e) {
    		this.yearImmigrated =-1;
    	}
    	this.occupation = occupation.substring(0,1).toUpperCase() + occupation.substring(1).toLowerCase();
    	this.industry = industry;
    	this.transcibedRemarks = transcibedRemarks;
    }
    
    public int compareTo(Citizen other) {
    	if(getFirst().compareTo(other.getFirst())<0)
    		return -1;
    	if(getFirst().compareTo(other.getFirst())>0)
    		return 1;
    	if(getLast().compareTo(other.getLast())<0)
    		return -1;
    	if(getLast().compareTo(other.getLast())>0)
    		return 1;
    	
    	if(getStreet().compareTo(other.getStreet())<0)
    		return -1;
    	if(getStreet().compareTo(other.getStreet())>0)
    		return 1;
    	
    	if(getStreetNum()<other.getStreetNum())
    		return -1;
    	if(getStreetNum()>other.getStreetNum())
    		return 1;
    	if(getRelation().compareTo(other.getRelation())<0)
    		return -1;
    	if(getRelation().compareTo(other.getRelation())>0)
    		return 1;
    	if(getRentOrOwn().compareTo(other.getRentOrOwn())<0)
    		return -1;
    	if(getRentOrOwn().compareTo(other.getRentOrOwn())>0)
    		return 1;
    	if(getPropValue()<other.getPropValue())
    		return -1;
    	if(getPropValue()>other.getPropValue())
    		return 1;
    	if(getGender().compareTo(other.getGender())<0)
    		return -1;
    	if(getGender().compareTo(other.getGender())>0)
    		return 1;
    	if(getAge()<other.getAge())
    		return -1;
    	if(getAge()>other.getAge())
    		return 1;
    	if(getMaritalStatus().compareTo(other.getMaritalStatus())<0)
    		return -1; 
		if(getMaritalStatus().compareTo(other.getMaritalStatus())>0)
			return 1;
		if(getAgeFirstMarriage()<other.getAgeFirstMarriage())
    		return -1; 
		if(getAgeFirstMarriage()>other.getAgeFirstMarriage())
			return 1;
		if(didAttendSchool())
			return -1;
		if(!didAttendSchool())
			return 1;
		return 0;
    }
    public String getFirst() {
		return first;
	}

	public String getLast() {
		return last;
	}

	public String getStreet() {
		return streetName;
	}

	public int getStreetNum() {
		return streetNumber;
	}

	public String getRelation() {
		return relation;
	}

	public String getRentOrOwn() {
		return rentOwn;
	}

	public double getPropValue() {
		return valueProp;
	}

	public String getGender() {
		return gender;
	}

	public double getAge() {
		return age;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public int getAgeFirstMarriage() {
		return ageFirstMarriage;
	}

	public boolean didAttendSchool() {
		return attendSchool;
	}

	public boolean isCanRead() {
		return canRead;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public String getFathersBirthplace() {
		return fathersBirthplace;
	}

	public String getMothersBirthplace() {
		return mothersBirthplace;
	}

	public String getMothertongue() {
		return mothertongue;
	}

	public int getYearImmigrated() {
		return yearImmigrated;
	}

	public String getOccupation() {
		return occupation;
	}

	public String getIndustry() {
		return industry;
	}

	public String getTranscibedRemarks() {
		return transcibedRemarks;
	}

    public String toString() {
    	return String.format("%-25sAge: %s", last+","+first,age);
    }
}
