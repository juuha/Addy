###Aihe:
Addy niminen korttipeli, jota voi pelata kahdesta ylöspäin pelaajaa (yli neljällä pelaajalla kortit käyvät vähiin). Pelin tavoitteena on päästä omassa kädessä olevista korteista eroon. 
**Säännöt:** Pelaajat aloittavat pelin 7 korttia kädessä, 1 kortti kuvapuoli ylöspäin pöydällä ja loput kortit pakassa. Omalla vuorollaan, pelaaja pelaa maksimissaan 3 korttia kädestään ja pelaa niitä siten, että 1-3 kortin summan viimeinen numero on sama kuin pöydällä olevan kortin viimeinen luku. Esim: pelaaja voi pelata pata 3:n, risti J:n ja hertta K:n pöydällä olevan ruutu 7:n päälle. (3 + 11 + 13 = 27 -> 7). Pelaaja myös valitsee, mikä korteista jää pakan päällimmäiseksi. Jos pelaaja ei onnistu pelaamaan vuorollaan mitään korttiyhdistelmää, voi hän nostaa pakasta kortin ja koittaa uudestaan. Pakasta voi nostaa omalla vuorollaan enintään 3 korttia, jonka jälkeen jos pelaaja ei onnistu vieläkään pelaamaan mitään tai valitsee olla pelaamatta mitään hän ohittaa vuoronsa ja vuoro siirtyy seuraavalle pelaajalle. Vuoroa ei voi lopettaa, ellei nosta 3:a korttia tai pelaa kortteja pöytään. Ennen jokaista vuoroa, on väli-ikkuna jossa on painike vuoron aloitukseen, joka estää edellisen vuoron pelaajaa näkemästä seuraavan vuoron pelaajan kortteja. Pelaajat eivät myöskään näe mitä kortteja vastustajillaan on heidän käsissä, mutta näkee monta korttia heillä on. Kun pakasta loppuu kortit, sekoitetaan pöydällä olevat kortit takaisin pakkaan.

###Käyttäjät: Pelaajat

####Pelaajien toiminnot:

+ Korttien valitseminen
+ Korttien pelaaminen
+ Korttien nosto
+ Vuoron päättäminen
+ Vuoron aloittaminen



##Rakennekuvaus:
Pelaaja luokka sisältää tiedot pelaajan nimestä, listan korteista joita hänellä on ja tiedon monta korttia on tällä vuorolla nostanut. Pelaajalla voi olla mielimääräinen luku kortteja.
Kortti luokka sisältää tiedot korttien maasta ja arvosta. Kortti voi palauttaa arvonsa, sekä peliarvonsa joka on sama kuin arvo, mutta mod 10.
Pakka luokka sisältää tiedot pakassa olevista korteista ja hoitaa niihin liittyvät asiat. Pakkassa voi olla enintään 52 korttia.
Poyta luokka yhdistää pakan, pelaajan ja kortit siten, että poyta sisältää pakan ja pelaajat. Poyta pitää tiedot siitä, mitä on viimeksi pelattu, kenen vuoro nyt on ja mikä on pöydällä olevien jo pelattujen korttien päällimmäinen kortti. Poyta luokan avulla pystytään muuttamaan pelaajien määrää, lisäämällä tai poistamalla pelaajia siitä. Poydällä voi olla rajattomasti pelaajia, mutta ohjelman rajojen sisällä, siellä voi olla vain kahdesta neljään. Pöydällä on vain yksi pakka.
Vuoro luokka toimii logiikkana kaikessa, joka tapahtuu pelin vuoron aikana. Se valmistelee ja tarkastaa onko pelin eka vuoro suoritettu ja katsoo onko joku voittanut pelin. Vuoro luokka pelaa kortit pöydälle ja huolehtii että jos kortteja pelataan, niin pelaajan kädestä lähtee myös kortteja. Vuoro luokan avulla pelaaja voi nostaa kortin pakasta.
