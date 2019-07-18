#lang racket

#|
  (rotar grafo nodoBuscado listaMaestros intentos)

  La funcion busca todos los nodos desde los cuales se puede acceder al nodoBuscado, iterando una cierta cantidad de "intento"
  los cuales dependen del largo del grafo.
  Retorna la lista con los nodos que llevan al nodo buscado.
|#

(define (rotar grafo nodoBuscado listaMaestros intentos)
  (cond
    [(= intentos 0) listaMaestros]
    [(member nodoBuscado (cadar grafo)) (rotar (cdr grafo) nodoBuscado (append listaMaestros (list (caar grafo))) (- intentos 1))]
    [else (rotar (append (cdr grafo) (list (car grafo))) nodoBuscado listaMaestros (- intentos 1))]
   )
)


(define (maestro nodo grafo)
  (let ([listaResultante (rotar grafo nodo '() (length grafo))])
     (cond
       [(> (length listaResultante) 1) listaResultante] ;  NOTA 1
       [(> (length listaResultante) 0) listaResultante] ; NOTA 2
       [(equal? 0 (length listaResultante)) #f]
     )
   )
 )


#| NOTAS: El programa retorna una lista con todos los nodos que llevan al buscado.

   En caso de que si se encuentra más de un maestro se deba retornar falso, se debe cambiar "listaResultante" por "#f" en NOTA 1
   Lo cual implicaría que el resultado no es una lista, por lo que en NOTA 2 se debería cambiar por "(car listaResultante)"

   Se considera que el resultado es una lista, ya que, en el ejemplo el resultado se muestra como "(3)", aunque le falta la apostrofe
#|


(maestro 5 '((1 (2 3)) (2 (3 4)) (3 (4 5)) (4 (2)) (5 (4))))