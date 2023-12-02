package br.com.app.conatus.commons.entities.factory;

import br.com.app.conatus.commons.entities.DominioEntity;
import br.com.app.conatus.commons.entities.PessoaFisicaEntity;
import br.com.app.conatus.commons.entities.UsuarioEntity;
import br.com.app.conatus.commons.model.request.UsuarioRecordRequest;

public class UsuarioEntityFactory {

	private UsuarioEntityFactory() {}

	public static UsuarioEntity converterParaEntity(UsuarioRecordRequest usuario, PessoaFisicaEntity pf, String hashSenha, DominioEntity situacaoAtiva) {
		
		return UsuarioEntity.builder()
				.pessoa(pf)
				.situacao(situacaoAtiva)
				.senha(hashSenha)
				.build();
	}
	
}
