package br.com.app.conatus.commons.entities;

import java.time.ZonedDateTime;

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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_ENDERECO")
@Builder @AllArgsConstructor @NoArgsConstructor
@Setter @Getter @EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EnderecoEntity {

	@Id @Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDENT")
	private Long id;
	
	@Column(name = "DS_LOGRADOURO")
	private String logradouro;
	
	@Column(name = "DS_NUMERO")
	private String numero;
	
	@Column(name = "CD_CEP")
	private String cep;
	
	@Column(name = "DS_COMPLEMENTO")
	private String complemento;
	
	@Column(name = "DS_BAIRRO")
	private String bairro;
	
	@Column(name = "DS_MUNICIPIO")
	private String municipio;
	
	@Column(name = "SG_UF")
	private String uf;
	
	@TenantId
	@Column(name = "ID_TENANT", insertable = false, updatable = false)
	private String idTenant;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TENANT", referencedColumnName = "CD_TENANT")
	private TenantEntity tenant;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DOM_SITUACAO")
	private DominioEntity situacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USUARIO_ATUALIZACAO")
	private UsuarioEntity usuarioAtualizacao;
	
	@UpdateTimestamp
	@Column(name = "DT_ATUALIZACAO")
	private ZonedDateTime dataAtualizacao;
}
