# Pokemon-Project
Dessign pattern used and why:
Builder pentru crearea pokemonilor deoarece exista multi pokemoni care au anumite 
campuri nulle, cum ar fi attack/specialAttack, Ability1, Ability2
builder separa constructia unui obiect complex de reprezentarea sa, astfel incat acelasi
proces de constructie poate duce la reprezentari diferite

Singleton pentru crearea bazei de date pentru a crea o singura instanta de "dictionar" al 
pokemonilor si itemilor, si pentru a furniza un punct global de acces la ea. Singleton e ca o variabila 
globala din punctul de vedere al faptului ca prezinta acces global la instanta.
Constructorul privat asigura ca nu putem crea obiecte in afara clasei

Command pentru crearea celor 3 comenzi pe care le poate da antrenorul (Attack obisnuit, abilitate1,
abilitate2). Pentru Command avem interfata Action care este implementata de cele 3 
actiuni posibile, astfel comenzile au o interfata comuna, invocand tranzactiile in acelasi fel.
Antrenorul alege in mod aleator din lista de comenzi declarata si implementata in main 
actiunea cu care va ataca pokemonul sau in lupta.

Strategy pentru a adauga mai usor evenimente noi. Clasele FightPokemonVsNeutrels si
FightThread implementeaza interfata Strategy. Clasa ContextStrategy este folosita mai apoi in Adventure 
pentru a vedea modificarile de comportament cand se modifica strategia.

