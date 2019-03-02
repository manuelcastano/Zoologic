package ui;

import model.*;
import java.util.Scanner;

public class Main {
	
	private Zoo zooCali;
	private Scanner reader;

	//initializer
	
	public Main (){
		init();
		reader = new Scanner(System.in);
	}
	
	public static void main(String[] args) {

		Main m = new Main();
		m.menu();
		m.showMenu();
	}

		
		
	//Menu
	
	public void menu(){
		welcome();
	}
	
	public void welcome(){
		System.out.println("----------------------------------------------------------------------------------------------------");
		System.out.println("|                                  Bienvenido al zoologico de Cali                                 |");
		System.out.println("----------------------------------------------------------------------------------------------------");
	}
		
	public void showMenu(){
		
         int option = 0;

		
        while(option !=11){
		
		System.out.println("1. Animales cuyos nombres empiezan o terminan con una mayuscula");
		System.out.println("2. Ver datos de la zona de los dragones barbados");
		System.out.println("3. ver datos de los dragones");
		System.out.println("4. Ver datos de la zona de los canguros");
		System.out.println("5. Ver datos de los ambientes de los canguros");
		System.out.println("6. Ver datos de los canguros");
		System.out.println("7. Ingresar un nuevo canguro");
		System.out.println("8. Trasladar un canguro de ambiente");
		System.out.println("9. Eliminar un canguro");
		System.out.println("10. Canguros que necesitan vacunas");
		System.out.println("11. Salir");
			
			option = reader.nextInt();
			reader.nextLine();

			
			
			switch(option){
				case(1):
					System.out.println("");	
					System.out.println(zooCali.getKangarooZone().vowelsNames());	
					System.out.println("");
				break;
				case(2):
					System.out.println("");
                    System.out.println(zooCali.getDragonZone().infoZone());
					System.out.println(" ");
					break;
				case(3):
					System.out.println("");
                    System.out.println(zooCali.getDragonZone().infoDragon());
					break;
				case(4):
					System.out.println("");	
					System.out.println(zooCali.getKangarooZone().infoZone());
					System.out.println("");
					break;
				case(5):
					System.out.println("");
					System.out.println(zooCali.getKangarooZone().infoEnvironments());
				break;
				case(6):
				    System.out.println(zooCali.getKangarooZone().infoKangaroo()+"\n");
				break;
				case(7):
                    addKangaroo();
				break;
				case(8):
				    changeEnvironment();
				break;
				case(9):
				    eliminateKangaroo();
				break;
				case(10):
				    System.out.println("");
				    System.out.println(zooCali.getKangarooZone().vaccination());
				break;
				case(11):
				break;
				default:
				System.out.println("Ingresa un numero valido");
				break;

			}					
		}

					
					
					
			}
	public void init(){
		
        Kangaroo kan1 = new Kangaroo ("Pablo", 15.6, 1.6, 1, 3, new Date (25, 11, 2008));
		Kangaroo kan2 = new Kangaroo("Andrea", 35.3, 1.5, 2, 6, new Date (1, 2, 2000));
		Kangaroo kan3 = null;
		Kangaroo kan4 = new Kangaroo ("Andres", 25.0, 1.57, 1, 6, new Date (4, 8, 2018));
		Kangaroo kan5 = new Kangaroo("Lina", 40.0, 1.7, 2, 5, new Date (7, 4, 2015));
		Kangaroo kan6 = null;
		Kangaroo kan7 = new Kangaroo ("Fernando", 28.0, 1.67, 1, 5, new Date (1, 1, 2019));
		Kangaroo kan8 = new Kangaroo("Lola", 32.0, 1.59, 2, 6, new Date(20, 12, 2006 ));
		Kangaroo kan9 = null;
	
		zooCali = new Zoo("Zoologico de Cali", new ZoneDragon(50.5, 20.0, 37.6, 12.0, 4.5, 4.5, new BeardedDragon(0.6, 0.45), new BeardedDragon(0.55, 0.4)), new ZoneKangaroo(30.0, 36.2, 27.0, 45.0, 10.9, new Environment( kan1, kan2, kan3), new Environment(kan4, kan5, kan6), new Environment(kan7, kan8, kan9)));

		
	}
	
