#lang racket

#|
   (search arbol nivel listaNodos)
   Busca el final de una rama del arbol, solo va a la derecha cuando la izquierda es nula o ya está vista
   listaNodos indica cuales son los nodos ya visitados, y Nivel indica que tan abajo está.
   retorna una lista ((ultimo nodo visto) (lista de nodos visitados) (nivel mas bajo))
|#


(define (search arbol nivel listaNodos)
  (cond
    [(and (not (null? (cadr arbol))) (not (member (caadr arbol) listaNodos))) (search (cadr arbol) (+ nivel 1) listaNodos)]
    [(and (not (null? (caddr arbol))) (not (member (caaddr arbol) listaNodos))) (search (caddr arbol) (+ nivel 1) listaNodos)]
    [else (list (list (car arbol)) (cons (car arbol) listaNodos) nivel)]
  )
)



#|
     (iteraciones arbol nodosMaximos alturaMaxima nodosVisitados)
  Ejecuta search muchas veces, y listo. Si encuentra un nodo más abajo que el actual, lo guarda.
   Si no, se lo salta, y si son iguales los junta en una lista
   retorna el resultado del problema

|#

(define (iteraciones arbol nodosMaximos alturaMaxima nodosVisitados)
  ;subarbol izquierdo (cadr arbol)
  ;subarbol derecho   (caddr arbol)
  (let [(busqueda (search arbol 0 nodosVisitados))]
     (cond
        [(member 1 (cadr busqueda)) nodosMaximos]
        [else
           (cond
               [(> alturaMaxima (caddr busqueda)) (iteraciones arbol nodosMaximos alturaMaxima (append nodosVisitados (car busqueda)))]
               [(< alturaMaxima (caddr busqueda)) (iteraciones arbol (car busqueda) (caddr busqueda) (append nodosVisitados (car busqueda)))]
               [(equal? alturaMaxima (caddr busqueda)) (iteraciones arbol (append nodosMaximos (car busqueda)) alturaMaxima (append nodosVisitados (car busqueda)))]
           )
        ]
     )
  )
)

(define (hoja arbol)
  (cond
      [(equal? '() arbol) "No hay arbol"]
      [(equal? arbol '(1 () ())) 1]
      [else (let [(resultado (iteraciones arbol '() 0 '()))]
                (cond
                   [(> (length resultado) 1) resultado]
                   [else (car resultado)]
                 )
             )
      ]
   )
)

;(hoja '(1 ( 2 (4 () ()) (5 () ())) (3 (6 () (7 () ())) ())))

;(hoja '(1 (2 (4 (7 () ()) (8 () ())) (5 () ())) (3 () (6 (9 () ()) ()))))

;(hoja '(1 () ()))

;(hoja '())