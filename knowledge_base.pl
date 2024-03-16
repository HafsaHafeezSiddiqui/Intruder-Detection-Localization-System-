% facts 
apartmentno(1, 1).
apartmentno(1, 2).
apartmentno(1, 3).
apartmentno(2, 1).
apartmentno(2, 2).
apartmentno(2, 3).
apartmentno(3, 1).
apartmentno(3, 2).
apartmentno(3, 3).
apartmentno(4, 1).
apartmentno(4, 2).
apartmentno(4, 3).
apartmentno(5, 1).
apartmentno(5, 2).
apartmentno(5, 3).
apartmentno(6, 1).
apartmentno(6, 2).
apartmentno(6, 3).

% define the goal state

randomize_burglar :-
  random(1, 6, X),
  random(1, 3, Y),
  retractall(burglar(_,_)),
  assertz(burglar(X, Y)).

%burglar(5,3).
goal(X, Y) :- apartmentno(X, Y), burglar(X, Y).


% define the heuristic function
heuristic(X, Y, H) :- goal(Xg, Yg), H is abs(X - Xg) + abs(Y - Yg).

% define the possible moves
move(X, Y, X1, Y1) :- apartmentno(X1, Y1), X1 is X+1, Y1 is Y, apartmentno(X1, Y1).
move(X, Y, X1, Y1) :- apartmentno(X1, Y1), X1 is X-1, Y1 is Y, apartmentno(X1, Y1).
move(X, Y, X1, Y1) :- apartmentno(X1, Y1), X1 is X, Y1 is Y+1, apartmentno(X1, Y1).
move(X, Y, X1, Y1) :- apartmentno(X1, Y1), X1 is X, Y1 is Y-1, apartmentno(X1, Y1).

% define the path-checking predicate
path(X, Y, X, Y, Path, Visited) :- Path = [(X, Y)|Visited].
path(X, Y, X1, Y1, Path, Visited) :-
  setof((X2, Y2), (move(X, Y, X2, Y2), heuristic(X2, Y2, _), \+ member((X2, Y2), Visited)), NextMoves),
  member((X2, Y2), NextMoves),
  path(X2, Y2, X1, Y1, Path, [(X2, Y2)|Visited]).

% define the predicate to find the path
find_path(X, Y, Path) :- randomize_burglar, goal(X, Y), path(1, 1, X, Y, Path, []).
