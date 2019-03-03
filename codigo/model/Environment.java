package model;

public class Environment {
	
	//Atributos
	private double area;
	
	//Relaciones
	private Kangaroo kan1;
	private Kangaroo kan2;
	private Kangaroo kan3;
	
	//Metodo constructor
	public Environment (Kangaroo kan1, Kangaroo kan2, Kangaroo kan3) {
		this.kan1=kan1;
		this.kan2=kan2;
		this.kan3=kan3;
		area = environmentArea();
	}
	
	//Metodos get y set
	public double getArea(){
		return area;
	}
	
	public void setArea (double area){
		this.area=area;
	}
	
	public Kangaroo getKan1(){
		return kan1;
	}
	
	public void setKan1 (Kangaroo kan1){
		this.kan1=kan1;
	}
	
	public Kangaroo getKan2(){
		return kan2;
	}
	
	public void setKan2 (Kangaroo kan2){
		this.kan2=kan2;
	}
	
	public Kangaroo getKan3(){
		return kan3;
	}
	
	public void setKan3 (Kangaroo kan3){
		this.kan3=kan3;
	}
	
	public String getKan1Name(){
		return kan1.getName();
		}
		
	public String getKan2Name(){
		
		String name = "";
		
		if(kan2 != null){
		    name = kan2.getName();
		}
		
		return name;
	}

	public String getKan3Name(){
		
		String theName = "";
		
		if(kan3 != null){
		    theName = kan3.getName();
		}
		
		return theName;
	}
	
    //Calcular cantidad de agua

    public double environmentWater(){
		
		double water = 0.0;
		if (kan1 != null){
			water += (kan1.calculateIMC() * 1.5);
		}
		if (kan2 != null){
			water += (kan2.calculateIMC() * 1.5);
		}
		if (kan3 != null){
			water += (kan3.calculateIMC() * 1.5);
		}
		return water;
	}
	
	//Calcular el area del ambiente
	
	public double environmentArea(){
		double theArea = 0.0;
		if (getKan1() != null){
			theArea += kan1.getHeight()*8.0;
		}
		if (getKan2() != null){
			theArea += kan2.getHeight()*8.0;
		}
		if (getKan3() != null){
			theArea += kan3.getHeight()*8.0;
		}
		return theArea;
	}
	
	//Ya hay machos?
	public boolean male (){
		boolean male = false;
		if (getKan1() != null){
			if(getKan1().getSex() == 1){
				male = true;
			}
		}
		if (getKan2() != null){
			if(getKan2().getSex() == 1){
				male = true;
			}
		}
		if (getKan3() != null){
			if(getKan3().getSex() == 1){
				male = true;
			}
		}
		return male;
	}
	
	//Cantidad de comida
	public double calculateFood(){
		double food = 0.0;
		if (kan1 != null){
			food += kan1.calculateFood();
		}
		if (kan2 != null){
			food += kan2.calculateFood();
		}
		if (kan3 != null){
			food += kan3.calculateFood();
		}
		return food;
	}
	public String infoKangaroo (){
		String message = "";
		if(kan1 !=null){
			message += "El primer canguro:\n"+kan1.showKangaroo()+"\n";
		}
		if(kan2 !=null){
			message += "El segundo canguro:\n"+kan2.showKangaroo()+"\n";
		}
		if(kan3 !=null){
			message += "El tercer canguro:\n"+kan3.showKangaroo()+"\n";
		}
		return message;
	}
	
	public String vowelsNames(){
		String message = "";
		if (kan1 != null){
			if(kan1.vowels() == true){
				message += kan1.getName()+"\n";
			}
			
		}
		if (kan2 != null){
			if(kan2.vowels() == true){
				message += kan2.getName()+"\n";
			}
			
		}
		if (kan3 != null){
			if(kan3.vowels() == true){
				message += kan3.getName()+"\n";
			}
			
		}
		return message;
	}
	public String infoEnvironment (){
		String message ="";
		message += "tiene de area "+area+" y necesita de comida "+calculateFood()+" kilos\n";
		return message;
	}
	
	//Vacunas
	public String vaccination(){
		String message = "";
		if(kan1 != null){
			message += kan1.getName()+kan1.needsVaccine();
		}
		if(kan2 != null){
			message += kan2.getName()+kan2.needsVaccine();
		}
		if(kan3 != null){
			message += kan3.getName()+kan3.needsVaccine();
		}
		return message;
	}
	

}