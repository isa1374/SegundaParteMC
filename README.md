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
