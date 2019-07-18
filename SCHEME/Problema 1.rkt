#lang racket

;funcion factorial
;calcula fatorial izi pizi
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
(define (div2 List)
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


;funcion div
;hace lo mismo que la anterior, pero con un corte limpio, me gusta mas la anterior asi que la dejé
;dab
(define (div List)
  (define sum (apply + List))
  (if (and (even? sum) (not (empty? List)))
   (let hlp ((l List) (lret '()))  
    (cond
      [(= (apply + l) (/ sum 2))
       (reverse (append (list l) (list lret)))
       ]
      [(empty? l)
       (display "F\n")
       ]
      [else
       (hlp (cdr l) (append lret (list (car l))))
       ]
     )
    )
    (display "F\n")
   )
  )

(div2 '(4 5 6 7 8))
(div2 '(1 2 3 4 5 6 7 8))
(div2 '(1 2 3 4 5 6 7 8 9 10 11))
(div2 '(5 6 7 8 9 10 11))
(div2 '(30 31 32 33 34))
(div2 '(44 45 46 47 48))
