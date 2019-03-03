package model;
import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
public class Kangaroo {
	
	//Atributos
	public static final int MALE = 1;
	public static final int FEMALE = 2;
    public static final int A = 3;
    public static final int B = 4;
    public static final int O = 5;
    public static final int AB = 6;
	public static final int DAYS_OF_THE_YEAR = 365;
	public static final int DAYS_OF_THE_WEEK = 7;
	private String name; 
	private double weight; //Kilos
	private double height; //Metros
	private int sex;
	private int bloodType;
	
	//Relaciones
	private Date birth;
	
	//Metodo constructor
	public Kangaroo(String theName, double theWeight, double theHeight, int theSex, int typeBlood, Date theBirth){
		name=theName;
		weight=theWeight;
		height=theHeight;
		sex=theSex;
		bloodType=typeBlood;
		birth = theBirth;
	}
	
	//Metodos get y set
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	
	public double getWeight(){
		return weight;
	}
	public void setWeight(double weight){
		this.weight=weight;
	}
	
	public double getHeight(){
		return height;
	}
	public void setHeight(double height){
		this.height=height;
	}
	
	public int getSex(){
		return sex;
	}
	public void setSex(int sex){
		this.sex=sex;
	}
	
	public int getBloodType(){
		return bloodType;
	}
	public void setBloodType(int bloodType){
		this.bloodType=bloodType;
	}
	
	public Date getBirth(){
		return birth;
	}
	public void setBirth(Date birth){
		this.birth=birth;
	}
	
	//Calculate IMC
	public double calculateIMC(){
		return weight/(height*height);
	}
	
	//Cantidad de alimento
	public double calculateFood(){
		double food = 0.0;
		if(weight < 30){
			food = weight * 0.8;
		}
		else if(weight >= 30 && weight <= 48){
			food = weight * 1.1;
		}
		else{
			food = 40.0 + (0.4 * (weight - 48));
		}
		return food;
	}
	
	//Enfermedades cardiacas
	public String issues(){
		String risk = "";
		if(calculateIMC() < 18.0){
			if (bloodType == 3 || bloodType == 6){
				risk = "bajo";
			}
			else{
				risk = "moderado";
			}
		}
		else if (calculateIMC() >= 18.0 && calculateIMC() <= 25.0){
			risk = "bajo";
		}
		else {
			if (bloodType == 3 || bloodType == 4 || bloodType == 5){
				risk = "alto";
			}
			else if (bloodType == 6){
				risk = "moderado";
			}
		}
		return risk;
	}
	
	//Vocales
	public boolean vowels(){
		boolean haveVowels = false;
		if (getName().charAt(0) == 'a' || getName().charAt(0) == 'e' || getName().charAt(0) == 'i' || getName().charAt(0) == 'o' || getName().charAt(0) == 'u' || getName().charAt(0) == 'A' || getName().charAt(0) == 'E' || getName().charAt(0) == 'I' || getName().charAt(0) == 'O' || getName().charAt(0) == 'U'){
			haveVowels = true;
	        }
        if ((getName().charAt(getName().length()-1)) == 'a' || getName().charAt(getName().length()-1) == 'e' || getName().charAt(getName().length()-1) == 'i' || getName().charAt(getName().length()-1) == 'o' || getName().charAt(getName().length()-1) == 'u' || getName().charAt(getName().length()-1) == 'A' || getName().charAt(getName().length()-1) == 'E' || getName().charAt(getName().length()-1) == 'I' || getName().charAt(getName().length()-1) == 'O' || getName().charAt(getName().length()-1) == 'U'){
			haveVowels = true;
		    }
		return haveVowels;
	}
	
	//informacion del canguro
	public String showKangaroo(){
		String theSex = "";
		String theBloodType = "";
		String message = "";
		message += "El nombre del canguro es "+name+"\n";
		message += "El peso del canguro es "+weight+"\n";
		message += "La altura del canguro es "+height+"\n";
		if(sex == 1){
			theSex = "macho";
		}
		else if (sex == 2){
			theSex = "hembra";
		}
		message += "El sexo del canguro es "+theSex+"\n";
		if (bloodType == 3){
			theBloodType = "A";
		}
		else if (bloodType == 4){
			theBloodType = "B";
		}
		else if (bloodType == 5){
			theBloodType = "O";
		}
		else if (bloodType == 6){
			theBloodType = "AB";
		}
		message += "El tipo de sangre del canguro es "+theBloodType+"\n";
		message += "El riesgo cardiaco del canguro es "+issues()+"\n";
		return message;
	}
	
	public long calculateAge(){

	LocalDate start = LocalDate.of(birth.getYear(), birth.getMonth(), birth.getDay());

	LocalDate end = LocalDate.now();

	long years = ChronoUnit.YEARS.between(start, end);

		return years;
//
	}



public int numberOfDays() {

		GregorianCalendar date = new GregorianCalendar(birth.getYear(), birth.getMonth() - 1, birth.getDay());

		int cont = 0;
		
		GregorianCalendar actualDate = new GregorianCalendar();
		
		while (true) {
		
			if ((date.get(Calendar.DAY_OF_MONTH) == actualDate.get(Calendar.DAY_OF_MONTH))
		
					&& (date.get(Calendar.MONTH) == actualDate.get(Calendar.MONTH))
		
					&& (date.get(Calendar.YEAR) == actualDate.get(Calendar.YEAR))){
		
				break;
		
			}
		
			date.add(Calendar.DAY_OF_MONTH, 1);
		
			cont++;
		
		}
		
		return cont;
	}

	public int leftWeeks(){

		int leftWeeks = 0;

		int leftDays = DAYS_OF_THE_YEAR - numberOfDays();

		leftWeeks = leftDays / DAYS_OF_THE_WEEK;

		return leftWeeks;

	}

	public int leftDays(){

		int days = 0;

		int leftDays = DAYS_OF_THE_YEAR - numberOfDays();

		days = leftDays % DAYS_OF_THE_WEEK;

		return days;

	}

	public String needsVaccine(){

		String msg = "";

		int year = birth.getYear()+1;

		if (calculateAge() < 1){
			
			msg += " necesita ser vacunado en " + leftWeeks() + " semanas y " + leftDays() + " dias.\n";
		}
		else{
			msg += " no necesita ser vacunado.\n";
		}
		return msg;
}


	

}