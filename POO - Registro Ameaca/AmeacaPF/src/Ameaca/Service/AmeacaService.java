package Ameaca.Service;

import java.util.LinkedList;
import java.util.List;

import Ameaca.Entities.Ameaca;
import Ameaca.Repository.AmeacaRepository;


public class AmeacaService {

	private AmeacaRepository rep = new AmeacaRepository();

	public void inserir(Ameaca a)
	{
		a.convertData(a.getData());
		if(a.getDia() <= 0 || a.getDia() > 31)
			throw new BussinesException("Dia invalido");
		if(a.getMes() <= 0 || a.getMes() > 12)
			 throw new BussinesException("Mês invalido");
		if(a.getAno() < 1946 || a.getAno() > 2023)
			throw new BussinesException("Ano Invalido");
		if(a.getCve() == null)
			throw new BussinesException("CVE nao pode ser vazio");
		if(a.getProduto() == null && a.getProduto().length() > 5)
			throw new BussinesException("Produto nao pode ser vazio ou possuir menos de 5 letras");
		if(a.getVersao() == null && a.getVersao().length() > 0)
			throw new BussinesException("Versao nao poder ser vazia");
		if(a.getTipo() == null)
			throw new BussinesException("Tipo nao pode ser vazio");
		if(a.getCriticidade() <= 0 && a.getCriticidade() > 9)
			throw new BussinesException("Valor de criticidade deve ser entre 1 e 9");
		if(a.getData() == null)
			throw new BussinesException("Data nao pode ser vazia");
		rep.inserir(a);

	}

	public void alterar(int id, Ameaca a)
	{
		ArquivosService as = new ArquivosService();
		a.convertData(a.getData());
		if(a.getDia() <= 0 || a.getDia() > 31)
			throw new BussinesException("Dia invalido");
		if(a.getMes() <= 0 || a.getMes() > 12)
			throw new BussinesException("Mês invalido");
		if(a.getAno() < 1946 || a.getAno() > 2023)
			throw new BussinesException("Ano Invalido");
		if(a.getCve() == null)
			throw new BussinesException("CVE nao pode ser vazio");
		if(a.getProduto() == null && a.getProduto().length() > 5)
			throw new BussinesException("Produto nao pode ser vazio ou possuir menos de 5 letras");
		if(a.getVersao() == null && a.getVersao().length() > 0)
			throw new BussinesException("Versao nao poder ser vazia");
		if(a.getTipo() == null)
			throw new BussinesException("Tipo nao pode ser vazio");
		if(a.getCriticidade() <= 0 && a.getCriticidade() > 9)
			throw new BussinesException("Valor de criticidade deve ser entre 1 e 9");
		if(a.getData() == null)
			throw new BussinesException("Data nao pode ser vazia");

		var aux = rep.get(id);
		if (aux == null)
			throw new BussinesException("Ameaca não encontrada para alteração");

		if (id!=a.getId() && rep.get(a.getId())!=null)
			throw new BussinesException("Ameaca com id ja existente");
		as.alterarArquivo(a);
		rep.alterar(id, a);
	}

	public void remover(int id)
	{
		ArquivosService as = new ArquivosService();
		var aux = rep.get(id);
		if (aux == null)
			throw new BussinesException("Ameaca não encontrada para remoção");
		as.remover(id);
		rep.remover(id);
	}

	public Iterable<Ameaca> listar()
	{
		return rep.listar();
	}

	public Iterable<Ameaca> listar(String parte)
	{
		List<Ameaca> lista = new LinkedList<Ameaca>();
		for(Ameaca a : rep.listar())
		{
			if (a.getProduto().contains(parte) || a.getTipo().contains(parte) ||
					(a.getVersao()+"").contains(parte) || (a.getCriticidade()+"").contains(parte))
				lista.add(a);
		}
		return lista;
	}

}
