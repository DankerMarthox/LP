#lang racket

#| (rellenar lista)
   recibe una lista (una fila de la matriz), y rellena numeros faltantes.
   retorna las mismas listas, pero rellenando numeros en caso de que se pueda
|#
(define (rellenar lista)
  (cond
    ; En los 3 siguientes casos, una fila tiene 2 o mas incognitas, por lo que se omiten
    [(and (equal? -1 (car lista)) (equal? -1 (cadr lista))) lista]
    [(and (equal? -1 (car lista)) (equal? -1 (caddr lista))) lista]
    [(and (equal? -1 (cadr lista)) (equal? -1 (caddr lista))) lista]

    ; Luego, se revisan los casos con solo 1 incognita, y se completa hasta que sumen 15
    [(equal? -1 (car lista)) (list (- 15 (+ (cadr lista) (caddr lista))) (cadr lista) (caddr lista))]
    [(equal? -1 (cadr lista)) (list (car lista) (- 15 (+ (car lista) (caddr lista))) (caddr lista))]
    [(equal? -1 (caddr lista)) (list (car lista) (cadr lista) (- 15 (+ ( car lista) (cadr lista))))]
    ;A este punto es capaz de tomar una lista de 3 numeros y completar hasta 15
    
    [else lista]
  )
)
; ###########################################################################################################################
; ###########################################################################################################################

 #|
      (columnaX lista1 lista2 lista3)
      cada una de estas funciones realiza lo mismo, pero utilizando distintas columnas de la matriz.

     Al igual que con las filas, revisan si es posible rellenar una columna con los datos existentes

    Retornan la matriz con cambios, si es que se hicieron

 |#

(define (columna1 lista1 lista2 lista3)
  (cond
    [(and (equal? -1 (car lista1)) (equal? -1 (car lista2))) (list lista1 lista2 lista3)]
    [(and (equal? -1 (car lista1)) (equal? -1 (car lista3))) (list lista1 lista2 lista3)]
    [(and (equal? -1 (car lista2)) (equal? -1 (car lista3))) (list lista1 lista2 lista3)]

    [(equal? -1 (car lista1)) (list (cons (- 15 (+ (car lista2) (car lista3))) (cdr lista1)) lista2 lista3)]
    [(equal? -1 (car lista2)) (list lista1 (cons (- 15 (+ (car lista1) (car lista3))) (cdr lista2)) lista3)]
    [(equal? -1 (car lista3)) (list lista1 lista2 (cons (- 15 (+ (car lista1) (car lista2))) (cdr lista3)))]
    
    [else (list lista1 lista2 lista3)]
    
  )
)

; descripcion arriba

(define (columna2 lista1 lista2 lista3)
  (cond
    [(and (equal? -1 (cadr lista1)) (equal? -1 (cadr lista2))) (list lista1 lista2 lista3)]
    [(and (equal? -1 (cadr lista1)) (equal? -1 (cadr lista3))) (list lista1 lista2 lista3)]
    [(and (equal? -1 (cadr lista2)) (equal? -1 (cadr lista3))) (list lista1 lista2 lista3)]

    [(equal? -1 (cadr lista1)) (list (list (car lista1) (- 15 (+ (cadr lista2) (cadr lista3))) (caddr lista1)) lista2 lista3)]
    [(equal? -1 (cadr lista2)) (list lista1 (list (car lista2) (- 15 (+ (cadr lista1) (cadr lista3))) (caddr lista2)) lista3)]
    [(equal? -1 (cadr lista3)) (list lista1 lista2 (list (car lista3) (- 15 (+ (cadr lista1) (cadr lista2))) (caddr lista3)))]
    
    [else (list lista1 lista2 lista3)]
    
  )
)


; descripcion arriba

(define (columna3 lista1 lista2 lista3)
  (cond
    [(and (equal? -1 (caddr lista1)) (equal? -1 (caddr lista2))) (list lista1 lista2 lista3)]
    [(and (equal? -1 (caddr lista1)) (equal? -1 (caddr lista3))) (list lista1 lista2 lista3)]
    [(and (equal? -1 (caddr lista2)) (equal? -1 (caddr lista3))) (list lista1 lista2 lista3)]

    [(equal? -1 (caddr lista1)) (list (list (car lista1) (cadr lista1) (- 15 (+ (caddr lista2) (caddr lista3)))) lista2 lista3)]
    [(equal? -1 (caddr lista2)) (list lista1 (list (car lista2) (cadr lista2) (- 15 (+ (caddr lista1) (caddr lista3)))) lista3)]
    [(equal? -1 (caddr lista3)) (list lista1 lista2 (list (car lista3) (cadr lista3) (- 15 (+ (caddr lista1) (caddr lista2)))))]
    
    [else (list lista1 lista2 lista3)]  
  )
)

; ###########################################################################################################################
; ###########################################################################################################################

#|
  
    diagonalX lista1 lista2 lista3

    Hace exactamente lo mismo que las demas funciones, pero revisando las diagonales principales, y como siempre, las rellena
    si es posible, y retornan la matriz con cambios.

|#

