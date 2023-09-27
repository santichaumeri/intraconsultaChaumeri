package ar.unlam.intraconsulta;

public class Nota {
	
	private TipoNota tipoNota;
	private Integer valor;

	public Nota(TipoNota nota, Integer valor) {
		
		this.tipoNota = nota;
		this.valor = valor;
	}
	
	
	public TipoNota getTipoNota() {
		return tipoNota;
	}
	public void setNota(TipoNota nota) {
		this.tipoNota = nota;
	}
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	
	
	
	
}
