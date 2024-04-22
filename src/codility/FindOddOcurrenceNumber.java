package codility;

import java.util.HashMap;

public class FindOddOcurrenceNumber {

	public FindOddOcurrenceNumber() {
	}

	public static void main(String[] args) {
		int[] vec=  {1,1,2,2,3,3,4,4,5,1,5}; 
		
		System.out.println(findOddOcNumb(vec));
		
		
	}
	
	public static int findOddOcNumb(int[] vec) {
		 
		HashMap<Integer, Integer> hashTmp=new HashMap<Integer, Integer>();
		boolean foundImpar=false;
		int r= -1;
		try {
			if( vec != null && vec.length > 0 && vec.length % 2 != 0) {
				if (vec.length==1) 
					return vec[0];
				else {
					
					int i = 0;
					int cantITmp=0;
					int elementActual=-1;
					
					while (!foundImpar && i < vec.length) {
						elementActual = vec[i];
						if (!hashTmp.containsValue(elementActual)){
							cantITmp = contarElemOcs(vec,elementActual);
							if ( (cantITmp % 2) != 0 ) { 
								r=elementActual;
								foundImpar=true;
							}else { 
								hashTmp.put(elementActual, elementActual);
								i++;
							}
						}else { 
							i++;
						}
						
					}
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return r;
	}
	
	public static int contarElemOcs(int[] vec, int elementActual) {
		int cant=0;
		try {
			
			for (int i = 0; i < vec.length; i++) {
				if (vec[i]==elementActual)
					cant++;
			}
		
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			cant = -1;
		}
		return cant;
	}
	
}
