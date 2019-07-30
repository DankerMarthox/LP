%	
% Hay solo 2 tipos de datos, las parejas, que solo representan a una de las partes
% Y "progenitor", que identifica quién es padre de quien
% En base a esto se hacen todas las consultas
% Todas las consultas tienen el mismo formato de consulta(persona, X)

% Consultas disponibles:
% hijos
% casado
% hermanos
% tios
% sobrinos
% abuelos
% nietos
% bisabuelos
% bisnietos


pareja(daniel, diana).
pareja(patricia, gonzalo).
pareja(angel, carlota).
pareja(marta, mark).
pareja(helena, marti).
pareja(ismael, silvia).
pareja(andres, jimena).
pareja(guillermo, daniela).

progenitor(daniel, gonzalo).
progenitor(daniel, joel).
progenitor(diana, gonzalo).
progenitor(diana, joel).
progenitor(patricia, marta).
progenitor(gonzalo, marta).
progenitor(mark, silvia).
progenitor(marta, silvia).
progenitor(mark, andres).
progenitor(marta, andres).
progenitor(angel, ismael).
progenitor(carlota, ismael).
progenitor(silvia, saul).
progenitor(ismael, saul).
progenitor(andres, laura).
progenitor(jimena, laura).
progenitor(helena, jimena).
progenitor(marti, jimena).
progenitor(helena, guillermo).
progenitor(marti, guillermo).
progenitor(guillermo, izan).
progenitor(daniela, izan).
progenitor(laura, adriana).
progenitor(izan, adriana).

hijos(Padre, Hijo):-
    progenitor(Padre, Hijo).

casado(Conyuge1, Conyuge2):-
    pareja(Conyuge1, Conyuge2); pareja(Conyuge2, Conyuge1).

hermanos(Persona, Hermano):-
    progenitor(Padre, Persona),
    pareja(Padre, Padre2),
    progenitor(Padre2, Hermano),
    Persona \= Hermano.

tios(Persona, Tio):-
    progenitor(Padre, Persona),
    hermanos(Padre, Tio).

sobrinos(Persona, Sobrino):-
    tios(Sobrino, Persona).

abuelos(Persona, Abuelo):-
    progenitor(Padre, Persona),
    progenitor(Abuelo, Padre).

bisabuelos(Persona, Bisabuelo):-
    abuelos(Persona, Abuelo),
    progenitor(Bisabuelo, Abuelo).

bisnietos(Persona, Bisnieto):-
    bisabuelos(Bisnieto, Persona).

nietos(Persona, Nieto):-
    abuelos(Nieto, Persona).




























