package Controler.servlets.produtos;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.PRODUTODAO;
import Model.PRODUTOMODEL;


@WebServlet("/adicionaProduto")
public class PRODUTO_SERVLET_ADICINAR extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
		protected void service(HttpServletRequest request,
								HttpServletResponse response)	throws IOException, ServletException {
		
			String msg;
		// pegando os parâmetros do request
			String IDproduto = request.getParameter("IDproduto");  // atributos privados
			String Codigo= request.getParameter("Codigo");  // atributos privados
			String Descricao = request.getParameter("Descricao");  // atributos privados
			String Quantidade = request.getParameter("Quantidade");  // atributos privados
			String Valor = request.getParameter("Valor");  // atributos privados
			String Imagem = request.getParameter("Imagem");  // atributos privados
			
			if(IDproduto==""||Codigo==""||Descricao==""||Quantidade==""||Valor==""){
			 	msg = "Preencha todos os campos!";
		        request.setAttribute("msg", msg);
		 		getServletContext().getRequestDispatcher("/ProdutoCadastrar.jsp").forward(request, response);	 		
			}
		
		// monta um objeto produto
		PRODUTOMODEL produto = new PRODUTOMODEL();
		
		produto.setIDproduto(IDproduto);
		produto.setCodigo(Codigo);
		produto.setDescricao(Descricao);
		produto.setQuantidade(Quantidade);
		produto.setValor(Valor);
		produto.setImagem(Imagem);
		
		
		
		
		// salva o contato
		PRODUTODAO dao = new PRODUTODAO();
		dao.adiciona(produto);
		        
        // Chama pagina de resposta
        getServletContext().getRequestDispatcher("/Index.jsp").forward(request, response); 
        
		
		}
}
		


