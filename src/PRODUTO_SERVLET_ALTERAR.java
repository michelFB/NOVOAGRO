import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projeto.PRODUTODAO;
import projeto.PRODUTOMODEL;

@WebServlet("/alteraProduto")
public class PRODUTO_SERVLET_ALTERAR extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request,
								HttpServletResponse response)	throws IOException, ServletException {
		String msg;
			
		// pegando os parâmetros do request
		String IDproduto = request.getParameter("IDproduto");
		String Codigo = request.getParameter("Codigo");
		String Descricao = request.getParameter("Descricao");
		String Quantidade = request.getParameter("Quantidade");
		String Valor = request.getParameter("Valor");
		String Imagem = request.getParameter("Imagem");
		
		// monta um objeto produto
		PRODUTOMODEL produto = new PRODUTOMODEL();
		produto.setIDproduto(IDproduto);
		produto.setCodigo(Codigo);
		produto.setDescricao(Descricao);
		produto.setQuantidade(Quantidade);
		produto.setValor(Valor);
		produto.setImagem(Imagem);
		
		System.out.println(IDproduto);
		System.out.println(Descricao);
		 
		// salva o contato
		PRODUTODAO dao = new PRODUTODAO();
		boolean res = dao.altera(produto);
		if(res==true){
	 		msg = "Produto " + IDproduto + " alterado com sucesso!";
	 	 }else{
	 		msg = "Não foi possivel alterar registro!";
	 	 }	
		// Define parametros para a sessão
        request.setAttribute("msg", msg);
		// Chama pagina de resposta
        getServletContext().getRequestDispatcher("/Index.jsp").forward(request, response); 
        
		
		}
}
		


