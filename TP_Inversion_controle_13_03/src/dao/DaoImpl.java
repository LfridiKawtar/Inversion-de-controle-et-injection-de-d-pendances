package dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class DaoImpl implements IDao{

	@Override
	public double getData() {
		System.out.println("Version base de données");
		double temp=23;
		return temp;
	}
	public void init()
	{
		System.out.println("Instanciation de DaoImpl");
	}

}
