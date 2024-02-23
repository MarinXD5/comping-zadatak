# comping-zadatak

Prilikom prijave za posao za Java Developera u Comping, bilo je potrebno riješiti zadatak i pohraniti ga u GitHub repozitorij.
Ovdje se nalazi source code za zadani zadatak.

## Instalacija

Prilikom instalacije ovog programa, potrebno je lokalno klonirati ovaj repozitorij. Nakon toga, potrebno je otvoriti program u jednom od IDE-ova: Intellij, Eclipse, VSC...
Nakon otvaranja projekta u IDE-u, potrebno je pokrenuti program klikom na zelenu strelicu da bi se započelo izvršavanje programa.

## Testiranje API-ja

Svaki API poziva jednu controller metodu. 

### Kreiranje novih podataka

Za kreiranje novih entrya u bazi podataka, potrebno je prvo kreirati novog pruzatelja. Razlog tomu je, jer iako postoji veza vise-na-vise, jedna strana mora biti "owning" strana. Za potrebe
ovog zadatka to je Usluga. Stoga, da bi se mogli kreirati i vezati podaci u međutablici, potrebno je prvo kreirati pružatelja service, a zatim samu uslugu. Da bi se kreirao novi pružatelj usluge
potrebno je pozvati:

http://localhost:8080/new-pruzatelj (POST) i u requestbody upisati:

{
    "nazivPruzatelja": "some-random-value"
}

Da bi se zatim kreirala nova service, potrebno je pozvati:

http://localhost:8080/new-service (POST) i u requestbody upisati:

{
    "opisUsluge": "Default service description3",
    "pruzateljiUsluge": [ //ID mora bit koji vec postoji, ovo je demonstrature radi samo //
        {"id": 3},
        {"id": 4}
    ]
}

Nakon pozivanja /new-service endpointa kreirat će se veza u međutablici usluga_id : pruzatelj_usluge_id

### Dohvaćanje podataka

#TODO
