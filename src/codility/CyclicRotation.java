package codility;

public class CyclicRotation {

	public CyclicRotation() {

	}

	static final int CANT_VUELTAS  =2; 
	
	public static void main(String[] args) {
				
		int k=CANT_VUELTAS; //3
		
		int[] vec = {3,8,9,7,6};
		
		for (int i = 0; i < CANT_VUELTAS; i++) {
			rotarCiclicamente(vec); 
		}
			
		imprimirVector(vec);
	}
	
	public static void rotarCiclicamente(int[] vec) { 
		try {
			if ( ( vec !=null) && vec.length > 1 ) {
				int lastElem = vec[vec.length-1]; 
				
				int iDondeMeterTmp=vec.length-1; 
				int iParaMeter=vec.length -1 -1 ;
				
				while (iDondeMeterTmp >0) {
					
					vec[iDondeMeterTmp] = vec[iParaMeter]; 
					iDondeMeterTmp-- ;
					iParaMeter--;
					
				}
				vec[0]=lastElem;
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	public static final void imprimirVector(int[] vec) {
		try {
			for (int i = 0; i < vec.length; i++) {
				System.out.println(vec[i] );
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
