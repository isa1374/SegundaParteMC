
import java.util.LinkedList;
import java.util.List;


public class Estado {
	private String name;

	private boolean final = false;

	private List<Transicion> Transiciones;

	public Estado(String nombre) {
		this.Transiciones = new LinkedList<Transicion>();
		this.nombre = nombre;
	}

	public Estado agregarTransicion(String lectura, String pop, String push, Estado Siguiente) {
		Transiciones.add(new Transicion(lectura, pop, push, Siguiente));
		return this;
	}

	public Transicion getSiguiente(String lectura, String pop) {
		for (Transicion transicion : Transiciones) {
			if (transicion.getRead().equals(lectura) && transicion.getPop().equals(pop)) {
				return transicion;
			}
		}

		return null;
	}

	public String getNombre() {
		return this.name;
	}

	public void setFinal(boolean final) {
		this.final = final;
	}

	public void setFinal() {
		this.final = true;
	}

	public boolean final() {
		return this.final;
	}
}