	//Aniadir canguro
	public void addKangaroo(){
		int number = 0;
		String name=""; 
	    double weight=0.0; //Kilos
	    double height=0.0; //Metros
	    int sex= 0;
	    int bloodType= 0;
		int day = 0;
		int month = 0;
		int year = 0;
		int ambient = 0;
		int incorrect = 0;
		int exit = 0;
		System.out.println("");
		while (exit != 1){
			System.out.println("Nombre:");
			name = reader.nextLine();
			System.out.println("Peso:");
			weight = reader.nextDouble();
			System.out.println("Estatura:");
			height = reader.nextDouble();
			System.out.println("Sexo (1. Macho, 2. Hembra): ");
			sex = reader.nextInt();
			while(sex != 1 && sex != 2){
			switch(sex){
				case(1):
				sex = Kangaroo.MALE;
				break;
				case(2):
				sex = Kangaroo.FEMALE;
				break;
				default:
				System.out.println("Ingresa un numero valido");
				break;
			}
			}
			System.out.println("Tipo de sangre (3.A, 4.B, 5.O, 6.AB):");
			bloodType = reader.nextInt();
			while (bloodType != 3 && bloodType != 4 && bloodType != 5 && bloodType != 6){
		    switch(bloodType){
		    	case(3):
				bloodType = Kangaroo.A;
				break;
		    	case(4):
				bloodType = Kangaroo.B;
				break;
		    	case(5):
				bloodType = Kangaroo.O;
				break;
		    	case(6):
				bloodType = Kangaroo.AB;
				break;
				default:
				System.out.println("Ingresa un numero valido");
				break;
			}
			}
			while (incorrect != 1){
			incorrect = 4;
			System.out.println("Dia de nacimiento");
			day = reader.nextInt();
			if (!(day >= 1 && day <= 31)){
				System.out.println("Ingresa un dia valido");
				day = 0;
				incorrect = 2;
			}
			if(incorrect != 2){
				System.out.println("Mes de nacimiento:");
			    month = reader.nextInt();
			    if (!(month >= 1 && month <= 12)){
				System.out.println("Ingresa un mes valido");
				month = 0;
				incorrect = 3;				
			}
			if (incorrect != 3){
				System.out.println("Anio de nacimiento:");
			year = reader.nextInt();
			incorrect = 1;
			}
			}
			}
			System.out.println("Ambiente:");
			ambient = reader.nextInt();
			while(ambient != 1 && ambient != 2 && ambient != 3){
            if(ambient != 1 || ambient != 2 || ambient != 3){
				System.out.println("Ingresa un ambiente valido");
				ambient = 0;
			}			
			}
			switch(ambient){
			case(1):
			if(zooCali.getKangarooZone().getEnv1().getKan1() != null && zooCali.getKangarooZone().getEnv1().getKan2() != null && zooCali.getKangarooZone().getEnv1().getKan3() != null){
				System.out.println("El ambiente ya se encuentra lleno");
			}
			else{
				if(zooCali.getKangarooZone().getEnv1().male() == true && sex == 1){
					System.out.println("No se puede agregar el canguro al ambiente debido a que ya hay un macho");
					exit = 1;
				}
				else{
					if(zooCali.getKangarooZone().getEnv1().getKan1() == null){
						zooCali.getKangarooZone().getEnv1().setKan1(new Kangaroo(name, weight, height, sex, bloodType, new Date(day, month, year)));
						System.out.println("");
			System.out.println("Canguro agregado con exito");
			System.out.println("");
			exit = 1;
					}
					else{
						if(zooCali.getKangarooZone().getEnv1().getKan2() == null){
						zooCali.getKangarooZone().getEnv1().setKan2(new Kangaroo(name, weight, height, sex, bloodType, new Date(day, month, year)));
						System.out.println("");
			System.out.println("Canguro agregado con exito");
			System.out.println("");
			exit = 1;
					}
					else{
						zooCali.getKangarooZone().getEnv1().setKan3(new Kangaroo(name, weight, height, sex, bloodType, new Date(day, month, year)));
						System.out.println("");
			System.out.println("Canguro agregado con exito");
			System.out.println("");
			exit = 1;
					}
						
					}
				}
			}
			break;
			case(2):
			if(zooCali.getKangarooZone().getEnv2().getKan1() != null && zooCali.getKangarooZone().getEnv2().getKan2() != null && zooCali.getKangarooZone().getEnv2().getKan3() != null){
				System.out.println("El ambiente ya se encuentra lleno");
			}
			else{
				if(zooCali.getKangarooZone().getEnv2().male() == true && sex == 1){
					System.out.println("No se puede agregar el canguro al ambiente debido a que ya hay un macho");
					exit = 1;
				}
				else{
					if(zooCali.getKangarooZone().getEnv2().getKan1() == null){
						zooCali.getKangarooZone().getEnv2().setKan1(new Kangaroo(name, weight, height, sex, bloodType, new Date(day, month, year)));
						System.out.println("");
			System.out.println("Canguro agregado con exito");
			System.out.println("");
			exit = 1;
					}
					else{
						if(zooCali.getKangarooZone().getEnv2().getKan2() == null){
						zooCali.getKangarooZone().getEnv2().setKan2(new Kangaroo(name, weight, height, sex, bloodType, new Date(day, month, year)));
						System.out.println("");
			System.out.println("Canguro agregado con exito");
			System.out.println("");
			exit = 1;
					}
					else{
						zooCali.getKangarooZone().getEnv2().setKan3(new Kangaroo(name, weight, height, sex, bloodType, new Date(day, month, year)));
						System.out.println("");
			System.out.println("Canguro agregado con exito");
			System.out.println("");
			exit = 1;
					}
						
					}
				}
			}
			break;
				case(3):
			if(zooCali.getKangarooZone().getEnv3().getKan1() != null && zooCali.getKangarooZone().getEnv3().getKan2() != null && zooCali.getKangarooZone().getEnv3().getKan3() != null){
				System.out.println("El ambiente ya se encuentra lleno");
			}
			else{
				if(zooCali.getKangarooZone().getEnv3().male() == true && sex == 1){
					System.out.println("");
					System.out.println("No se puede agregar el canguro al ambiente debido a que ya hay un macho");
					System.out.println("");
					exit = 1;
				}
				else{
					if(zooCali.getKangarooZone().getEnv3().getKan1() == null){
						zooCali.getKangarooZone().getEnv3().setKan1(new Kangaroo(name, weight, height, sex, bloodType, new Date(day, month, year)));
						System.out.println("");
			System.out.println("Canguro agregado con exito");
			System.out.println("");
			exit = 1;
					}
					else{
						if(zooCali.getKangarooZone().getEnv3().getKan2() == null){
						zooCali.getKangarooZone().getEnv3().setKan2(new Kangaroo(name, weight, height, sex, bloodType, new Date(day, month, year)));
						System.out.println("");
			System.out.println("Canguro agregado con exito");
			System.out.println("");
			exit = 1;
					}
					else{
						zooCali.getKangarooZone().getEnv3().setKan3(new Kangaroo(name, weight, height, sex, bloodType, new Date(day, month, year)));
						System.out.println("");
			System.out.println("Canguro agregado con exito");
			System.out.println("");
			exit = 1;
					}
						
					}
				}
			}
			break;
			}
			}
	}
	
