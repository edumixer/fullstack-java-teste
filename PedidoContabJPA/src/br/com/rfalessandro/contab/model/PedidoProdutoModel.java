package br.com.rfalessandro.contab.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedido_produto")
public class PedidoProdutoModel extends BaseModel {

	private static final long serialVersionUID = 9157169086056380788L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cdPedidoProduto;

	@Column(precision = 10, scale = 2)
	private BigDecimal quantidade;

	@OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "cdProduto", nullable=false)
	private ProdutoModel produto; 
 
	@ManyToOne
	@JoinColumn(name = "cdPedido", nullable=false)
	private PedidoModel pedido;

	public long getCdPedidoProduto() {
		return cdPedidoProduto;
	}

	public void setCdPedidoProduto(long cdPedidoProduto) {
		this.cdPedidoProduto = cdPedidoProduto;
	}

	public ProdutoModel getProduto() {
		return produto;
	}

	public void setProduto(ProdutoModel produto) {
		this.produto = produto;
	}

	public PedidoModel getPedido() {
		return pedido;
	}

	public void setPedido(PedidoModel pedido) {
		this.pedido = pedido;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

}
