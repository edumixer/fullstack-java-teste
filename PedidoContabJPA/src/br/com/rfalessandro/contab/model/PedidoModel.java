package br.com.rfalessandro.contab.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
 
@Entity
@Table(name = "pedido")
@NamedQueries({
	@NamedQuery(name="PedidoModel.getAll", query="select p from PedidoModel p "),
	@NamedQuery(name="PedidoModel.getAllByCodigo", query="select p from PedidoModel p join fetch p.cliente where p.codigo = ?1"),
	@NamedQuery(name="PedidoModel.getByCdPedido", query="select p from PedidoModel p join fetch p.cliente join fetch p.lsProdutos  where p.cdPedido = ?1")
}) 
public class PedidoModel extends BaseModel {

	private static final long serialVersionUID = -6472954781201569731L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cdPedido;

	@Column(nullable = false,  precision = 15)
	private BigDecimal codigo;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal valorTotal;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Calendar dataEmissao;

	@OneToMany(fetch=FetchType.LAZY, mappedBy = "pedido")
	private List<PedidoProdutoModel> lsProdutos;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "cdCliente", nullable=false)
	private ClienteModel cliente;

	public long getCdPedido() {
		return cdPedido;
	}

	public void setCdPedido(long cdPedido) {
		this.cdPedido = cdPedido;
	}

	

//	public String getDescricao() {
//		return descricao;
//	}
//
//	public void setDescricao(String descricao) {
//		this.descricao = descricao;
//	}

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

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getCodigo() {
		return codigo;
	}

	public void setCodigo(BigDecimal codigo) {
		this.codigo = codigo;
	}

}
