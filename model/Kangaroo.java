package model;
import java.util.*;

public class Kangaroo {
	
	//Atributos
	public static final int MALE = 1;
	public static final int FEMALE = 2;
    public static final int A = 3;
    public static final int B = 4;
    public static final int O = 5;
    public static final int AB = 6;
	private String name; 
	private double weight; //Kilos
	private double height; //Metros
	private int sex;
	private int bloodType;
	private boolean needVaccination;
	
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
		needVaccination=needVaccination1();
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
	
	public boolean needVaccination1(){
		Calendar today = new GregorianCalendar();
		int month = today.get(Calendar.MONTH)+1;
		int day = today.get(Calendar.DATE);
		int year = today.get(Calendar.YEAR);
		
		boolean needVac = false;
		int todayDays = 0;
		
		month *= 30;
		todayDays += month;
		
		year -= getBirth().getYear();
		year *= 360;
        todayDays += year;

        if(todayDays <= 360){
			needVac = true;
		}
        return needVac;		
	}
	
	//informacion del canguro
	public String showKangaroo(){
		String message = "";
		message += "El nombre del canguro es "+name+"\n";
		message += "El peso del canguro es "+weight+"\n";
		message += "La altura del canguro es "+height+"\n";
		if(sex == 1){
			sex = MALE;
		}
		else if (sex == 2){
			sex = FEMALE;
		}
		message += "El sexo del canguro es "+sex+"\n";
		if (bloodType == 3){
			bloodType = A;
		}
		else if (bloodType == 4){
			bloodType = B;
		}
		else if (bloodType == 5){
			bloodType = O;
		}
		else if (bloodType == 6){
			bloodType = AB;
		}
		message += "El tipo de sangre del canguro es "+bloodType+"\n";
		message += "El riesgo cardiaco del canguro es "+issues()+"\n";
		return message;
	}
	

	

}