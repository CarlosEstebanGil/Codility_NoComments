package codility;

public class BinaryGap {

	public BinaryGap() {
	}

	public static void main(String[] args) throws Exception {

		int casoPrueba=65537;;
		
		System.out.println(Integer.toBinaryString(casoPrueba));	
		System.out.println(binaryGap(casoPrueba));
		 
		}
	
		public static int binaryGap(int n) throws Exception {
			String s=null;
			int max=0;
			int cont=0;
			boolean estoyEnUno=false;
			
			try {
				s = Integer.toBinaryString(n);
				
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i)=='1') {  
						estoyEnUno=true;
						if (cambio(i,s)) {
							max=Integer.max(cont,max);
							cont=0;
						}
					}else 
						if (estoyEnUno)
							cont++;
						else 
							continue;
				}
				
				return max;
				
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}	
		
		}


		
		public static boolean cambio(int i, String s) {
			boolean cambio= false;
			if(i>0)  
			{
				if (s.charAt(i)=='1' && s.charAt(i-1)=='0') 
					cambio=true;
			}
			return cambio;
			

		}
		
}
