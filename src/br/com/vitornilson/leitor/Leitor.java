package br.com.vitornilson.leitor;

/**
 * @author Vitor Barbosa
 */



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Leitor {

	public static void main(String[] args) {
		
		/**
		 * A String arquivoCSV cont�m o caminho raiz do documento. 
		 * Nesse caso, o documento est� no desktop do meu notebook,
		 * na pasta Documentos teste.
		 * 
		 * @param arquivoCSV
		 */
		
		String arquivoCSV = ("C:\\Users\\Vitor Barbosa\\Desktop\\Documentos teste\\caracteristicasmuncipais.csv");
		
		/**
		 * Um BufferedReader � inicializado fora do bloco try / Catch.
		 * 
		 * @param conteudoCSV
		 */
		BufferedReader conteudoCSV = null;
		
		/**
		 * A String linha � a linha fica inicializada como vazia,
		 * logo ser� preenchida.
		 */
		String linha = "";
		
		/**
		 * A String separadorCSV � o indicador utilizado para separar
		 * cada item. No caso desse CSV foi utilizado ";". Recomendo
		 * abrir o documento com um leitor, bloco de notas mesmo, e verificar
		 * qual � o indicador que separa os itens.
		 */
		String separadorCSV = ";";
		
		/**
		 * Damos inicio ao bloco onde a leitura acontece.
		 */
		try {
			
			/**
			 * O BufferedReader anteriormente criado � instanciado,
			 * e j� � passado como par�metro o FileReader que faz a leitura
			 * do arquivo. O par�metro do FileReader � justamente a String que
			 * cont�m o endere�o do arquivo. Aqui poderia ter sido passado o endere�o
			 * diretamente tamb�m.
			 */
			conteudoCSV = new BufferedReader(new FileReader(arquivoCSV));
			
			/**
			 * Enquanto a pr�xima linha do arquivo n�o for nula.
			 */
			while((linha = conteudoCSV.readLine()) != null) {
				
				/**
				 * Aqui a linha anteriormente � cortada com o m�todo split. 
				 * O par�metro � o separadorCSV = ";"
				 * 
				 * @param linha.split
				 */
				String[] dados = linha.split(separadorCSV);
				
				/**
				 * Nesse ponto, a impress�o da leitura do documento � formatada.
				 * Cada coluna do documento possui um nome e � aqui que ela �
				 * impressa. Cada coluna possui um �ndice.
				 */
				System.out.println("C�digo: " + dados[0] + " "
						+ "Munic�pio: " + dados[1] + " "
						+ "Ano de funda��o: " + dados[2] + " "
						+ "Altitude: " + dados[3] + " "
						+ "Dist�ncia de Macei�: " + dados[4] + " "
						+ "Coordenadas: " + dados[5] + " "
						+ "Clima: " + dados[6] + " "
						+ "Temperatura :" + dados[7] + " ");
			}
			
			}catch (FileNotFoundException ex) {
				System.out.println("Arquivo n�o encontrado");
			}catch (ArrayIndexOutOfBoundsException ex) {
				System.out.println("Index grande");
			}catch(IOException ex){
				
			}finally {
				if (conteudoCSV != null) {
					try{
						conteudoCSV.close();
					}catch(IOException ex) {
						System.out.println("Io ");
					}
				}
			}
			
}}
