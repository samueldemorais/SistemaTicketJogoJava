package daodb4o;

import java.util.List;

import com.db4o.query.Query;

import modelo.IngressoIndividual;

public class DaoIngressoIndividual extends DAO<IngressoIndividual>{
	public IngressoIndividual read (Object chave){
		int codigo = (int) chave;	//casting para o tipo da chave
		Query q = manager.query();
		q.constrain(IngressoIndividual.class);
		q.descend("codigo").constrain(codigo);
		List<IngressoIndividual> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
}
