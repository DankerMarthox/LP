#lang racket

;funcion change oldList
;transforma una list de 0 y 1 a #t o #f segun corresponda
;retorna la lista cambiada
(define (change oldList)
  (let aiura ((ln oldList) (lfinal '()))
    (cond
      [(empty? ln)
       lfinal]
      [(and (number? (car ln)) (= (car ln) 1))
       (aiura (cdr ln) (append lfinal (list #t))) 
       ]
      [(and (number? (car ln)) (= (car ln) 0))
       (aiura (cdr ln) (append lfinal (list #f)))
       ]
       ) ) )

;funcion applyAnd list
;aplica la funcion and a una lista segun se especifica en el enunciado
;retorna la lista correspondiente
(define (applyAnd list)
  (define changed (change list))
  (let hlp ((final '())(act (car changed)) (todo (cdr changed)))
    (cond
      [(empty?  todo)
       final]
      [(and act (car todo))
        (hlp (append final '(1)) (car todo) (cdr todo))]
      [else
        (hlp (append final '(0)) (car
                                  todo) (cdr todo))]
     )
    )
)

;lo mismo que la funcion anterior pero con or
(define (applyOr list)
  (define changed (change list))
  (let hlp ((final '())(act (car changed)) (todo (cdr changed)))
    (cond
      [(empty?  todo)
       final]
      [(or act (car todo))
        (hlp (append final '(1)) (car todo) (cdr todo))]
      [else
        (hlp (append final '(0)) (car todo) (cdr todo))]
     )
    )
)

;lo mismo que la funcion anterior pero con XOR
(define (applyXor list)
  (define changed (change list))
  (let hlp ((final '())(act (car changed)) (todo (cdr changed)))
    (cond
      [(empty?  todo)
       final]
      [(xor act (car todo))
        (hlp (append final '(1)) (car todo) (cdr todo))]
      [else
        (hlp (append final '(0)) (car todo) (cdr todo))]
     )
    )
)

;funcion oruga lista
;aplica la funcion correspondiente segun la letra parametro
;retorna la lista correspondiente al aplicar and|or|xor
;si no existe parametro retorna 'lol'
(define (oruga list)
  (cond
    [(eq? (car list) 'A)
     (applyAnd (cadr list)) ]
    [(eq? (car list) 'O)
     (applyOr (cadr list))]
    [(eq? (car list) 'X)
     (applyXor (cadr list))]
    [else
     (display "lol")
     ]
    )
  )
(oruga '(O (1 1 1 1 0 0 1)))