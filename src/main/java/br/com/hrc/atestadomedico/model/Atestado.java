package br.com.hrc.atestadomedico.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "atestado")
public class Atestado implements Serializable{

	private static final long serialVersionUID = 4041601369013862772L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "protocolo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long protocolo;	
	
	@Column(name = "nome_Funcionario" , length = 80 , nullable = false)
	private String nomeFuncionario;
	
	@Column(name = "matricula" , length = 10 , nullable = false)
	private String matricula;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dtcadastro" , nullable = false)
	private Date dtCadastro = new Date();		
	
	@Temporal(TemporalType.DATE)
	@Column(name="dtinicio", nullable = false)
	private Date dtDiaInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_fim", nullable = false)
	private Date dtDiaFim;
	
	@Column(name = "qtidadeDias", nullable = false)
	private Integer qtidadeDia;
	
	@Column(name="cid_10", length = 200, nullable = false)
	private String cid10;	
	
	@Column(name = "unidHospitalar" , length = 20, nullable = false)
	private String unidHosp;
	
	@Column(name = "profMedico" , length = 40, nullable = false)
	private String profMedico;
	
	@Column(name = "numconselho" , length = 10, nullable = false)
	private String numconselho;
	
	@Column(name = "tipoconselho" , length = 3, nullable = false)
	private String tipoconselho;
	
	@Column(name = "uf" , length = 4, nullable = false)
	private String uf;
	
	@Column(name = "observacao", length = 100, nullable = false)
	private String observacao;
	
	@ManyToOne
	@JoinColumn(name = "id_funcionario")
	private Funcionario funcionario;		
	
	// construtor defaut
	public Atestado() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(Long protocolo) {
		this.protocolo = protocolo;
	}
	
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public Date getDtDiaInicio() {
		return dtDiaInicio;
	}

	public void setDtDiaInicio(Date dtDiaInicio) {
		this.dtDiaInicio = dtDiaInicio;
	}

	public Date getDtDiaFim() {
		return dtDiaFim;
	}

	public void setDtDiaFim(Date dtDiaFim) {
		this.dtDiaFim = dtDiaFim;
	}

	public Integer getQtidadeDia() {
		return qtidadeDia;
	}

	public void setQtidadeDia(Integer qtidadeDia) {
		this.qtidadeDia = qtidadeDia;
	}

	public String getCid10() {
		return cid10;
	}

	public void setCid10(String cid10) {
		this.cid10 = cid10;
	}

	public String getUnidHosp() {
		return unidHosp;
	}

	public void setUnidHosp(String unidHosp) {
		this.unidHosp = unidHosp;
	}
	
	public String getProfMedico() {
		return profMedico;
	}

	public void setProfMedico(String profMedico) {
		this.profMedico = profMedico;
	}
	
	public String getNumconselho() {
		return numconselho;
	}

	public void setNumconselho(String numconselho) {
		this.numconselho = numconselho;
	}

	public String getTipoconselho() {
		return tipoconselho;
	}

	public void setTipoconselho(String tipoconselho) {
		this.tipoconselho = tipoconselho;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atestado other = (Atestado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}