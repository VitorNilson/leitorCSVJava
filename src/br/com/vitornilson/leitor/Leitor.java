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
		 * A String arquivoCSV contém o caminho raiz do documento. 
		 * Nesse caso, o documento está no desktop do meu notebook,
		 * na pasta Documentos teste.
		 * 
		 * @param arquivoCSV
		 */
		
		String arquivoCSV = ("C:\\Users\\Vitor Barbosa\\Desktop\\Documentos teste\\caracteristicasmuncipais.csv");
		
		/**
		 * Um BufferedReader é inicializado fora do bloco try / Catch.
		 * 
		 * @param conteudoCSV
		 */
		BufferedReader conteudoCSV = null;
		
		/**
		 * A String linha é a linha fica inicializada como vazia,
		 * logo será preenchida.
		 */
		String linha = "";
		
		/**
		 * A String separadorCSV é o indicador utilizado para separar
		 * cada item. No caso desse CSV foi utilizado ";". Recomendo
		 * abrir o documento com um leitor, bloco de notas mesmo, e verificar
		 * qual é o indicador que separa os itens.
		 */
		String separadorCSV = ";";
		
		/**
		 * Damos inicio ao bloco onde a leitura acontece.
		 */
		try {
			
			/**
			 * O BufferedReader anteriormente criado é instanciado,
			 * e já é passado como parâmetro o FileReader que faz a leitura
			 * do arquivo. O parâmetro do FileReader é justamente a String que
			 * contém o endereço do arquivo. Aqui poderia ter sido passado o endereço
			 * diretamente também.
			 */
			conteudoCSV = new BufferedReader(new FileReader(arquivoCSV));
			
			/**
			 * Enquanto a próxima linha do arquivo não for nula.
			 */
			while((linha = conteudoCSV.readLine()) != null) {
				
				/**
				 * Aqui a linha anteriormente é cortada com o método split. 
				 * O parâmetro é o separadorCSV = ";"
				 * 
				 * @param linha.split
				 */
				String[] dados = linha.split(separadorCSV);
				
				/**
				 * Nesse ponto, a impressão da leitura do documento é formatada.
				 * Cada coluna do documento possui um nome e é aqui que ela é
				 * impressa. Cada coluna possui um índice.
				 */
				System.out.println("Código: " + dados[0] + " "
						+ "Município: " + dados[1] + " "
						+ "Ano de fundação: " + dados[2] + " "
						+ "Altitude: " + dados[3] + " "
						+ "Distância de Maceió: " + dados[4] + " "
						+ "Latitude: " + dados[5] + " "
						+ "Longitude: " + dados[6] + " "
						+ "Clima :" + dados[7] + " "
						+ "Temperatura MÁX: " + dados[8] + " "
						+ "Temperatura MIN: " + dados[9] + " ");
			}
			
			}catch (FileNotFoundException ex) {
				System.out.println("Arquivo não encontrado");
			}catch (ArrayIndexOutOfBoundsException ex) {
				System.out.println("Index grande " +  ex.getMessage());
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
