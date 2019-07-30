


% las consultas deben ser del tipo
% todos_caminos(X, L1, Z), donde
% X es la ciudad desde la que se quiere partir
% L1 es la lista a las ciudades que se puede llegar
% Z es la cantidad de tiempo disponible

%	nombres ciudades:
%	gp: greenpath, cr: crossroad
%	cn: canyon, dm: dirtmount
%	bl: bluelake, cp: cristal peak
%	rg: resting grounds
%	ed: edge, hv: hive
%	ct: city of tears
%	fg: fungal, gd: garden
%	bd: beast den, ww: waterways
%	dn: deepnest 
%		camino(a,b,c)
%	arista desde ciudad a hasta 
%	ciudad b con duracion 
%	de viaje c
%
% camino de ida	
camino(gp,cr, 4).
camino(gp, cn, 10).
camino(gd, cn, 12).
camino(bd, dn, 8).
camino(dn, fg, 10).
camino(gd, fg, 16).
camino(dm, cp, 5).
camino(dm, cr, 1).
camino(cr, fg, 5).
camino(fg, ww, 10).
camino(cr, ct, 4).
camino(cr, bl, 2).
camino(bl, rg, 3).
camino(cp, rg, 8).
camino(rg, ed, 14).
camino(ct, rg, 3).
camino(ct, ww, 7).
camino(ww, ed, 6).
camino(ed, hv, 3).
camino(cn, fg, 3).

% camino de vuelta
camino(cr, gp, 4).
camino(cn, gp, 10).
camino(cn, gd, 12).
camino(dn, bd, 8).
camino(fg, dn, 10).
camino(fg, gd, 16).
camino(cp, dm, 5).
camino(cr, dm, 1).
camino(fg, cr, 5).
camino(ww, fg, 10).
camino(ct, cr, 4).
camino(bl, cr, 2).
camino(rg, bl, 3).
camino(rg, cp, 8).
camino(ed, rg, 14).
camino(rg, ct, 3).
camino(ww, ct, 7).
camino(ed, ww, 6).
camino(hv, ed, 3).
camino(fg, cn, 3).


caminos(X,Y,P):-
    		caminos(X,Y,P,[X]).
			
caminos(X,Y,P,_):-
		    camino(X,Y,P).

caminos(X,Y,P, Temp):-
    		camino(X,B,P1), not(member(B,Temp)),
    		append(Temp,[B],Temp1), caminos(B,Y,P2,Temp1), P is P1 + P2.

todos_caminos(X, L1, Z) :- 
    findall(Y,(caminos(X, Y, V), V =< Z),L2), sort(L2,L1).