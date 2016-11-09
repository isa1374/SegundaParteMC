# SegundaParteMC

Instrucciones

Realiza un programa en JAVA que lea, de un archivo de texto, los elementos que definen una gramática libre de contexto (en su forma normalizada de Greibach) y que devuelva, en un archivo de texto con formato similar, un atómata d epila equivalente. Además, deberá recibir una cadena y debará devolver si la cadena forma parte del lenguaje producido por la gramática.

El archivo de texto deberá tener el siguiente formato: 

1. El primer renglón indica el conjunto de símbolos no terminales, separados por comas. 
2. El segundo renglón indica el conjunto de símbolos terminales, separador por comas. 
3. El tercer renglón indica el símbolo no terminal inicial. 
4. A partir del cuarto renglón se indican las reglas de producción de la gramática, una regla por renglón, con el ofrmato siguiente: 

                     símbolo_no_terminal->cadena 
        donde: cadena  ∈ (V ∪ Σ)}*, escrito en la forma normal de Greibach
 
 
 Ejemplo: 
 
 La representación en el archivo de texto de la siguiente gramática libre de contexto 
 G= (V, Σ, S, P), será: 
  
 
              V= (A, B) , Σ = (a, b), 
              P: S -> aS|aA
                A->aAB|a
                B->b|lmd 
                
                
               A, B
               a, b
               S
               S-> aS
               S->aA
               A->aAB
               A->a
               B->b
               B->lmd

El archivo resultante deberá tener el formato siguiente: 

1. El primer renglón indica el conjunto de estados, separados or comas. 
2. El segundo renglón indica los símbolos dle afabeto de entrada, separados por comas. 
3. El tercer renglón indica los símbolos del alfabeto de la pila, separados por comas. 
4. El cuatro renglón indica el conjunto de estados finales, separados por comas. 
5. A partir del quinto renglón deberá especificar la función de transición del autómata de pila, en el formato: 
      
      estado, símbolo_alfabeto, símbolo_pila->(estado, símbolo_pila) 
      
Por ejemplo, el autómata de pila equivalente de la gramática anterior será: 

      q0, q1
      a, b
      A, B
      q1
      q0,a,lmd->(q0,lmd)
      q0,a,lmd->(q1,A)
      q1,a,A->(q1, AB)
      q1,a,A->(q1,lmd)
      q1,b,B->(q1,lmd)
      q1,lmd,B->(q1,lmd)
      
Se deberá probar que la cadena w (dada por el usuario) forma parte del lenguaje o no. 

Ejemplo: 

Cadena: aaab 
Se acepta porque:
  
    (q0, aaab, lmd)⊢(q1,ab,AB)⊢(q1,b,B)⊢(q1,b,lmd)

      
