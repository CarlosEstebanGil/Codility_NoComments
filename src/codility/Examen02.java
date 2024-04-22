package codility;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Examen02 {

	public Examen02() {
	}


	final static String ARROBA="@";
	final static String SEP_FIRST_LAST=".";
	final static String Z=".COM";
	final static String EMPRESA = "gmail";
	final static String EMAILS_SEPARATOR= ";";
	
	
	private HashMap<String, String> hashEmailsStr=new HashMap<String, String>();
	
	public String solution(String S, String C) {
        String r=null; 
        
        final String SEP="; ";
        final String z=".COM";
        
        StringBuilder sbTmp= new StringBuilder();
        String strDirTmp="";

        String[] arrOfStrNames= S.split(SEP);
        

        for (int i = 0; i < arrOfStrNames.length; i++) {

        	strDirTmp=ArmarDireccion(arrOfStrNames[i]); 
        	if(strDirTmp.compareTo("")!=0) { 
        		
        		if (yaExistEnteEnHash(strDirTmp,hashEmailsStr)) { 
        			strDirTmp=corregirURLFinalDuplicada(strDirTmp,hashEmailsStr); 
        		}else
        		{
        			
        		}

        		hashEmailsStr.put(strDirTmp, strDirTmp); 
        		sbTmp.append(strDirTmp).append(EMAILS_SEPARATOR);
        		
        	}
		}
        
        r= sbTmp.toString();
        return r;
    }
	
	public boolean yaExistEnteEnHash(String strEMAILURL, HashMap<String, String> hashUrls) {
		boolean r=false;
		
		
		if ( ( hashUrls!=null) & ( strEMAILURL !=null) ) {
			if ( ( hashUrls.size() > 0 ) && (strEMAILURL.length()>0 ) ) {
				if (hashUrls.get(strEMAILURL)!=null) { //existe
					r=true;
				}
			}
		}
		
		return r;
	}
	
	
	public String corregirURLFinalDuplicada(String strDuplicatedEMAILURL, HashMap<String, String> hashEmailsStr) {
		String r=strDuplicatedEMAILURL;
		
		int iDefMax= -1; 
		int maxCorrelativNumb=0;
		String  hashElemActualStr="";
		for (String key : hashEmailsStr.keySet()) { 
			hashElemActualStr=key; 
			maxCorrelativNumb =coincidente( strDuplicatedEMAILURL,  hashElemActualStr); 
			if ( maxCorrelativNumb > 0) {
				iDefMax=Integer.max(maxCorrelativNumb,iDefMax);
			}else if (maxCorrelativNumb < 0) {
			}else { 
				iDefMax=Integer.max(maxCorrelativNumb,iDefMax); al sig del hash , hash.leer sig

		} 
		
		
		if (iDefMax!= -1) { 
			iDefMax= iDefMax + 1; 
			
			r= parteNameOnlyyStringUnicamente( r)  + iDefMax + ARROBA+EMPRESA+Z;
		}
	
			
		return r; 
	}
	
	public String parteNameOnlyyStringUnicamente(String hashElemActualStr) {
		String r="";
		int i = 0;
		while (i<hashElemActualStr.length()) {
			if ( (Character.isDigit(hashElemActualStr.charAt(i)) || (Character.toString(hashElemActualStr.charAt(i)).compareToIgnoreCase(ARROBA)==0 ) )) {
				break;
			}
			r = r + hashElemActualStr.charAt(i);
			i++;
		}
		 
		return r;
	}
	
	public int coincidente(String strDuplicatedEMAILURL, String hashElemActualStr) {
		
		strDuplicatedEMAILURL=strDuplicatedEMAILURL.substring(0,strDuplicatedEMAILURL.indexOf(ARROBA));
		hashElemActualStr=hashElemActualStr.substring(0,hashElemActualStr.indexOf(ARROBA));
		
		int r=-1;
		int i= 0; 
		
		int iRestoHash=-1;
		
		while (i < strDuplicatedEMAILURL.length()  ) { 
			if ( strDuplicatedEMAILURL.charAt(i) != hashElemActualStr.charAt(i) ) {
				break; 
			}
			i++;
		}	
		if (i >= strDuplicatedEMAILURL.length() ) {	
			
			
			if ( hashElemActualStr.length()>i ) {
				
				String strRestoHash = hashElemActualStr.substring(i,hashElemActualStr.length());
				
				if (isInteger(strRestoHash)) {
					iRestoHash=Integer.parseInt(strRestoHash);
				}
				
			}else if  ( hashElemActualStr.length()==i ) { 
				iRestoHash=0;
			}
			
		} else { 
			iRestoHash=-1;
		}
		
		r=iRestoHash;
		
		return r;
	}
	
		 

		public static boolean isInteger(String s) {
		    try { 
		        Integer.parseInt(s); 
		    } catch(NumberFormatException e) { 
		        return false; 
		    } catch(NullPointerException e) {
		        return false;
		    }
		    return true;
		}
		
		
	public String ArmarDireccion(String strCurrentCompleteName) {
		String r="";
		final String SEP=" ";
		int posCampoTmp=0;
		String[] arrOfStrSubNames= strCurrentCompleteName.split(SEP);
		
		if ( (arrOfStrSubNames.length==2) || (arrOfStrSubNames.length==3) ) { 
			
			switch (arrOfStrSubNames.length) {
			case 2:
				posCampoTmp=1;
				break;
			case 3:
				posCampoTmp=2;
				break;
			default:
				break;
			}
			
			r= ArmarURLEmail(arrOfStrSubNames,posCampoTmp);
			
		}else {
		}
		
		return r;
	}
	
	
	public String ArmarURLEmail(String[] arrOfStrSubNames, int posCampoTmp ) {
		String r="";
		String firstName="";
		String lastName="";
		
			firstName= arrOfStrSubNames[0];
			lastName=arrOfStrSubNames[posCampoTmp];
			
			if (lastName.contains("-")) {
				lastName= removerGuion(lastName);
			}
			
			if (firstName.length()>8) {
				firstName=firstName.substring(0,7);
			}
			if (lastName.length()>8) {
				lastName=lastName.substring(0,7);
			}
			
			firstName=firstName.toLowerCase();
			lastName=lastName.toLowerCase();
			
		r=firstName + SEP_FIRST_LAST + lastName +  ARROBA + EMPRESA + Z;	
		return r;
	}
	
	public String  removerGuion(String s){
		String r="";
				
		r=s.replace("-", "");
		return r;
	}

}
