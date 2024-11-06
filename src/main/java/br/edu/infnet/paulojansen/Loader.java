package br.edu.infnet.paulojansen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.paulojansen.model.domain.Endereco;
import br.edu.infnet.paulojansen.model.domain.Passageiro;
import br.edu.infnet.paulojansen.model.service.PassageiroService;

@Component
public class Loader implements ApplicationRunner {
	
	@Autowired
	private PassageiroService passageiroService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Iniciando loader...");
		Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
		Statement stmt = conn.createStatement();

        String sql = "CREATE TABLE IF NOT EXISTS produto (" +
                     "id INT AUTO_INCREMENT PRIMARY KEY, " +
                     "nome VARCHAR(255), " +
                     "preco DECIMAL(10, 2))";
        stmt.execute(sql);

        System.out.println("Banco de dados H2 em memória criado com sucesso!");


		FileReader file = new FileReader("files/passageiros.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();	
		while(linha != null ) {
			String[] campos = linha.split(";");

			Passageiro passageiro = null;
			switch (campos[0].toUpperCase()) {
			case "P":
				//passageiro = new Passageiro(campos[1], campos[2], campos[3]);
				passageiro = new Passageiro();
				passageiro.setNome(campos[1]);
				passageiro.setCpf(campos[2]);
				passageiro.setEmail(campos[3]);
				
				Endereco endereco = new Endereco();
				endereco.setCep("09110090");
				//passageiro.setEndereco(endereco);
				
				passageiroService.incluir(passageiro);
				
				break;
			case "R":
				break;
			default:
				break;
			}
			
			linha = leitura.readLine();			
		}
		
		for(Passageiro passageiro: passageiroService.obterLista()) {
			//System.out.println(passageiro);
		}
		
		leitura.close();
	}

}
