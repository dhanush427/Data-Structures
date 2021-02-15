public class Car implements Comparable<Car>{

		private int acc;
		private int mpg;
		private int horsePower;
		private int engineSize;
		private int weight;
		private int cylinders;
		private int carID;
		private String country;

		public Car(int acc,int mpg,int hp,int es,int w,int cyl,int ID,String country){
			acc = acc;
			this.mpg = mpg;
			horsePower = hp;
			engineSize = es;
			weight = w;
			cylinders = cyl;
			this.carID = ID;
			this.country = country;
		}

		public int getAcc(){
			return acc;
		}
		public int getMPG(){
			return mpg;
		}
		public int getHP(){
			return horsePower;
		}
		public int getEngineSize(){
			return engineSize;
		}
		public int getWeight(){
			return weight;
		}
		public int getCylinders(){
			return cylinders;
		}
		public int getID(){
			return carID;
		}
		public String getCountry(){
			return country;
		}

		public int compareTo(Car car){
			if(getAcc()>car.getAcc()){
				return -1;
			}else if(getAcc()<car.getAcc()){
				return 1;
			}

			if(getMPG()>car.getMPG()){
				return -1;
			}else if(getMPG()<car.getMPG()){
				return 1;
			}

			if(getHP()>car.getHP()){
				return -1;
			}else if(getHP()<car.getHP()){
				return 1;
			}

			if(getEngineSize()>car.getEngineSize()){
				return -1;
			}else if(getEngineSize()<car.getEngineSize()){
				return 1;
			}

			if(getWeight()>car.getWeight()){
				return -1;
			}else if(getWeight()<car.getWeight()){
				return 1;
			}

			if(getCylinders()>car.getCylinders()){
				return -1;
			}else if(getCylinders()<car.getCylinders()){
				return 1;
			}

			if(getID()>car.getID()){
				return -1;
			}else if(getID()<car.getID()){
				return 1;
			}

		return 0;
		}

		public String toString(){
			return "CarID: "+carID+"\tmpg: "+mpg+"\t\tEngineSize: "+engineSize+"\t\tHorse Power: "+horsePower+"  Weight: "+weight+"\t\tAcceleration: "+acc+ "\t\tCountry: "+country;
		}



	}