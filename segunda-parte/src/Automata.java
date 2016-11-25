import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Automata {
	public static final char pilaInicio = 'Z';

	private final Stack<String> pila;
	private final List<String> alfabeto;
	private final Estado inicial;

	public Automata(PushdownState inicial, char... alfabeto) {
		this.pila = new Stack<String>();
		this.alfabeto = new LinkedList<String>();
		this.inicial = inicial;

		for (char letra : alfabeto) {
			this.alfabeto.add(String.valueOf(letra));
		}
	}

	public Result testWord(String input) {
		boolean valido = true;

		pila.push(String.valueOf(pilaInicio));

		Estado current = inicial;

		System.out.println("test word [" + input + "]");

		if (!checkInput(input)) {
			System.out.println("No es valido el caracter");
			valido = false;
		}

		for (int i = 0; i < input.length() && valido; i++) {
			String  = String.valueOf(input.charAt(i));

			String pop = pila.pop();

			System.out.print("En el estado [" + current.getName() + "] leer: [" + lectura + "] pop: [" + pop + "] \t");

			Transicion transicion = current.getNext(lectura, pop);

			if (transicion == null) {
				pila.push(pop);

				System.out.println("No es valido no hay transicion");

				valido = false;
			} else {
				String push = transicion.getPush();

				if (!push.isEmpty()) {
					for (int h = 0; h < push.length(); h++) {
						pila.push(push.substring(push.length() - 1 - (h), push.length() - h));
					}
				}

				current = transicion.getNext();

				System.out.println(current.getName() + ", " + pila + ", " + input.substring(i));
			}
		}

		if (!current.final() || pila.empty() || pila.pop().equals(String.valueOf(pilaInicio))) {
			valido = false;
		}

		return new Resultado(pila, input, valido);
	}

	private boolean checarInput(String input) {
		for (int i = 0; i < input.length(); i++) {
			String leer = String.valueOf(input.charAt(i));
			if (!alfabeto.contains(leer)) {
				return false;
			}
		}

		return true;
	}

	public class Resultado {
		private final Stack<String> pila;
		private final String input;
		private final boolean valido;

		public Result(Stack<String> pila, String input, boolean valido) {
			this.pila = new Stack<String>();

			this.pila.addAll(pila);
			this.input = input;
			this.valido = valido;
		}

		public Stack<String> getPila() {
			return pila;
		}

		public String getInput() {
			return input;
		}

		public boolean valido() {
			return valido;
		}
	}
}
