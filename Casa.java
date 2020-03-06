import java.util.ArrayList;
/**
 * 
 * @author Sergiu
 * Clasa ce descrie o casa
 */
public class Casa {

	public Casa() {
		// TODO Auto-generated constructor stub
	}
	
	int nr_camere;
	double temp_globala;
	int t_referinta;
	int prim;
	ArrayList<Camera> v; //array de camere
	/**
	 * 
	 * @param nr_camere Numarul de camere
	 * @param temp_globala Temperatura dorita
	 * @param t_referinta Timpul de referinta
	 */
	public Casa(int nr_camere, double temp_globala, int t_referinta) {
		super();
		this.nr_camere = nr_camere;
		this.temp_globala = temp_globala;
		this.t_referinta = t_referinta;
		this.v= new ArrayList<Camera>(nr_camere);
		prim=0;
	}
	/**
	 * 
	 * @param c Camera de adaugat in casa
	 */
	public void adaug(Camera c)
	{
		this.v.add(c);
	}
	/**
	 * Afisarea datelor despre casa
	 */
	public void see()
	{	int i=0;
		for (Camera number : v) 
	      number.see();
	}
	/**
	 * 
	 * @param device Id ul device ului
	 * @return Camera cu acel device
	 */
	public Camera getdevice (String device)
	{
		for (Camera number : v) {
	         if(number.device_id.equals(device))
	        	 {
	        	 return number;
	        	 }
	        	 
	}
		return null;
	}
	/**
	 * 
	 * @param room Id ul camerei
	 * @return Camera 
	 */
	public Camera getcamera (String room)
	{
		for (Camera number : v) {
	         if(number.id_camera.equals(room))
	        	 {
	        	 return number;
	        	 }
	        	 
	}
		return null;
	}
	/**
	 * 
	 * @return Media ponderata pentru temperatura din toata casa
	 */
	public double medielasthour()
	{ double sum=0;
		double ariatotala=0;
		for (Camera number : v)
		{
			sum+=number.getlasthour();
			ariatotala+=number.getAria();
		}
		return sum/ariatotala;
	}
	/**
	 * 
	 * @return Media ponderata pentru umiditate din toata casa
	 */
	public double medielasthourhum()
	{ double sum=0;
		double ariatotala=0;
		for (Camera number : v)
		{
			sum+=number.getlasthourhum();
			ariatotala+=number.getAria();
		}
		return sum/ariatotala;
	}
	/**
	 * 
	 * @param room Id ul camerei
	 * @param start Inceputul intervalului
	 * @param stop Sfarsitul intervalului
	 */
	public void list(String room,int start,int stop)
	{
		Camera rm=getcamera(room);
		if(prim!=0)
		System.out.println();	
		prim++;
		System.out.print(room);
		rm.listcamera(start, stop,this.t_referinta);
	}
}
