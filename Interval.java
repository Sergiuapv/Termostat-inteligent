import java.util.ArrayList;
import java.util.*;
/**
 * 
 * @author Sergiu
 * Un interval din cele 24
 */
public class Interval {
	
	public Interval() {
		// TODO Auto-generated constructor stub
		this.valori= new ArrayList<Element>(100);
		this.valori2=new ArrayList<Element2>(100);
	}
	
	ArrayList<Element> valori; //array ul pentru temperaturi
	ArrayList<Element2> valori2; //array ul pentru umiditate
	/**
	 * 
	 * @param temper Temperatura 
	 * @param timestamp Timp
	 * Adauga o noua valoare astfel incat sa ramana vectorul sortat
	 */
	public void adaugelem(double temper,int timestamp)
	{	int i=0;
	int ok=1;
		Element elem=new Element(timestamp,temper);
			for(i=0;i<valori.size();i++)
			{ ok=0;
			
			if(valori.get(i).temperature>=elem.temperature)
				{
				if(!exista(elem.temperature))
						this.valori.add(i,elem);
				break;
				}
			
			}
			
			if(ok==0&& i==valori.size())
				if(!exista(elem.temperature))
				this.valori.add(elem);
		if(ok==1)
			if(!exista(elem.temperature))
			this.valori.add(0,elem);
	}
	/**
	 * 
	 * @param hum Umiditate
	 * @param timestamp Timp
	 * Adauga o noua valoare astfel incat sa ramana vectorul sortat
	 */
	public void adaugelem2(double hum,int timestamp)
	{
		int i=0;
		int ok=1;
			Element2 elem=new Element2(timestamp,hum);
				for(i=0;i<valori2.size();i++)
				{ ok=0;
				
				if(valori2.get(i).hum>=elem.hum)
					{
					if(!exista2(elem.hum))
							this.valori2.add(i,elem);
					break;
					}
				
				}
				
				if(ok==0&& i==valori2.size())
					if(!exista2(elem.hum))
					this.valori2.add(elem);
			if(ok==1)
				if(!exista2(elem.hum))
				this.valori2.add(0,elem);
	}
	public void see()
	{
		for (Element number : valori)  
	     System.out.println(number.temperature+" "+number.time);
	 
	}
	/**
	 * 
	 * @param t Umiditatea
	 * @return True daca exista deja ,false altfel
	 */
	public boolean exista2(double t)
	{
		for (Element2 number : valori2)  
	     if(number.hum==t)
	    	 {
	    	 return true;
	    	 }
		return false;
	 
	}
	/**
	 * 
	 * @param t Temperatura
	 * @return True daca exista deja ,false altfel
	 */
	public boolean exista(double t)
	{
		for (Element number : valori)  
	     if(number.temperature==t)
	    	 {
	    	 return true;
	    	 }
		return false;
	 
	}
	/**
	 * 
	 * @param start Inceput de interval
	 * @param stop Sfarsit de interval
	 * @param postart
	 * @param postop
	 * Afiseaza elementele din intervalul cerut
	 */
	public void seel(int start,int stop,int postart,int postop)
	{
		for (Element number : valori)  
	     {if(number.time>=start && number.time<=stop)
	    	
		System.out.print(String.format(" %.2f",number.temperature));
	     }
	 
	}
	

}

