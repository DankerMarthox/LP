#lang scheme

;funcion applyDouble
;este problema esta mal redactado
;simplemente scheme no funciona asi
;hace lo que quieres que haga
;     *Da-dabs*

(define ((applyDouble i p) value)
  (if (even? value)
      (+ (i value) (p (p value)))
      (+ (i (i value)) (p value))
      )
  )

(define impar (lambda (x) (* x x)))
(define par (lambda (x) (* 2 x)))

((applyDouble (lambda (x) (* x x)) (lambda (x) (* 2 x))) 5)

((applyDouble (lambda (x) (* x x)) (lambda (x) (* 2 x))) 3)

((applyDouble (lambda (x) (* x x)) (lambda (x) (* 2 x))) 6)