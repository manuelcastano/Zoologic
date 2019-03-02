package model;

public class ZoneKangaroo{
	
	//Atributos
	private double heatSource;
	private double humidity;
	private double temperature;
	private double filtration;
	private double waterLiters;
	
	//Relaciones
	private Environment env1;
	private Environment env2;
	private Environment env3;
	
	//Metodo constructor
	public ZoneKangaroo (double sourceHeat, double theHumidity, double theTemperature, double theFiltration, double theWaterLiters, Environment env1, Environment env2, Environment env3){
		heatSource=sourceHeat;
		humidity=theHumidity;
		temperature=theTemperature;
		filtration=theFiltration;
		waterLiters=theWaterLiters;
		this.env1=env1;
		this.env2=env2;
		this.env3=env3;
	}
	
	//Metodos set y get
	
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
	
	public Environment getEnv1(){
		return env1;
	}
	public void setEnv1(Environment env1){
		this.env1=env1;
	}
	
	public Environment getEnv2(){
		return env2;
	}
	public void setEnv2(Environment env2){
		this.env2=env2;
	}
	
	public Environment getEnv3(){
		return env3;
	}
	public void setEnv3(Environment env3){
		this.env3=env3;
	}
    
	//calcular la cantidad de agua
	
    public double calculateWater(){
		waterLiters = env1.environmentWater()+env2.environmentWater()+env3.environmentWater();
		return waterLiters;
	}
	
	public String infoKangaroo(){
		String message ="";
		message += env1.infoKangaroo()+"\n";
		message += env2.infoKangaroo()+"\n";
		message += env3.infoKangaroo()+"\n";
		return message;
	}
	
	public String vowelsNames(){
		String message = "";
		message += env1.vowelsNames()+"\n";
		message += env2.vowelsNames()+"\n";
		message += env3.vowelsNames()+"\n";
		return message;
	}

	public String infoZone(){
		String message = "";
		message += "La fuente de calor esta en "+heatSource+" grados\n";
		message += "La zona tiene un "+humidity+" % de humedad\n";
		message += "La zona esta en "+temperature+" grados\n";
		message += "La filtracion es de "+filtration+"\n";
		message += "La zona necesita "+calculateWater()+" litros de agua\n";
		return message;
	}
	public String infoEnvironments(){
		String message ="";
		message += "El ambiente 1 "+env1.infoEnvironment();
		message += "El ambiente 2 "+env2.infoEnvironment();
		message += "El ambiente 3 "+env3.infoEnvironment();
		return message;
	}
	
	//Vacunacion
	public String vaccination(){
		String message = "";
		message += "Primer ambiente:\n";
		message += env1.vaccination();
		message += "\nSegundo ambiente:\n";
		message += env2.vaccination();
		message += "\nTercer ambiente:\n";
		message += env3.vaccination();
		return message;
	}

	
}
