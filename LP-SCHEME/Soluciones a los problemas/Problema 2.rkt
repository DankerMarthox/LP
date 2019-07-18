#lang racket

#|
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Funcion Binary:
   Recibe:
      Numero: el numero a convertir
      exponente: numero de iteracion (empezando en 0)
      total: donde se guarda el numero
   Retorna: El numero convertido
   What-do: Divide el numero en 2 hasta que se acaba el numero, kek

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Funcion Decbin:
    Recibe:
       Numero: EL numero a convertir
    Retorna: EL numero convertido
    What-do: Llamar a la otra funcion

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
|#


(define (binary numero exponente total)
  (cond
    [(equal? numero 0) (+ 0 total)]
    [(integer? (/ numero 2)) (binary (/ numero 2) (+ exponente 1) total)]
    [else (binary (quotient numero 2) (+ exponente 1) (+ total (expt 10 exponente)))]

  )
)

(define (decbin numero)
  (binary numero 0 0)
)


;(decbin NUMERO)