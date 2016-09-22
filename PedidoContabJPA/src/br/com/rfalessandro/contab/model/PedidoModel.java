package br.com.rfalessandro.contab.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pedido")
@NamedQueries({@NamedQuery(name="PedidoModel.getAll", query="select p from PedidoModel p ")})
public class PedidoModel extends BaseModel {

	private static final long serialVersionUID = -6472954781201569731L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cdPedido;

	@Column(nullable = false, unique = true, length = 256)
	private String codigo;

	@Column(nullable = false, length = 2048)

	private String descricao;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal valorUnitario;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Calendar dataEmissao;

	@OneToMany(mappedBy = "pedido")
	private List<PedidoProdutoModel> lsProdutos;

	public long getCdPedido() {
		return cdPedido;
	}

	public void setCdPedido(long cdPedido) {
		this.cdPedido = cdPedido;
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

	public Calendar getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Calendar dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public List<PedidoProdutoModel> getLsProdutos() {
		return lsProdutos;
	}

	public void setLsProdutos(List<PedidoProdutoModel> lsProdutos) {
		this.lsProdutos = lsProdutos;
	}

}
