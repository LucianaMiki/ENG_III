package br.com.fatec.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import br.com.fatec.command.AlterarCommand;
import br.com.fatec.command.ExcluirCommand;
import br.com.fatec.command.ICommand;
import br.com.fatec.command.InserirCommand;
import br.com.fatec.dominio.EntidadeDominio;
import br.com.fatec.viewhelper.IViewHelper;
import br.com.fatec.viewhelper.FilmeVH;
import br.com.fatec.viewhelper.SalaVH;
import br.com.fatec.viewhelper.SessaoVH;
import br.com.fatec.controller.InserirControle;

@WebServlet(urlPatterns = {"/ESIIItest/Salvar"})
public class Controle extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String operacao = null;

    public Controle() {
    	super();
		
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

    	operacao = request.getParameter("operacao");
    	if(operacao.equals("CADASTRAR")) {
    		String acao = null;
    		acao = InserirControle.Inserir(request);
    		if(acao.equals("nullnullnull")) {
    			response.sendRedirect(request.getContextPath() + "/func.jsp");
    			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
    		} else {
    			response.sendRedirect(request.getContextPath() + "/formadd.jsp");
    			JOptionPane.showMessageDialog(null, acao );
    		}
    	}
    	
	    if(operacao.substring(0,6).equals("Editar")) {
	    	List<String> atributos = EditarControle.Editar(request, response, operacao); 
	    	
	    	request.getRequestDispatcher("/formed.jsp"). forward (request, response);
	    }
	    
	    if(operacao.equals("EDITAR")) {
	    	String acao = null;
	    	acao = EditarControle.Alterar(request); 
	    	if(acao.equals("nullnullnull")) {
    			JOptionPane.showMessageDialog(null, "Altercao realizada com sucesso!");
    			response.sendRedirect(request.getContextPath() + "/func.jsp");
    		} else {
    			response.sendRedirect(request.getContextPath() + "/func.jsp");
    			JOptionPane.showMessageDialog(null, acao );
    		}
	    }
	    
	    if(operacao.substring(0,7).equals("Excluir")) {
	    	String acao = null;
	    	acao = ExcluirControle.Excluir(request, operacao);
	    	System.out.println(acao);
	    	if(acao.equals("nullnullnull")) {
	    		response.sendRedirect(request.getContextPath() + "/func.jsp");
    			JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
    		} else {
    			response.sendRedirect(request.getContextPath() + "/func.jsp");
    			JOptionPane.showMessageDialog(null, acao );
    		}
	    }
  
    	/*else {
    	
		String uri = request.getRequestURI();		
		
		IViewHelper vh = vhs.get(uri);
		
		EntidadeDominio entidade = IViewHelper.getEntidade(request);
		
		ICommand cmd = commands.get(operacao);	
		
		Object msg = cmd.executar(entidade);
		
		vh.setView(msg, request, response);
    	}*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}

