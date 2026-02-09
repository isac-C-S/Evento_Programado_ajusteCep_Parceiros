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
		DynamicVO voParceiro = (DynamicVO) event.getVo();

	    String cep = voParceiro.asString("CEP").trim();
  
	    if (cep == null) return;
	    
	    List<Endereco> pesquisaCep = PesquisaCepHelper.obterDadosDoCepLocal(cep);
	    
	    String cepAtual = pesquisaCep.get(0).getCep();
	    BigDecimal codBairro = pesquisaCep.get(0).getCodBairro();
	    BigDecimal codCidade = pesquisaCep.get(0).getCodCid();
	    BigDecimal codEndereco = pesquisaCep.get(0).getCodEnd();

	    if (pesquisaCep != null && !pesquisaCep.isEmpty()) {
	        if(cepAtual != null && !cepAtual.isEmpty()) voParceiro.setProperty("CEP", cepAtual);
	        if(codBairro != null) voParceiro.setProperty("CODBAI", codBairro);
	        if(codCidade != null) voParceiro.setProperty("CODCID", codCidade);
	        if(codCidade != null) voParceiro.setProperty("CODEND", codEndereco);
	    }
	}

   /**
	* Metodo Para Realizar a Ação Antes da Atualização.
	*/
	@Override
	public void beforeUpdate(PersistenceEvent event) throws Exception {
		DynamicVO voParceiro = (DynamicVO) event.getVo();

	    String cep = voParceiro.asString("CEP").trim();

	    if (cep == null) return;
	    
	    List<Endereco> pesquisaCep = PesquisaCepHelper.obterDadosDoCepLocal(cep);
	    
	    String cepAtual = pesquisaCep.get(0).getCep();
	    BigDecimal codBairro = pesquisaCep.get(0).getCodBairro();
	    BigDecimal codCidade = pesquisaCep.get(0).getCodCid();
	    BigDecimal codEndereco = pesquisaCep.get(0).getCodEnd();

	    if (pesquisaCep != null && !pesquisaCep.isEmpty()) {
	        if(cepAtual != null && !cepAtual.isEmpty()) voParceiro.setProperty("CEP", cepAtual);
	        if(codBairro != null) voParceiro.setProperty("CODBAI", codBairro);
	        if(codCidade != null) voParceiro.setProperty("CODCID", codCidade);
	        if(codCidade != null) voParceiro.setProperty("CODEND", codEndereco);
	    }
		
	}

}
