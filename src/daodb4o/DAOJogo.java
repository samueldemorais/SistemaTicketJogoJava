package daodb4o;

import java.util.List;

import com.db4o.query.Query;

import modelo.Jogo;

public class DAOJogo extends DAO<Jogo>{
	public Jogo read (Object chave){
		int id = (int) chave;	//casting para o tipo da chave
		Query q = manager.query();
		q.constrain(Jogo.class);
		q.descend("id").constrain(id);
		List<Jogo> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}

}
