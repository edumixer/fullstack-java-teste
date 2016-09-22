package br.com.rfalessandro.contab.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
@NamedQueries({@NamedQuery(name="ClienteModel.getAllByNome", query="select c from ClienteModel c where c.nome = ?1 ")})
public class ClienteModel extends BaseModel {

	private static final long serialVersionUID = 7651560349851796130L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cdCliente;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false, length = 32)
	private String nrDocumento;

	@Column(nullable = false, precision = 1)
	private byte idTipoPessoa;

	@Column(length = 12)
	private String telefone;

	@Column(length = 320)
	private String email;

	public long getCdCliente() {
		return cdCliente;
	}

	public void setCdCliente(long cdCliente) {
		this.cdCliente = cdCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNrDocumento() {
		return nrDocumento;
	}

	public void setNrDocumento(String nrDocumento) {
		this.nrDocumento = nrDocumento;
	}

	public byte getIdTipoPessoa() {
		return idTipoPessoa;
	}

	public void setIdTipoPessoa(byte idTipoPessoa) {
		this.idTipoPessoa = idTipoPessoa;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
