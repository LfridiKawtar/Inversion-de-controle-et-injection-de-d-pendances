package pres;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;



import dao.DaoImpl;
import dao.IDao;
import metier.IMetier;
import metier.MetierImpl;
public class Presentation {
 // fabrique (factory) la classe où on crée des objets 
	
	public static void main(String[] args) {
		//Injection des dépendances par instanciation statique => new
		/*DaoImpl dao=new DaoImpl();
		MetierImpl metier = new MetierImpl();
		metier.setDao(dao);
		System.out.println(metier.calcul());*/
		
		
		// Injection des dépendances par instanciation dynamique 
		try {
			Scanner scanner = new Scanner(new File("config.txt"));
			String daoClassName= scanner.nextLine();
	
			Class cDao=Class.forName(daoClassName);
			IDao dao = (IDao) cDao.newInstance();
			
			String metierClassName= scanner.nextLine();
			Class cMetier=Class.forName(metierClassName);
			IMetier metier = (IMetier) cMetier.newInstance();
			
			Method m=cMetier.getMethod("setDao", IDao.class);
			m.invoke(metier,dao);
			System.out.println(metier.calcul());
			 
		} catch (FileNotFoundException | ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
	}

}
