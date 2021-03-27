package metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dao.IDao;
@Service("metier")
public class MetierImpl implements IMetier {

	//couplage faible
	@Autowired
    private IDao dao=null;
	@Override
	public double calcul() {
		double temp=dao.getData();
		double res=temp*Math.PI;
		return res;
	}
	
	//pour injecter dans la variable dao un objet d'une classe qui implémente  IDao
	public void setDao(IDao dao) {
		this.dao = dao;
		System.out.println("Injection des dépendances");
	}
	public void init()
	{
		System.out.println("Initialisation de MetierImpl");
	}
	public MetierImpl() {
		System.out.println("Instanciation de MetierImpl");
	}

}
