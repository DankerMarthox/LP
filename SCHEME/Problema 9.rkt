#lang scheme

;funcion order list
;separa una lista en dos segun par o impar
;retorna una lista de dos listas, la primera con elementos par o impar segun el primer elmento que encuentre
;la segunda con el contrario
(define (order List)
  (let order-help ( (l List) (l-end '()) (remain '()) )
    (cond
      [(empty? l)
        (list l-end remain) ]
      [(even? (car l))
       (order-help (cdr l) (append l-end (list (car l))) remain ) ]
      [else
       (order-help (cdr l) l-end (append remain (list (car l))) ) ]
      )
    )
   )

;funcion mergelists
;mezcla dos listas intercaladaente
;retorna lista intercalda
(define (merge-lists list1 list2)
  (let merge-help ( (l1 list1) (l2 list2) (l-final '()) )
    (cond
      [(and (empty? l1) (empty? l2))
        l-final
        ]
      [(empty? l1)
       (append l-final l2)
       ]
      [(empty? l2)
       (append l-final l1)
       ]
      [else
       (merge-help (cdr l1) (cdr l2) (append l-final (list (car l1) (car l2))) )
       ]
      )
    )
  )  

;funcion conga
;realiza lo especificado en el enunciado segun corresponda
;hace uso de las funciones anteriores
;y hace la tarea dab
(define (conga List1 List2)
  (define L1 (order List1)) (define L2 (order List2))
  (display L1)(display "\n") (display L2)(display "\n")
  (cond
    [(and (even? (car List1)))
     (merge-lists (merge-lists (car L1) (car L2)) (merge-lists (cadr L1) (cadr L2)))
     ]
    [else
     (append (merge-lists (cadr L1) (car L2)) (merge-lists (cadr L2) (car L1)))
     ]
   )
  )

(conga '(4 5 6 7 8) '(4 5 6 7 9))(display "\n")
(conga '(1 2 3 4 5) '(9 8 10 11 12))(display "\n")
(conga '(3 3 2 5 4 9 2 1) '(4 6 8 10 2 5 5 5))
