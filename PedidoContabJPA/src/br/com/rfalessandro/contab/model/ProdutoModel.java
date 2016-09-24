package br.com.rfalessandro.contab.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
@NamedQueries({@NamedQuery(name="ProdutoModel.getAllByDesc", query="select p from ProdutoModel p where p.descricao like ?1 ")})
public class ProdutoModel extends BaseModel {

	private static final long serialVersionUID = -1240937475687494335L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cdProduto;

	@Column(nullable = false)
	private String codigo;

	@Column(length = 2048)
	private String descricao;

	@Column(precision = 10, scale = 2)
	private BigDecimal valorUnitario;

	public long getCdProduto() {
		return cdProduto;
	}

	public void setCdProduto(long cdProduto) {
		this.cdProduto = cdProduto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

}
