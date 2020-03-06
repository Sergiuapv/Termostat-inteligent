import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.StringTokenizer;
/**
 * 
 * @author Sergiu
 * De aici se face citirea din fisier si se lanseaza in executie restul temei
 */
public class Head {

	public Head() {
		// TODO Auto-generated constructor stub

	}
	public static void main(String[] args) throws  java.lang.StringIndexOutOfBoundsException, IOException{
		File file = new File("therm.in"); 
		File file1 = new File("therm.out"); 
		BufferedReader br = new BufferedReader(new FileReader(file));
		PrintStream o = new PrintStream(file1);
		System.setOut(o);
		String st;
		int t_referinta;
		double hum_glob=0;
		st=br.readLine();
		StringTokenizer def=new StringTokenizer(st);
		String st1=def.nextToken();
		int nrcamere=Integer.parseInt(st1);
		st1=def.nextToken();
		double temp_globala=Double.parseDouble(st1);
		st1=def.nextToken();
		double d=Double.parseDouble(st1);
		if(d>1000)
		{ 	int x=Integer.parseInt(st1);
		t_referinta=x;
		}
		else
		{ hum_glob=d;
		st1=def.nextToken();
		t_referinta=Integer.parseInt(st1);
		}


		Casa house=new Casa(nrcamere,temp_globala,t_referinta); 
		//initializez casa cu datele citite
		//construiesc camerele si le adaug in casa
		for (int i=1;i<=nrcamere;i++)
		{	
			st=br.readLine();
			StringTokenizer def1=new StringTokenizer(st);
			st1=def1.nextToken();
			String idcamera=st1;
			st1=def1.nextToken();
			String device=st1;
			st1=def1.nextToken();
			double aria=Double.parseDouble(st1);
			Camera room=new Camera(idcamera,device,aria);
			house.adaug(room);
		}

		try
		{	
			while ((st=br.readLine())!=null && st.length()>1)
			{StringTokenizer def1=new StringTokenizer(st);
			st1=def1.nextToken();
			//adaug temperatura observata
			if(st1.equals("OBSERVE"))
			{	
				st1=def1.nextToken();

				Camera r;
				r=house.getdevice(st1);
				st1=def1.nextToken();
				int timp=Integer.parseInt(st1);
				st1=def1.nextToken();
				double temperatura=Double.parseDouble(st1);
				r.adaugtemp(temperatura, timp,t_referinta);


			}else
				//adaug umiditatea observata
				if(st1.equals("OBSERVEH"))
				{
					st1=def1.nextToken();

					Camera r;
					r=house.getdevice(st1);
					st1=def1.nextToken();
					int timp=Integer.parseInt(st1);
					st1=def1.nextToken();
					double humidity=Double.parseDouble(st1);
					r.adaughumidity(humidity, timp,t_referinta);
				}
				else
					if(st1.equals("LIST"))
					{	st1=def1.nextToken();
					String room =st1;
					st1=def1.nextToken();
					int start=Integer.parseInt(st1);
					st1=def1.nextToken();
					int stop=Integer.parseInt(st1);
					house.list(room,start,stop);


					}
					else
						if(st1.equals("TRIGGER"))
						{ 
							int ok=0;
							st1=def1.nextToken();
							if(house.medielasthourhum()>hum_glob)
							{System.out.println("NO");
							ok=1;
							}
							if(ok==0)
								if(house.medielasthour()<house.temp_globala)
									System.out.println("YES");
								else
									System.out.println("NO");
						}
						else
							if(st1.equals("TEMPERATURE"))
							{
								st1=def1.nextToken();
								double temperatur1=Double.parseDouble(st1);
								house.temp_globala=temperatur1;
							}

			}
		}catch (IOException e) 
		{

			e.printStackTrace();

		}
		finally {

			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

}
