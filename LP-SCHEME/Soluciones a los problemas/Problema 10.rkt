#lang racket

#|
   (crearCajeros numeroCajeros listaCajeros)
   en numeroCajeros se recibe la cantidad de cajeros existentes, los cuales se guardan en listaCajeros
   Retorna una lista con los cajeros
|#

(define (crearCajeros numeroCajeros listaCajeros)
  (cond
    [(>  numeroCajeros 0) (crearCajeros (- numeroCajeros 1) (cons (cons numeroCajeros (list '(0))) listaCajeros))]
    [(equal? 0 numeroCajeros) listaCajeros]
  )
)

#|
   (obtenerMenor numeroCajeros listaCajeros maximo indiceMenor)
   obtenerMenor retorna el numero del cajero que tiene el numero menor de tiempo
   listaCajeros: lista con los cajeros y su tiempo. numeroCajeros es la cantidad de cajeros; maximo es el tiempo mas grande encontrado actualmente
   indiceMenor es la caja con el menor tiempo
   La funcion retorna el proximo cajero que debe ser usado
|#
(define (obtenerMenor numeroCajeros listaCajeros maximo indiceMenor)
  (cond
    [(equal? numeroCajeros 0) indiceMenor] 
    [(> maximo (caadar listaCajeros)) (obtenerMenor (- numeroCajeros 1) (cdr listaCajeros) (caadar listaCajeros) (caar listaCajeros))]
    [(<= maximo (caadar listaCajeros)) (obtenerMenor (- numeroCajeros 1) (cdr listaCajeros) maximo indiceMenor)]
   )
)


#|
   (aumentarCaja indiceBuscado listaCajeros aumento)
   la funcion toma la lista con los cajeros y el indice con la caja mas desocupada, a la cual le aumenta la cantidad necesaria
   retorna la lista actualizada
|#

(define (aumentarCaja indiceBuscado listaCajeros aumento)
  (cond
    [(equal? aumento 0) (begin
                            (cond
                              [(equal? (caar listaCajeros) 1) listaCajeros]
                              [else (aumentarCaja 1 (append (cdr listaCajeros) (list (car listaCajeros))) 0)]
                             )
                          )]
    [(equal? indiceBuscado (caar listaCajeros)) (aumentarCaja 1 (cons (cons indiceBuscado (list (list (+ aumento (caadar listaCajeros)))))(cdr listaCajeros)) 0)]
    [else (aumentarCaja indiceBuscado (append (cdr listaCajeros) (list (car listaCajeros))) aumento)]
  )
)


#|
    (iterarLista listaOrden listaCajeros listaIngresos numeroCajeros)
    listaOrden es la lista que se entrega como resultado del problema, y listaIngresos es la lista que se ingresa como parametro al iniciar la funcion
    retorna el resultado
|#

(define (iterarLista listaOrden listaCajeros listaIngresos numeroCajeros)
  (cond
    [(equal? listaIngresos '()) listaOrden]
    [else (begin
             (let ([indiceMenor (obtenerMenor numeroCajeros listaCajeros +inf.0 0)])
               (iterarLista (append listaOrden (list indiceMenor)) (aumentarCaja indiceMenor listaCajeros (car listaIngresos)) (cdr listaIngresos) numeroCajeros)
             )
           )
    ]
  )
 )


(define (caja cajeros lista)
  (cond
    [(equal? lista '()) "No hay lista."]
    [(> cajeros 0) (iterarLista '() (crearCajeros cajeros '()) lista cajeros)]
    [(equal? cajeros 0) "No hay cajeros."]
  )
)


(caja 3 '(406 424 87 888 871 915 516 81 275 578))