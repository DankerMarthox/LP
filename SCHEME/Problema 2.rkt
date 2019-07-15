#lang racket

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