(define (diagonal1 lista1 lista2 lista3)
  (cond
    [(and (equal? -1 (car lista1 )) (equal? -1 (cadr lista2)))  (list lista1 lista2 lista3)]
    [(and (equal? -1 (cadr lista2)) (equal? -1 (caddr lista3))) (list lista1 lista2 lista3)]
    [(and (equal? -1 (car lista1 )) (equal? -1 (caddr lista3))) (list lista1 lista2 lista3)]

    [(equal? -1   (car lista1)) (list (cons (- 15 (+ (cadr lista2) (caddr lista3))) (cdr lista1)) lista2 lista3)]
    [(equal? -1  (cadr lista2)) (list lista1 (list (car lista2) (- 15 (+ (car lista1) (caddr lista3))) (caddr lista2)) lista3)]
    [(equal? -1 (caddr lista3)) (list lista1 lista2 (list (car lista3) (cadr lista3) (- 15 (+ (car lista1) (cadr lista2)))))]
    
    [else (list lista1 lista2 lista3)]  
  )
)

(define (diagonal2 lista1 lista2 lista3)
  (cond
    [(and (equal? -1 (caddr lista1)) (equal? -1 (cadr lista2))) (list lista1 lista2 lista3)]
    [(and (equal? -1 (caddr lista1)) (equal? -1  (car lista3))) (list lista1 lista2 lista3)]
    [(and (equal? -1  (cadr lista2)) (equal? -1  (car lista3))) (list lista1 lista2 lista3)]

    [(equal? -1 (caddr lista1)) (list (list (car lista1) (cadr lista1) (- 15 (+ (cadr lista2) (car lista3)))) lista2 lista3)]
    [(equal? -1  (cadr lista2)) (list lista1 (list (car lista2) (- 15 (+ (caddr lista1) (car lista3))) (caddr lista2)) lista3)]
    [(equal? -1   (car lista3)) (list lista1 lista2 (cons (- 15 (+ (caddr lista1) (cadr lista2))) (cdr lista3)))]
    
    [else (list lista1 lista2 lista3)]  
  )
)

; ###########################################################################################################################
; ###########################################################################################################################


#|

   (iterar matriz intentos)

    Realiza las operaciones definidas arriba, una por una.

   La cantidad de operaciones es para definir un limite de iteraciones que se pueden realizar. Si supera las 8, es que no es posible responder
   Retorna la matriz final.
  
|#

(define (iterar matriz intentos)
  (let [(matriz2 (columna1 (rellenar (car matriz)) (rellenar (cadr matriz)) (rellenar (caddr matriz))))]  
     (let [(matriz3 (columna2 (car matriz2) (cadr matriz2) (caddr matriz2)))]
        (let [(matriz4 (columna3 (car matriz3) (cadr matriz3) (caddr matriz3)))]
           (let [(matriz5 (diagonal1 (car matriz4) (cadr matriz4) (caddr matriz4)))]
              (let [(matriz6 (diagonal2 (car matriz5) (cadr matriz5) (caddr matriz5)))]
                 (cond
                    [(equal? intentos 0) matriz6]
                    [(member -1 (car matriz6))   (iterar matriz6 (- intentos 1))]
                    [(member -1 (cadr matriz6))  (iterar matriz6 (- intentos 1))]
                    [(member -1 (caddr matriz6)) (iterar matriz6 (- intentos 1))]
                    [else matriz6]
                 )
              )
           )
        )
     )
  )
)


(define (magia matriz)
  (let [(resultado (iterar matriz 8))]
    (cond
      ;Se verifican las Filas
      [(not (equal? 15 (+ (car (car resultado)) (cadr (car resultado)) (caddr (car resultado))))) "No se puede resolver con los numeros entregados"]
      [(not (equal? 15 (+ (car (cadr resultado)) (cadr (cadr resultado)) (caddr (cadr resultado))))) "No se puede resolver con los numeros entregados"]
      [(not (equal? 15 (+ (car (caddr resultado)) (cadr (caddr resultado)) (caddr (caddr resultado))))) "No se puede resolver con los numeros entregados"]
      ;Se verifican las Columnas
      [(not (equal? 15 (+ (car (car resultado))       (car (cadr resultado)) (car (caddr resultado))))) "No se puede resolver con los numeros entregados"]
      [(not (equal? 15 (+ (cadr (car resultado))    (cadr (cadr resultado)) (cadr (caddr resultado))))) "No se puede resolver con los numeros entregados"]
      [(not (equal? 15 (+ (caddr (car resultado)) (caddr (cadr resultado)) (caddr (caddr resultado))))) "No se puede resolver con los numeros entregados"]
      ;Se verifican las Diagonales
      [(not (equal? 15 (+ (car (car resultado)) (cadr (cadr resultado)) (caddr (caddr resultado))))) "No se puede resolver con los numeros entregados"]
      [(not (equal? 15 (+ (car (caddr resultado)) (cadr (cadr resultado)) (caddr (car resultado))))) "No se puede resolver con los numeros entregados"]
      
      [else resultado]
    )
  )
)


;(magia '((4 -1 2) (-1 5 7) (-1 1 -1)))

;(magia '((4 -1 -1) (-1 -1 -1) (8 -1 6)));