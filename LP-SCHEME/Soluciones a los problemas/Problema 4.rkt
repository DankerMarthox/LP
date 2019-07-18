#lang racket

#|

Funciones:

 qf: (Queue Factorial)
    Recibe:
       Numero: Numero a calcular
       Total: total acumulado
    Retorna: El factorial del numero recibido
    What-do: look above

 sf: (Stack Factorial)
    Recibe:
       Numero: Numero a calcular
    Retorna: El factorial del numero recibido
    What do: look above again

 hipercola:
    recibe: x, k, N, n: Numeros utilizados para calcular
    retorna: distribucion hipergeometrica
    what-do: aplica la formula de distribucion hipergeometrica con recursion de cola (usando qf)

 hipersimple:
    Lo mismo que la funcion anterior, pero con recursion de stack (usando sf)

|#


(define (qf numero total)
  (cond
    [(= numero 0) (+ total 0)]
    [else (qf (- numero 1) (* total numero))]
  )
)


(define (sf numero)
  (cond
    [(= numero 0) (+ 1 0)]
    [else (* numero (sf (- numero 1)))]
  )
)


(define (hipercola x k N n)
  (exact->inexact (/     (* (qf k 1) (qf n 1) (qf (- N k) 1) (qf (- N n) 1))    (* (qf x 1) (qf N 1) (qf (- k x) 1) (qf (- n x) 1) (qf (- (+ N x) (+ k n)) 1))))
)


(define (hipersimple x k N n)
  (exact->inexact (/     (* (sf k) (sf n) (sf (- N k)) (sf (- N n)))    (* (sf x) (sf N) (sf (- k x)) (sf (- n x)) (sf (- (+ N x) (+ k n))))))
)
