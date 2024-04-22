package codility;

public class Examen01 {

	public Examen01() {
		
	}
	
	
	public int solution(int[] A) {
		int r = 0; 
		int indexOpuesto=-1;
		
		try {
			if ( (A != null) && (A.length >0 ) ) {
				
				for (int i = 0; i < A.length; i++) {
					if (A[i]>0) { 
						if (A[i]!=r) { 
							indexOpuesto=findOpposite(A, A[i]);
							
							if (indexOpuesto!=-1) { 
								if(A[i]>r) {
									r=A[i];
								}
							}
						}
					}
				}
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return r;
	}
	
	
	public int findOpposite(int []A, int x) throws Exception{
		int r=-1;
		try {
			for (int i = 0; i < A.length; i++) {
					if (isOpposite(A[i],x)) {
						r=i;
						break; 
					} 
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return r;
	}

	public boolean isOpposite(int i,int x) {  
		boolean r=false;
		if (i==(x*-1)) {
			r=true;
		}
		return r;
	}
	
}
