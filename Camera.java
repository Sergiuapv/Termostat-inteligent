import java.util.ArrayList;
/**
 * 
 * @author Sergiu
 * Camera
 */
public class Camera {

	public Camera() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param id_camera Id ul camerei
	 * @param device_id Id ul device ului
	 * @param aria Aria
	 */
	public Camera(String id_camera, String device_id, double aria) {
	
		
		super();
		this.id_camera = id_camera;
		this.device_id = device_id;
		this.aria = aria;
		this.vect=new ArrayList<Interval>(24);
		for(int i=0;i<=23;i++)
		{	Interval inte=new Interval();
			vect.add(i,inte);
		}

	}
	ArrayList<Interval> vect; //vector de 24 de intervale 
	String id_camera;
	String device_id;
	double aria;
	
	public void see()
	{
		for (Interval number : vect) {
		    
			number.see();
		}
	}
	/**
	 * 
	 * @param temperatura Temperatura de adaugat
	 * @param timp Timpul la care s a inregistrat
	 * @param t_ref Timpul de referinta
	 */
	public void adaugtemp(double temperatura,int timp,int t_ref)
	{	int pos=0;
	//calculez pozitia corespunzatoare din interval
		pos=t_ref-(24*3600);
		pos=timp-pos;
		pos=pos/3600;
		Integer i=0;
		
		for (Interval number : vect) {
		    if(i.equals(pos))
			number.adaugelem(temperatura, timp);
		    i++;
		}
		
	}
	/**
	 * 
	 * @param hum Umiditatea de adaugat
	 * @param timp Timpul la care s a inregistrat
	 * @param t_ref Timpul de referinta
	 */
	public void adaughumidity(double hum,int timp,int t_ref)
	{
		int pos=0;
		
		pos=t_ref-(24*3600);
		pos=timp-pos;
		pos=pos/3600;
		Integer i=0;
		
		for (Interval number : vect) {
		    if(i.equals(pos))
			number.adaugelem2(hum, timp);
		    i++;
		}
	}
	/**
	 * 
	 * @param start Inceputul intervalului
	 * @param stop Sfarsitul Intervalului
	 * @param t_referinta Timp de referinta
	 * Calculez pe ce intervale trebuie sa caut valorile cerute
	 */
	public void listcamera(int start,int stop,int t_referinta)
	{
		 int postart=t_referinta-24*3600;
		 postart=(start-postart)/3600;
		 int postop=t_referinta-24*3600;
		 postop=(stop-postop)/3600;
		 
		 for (int i=postop;i>=postart;i--)
		 {
			 		
					 vect.get(i).seel(start,stop,postart,postop);
			}
	}
	/**
	 * 
	 * @return Prima valoare din ultimul interval cu valori inmultita cu aria
	 */
	public double getlasthour()
	{
		for(int i=23;i>=0;i--)
			if(vect.get(i).valori.size()>0)
				return vect.get(i).valori.get(0).temperature * this.aria;
				return 0;
	}
	/**
	 * 
	 * @return Ultima valoare din ultimul interval cu valori inmultita cu aria
	 */
	public double getlasthourhum()
	{
		for(int i=23;i>=0;i--)
			if(vect.get(i).valori2.size()>0)
				return vect.get(i).valori2.get(vect.get(i).valori2.size()-1).hum * this.aria;
				return 0;
	}
	/**
	 * 
	 * @return Aria
	 */
	public double getAria()
	{
		return aria;
	}

}
