package Dados;

import java.awt.Container;

public class Cargo {
	private String nomecargo;
	private double salarioBase;
	private String descricao;
	
	//Construtor
	
	public Cargo(String nomecargo, double salarioBase, String descricao) {
		super();
		this.nomecargo = nomecargo;
		this.salarioBase = salarioBase;
		this.descricao = descricao;
	}
	
	
	//Encapsulamento
	
	public Cargo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getNome() {
		return nomecargo;
	}

	public void setNome(String nomecargo) {
		this.nomecargo = nomecargo;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	//toString
	@Override
	public String toString() {
		return "Cargo [nomecargo=" + nomecargo + ", salarioBase=" + salarioBase + ", descricao=" + descricao + "]";
	}
		
}
