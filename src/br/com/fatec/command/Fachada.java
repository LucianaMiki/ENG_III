package br.com.fatec.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.fatec.dao.FilmeDAO;
import br.com.fatec.dao.IDAO;
import br.com.fatec.dao.SalaDAO;
import br.com.fatec.dao.SessaoDAO;
import br.com.fatec.dominio.EntidadeDominio;
import br.com.fatec.dominio.Filme;
import br.com.fatec.dominio.Sala;
import br.com.fatec.dominio.Sessao;
import br.com.fatec.strategy.IStrategy;
import br.com.fatec.strategy.ValidarExistenciaFilme;
import br.com.fatec.strategy.ValidarExistenciaSala;
import br.com.fatec.strategy.ValidarExistenciaSessao;
import br.com.fatec.strategy.ValidarLimiteFilme;
import br.com.fatec.strategy.ValidarLimiteSala;
import br.com.fatec.strategy.ValidarLimiteSessao;

public class Fachada implements IFachada {
    private Map<String, IDAO> daos;
    
    private Map<String, List<IStrategy>> rns;
    
    private StringBuilder sb = new StringBuilder();

    IDAO dao = null;
    String nmClasse = null;
    List<IStrategy> rng = null;

    public Fachada() {
        daos = new HashMap<String, IDAO>();
        rns = new HashMap<String, List<IStrategy>>();
        
        ValidarExistenciaFilme vExiFilme = new ValidarExistenciaFilme();
        ValidarExistenciaSala vExiSala = new ValidarExistenciaSala();
        ValidarExistenciaSessao vExiSessao = new ValidarExistenciaSessao();
        ValidarLimiteFilme vLimFilme = new ValidarLimiteFilme();
        ValidarLimiteSala vLimSala = new ValidarLimiteSala();
        ValidarLimiteSessao vLimSessao = new ValidarLimiteSessao();
     
        daos.put(Sala.class.getName(), new SalaDAO());

		List<IStrategy> rnsSala = new ArrayList<IStrategy>();
		rnsSala.add(vExiSala);
		rnsSala.add(vLimSala);
		rns.put(Sala.class.getName(), rnsSala);
         
        daos.put(Filme.class.getName(), new FilmeDAO());

		List<IStrategy> rnsFilme = new ArrayList<IStrategy>();
		rnsFilme.add(vExiFilme);
		rnsFilme.add(vLimFilme);
		rns.put(Filme.class.getName(), rnsFilme);
                
        daos.put(Sessao.class.getName(), new SessaoDAO());

		List<IStrategy> rnsSessao = new ArrayList<IStrategy>();
		rnsSessao.add(vExiSessao);
		rnsSessao.add(vLimSessao);
		rns.put(Sessao.class.getName(), rnsSessao);
		
		//daos.put(Tudo.class.getName(), new SessaoDAO());
       
    }

    @Override
    public String Inserir(EntidadeDominio entidade) {
        String nmClasse = entidade.getClass().getName();
        String msg = executarRegras(entidade);
        if (msg == null) {
			IDAO dao = daos.get(nmClasse);
			dao.Inserir(entidade);
		} else {
			return msg;
		}
		return null;
    }
        
    public String executarRegras(EntidadeDominio entidade) {
    	String nmClasse = entidade.getClass().getName();
		StringBuilder msg = new StringBuilder();
		
		List<IStrategy> regras = rns.get(nmClasse);
		
		if (regras != null) {
			for (IStrategy s : regras) {
				String m = s.processar(entidade);

				if (m != null) {
					msg.append(m);
					msg.append("\n");
				}
			}
		}

		if (msg.length() > 0)
			return msg.toString();
		else
			return null;
    }
    
    public String executarRegrasAlterar(EntidadeDominio entidade) {
    	String nmClasse = entidade.getClass().getName();
		StringBuilder msg = new StringBuilder();
		
		if(nmClasse.equals("br.com.fatec.dominio.Sala")) {
			rns.remove("br.com.fatec.dominio.Sala");
			List<IStrategy> rnsSala = new ArrayList<IStrategy>();
			ValidarLimiteSala vLimSala = new ValidarLimiteSala();
			rnsSala.add(vLimSala);
			rns.put(Sala.class.getName(), rnsSala);
		}
		
		List<IStrategy> regras = rns.get(nmClasse);

		if (regras != null) {
			for (IStrategy s : regras) {
				String m = s.processar(entidade);

				if (m != null) {
					msg.append(m);
					msg.append("\n");
				}
			}
		}

		if (msg.length() > 0)
			return msg.toString();
		else
			return null;
    }

    @Override
    public String Alterar(EntidadeDominio entidade) {
    	String nmClasse = entidade.getClass().getName();
        String msg = executarRegrasAlterar(entidade);
        if (msg == null) {
			IDAO dao = daos.get(nmClasse);
			dao.Alterar(entidade);
		} else {
			return msg;
		}
		return null;
    }

    @Override
    public String Excluir(EntidadeDominio entidade) {
    	String nmClasse = entidade.getClass().getName();
        String msg = null;
        try {
			IDAO dao = daos.get(nmClasse);
			dao.excluir(entidade);
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Nao foi possivel excluir...";
		}
		return msg;

    }

    @Override
    public String Consultar(EntidadeDominio entidade) {
    	String nmClasse = entidade.getClass().getName();
        String msg = executarRegras(entidade);
        if (msg == null) {
			IDAO dao = daos.get(nmClasse);
			dao.Consultar(entidade);
		} else {
			return msg;
		}
		return null;
    }
    
}
