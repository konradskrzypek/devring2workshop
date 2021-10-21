# Uruchomienie testów

1. "po prostu"

`./gradlew test`

2. Ustawiając poziom logowania

* info
```
./gradlew test -i
./gradlew test --info
```

* debug
```
./gradlew test -d
./gradlew test --debug
```

3. Podając nazwy klas i testów

```
./gradlew test --tests NazwaKlasyTestowej 
./gradlew test --tests org.mojpakiet.NazwaKlasyTestowej 
./gradlew test --tests NazwaKlasyTestowej.nazwaMetodyTestowej
./gradlew test --tests org.mojpakiet.NazwaKlasyTestowej.nazwaMetodyTestowej
```

 Wiele klas lub testów - parametr `--tests` może występować wiele razy
```
./gradlew test --tests NazwaKlasyTestowej --tests org.mojpakiet.NazwaKlasyTestowej
```

 Pattern matching:
```
./gradlew test --tests '*.nazwaKMetodyTestowej'
./gradlew test --tests 'org.mojpakiet.podpakiet.*'
```

 Sprawdzane jest dopasowanie patternu "stringowo" na kwalifikowanej nazwie testu (np. `org.mojpakiet.NazwaKlasyTestowej.nazwaMetodyTestowej`), a więc można matchować np. część nazwy testu
 
 ```
./gradlew test --tests 'org.mojpakiet.podpakiet.NazwaKlasyTestowej.*Linux*'
```

Albo wykonać testy dla wszystkich albo podzbioru klas z pakietu

 ```
./gradlew test --tests 'org.mojpakiet.podpakiet.*'
./gradlew test --tests 'org.mojpakiet.podpakiet.PaczatekNazwy*'
```

4. Dodatkowe parametery

Wykonanie w zależności od:
* "system property" (przekazywanyc do JVM przez `-Dzmienna=wartość`)
``` 
    @EnabledIfSystemProperty(named = "zmienna", matches = "pattern")
    @DisabledIfSystemProperty(named = "zmienna", matches = "pattern")
```
tutaj trzeba pamiętać, że nie wystarczy dodanie -Dzmienna=pattern do wywołania gradle - to jest tylko przekazanie do JVM uruchamiającego gradle, dodatkowo task z testami musi przekazać zmienne do JVM która uruchamia testy, np przez skopiowanie ich w tasku test

```
test {
    systemProperties = System.properties
    useJUnitPlatform()
}

```


* zmiennej środowiskowej
``` 
    @EnabledIfEnvironmentVariable(named = "ENV", matches = "prod")
    @DisabledIfEnvironmentVariable(named = "ENV", matches = "prod")
```

* systemu operacyjnego 

```
    @DisabledOnOs(value = OS.MAC)
    @EnabledOnOs(value = OS.WINDOWS)
```

## Wymuszenie uruchomienia testów
Gradle pamięta co było uruchomione i zapisuje wyniki zadań. Uruchamia taski tylko kiedy jest taka potrzeba, np. bo zmienił sie kod od ostatniego wywołania. Jeśli pomimo to chcemy wywołać testy, można wymusić wykonanie tasków opcją `--rerun-tasks` 

```
./gradlew test --rerun-tasks
```

## Przydatne linki
* JUnit - dokumentacja https://junit.org/junit5/docs/current/user-guide/
* Gradle - wsparcie testów jednostkowych https://docs.gradle.org/current/userguide/java_testing.html


# Asercje JUnit

Statyczne metody klasy `org.junit.jupiter.api.Assertions`

`assertTrue`, `assertEquals` etc.

`assertXxxx(expected, actual, message)`

`message` może być `lazy evaluated`

Asercje na wielu polach
`
    assertAll("address name",
        () -> assertEquals("John", address.getFirstName()),
        () -> assertEquals("User", address.getLastName())
    );
`


## Asumpcje (założenia?)

Inny sposób wyłączania testów

`
Assumptions.assumeFalse(System.getProperty("os.name").contains
("Linux"));
`
# AssertJ

## Dokumentacja (bardzo dobra)
https://assertj.github.io/doc/

Uwaga - póki co pierwszy wynik wyszukiwania AssertJ w google kieruje na starą stronę, zwróć uwagę na aadres