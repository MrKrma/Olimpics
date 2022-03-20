package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class CountryData {
	private ArrayList<Country> data;
	
	//--------------------------------------------- Constructor
	public CountryData() {
		data = new ArrayList<>();
		load();
	}
	
	public void load() {
		try {
			
			FileInputStream is;
			is = new FileInputStream(new File("../listCountries.txt"));
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String line;
			
			while ((line= reader.readLine())!= null) {
				String[] info = line.split(";");
				
				int[] medal = new int [6]; 
				for (int i = 1; i<info.length; i++) {
					medal[i-1]=Integer.parseInt(info[i]);
				}
				data.add(new Country(info[0], medal[0], medal[1], medal[2], medal[3], medal[4], medal[5]));
			}
			
		} catch (Exception e) {
			
		} 
	}
	
	public void order(int a) {
		switch(a) {
			case 1: //----------------------------------------------------------------- ordenamiento externo
				Collections.sort(data, (A, B)->{
					int output = B.getGoldMaleMedal() - A.getGoldMaleMedal();
					if(output == 0) {
						output = B.getSilverMaleMedal() - A.getSilverMaleMedal();
						if(output == 0) {
							output = B.getBronzeMaleMedal() - A.getBronzeMaleMedal();
							if(output == 0) {
								output = B.getName().compareTo(A.getName());
							}
						}
					}
					return output;
				});
			break;
			case 2: //----------------------------------------------------------------- ordenamiento natural
				Collections.sort(data);
			break;
			default: //---------------------------------------------------------------- algoritmo de ordenamiento ()
				sortAll();
			break;
		}
	}
	
	//------------------------------------------------ Add method
	public void add(Country o) {
		data.add(o);
	}
	
	//--------------------------------------------------- Print method
	public void print(int type) {
		for(Country c: data) {
			System.out.println(c.toString(type));
		}
	}
	
	//--------------------------------------------------------- falta por terminar el algoritmo de ordenamiento. (selection sort)
	private void sortAll() {
		int total = data.size();
		for(int i = 0; i < total; i++) {
			int min = i;
			for(int j = i+1; j < total; j++) {
				int medalA = data.get(j).getGoldMaleMedal()+data.get(j).getGoldMFeminineMedal();
				int medalB = data.get(min).getGoldMaleMedal()+data.get(min).getGoldMFeminineMedal();
				if(medalA == medalB) {
					medalA = data.get(j).getSilverMaleMedal()+data.get(j).getSilverFeminineMedal();
					medalB = data.get(min).getSilverMaleMedal()+data.get(min).getSilverFeminineMedal();
					if(medalA == medalB) {
						medalA = data.get(j).getBronzeMaleMedal()+data.get(j).getBronzeFeminineMedal();
						medalB = data.get(min).getBronzeMaleMedal()+data.get(min).getBronzeFeminineMedal();
						if(medalA == medalB) {
							medalA = data.get(j).getName().compareTo(data.get(min).getName());
							if(medalA == -1) {
								Collections.swap(data, min, j);
							}
						}else {
							if(medalA > medalB) {
								Collections.swap(data, min, j);
							}
						}
					}else {
						if(medalA > medalB) {
							Collections.swap(data, min, j);
						}
					}
				}else {
					if(medalA > medalB) {
						Collections.swap(data, min, j);
					}
				}
				
			}
		}
	}
}
