package br.com.app.conatus.commons.model.response;

import lombok.Builder;

@Builder
public record DominioResponse(
		
		Long id,
		String descricao,
		String codigo) {
}
