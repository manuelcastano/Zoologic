package model;

public class BeardedDragon {
	
	//Atributers
	private double height; //Metros
	private double weight; //Kilos
	
	//constructor method
	public BeardedDragon (double theHeight, double theWeight){
		height=theHeight;
		weight=theWeight;
	}
	
	public BeardedDragon(){
		
	}
	
	//initialize method
	public void init (double theHeight, double theWeight){
		height=theHeight;
		weight=theWeight;
	}
	
	//get and set methods
	public double getHeight(){
		return height;
	}
	public void setHeight(double height){
		this.height=height;
	}
	
		public double getWeight(){
		return weight;
	}
	public void setWeight(double weight){
		this.weight=weight;
	}
	
	//Calculate IMC
	public double calculateIMC(){
		return weight/(height*height);
	}
	
}