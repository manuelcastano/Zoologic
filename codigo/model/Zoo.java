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
	
	public String vowelsNames(){
		String message = kangarooZone.vowelsNames();
		return message;
	}

	public String infoZoneD(){
		String message = dragonZone.infoZone();
		return message;
	}
	
	public String infoDragon(){
		String message = dragonZone.infoDragon();
		return message;
	}
	
	public String infoZoneK(){
		String message = kangarooZone.infoZone();
		return message;
	}
	
	public String infoEnvironments(){
		String message = kangarooZone.infoEnvironments();
		return message;
	}
	
	public String infoKangaroo(){
		String message = kangarooZone.infoKangaroo();
		return message;
	}
	
	public String vaccination (){
		String message = kangarooZone.vaccination();
		return message;
	}
}