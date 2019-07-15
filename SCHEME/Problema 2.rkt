#lang racket


;funcion change
;cambia los 1 y 0 de una lista por #t o #f o viceversa segun corresponda
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


;funciones apply[ XFUCTION ]
;aplica la funcion XFUNCTION a una lista segun lo especificado en la tarea
; XFUNCTION ::- [ and or xor ]
(define (applyAnd list)
  (define changed (change list))
  (let hlp ((final '())(act (car changed)) (todo (cdr changed)))
    (cond
      [(empty?  todo)
       final]
      [(and act (car todo))
        (hlp (append final '(1)) (car todo) (cdr todo))]
      [else
        (hlp (append final '(0)) (car todo) (cdr todo))]
     )
    )
)
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
;las 3 funciones anteriores trabajan exactamente igual

;funcion oruga
;aplica las funciones A, O, X segun corresponda a la lista lista
(define (oruga lista)
  (cond
    [(eq? (car lista) 'A)
     (applyAnd (cadr lista)) ]
    [(eq? (car lista) 'O)
     (applyOr (cadr lista))]
    [(eq? (car lista) 'X)
     (applyXor (cadr lista))]
    [else
     (display "lol")
     ]
    )
  )
(oruga '(O (1 1 1 1 0 0 1)))