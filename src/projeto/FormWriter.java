package projeto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FormWriter {

	//Caminho do arquivo
		private static final String path = "c:/Users/michel/workspace2/NOVOAGRO-seguro/WebContent/novo/arquivo.txt";
		//Método que escreve no arquivo
		public static void writeOnFile(String value) {
			if (value == ""){ 
			}else{
				BufferedWriter bw = null;
				try {
					 bw = new BufferedWriter(new FileWriter(path, true));
			        PrintWriter pw = new PrintWriter(bw);
					//Função para escrever texto no arquivo
					pw.println(value);
					pw.close();
					bw.close();	
						} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		public static String readOnFile() throws IOException { 
			String linha = "";
			BufferedReader br = new BufferedReader(new FileReader(path));
			while(br.ready()){
				linha = br.readLine() + "<HR>"+ linha;
			}
			br.close();
			return linha;
		

		}
		
		public static String getHash(String o)
	    {
	    	try
	    	{
	    		MessageDigest mdAlgorithm = MessageDigest.getInstance("MD5");
	    		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    		ObjectOutputStream oos = new ObjectOutputStream(baos);
	    		oos.writeObject(o);
	    		mdAlgorithm.update(baos.toByteArray());

	    		byte[] digest = mdAlgorithm.digest();
	    		StringBuffer hexString = new StringBuffer();

	    		for (int i = 0; i < digest.length; i++)
	    		{
	    			String x = Integer.toHexString(0xFF & digest[i]);
	    			if (x.length() < 2) x = "0" + x;
	    			hexString.append(x);
	    		}
	    		return(hexString.toString());
	    	}
	    	catch(NoSuchAlgorithmException e) { return(null); }
	    	catch(IOException e) { return(null); }
	    }
}
		

