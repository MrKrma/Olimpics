package main;

import model.CountryData;
import model.Country;

public class Main {

	public static void main(String[] args) {
		CountryData data = new CountryData();
//		data.add(new Country("USA", 10, 15, 17, 11, 12, 16));
//		data.add(new Country("RUSIA", 10, 21, 17, 26, 27, 15));
//		data.add(new Country("CHINA", 1, 4, 4, 0, 2, 9));
//		data.add(new Country("COLOMBIA", 2, 3, 6, 0, 2, 9));
		
		System.out.println("Masculino");
		data.order(1);
		data.print(1);
		System.out.println("----------");
		System.out.println("Femenino");
		data.order(2);
		data.print(2);
		System.out.println("----------");
		System.out.println("Combinado");
		data.order(3);
		data.print(3);
	}

}
