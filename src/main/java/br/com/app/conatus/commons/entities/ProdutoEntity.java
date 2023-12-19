package br.com.app.conatus.commons.entities;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import org.hibernate.annotations.TenantId;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
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
@Table(name = "TB_PRODUTO")
@Builder @AllArgsConstructor @NoArgsConstructor
@Setter @Getter @EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProdutoEntity {
	
	@Id @Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDENT")
	private Long id;
	
	@Column(name = "DS_DESCRICAO")
	private String descricao;
	
	@Column(name = "VL_UNIT")
	private BigDecimal valorUnitario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FORNECEDOR")
	private FornecedorEntity fornecedor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DOM_SITUACAO")
	private DominioEntity situacao;
	
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produto", cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.REMOVE})
	private List<ProdutoCategoriaEntity> categorias;

}
