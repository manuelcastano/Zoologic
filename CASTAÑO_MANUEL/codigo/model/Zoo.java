package model;



public class Zoo {
	
	//Atributos
	private String name;

	
	//Relaciones
	private ZoneDragon dragonZone;
	private ZoneKangaroo kangarooZone;
	
	//Metodo constructor
	public Zoo (String theName, ZoneDragon zd, ZoneKangaroo zk) {
		name = theName;
		dragonZone=zd;
		kangarooZone=zk;
	}
	
	//Metodos get y set
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	
	public ZoneDragon getDragonZone (){
		return dragonZone;
	}
	public void setDragonZone (ZoneDragon dragonZone){
		this.dragonZone=dragonZone;
	}
	
	public ZoneKangaroo getKangarooZone (){
		return kangarooZone;
	}
	public void setKangarooZone (ZoneKangaroo kangarooZone){
		this.kangarooZone=kangarooZone;
	}

	
}