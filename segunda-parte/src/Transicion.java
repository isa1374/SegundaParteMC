class Transicion {
	private final String lectura;
	private final String pop;
	private final String push;
	private final Estado Siguiente;

	public Transicion(final String lectura, final String pop, final String push, final Estado Siguiente) {
		this.lectura = lectura;
		this.pop = pop;
		this.push = push;
		this.Siguiente = Siguiente;
	}

	public String getRead() {
		return read;
	}

	public String getPop() {
		return pop;
	}

	public String getPush() {
		return push;
	}

	public PushdownState getSiguiente() {
		return next;
	}
}