	//Eliminar canguro
	
	public void eliminateKangaroo(){
		int name = 0;
		while(name != 10){
			System.out.println("");
			System.out.println("Cual canguro deseas eliminar?");
			if ( zooCali.getKangarooZone().getEnv1().getKan1() != null){
			System.out.println("1."+ zooCali.getKangarooZone().getEnv1().getKan1().getName());
			}
			if ( zooCali.getKangarooZone().getEnv1().getKan2() != null){
				System.out.println("2."+ zooCali.getKangarooZone().getEnv1().getKan2().getName());
			}
			if ( zooCali.getKangarooZone().getEnv1().getKan3() != null){
				System.out.println("3."+ zooCali.getKangarooZone().getEnv1().getKan3().getName());
			}
			if ( zooCali.getKangarooZone().getEnv2().getKan1() != null){
            System.out.println("4." +zooCali.getKangarooZone().getEnv2().getKan1().getName());
			}
			if ( zooCali.getKangarooZone().getEnv2().getKan2() != null){
				System.out.println("5."+ zooCali.getKangarooZone().getEnv2().getKan2().getName());
			}
			if ( zooCali.getKangarooZone().getEnv2().getKan3() != null){
				System.out.println("6."+ zooCali.getKangarooZone().getEnv2().getKan3().getName());
			}
			if ( zooCali.getKangarooZone().getEnv3().getKan1() != null){
			System.out.println("7."+ zooCali.getKangarooZone().getEnv3().getKan1().getName());
			}
			if ( zooCali.getKangarooZone().getEnv3().getKan2() != null){
				System.out.println("8."+ zooCali.getKangarooZone().getEnv3().getKan2().getName());
			}
			if ( zooCali.getKangarooZone().getEnv3().getKan3() != null){
				System.out.println("9."+ zooCali.getKangarooZone().getEnv3().getKan3().getName());
			}
			System.out.println("10. Atras");
			name = reader.nextInt();
			System.out.println("");
			switch(name){
				case(1):
				zooCali.getKangarooZone().getEnv1().setKan1(null);
				System.out.println("Canguro eliminado");
				System.out.println("");
				break;
				case(2):
				zooCali.getKangarooZone().getEnv1().setKan2(null);
				System.out.println("Canguro eliminado");
				System.out.println("");
				break;
				case(3):
				zooCali.getKangarooZone().getEnv1().setKan3(null);
				System.out.println("Canguro eliminado");
				System.out.println("");
				break;
				case(4):
				zooCali.getKangarooZone().getEnv2().setKan1(null);
				System.out.println("Canguro eliminado");
				System.out.println("");
				break;
				case(5):
				zooCali.getKangarooZone().getEnv2().setKan2(null);
				System.out.println("Canguro eliminado");
				System.out.println("");
				break;
				case(6):
				zooCali.getKangarooZone().getEnv2().setKan3(null);
				System.out.println("Canguro eliminado");
				System.out.println("");
				break;
				case(7):
				zooCali.getKangarooZone().getEnv3().setKan1(null);
				System.out.println("Canguro eliminado");
				System.out.println("");
				break;
				case(8):
				zooCali.getKangarooZone().getEnv3().setKan2(null);
				System.out.println("Canguro eliminado");
				System.out.println("");
				break;
				case(9):
				zooCali.getKangarooZone().getEnv3().setKan3(null);
				System.out.println("Canguro eliminado");
				System.out.println("");
				break;
				case(10):
				break;
				default:
				System.out.println("Ingresa un numero valido");
				break;
			}
		}
	
	}
	//Cambiar de ambiente
	public void changeEnvironment(){
		int option = 0;
		int ambient = 0;
		while(option != 10){
			System.out.println("");
			System.out.println("Cual canguro deseas trasladar?");
			if ( zooCali.getKangarooZone().getEnv1().getKan1() != null){
			System.out.println("1."+ zooCali.getKangarooZone().getEnv1().getKan1().getName());
			}
			if ( zooCali.getKangarooZone().getEnv1().getKan2() != null){
				System.out.println("2."+ zooCali.getKangarooZone().getEnv1().getKan2().getName());
			}
			if ( zooCali.getKangarooZone().getEnv1().getKan3() != null){
				System.out.println("3."+ zooCali.getKangarooZone().getEnv1().getKan3().getName());
			}
			if ( zooCali.getKangarooZone().getEnv2().getKan1() != null){
            System.out.println("4." +zooCali.getKangarooZone().getEnv2().getKan1().getName());
			}
			if ( zooCali.getKangarooZone().getEnv2().getKan2() != null){
				System.out.println("5."+ zooCali.getKangarooZone().getEnv2().getKan2().getName());
			}
			if ( zooCali.getKangarooZone().getEnv2().getKan3() != null){
				System.out.println("6."+ zooCali.getKangarooZone().getEnv2().getKan3().getName());
			}
			if ( zooCali.getKangarooZone().getEnv3().getKan1() != null){
			System.out.println("7."+ zooCali.getKangarooZone().getEnv3().getKan1().getName());
			}
			if ( zooCali.getKangarooZone().getEnv3().getKan2() != null){
				System.out.println("8."+ zooCali.getKangarooZone().getEnv3().getKan2().getName());
			}
			if ( zooCali.getKangarooZone().getEnv3().getKan3() != null){
				System.out.println("9."+ zooCali.getKangarooZone().getEnv3().getKan3().getName());
			}
			System.out.println("10. Atras");
			option = reader.nextInt();
			System.out.println("");
			switch(option){
				case(1):
				System.out.println("A que ambiente deseas trasladarlo?");
				ambient = reader.nextInt();
				if (ambient == 1){
					System.out.println("El canguro ya se encuentra en esta zona");
				}
				else if (ambient == 2){
					if (zooCali.getKangarooZone().getEnv2().male() == true && zooCali.getKangarooZone().getEnv1().getKan1().getSex() == 1){
						System.out.println("En el ambiente ya se encuentra un macho");
					}
					else if(zooCali.getKangarooZone().getEnv2().getKan1() != null && zooCali.getKangarooZone().getEnv2().getKan2() != null && zooCali.getKangarooZone().getEnv2().getKan3() != null){
						System.out.println("el ambiente ya se encuentra lleno");
					}
					
					else{
						if(zooCali.getKangarooZone().getEnv2().getKan1() == null){
							zooCali.getKangarooZone().getEnv2().setKan1(zooCali.getKangarooZone().getEnv1().getKan1());
							zooCali.getKangarooZone().getEnv1().setKan1(null);
						}
						else{
							if(zooCali.getKangarooZone().getEnv2().getKan2() == null){
								zooCali.getKangarooZone().getEnv2().setKan2(zooCali.getKangarooZone().getEnv1().getKan1());
								zooCali.getKangarooZone().getEnv1().setKan1(null);
							}
							else{
								zooCali.getKangarooZone().getEnv2().setKan3(zooCali.getKangarooZone().getEnv1().getKan1());
								zooCali.getKangarooZone().getEnv1().setKan1(null);
							}
						}
					}
				}
				else if(ambient == 3){
					if (zooCali.getKangarooZone().getEnv3().male() == true && zooCali.getKangarooZone().getEnv1().getKan1().getSex() == 1){
						System.out.println("En el ambiente ya se encuentra un macho");
					}
					else if(zooCali.getKangarooZone().getEnv3().getKan1() != null && zooCali.getKangarooZone().getEnv3().getKan2() != null && zooCali.getKangarooZone().getEnv3().getKan3() != null){
						System.out.println("el ambiente ya se encuentra lleno");
					}
					else{
						if(zooCali.getKangarooZone().getEnv3().getKan1() == null){
							zooCali.getKangarooZone().getEnv3().setKan1(zooCali.getKangarooZone().getEnv1().getKan1());
							zooCali.getKangarooZone().getEnv1().setKan1(null);
						}
						else{
							if(zooCali.getKangarooZone().getEnv3().getKan2() == null){
								zooCali.getKangarooZone().getEnv3().setKan2(zooCali.getKangarooZone().getEnv1().getKan1());
								zooCali.getKangarooZone().getEnv1().setKan1(null);
							}
							else{
								zooCali.getKangarooZone().getEnv3().setKan3(zooCali.getKangarooZone().getEnv1().getKan1());
								zooCali.getKangarooZone().getEnv1().setKan1(null);
				            }
			            }
	                }
				}
				break;
				case(2):
				System.out.println("A que ambiente deseas trasladarlo?");
				ambient = reader.nextInt();
				if (ambient == 1){
					System.out.println("El canguro ya se encuentra en esta zona");
				}
				else if (ambient == 2){
					if (zooCali.getKangarooZone().getEnv2().male() == true && zooCali.getKangarooZone().getEnv1().getKan2().getSex() == 1){
						System.out.println("En el ambiente ya se encuentra un macho");
					}
					else if(zooCali.getKangarooZone().getEnv2().getKan1() != null && zooCali.getKangarooZone().getEnv2().getKan2() != null && zooCali.getKangarooZone().getEnv2().getKan3() != null){
						System.out.println("el ambiente ya se encuentra lleno");
					}
					else{
						if(zooCali.getKangarooZone().getEnv2().getKan1() == null){
							zooCali.getKangarooZone().getEnv2().setKan1(zooCali.getKangarooZone().getEnv1().getKan2());
							zooCali.getKangarooZone().getEnv1().setKan2(null);
						}
						else{
							if(zooCali.getKangarooZone().getEnv2().getKan2() == null){
								zooCali.getKangarooZone().getEnv2().setKan2(zooCali.getKangarooZone().getEnv1().getKan2());
								zooCali.getKangarooZone().getEnv1().setKan2(null);
							}
							else{
								zooCali.getKangarooZone().getEnv2().setKan3(zooCali.getKangarooZone().getEnv1().getKan2());
								zooCali.getKangarooZone().getEnv1().setKan2(null);
							}
						}
					}
				}
				else if(ambient == 3){
					if (zooCali.getKangarooZone().getEnv3().male() == true && zooCali.getKangarooZone().getEnv1().getKan2().getSex() == 1){
						System.out.println("En el ambiente ya se encuentra un macho");
					}
					else if(zooCali.getKangarooZone().getEnv3().getKan1() != null && zooCali.getKangarooZone().getEnv3().getKan2() != null && zooCali.getKangarooZone().getEnv3().getKan3() != null){
						System.out.println("el ambiente ya se encuentra lleno");
					}
					else{
						if(zooCali.getKangarooZone().getEnv3().getKan1() == null){
							zooCali.getKangarooZone().getEnv3().setKan1(zooCali.getKangarooZone().getEnv1().getKan2());
							zooCali.getKangarooZone().getEnv1().setKan2(null);
						}
						else{
							if(zooCali.getKangarooZone().getEnv3().getKan2() == null){
								zooCali.getKangarooZone().getEnv3().setKan2(zooCali.getKangarooZone().getEnv1().getKan2());
								zooCali.getKangarooZone().getEnv1().setKan2(null);
							}
							else{
								zooCali.getKangarooZone().getEnv3().setKan3(zooCali.getKangarooZone().getEnv1().getKan2());
								zooCali.getKangarooZone().getEnv1().setKan2(null);
				            }
			            }
	                }
				}
				break;
				case(3):
				System.out.println("A que ambiente deseas trasladarlo?");
				ambient = reader.nextInt();
				if (ambient == 1){
					System.out.println("El canguro ya se encuentra en esta zona");
				}
				else if (ambient == 2){
					if (zooCali.getKangarooZone().getEnv2().male() == true && zooCali.getKangarooZone().getEnv1().getKan3().getSex() == 1){
						System.out.println("En el ambiente ya se encuentra un macho");
					}
					else if(zooCali.getKangarooZone().getEnv2().getKan1() != null && zooCali.getKangarooZone().getEnv2().getKan2() != null && zooCali.getKangarooZone().getEnv2().getKan3() != null){
						System.out.println("el ambiente ya se encuentra lleno");
					}
					else{
						if(zooCali.getKangarooZone().getEnv2().getKan1() == null){
							zooCali.getKangarooZone().getEnv2().setKan1(zooCali.getKangarooZone().getEnv1().getKan3());
							zooCali.getKangarooZone().getEnv1().setKan3(null);
						}
						else{
							if(zooCali.getKangarooZone().getEnv2().getKan2() == null){
								zooCali.getKangarooZone().getEnv2().setKan2(zooCali.getKangarooZone().getEnv1().getKan3());
								zooCali.getKangarooZone().getEnv1().setKan3(null);
							}
							else{
								zooCali.getKangarooZone().getEnv2().setKan3(zooCali.getKangarooZone().getEnv1().getKan3());
								zooCali.getKangarooZone().getEnv1().setKan3(null);
							}
						}
					}
				}
				else if(ambient == 3){
					if (zooCali.getKangarooZone().getEnv3().male() == true && zooCali.getKangarooZone().getEnv1().getKan3().getSex() == 1){
						System.out.println("En el ambiente ya se encuentra un macho");
					}
					else if(zooCali.getKangarooZone().getEnv3().getKan1() != null && zooCali.getKangarooZone().getEnv3().getKan2() != null && zooCali.getKangarooZone().getEnv3().getKan3() != null){
						System.out.println("el ambiente ya se encuentra lleno");
					}
					else{
						if(zooCali.getKangarooZone().getEnv3().getKan1() == null){
							zooCali.getKangarooZone().getEnv3().setKan1(zooCali.getKangarooZone().getEnv1().getKan3());
							zooCali.getKangarooZone().getEnv1().setKan3(null);
						}
						else{
							if(zooCali.getKangarooZone().getEnv3().getKan2() == null){
								zooCali.getKangarooZone().getEnv3().setKan2(zooCali.getKangarooZone().getEnv1().getKan3());
								zooCali.getKangarooZone().getEnv1().setKan3(null);
							}
							else{
								zooCali.getKangarooZone().getEnv3().setKan3(zooCali.getKangarooZone().getEnv1().getKan3());
								zooCali.getKangarooZone().getEnv1().setKan3(null);
				            }
			            }
	                }
				}
				break;
				case(4):
				System.out.println("A que ambiente deseas trasladarlo?");
				ambient = reader.nextInt();
				if (ambient == 2){
					System.out.println("El canguro ya se encuentra en esta zona");
				}
				else if (ambient == 1){
					if (zooCali.getKangarooZone().getEnv1().male() == true && zooCali.getKangarooZone().getEnv2().getKan1().getSex() == 1){
						System.out.println("En el ambiente ya se encuentra un macho");
					}
					else if(zooCali.getKangarooZone().getEnv1().getKan1() != null && zooCali.getKangarooZone().getEnv1().getKan2() != null && zooCali.getKangarooZone().getEnv1().getKan3() != null){
						System.out.println("el ambiente ya se encuentra lleno");
					}
					else{
						if(zooCali.getKangarooZone().getEnv1().getKan1() == null){
							zooCali.getKangarooZone().getEnv1().setKan1(zooCali.getKangarooZone().getEnv2().getKan1());
							zooCali.getKangarooZone().getEnv2().setKan1(null);
						}
						else{
							if(zooCali.getKangarooZone().getEnv1().getKan2() == null){
								zooCali.getKangarooZone().getEnv1().setKan2(zooCali.getKangarooZone().getEnv2().getKan1());
								zooCali.getKangarooZone().getEnv2().setKan1(null);
							}
							else{
								zooCali.getKangarooZone().getEnv1().setKan3(zooCali.getKangarooZone().getEnv2().getKan1());
								zooCali.getKangarooZone().getEnv2().setKan1(null);
							}
						}
					}
				}
				else if(ambient == 3){
					if (zooCali.getKangarooZone().getEnv3().male() == true && zooCali.getKangarooZone().getEnv2().getKan1().getSex() == 1){
						System.out.println("En el ambiente ya se encuentra un macho");
					}
					else if(zooCali.getKangarooZone().getEnv3().getKan1() != null && zooCali.getKangarooZone().getEnv3().getKan2() != null && zooCali.getKangarooZone().getEnv3().getKan3() != null){
						System.out.println("el ambiente ya se encuentra lleno");
					}
					else{
						if(zooCali.getKangarooZone().getEnv3().getKan1() == null){
							zooCali.getKangarooZone().getEnv3().setKan1(zooCali.getKangarooZone().getEnv2().getKan1());
							zooCali.getKangarooZone().getEnv2().setKan1(null);
						}
						else{
							if(zooCali.getKangarooZone().getEnv3().getKan2() == null){
								zooCali.getKangarooZone().getEnv3().setKan2(zooCali.getKangarooZone().getEnv2().getKan1());
								zooCali.getKangarooZone().getEnv2().setKan1(null);
							}
							else{
								zooCali.getKangarooZone().getEnv3().setKan3(zooCali.getKangarooZone().getEnv2().getKan1());
								zooCali.getKangarooZone().getEnv2().setKan1(null);
				            }
			            }
	                }
				}
				break;
				case(5):
				System.out.println("A que ambiente deseas trasladarlo?");
				ambient = reader.nextInt();
				if (ambient == 2){
					System.out.println("El canguro ya se encuentra en esta zona");
				}
				else if (ambient == 1){
					if (zooCali.getKangarooZone().getEnv1().male() == true && zooCali.getKangarooZone().getEnv2().getKan2().getSex() == 1){
						System.out.println("En el ambiente ya se encuentra un macho");
					}
					else if(zooCali.getKangarooZone().getEnv1().getKan1() != null && zooCali.getKangarooZone().getEnv1().getKan2() != null && zooCali.getKangarooZone().getEnv1().getKan3() != null){
						System.out.println("el ambiente ya se encuentra lleno");
					}
					else{
						if(zooCali.getKangarooZone().getEnv1().getKan1() == null){
							zooCali.getKangarooZone().getEnv1().setKan1(zooCali.getKangarooZone().getEnv2().getKan2());
							zooCali.getKangarooZone().getEnv2().setKan2(null);
						}
						else{
							if(zooCali.getKangarooZone().getEnv1().getKan2() == null){
								zooCali.getKangarooZone().getEnv1().setKan2(zooCali.getKangarooZone().getEnv2().getKan2());
								zooCali.getKangarooZone().getEnv2().setKan2(null);
							}
							else{
								zooCali.getKangarooZone().getEnv1().setKan3(zooCali.getKangarooZone().getEnv2().getKan2());
								zooCali.getKangarooZone().getEnv2().setKan2(null);
							}
						}
					}
				}
				else if(ambient == 3){
					if (zooCali.getKangarooZone().getEnv3().male() == true && zooCali.getKangarooZone().getEnv2().getKan2().getSex() == 1){
						System.out.println("En el ambiente ya se encuentra un macho");
					}
					else if(zooCali.getKangarooZone().getEnv3().getKan1() != null && zooCali.getKangarooZone().getEnv3().getKan2() != null && zooCali.getKangarooZone().getEnv3().getKan3() != null){
						System.out.println("el ambiente ya se encuentra lleno");
					}
					else{
						if(zooCali.getKangarooZone().getEnv3().getKan1() == null){
							zooCali.getKangarooZone().getEnv3().setKan1(zooCali.getKangarooZone().getEnv2().getKan2());
							zooCali.getKangarooZone().getEnv2().setKan2(null);
						}
						else{
							if(zooCali.getKangarooZone().getEnv3().getKan2() == null){
								zooCali.getKangarooZone().getEnv3().setKan2(zooCali.getKangarooZone().getEnv2().getKan2());
								zooCali.getKangarooZone().getEnv2().setKan2(null);
							}
							else{
								zooCali.getKangarooZone().getEnv3().setKan3(zooCali.getKangarooZone().getEnv2().getKan2());
								zooCali.getKangarooZone().getEnv2().setKan2(null);
				            }
			            }
	                }
				}
				break;
				case(6):
				System.out.println("A que ambiente deseas trasladarlo?");
				ambient = reader.nextInt();
				if (ambient == 2){
					System.out.println("El canguro ya se encuentra en esta zona");
				}
				else if (ambient == 1){
					if (zooCali.getKangarooZone().getEnv1().male() == true && zooCali.getKangarooZone().getEnv2().getKan3().getSex() == 1){
						System.out.println("En el ambiente ya se encuentra un macho");
					}
					else if(zooCali.getKangarooZone().getEnv1().getKan1() != null && zooCali.getKangarooZone().getEnv1().getKan2() != null && zooCali.getKangarooZone().getEnv1().getKan3() != null){
						System.out.println("el ambiente ya se encuentra lleno");
					}
					else{
						if(zooCali.getKangarooZone().getEnv1().getKan1() == null){
							zooCali.getKangarooZone().getEnv1().setKan1(zooCali.getKangarooZone().getEnv2().getKan3());
							zooCali.getKangarooZone().getEnv2().setKan3(null);
						}
						else{
							if(zooCali.getKangarooZone().getEnv1().getKan2() == null){
								zooCali.getKangarooZone().getEnv1().setKan2(zooCali.getKangarooZone().getEnv2().getKan3());
								zooCali.getKangarooZone().getEnv2().setKan3(null);
							}
							else{
								zooCali.getKangarooZone().getEnv1().setKan3(zooCali.getKangarooZone().getEnv2().getKan3());
								zooCali.getKangarooZone().getEnv2().setKan3(null);
							}
						}
					}
				}
				else if(ambient == 3){
					if (zooCali.getKangarooZone().getEnv3().male() == true && zooCali.getKangarooZone().getEnv2().getKan3().getSex() == 1){
						System.out.println("En el ambiente ya se encuentra un macho");
					}
					else if(zooCali.getKangarooZone().getEnv3().getKan1() != null && zooCali.getKangarooZone().getEnv3().getKan2() != null && zooCali.getKangarooZone().getEnv3().getKan3() != null){
						System.out.println("el ambiente ya se encuentra lleno");
					}
					else{
						if(zooCali.getKangarooZone().getEnv3().getKan1() == null){
							zooCali.getKangarooZone().getEnv3().setKan1(zooCali.getKangarooZone().getEnv2().getKan3());
							zooCali.getKangarooZone().getEnv2().setKan3(null);
						}
						else{
							if(zooCali.getKangarooZone().getEnv3().getKan2() == null){
								zooCali.getKangarooZone().getEnv3().setKan2(zooCali.getKangarooZone().getEnv2().getKan3());
								zooCali.getKangarooZone().getEnv2().setKan3(null);
							}
							else{
								zooCali.getKangarooZone().getEnv3().setKan3(zooCali.getKangarooZone().getEnv2().getKan3());
								zooCali.getKangarooZone().getEnv2().setKan3(null);
				            }
			            }
	                }
				}
				break;
				case(7):
				System.out.println("A que ambiente deseas trasladarlo?");
				ambient = reader.nextInt();
				if (ambient == 3){
					System.out.println("El canguro ya se encuentra en esta zona");
				}
				else if (ambient == 1){
					if (zooCali.getKangarooZone().getEnv1().male() == true && zooCali.getKangarooZone().getEnv3().getKan1().getSex() == 1){
						System.out.println("En el ambiente ya se encuentra un macho");
					}
					else if(zooCali.getKangarooZone().getEnv1().getKan1() != null && zooCali.getKangarooZone().getEnv1().getKan2() != null && zooCali.getKangarooZone().getEnv1().getKan3() != null){
						System.out.println("el ambiente ya se encuentra lleno");
					}
					else{
						if(zooCali.getKangarooZone().getEnv1().getKan1() == null){
							zooCali.getKangarooZone().getEnv1().setKan1(zooCali.getKangarooZone().getEnv3().getKan1());
							zooCali.getKangarooZone().getEnv3().setKan1(null);
						}
						else{
							if(zooCali.getKangarooZone().getEnv1().getKan2() == null){
								zooCali.getKangarooZone().getEnv1().setKan2(zooCali.getKangarooZone().getEnv3().getKan1());
								zooCali.getKangarooZone().getEnv3().setKan1(null);
							}
							else{
								zooCali.getKangarooZone().getEnv1().setKan3(zooCali.getKangarooZone().getEnv3().getKan1());
								zooCali.getKangarooZone().getEnv3().setKan1(null);
							}
						}
					}
				}
				else if(ambient == 2){
					if (zooCali.getKangarooZone().getEnv2().male() == true && zooCali.getKangarooZone().getEnv3().getKan1().getSex() == 1){
						System.out.println("En el ambiente ya se encuentra un macho");
					}
					else if(zooCali.getKangarooZone().getEnv2().getKan1() != null && zooCali.getKangarooZone().getEnv2().getKan2() != null && zooCali.getKangarooZone().getEnv2().getKan3() != null){
						System.out.println("el ambiente ya se encuentra lleno");
					}
					else{
						if(zooCali.getKangarooZone().getEnv2().getKan1() == null){
							zooCali.getKangarooZone().getEnv2().setKan1(zooCali.getKangarooZone().getEnv3().getKan1());
							zooCali.getKangarooZone().getEnv3().setKan1(null);
						}
						else{
							if(zooCali.getKangarooZone().getEnv2().getKan2() == null){
								zooCali.getKangarooZone().getEnv2().setKan2(zooCali.getKangarooZone().getEnv3().getKan1());
								zooCali.getKangarooZone().getEnv3().setKan1(null);
							}
							else{
								zooCali.getKangarooZone().getEnv2().setKan3(zooCali.getKangarooZone().getEnv3().getKan1());
								zooCali.getKangarooZone().getEnv3().setKan1(null);
				            }
			            }
	                }
				}
				break;
				case(8):
				System.out.println("A que ambiente deseas trasladarlo?");
				ambient = reader.nextInt();
				if (ambient == 3){
					System.out.println("El canguro ya se encuentra en esta zona");
				}
				else if (ambient == 1){
					if (zooCali.getKangarooZone().getEnv1().male() == true && zooCali.getKangarooZone().getEnv3().getKan2().getSex() == 1){
						System.out.println("En el ambiente ya se encuentra un macho");
					}
					else if(zooCali.getKangarooZone().getEnv1().getKan1() != null && zooCali.getKangarooZone().getEnv1().getKan2() != null && zooCali.getKangarooZone().getEnv1().getKan3() != null){
						System.out.println("el ambiente ya se encuentra lleno");
					}
					else{
						if(zooCali.getKangarooZone().getEnv1().getKan1() == null){
							zooCali.getKangarooZone().getEnv1().setKan1(zooCali.getKangarooZone().getEnv3().getKan2());
							zooCali.getKangarooZone().getEnv3().setKan2(null);
						}
						else{
							if(zooCali.getKangarooZone().getEnv1().getKan2() == null){
								zooCali.getKangarooZone().getEnv1().setKan2(zooCali.getKangarooZone().getEnv3().getKan2());
								zooCali.getKangarooZone().getEnv3().setKan2(null);
							}
							else{
								zooCali.getKangarooZone().getEnv1().setKan3(zooCali.getKangarooZone().getEnv3().getKan2());
								zooCali.getKangarooZone().getEnv3().setKan2(null);
							}
						}
					}
				}
				else if(ambient == 2){
					if (zooCali.getKangarooZone().getEnv2().male() == true && zooCali.getKangarooZone().getEnv3().getKan2().getSex() == 1){
						System.out.println("En el ambiente ya se encuentra un macho");
					}
					else if(zooCali.getKangarooZone().getEnv2().getKan1() != null && zooCali.getKangarooZone().getEnv2().getKan2() != null && zooCali.getKangarooZone().getEnv2().getKan3() != null){
						System.out.println("el ambiente ya se encuentra lleno");
					}
					else{
						if(zooCali.getKangarooZone().getEnv2().getKan1() == null){
							zooCali.getKangarooZone().getEnv2().setKan1(zooCali.getKangarooZone().getEnv3().getKan2());
							zooCali.getKangarooZone().getEnv3().setKan2(null);
						}
						else{
							if(zooCali.getKangarooZone().getEnv2().getKan2() == null){
								zooCali.getKangarooZone().getEnv2().setKan2(zooCali.getKangarooZone().getEnv3().getKan2());
								zooCali.getKangarooZone().getEnv3().setKan2(null);
							}
							else{
								zooCali.getKangarooZone().getEnv2().setKan3(zooCali.getKangarooZone().getEnv3().getKan2());
								zooCali.getKangarooZone().getEnv3().setKan2(null);
				            }
			            }
	                }
				}
				break;
				case(9):
				System.out.println("A que ambiente deseas trasladarlo?");
				ambient = reader.nextInt();
				if (ambient == 3){
					System.out.println("El canguro ya se encuentra en esta zona");
				}
				else if (ambient == 1){
					if (zooCali.getKangarooZone().getEnv1().male() == true && zooCali.getKangarooZone().getEnv3().getKan3().getSex() == 1){
						System.out.println("En el ambiente ya se encuentra un macho");
					}
					else if(zooCali.getKangarooZone().getEnv1().getKan1() != null && zooCali.getKangarooZone().getEnv1().getKan2() != null && zooCali.getKangarooZone().getEnv1().getKan3() != null){
						System.out.println("el ambiente ya se encuentra lleno");
					}
					else{
						if(zooCali.getKangarooZone().getEnv1().getKan1() == null){
							zooCali.getKangarooZone().getEnv1().setKan1(zooCali.getKangarooZone().getEnv3().getKan3());
							zooCali.getKangarooZone().getEnv3().setKan3(null);
						}
						else{
							if(zooCali.getKangarooZone().getEnv1().getKan2() == null){
								zooCali.getKangarooZone().getEnv1().setKan2(zooCali.getKangarooZone().getEnv3().getKan3());
								zooCali.getKangarooZone().getEnv3().setKan3(null);
							}
							else{
								zooCali.getKangarooZone().getEnv1().setKan3(zooCali.getKangarooZone().getEnv3().getKan3());
								zooCali.getKangarooZone().getEnv3().setKan3(null);
							}
						}
					}
				}
				else if(ambient == 2){
					if (zooCali.getKangarooZone().getEnv2().male() == true && zooCali.getKangarooZone().getEnv3().getKan3().getSex() == 1){
						System.out.println("En el ambiente ya se encuentra un macho");
					}
					else if(zooCali.getKangarooZone().getEnv2().getKan1() != null && zooCali.getKangarooZone().getEnv2().getKan2() != null && zooCali.getKangarooZone().getEnv2().getKan3() != null){
						System.out.println("el ambiente ya se encuentra lleno");
					}
					else{
						if(zooCali.getKangarooZone().getEnv2().getKan1() == null){
							zooCali.getKangarooZone().getEnv2().setKan1(zooCali.getKangarooZone().getEnv3().getKan3());
							zooCali.getKangarooZone().getEnv3().setKan3(null);
						}
						else{
							if(zooCali.getKangarooZone().getEnv2().getKan2() == null){
								zooCali.getKangarooZone().getEnv2().setKan2(zooCali.getKangarooZone().getEnv3().getKan3());
								zooCali.getKangarooZone().getEnv3().setKan3(null);
							}
							else{
								zooCali.getKangarooZone().getEnv2().setKan3(zooCali.getKangarooZone().getEnv3().getKan3());
								zooCali.getKangarooZone().getEnv3().setKan3(null);
				            }
			            }
	                }
				}
				break;
			}
		}
	}
}

