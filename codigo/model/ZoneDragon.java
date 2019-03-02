package model;

public class ZoneDragon{
	
	//Atributos
	private double heatSource;
	private double humidity;
	private double temperature;
	private double filtration;
	private double waterLiters;
	private double food; //kilos
	
	//Relaciones
	private BeardedDragon dra1;
	private BeardedDragon dra2;
	
	//Metodo constructor
	public ZoneDragon (double sourceHeat, double theHumidity, double theTemperature, double theFiltration, double theWaterLiters, double food, BeardedDragon bd, BeardedDragon bd2){
		heatSource=sourceHeat;
		humidity=theHumidity;
		temperature=theTemperature;
		filtration=theFiltration;
		waterLiters=theWaterLiters;
		this.food = food;
		dra1=bd;
		dra2=bd2;
	}
	
	//Metodos get y set
	public double getHeatSource(){
		return heatSource;
	}
	public void setHeatSource(double heatSource){
		this.heatSource=heatSource;
	}
	
	public double getHumidity(){
		return humidity;
	}
	public void setHumidity(double humidity){
		this.humidity=humidity;
	}
	
	public double getTemperature(){
		return temperature;
	}
	public void setTemperature(double temperature){
		this.temperature=temperature;
	}
	
	public double getFiltration(){
		return filtration;
	}
	public void setFiltration(double filtration){
		this.filtration=filtration;
	}
	
	public double getWaterLiters(){
		return waterLiters;
	}
	public void setWaterLiters(double waterLiters){
		this.waterLiters=waterLiters;
	}
	
	public double getFood(){
		return food;
	}
	public void setFood(double food){
		this.food=food;
	}
	
	public BeardedDragon getDra1(){
		return dra1;
	}
	public void setDra1 (BeardedDragon dra1){
		this.dra1=dra1;
	}
	
	public BeardedDragon getDra2(){
		return dra2;
	}
	public void setDra2 (BeardedDragon dra2){
		this.dra2=dra2;
	}
	
    //calcular cantidad de agua

    public double calculateWater(){
		waterLiters = (dra1.calculateIMC() * 0.75)+(dra2.calculateIMC() * 0.75);
		return waterLiters;
	}
	
	//Alertar cuando se tenga menos de 5kg de comida; true si les falta comida
	public boolean alertFood(){
		
		boolean alert = false;
		
		if(food < 5.0){
			alert = true;
		}
		
		return alert;
	}
	
	public String infoZone(){
		String message = "";
		message += "La fuente de calor esta en "+heatSource+" grados\n";
		message += "La zona tiene un "+humidity+" % de humedad\n";
		message += "La zona esta en "+temperature+" grados\n";
		message += "La filtracion es de "+filtration+"\n";
		message += "La zona necesita "+calculateWater()+" litros de agua\n";
		if(alertFood() == true){
			message += "La zona necesita mas comida\n";
		}
		return message;
	}
    
	//info dragon
	public String infoDragon(){
		String message ="";
		message += dra1.infoDragon();
		message += dra2.infoDragon();
		return message;
	}
 


}