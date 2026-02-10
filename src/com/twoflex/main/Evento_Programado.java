package com.twoflex.main;

import java.math.BigDecimal;
import java.util.List;

import br.com.sankhya.extensions.eventoprogramavel.EventoProgramavelJava;
import br.com.sankhya.jape.event.PersistenceEvent;
import br.com.sankhya.jape.event.TransactionContext;
import br.com.sankhya.jape.vo.DynamicVO;
import br.com.sankhya.modelcore.util.PesquisaCepHelper;
import br.com.sankhya.modelcore.util.PesquisaCepHelper.Endereco;

/**
 * Classe Principal para o Evento Programado.
 */
public class Evento_Programado implements EventoProgramavelJava  {

   /**
	* Metodo Para Realizar a Ação Apos o Delete.
	*/
	@Override
	public void afterDelete(PersistenceEvent event) throws Exception {
		// TODO Auto-generated method stub
		
	}

   /**
	* Metodo Para Realizar a Ação Apos o Isert.
	*/
	@Override
	public void afterInsert(PersistenceEvent event) throws Exception {
		
		
	}
	
   /**
	* Metodo Para Realizar a Ação Apos a Atualização.
	*/
	@Override
	public void afterUpdate(PersistenceEvent event) throws Exception {
		
		
	}
	
   /**
	* Metodo Para Realizar a Ação Antes do Commit.
	*/
	@Override
	public void beforeCommit(TransactionContext tranCtx) throws Exception {
		
	}

   /**
	* Metodo Para Realizar a Ação Antes do Delete.
	*/
	@Override
	public void beforeDelete(PersistenceEvent event) throws Exception {
		// TODO Auto-generated method stub
		
	}

   /**
	* Metodo Para Realizar a Ação Antes do Insert.
	*/
	@Override
	public void beforeInsert(PersistenceEvent event) throws Exception {
		DynamicVO voParceiro = (DynamicVO) event.getVo(); 	// Obtem o Evento de Persistencia.

	    String cep = voParceiro.asString("CEP"); 			// Obtem o valor do CEP do Evento de Persistencia.
  
	    if (cep == null || cep.trim().isEmpty()) return; 	// Se não Tiver Cep não fara nada.

	    cep = cep.trim(); // Retira os Espaços Extras.
	    
	    List<Endereco> pesquisaCep = PesquisaCepHelper.obterDadosDoCepLocal(cep); // Utiliza o Helper do Sankhya para Obter os dados do Endereço.
	    
	    if (pesquisaCep == null || pesquisaCep.isEmpty()) { // Encerra o Processo Caso nao Tenha Endereço.
	        return; 
	    }
	    
	    Endereco endereco = pesquisaCep.get(0); 		// Obtem os Dados do Endereço.

	    String cepAtual = endereco.getCep(); 			// Obtem o CEP.
	    BigDecimal codBairro = endereco.getCodBairro(); // Obtem o Codigo do Bairro.
	    BigDecimal codCidade = endereco.getCodCid(); 	// Obtem o Codigo da Cidade.
	    BigDecimal codEndereco = endereco.getCodEnd(); 	// Obtem o Codigo do Endereço.

	    if (cepAtual != null && !cepAtual.isEmpty()) voParceiro.setProperty("CEP", cepAtual); 	// Se Existir o CEP Atualiza.
	    if (codBairro != null) voParceiro.setProperty("CODBAI", codBairro); 					// Se Existir o Codigo do Bairro Atualiza.
	    if (codCidade != null) voParceiro.setProperty("CODCID", codCidade); 					// Se Existir o Codigo da Cidade Atualiza.
	    if (codEndereco != null) voParceiro.setProperty("CODEND", codEndereco); 				// Se Existir o Codigo do Endereço Atualiza.
	}

   /**
	* Metodo Para Realizar a Ação Antes da Atualização.
	*/
	@Override
	public void beforeUpdate(PersistenceEvent event) throws Exception {
		DynamicVO voParceiro = (DynamicVO) event.getVo(); 	// Obtem o Evento de Persistencia.

	    String cep = voParceiro.asString("CEP"); 			// Obtem o valor do CEP do Evento de Persistencia.
  
	    if (cep == null || cep.trim().isEmpty()) return; 	// Se não Tiver Cep não fara nada.

	    cep = cep.trim(); // Retira os Espaços Extras.
	    
	    List<Endereco> pesquisaCep = PesquisaCepHelper.obterDadosDoCepLocal(cep); // Utiliza o Helper do Sankhya para Obter os dados do Endereço.
	    
	    if (pesquisaCep == null || pesquisaCep.isEmpty()) { // Encerra o Processo Caso nao Tenha Endereço.
	        return; 
	    }
	    
	    Endereco endereco = pesquisaCep.get(0); 		// Obtem os Dados do Endereço.

	    String cepAtual = endereco.getCep(); 			// Obtem o CEP.
	    BigDecimal codBairro = endereco.getCodBairro(); // Obtem o Codigo do Bairro.
	    BigDecimal codCidade = endereco.getCodCid(); 	// Obtem o Codigo da Cidade.
	    BigDecimal codEndereco = endereco.getCodEnd(); 	// Obtem o Codigo do Endereço.

	    if (cepAtual != null && !cepAtual.isEmpty()) voParceiro.setProperty("CEP", cepAtual); 	// Se Existir o CEP Atualiza.
	    if (codBairro != null) voParceiro.setProperty("CODBAI", codBairro); 					// Se Existir o Codigo do Bairro Atualiza.
	    if (codCidade != null) voParceiro.setProperty("CODCID", codCidade); 					// Se Existir o Codigo da Cidade Atualiza.
	    if (codEndereco != null) voParceiro.setProperty("CODEND", codEndereco); 				// Se Existir o Codigo do Endereço Atualiza.
	}

}
