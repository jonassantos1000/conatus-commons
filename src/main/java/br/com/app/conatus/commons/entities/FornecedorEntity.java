package br.com.app.conatus.commons.entities;

import java.time.ZonedDateTime;
import java.util.List;

import org.hibernate.annotations.TenantId;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_FORNECEDOR")
@Builder @AllArgsConstructor @NoArgsConstructor
@Setter @Getter @EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FornecedorEntity {

	@Id @Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDENT")
	private Long id;
	
	private String nome;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fornecedor")
	private List<ProdutoEntity> produtos;
	
	@TenantId
	@Column(name = "ID_TENANT", insertable = false, updatable = false)
	private String idTenant;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TENANT", referencedColumnName = "CD_TENANT")
	private TenantEntity tenant;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USUARIO_ATUALIZACAO")
	private UsuarioEntity usuarioAtualizacao;
	
	@UpdateTimestamp
	@Column(name = "DT_ATUALIZACAO")
	private ZonedDateTime dataAtualizacao;
}
