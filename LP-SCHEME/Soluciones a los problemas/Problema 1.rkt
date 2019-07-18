#lang racket

;funcion factorial
;calcula el factorial de un numero con recursion de cola
(define (factorial x)
  (define (fact-iter a product)
	(if (= a 0)
		product
		(fact-iter (- a 1) (* product a))))
  (fact-iter x 1))

;funcion div lista
;divide una lista en dos de manera tal que la suma de las listas resultantes sea la misma
;usa la funcion factoial para calcular el maximo numero de permutaciones que tiene la lista inicial
;va separando la lista en 2 con el car y el cdr. si queda el cdr vacio se aumenta en 1 el contador de permutaciones (+ 1 iteraciones)
;si el contador de iteraciones es mayor que la cantidad de permutaciones de la lista, retorna F
;esto era un parche xd
(define (div List)
  (define Max (factorial (length List)))
  (define sum (apply + List))
  (if (and (even? sum) (not (empty? List)))
   (let hlp ((l List) (lret '()) (iteraciones 0))  
    (cond
      [(< Max iteraciones)
       (display "F\n")
       ]
      [(= (apply + l) (/ sum 2))
       (append (list l) (list lret))
       ]
      [(empty? l)
       (hlp (reverse(cddr (reverse lret))) (append '() (list (car (reverse lret)) (cadr (reverse lret)))) (+ iteraciones 1) )
       ]
      [else
       (hlp (cdr l) (append lret (list (car l))) iteraciones)
       ]
     )
    )
    (display "F\n")
   )
 )

(div '(4 5 6 7 8))
(div '(1 2 3 4 5 6 7 8))
(div '(1 2 3 4 5 6 7 8 9 10 11))
(div '(5 6 7 8 9 10 11))
(div '(30 31 32 33 34))
(div '(44 45 46 47 48))
(div '(45 46 47 48 49 50 51 52 53 54 55))
