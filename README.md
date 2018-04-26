# Algorithmen und Datenstrukturen

**Hochschule:** HTW Berlin

**Studiengang:** Angewandte informatik

**Fachbereich:** 4

**Dozent:** Prof. Dr. Jürgen Sieck

**Übung:** Prof. Dr.-Ing. V. Brovkov



## Aufgabe 1: Lists

**Aufgabenbeschreibung**

1. Erarbeiten Sie sich die notwendige Datenstruktur einer einfach verkettteten Liste.

Zu speichern sind die Studenten mit Vor- und Nachnamen nebst Matrikelnummer und Studiengang. Entwerfen Sie die notwendigen Datentypen und begründen Sie gegebenenfalls Ihre Wahl.

Implementieren Sie die notwendigen Datentypen in Java unter verwendung von class, interface, enum und den entsprechenden gewählten Datentypen.

2. Implementieren Sie eine Funktion zum Erstellen eines neuen Elements.

2.1 Implementieren Sie eine Funktion zum Hinzufügen eines Elements vor dem ersten Element.

2.2 Implementieren Sie eine Funktion zum Hinzufügen eines Elements nach dem letzten Element.

2.3 Implementieren Sie eine Funktion zur Ausgabe eines Elements der Liste.

2.4 Implementieren Sie eine Funktion zu Ausgabe der gesammten Liste.

2.5 Implementieren Sie eine Funktion zur Ausgabe der Anzahl der Elemente.

2.6 Implementieren Sie eine Funktion zum Löschen eines Elements.

2.7 Implementieren Sie eine Funktion zum Löschen der gesamten Liste.

2.8 Implementieren Sie Funktionalität zum Suchen eines oder mehrerer Studenten nach Vor-und Nachname, Matrikelnummer und Studiengang.

2.9 Implementieren Sie Funktionalität zum Sortieren der Datensätze der Studenten, Matrikelnummer und Studiengang nach zwei selbstgewählten Sortierverfahren.

3. Vergleich Liste / Array

Einige Methoden obiger einfach verketteter Liste lassen sich (im Gegensatz zum Array oder einer doppelt verketteten Liste) effizient (in unterschiedlicher Hinsicht) implementieren, andere nicht unbedingt - welche sind das und warum?

4. Implementierung doppelt verkettete Liste

Implementieren Sie obige Datenstruktur und 4 der oben genannten Funktionalitäten (möglichst laufzeiteffizienter) als doppelt verkettete Liste.

5. Komplexitätsanalyse der Sortierverfahren

Analysieren Sie die Komplexität der von Ihnen implementierten Sortierverfahren allgemein und im speziellen Fall Ihrer Implementierung.


## Aufagbe 2: Stack

**Aufgabenbeschreibung**

Aufgabe: Implementierung Stack
Implementieren Sie einen Stack und ein ausführbares Programm um diesen Stack, bei dem man folgende Funktionen interaktiv in der Kommandozeile ausführen kann (Beispielsweise über ein Menü mit Zahleneingabe)

1. Implementieren Sie die für einen Stack üblichen Funktionen push und pop

2. Implementieren Sie Funktionalität, um ihrem Stack ein Element hinzuzufügen und zu löschen.

3. Implementieren Sie Funktionen zur Ausgabe der Elemente im Stack.

4. Implementieren Sie Funktionalität zur Ausgabe der Anzahl von Elementen im Stack.



## Abgabe 3: RadixSort

**Aufgabenbeschreibung**

1. Erstellen Sie eine Vorgehensweise für die Speicherung einer Zahl (4-stellige Dezimalzahl mit Vorzeichen) in einer Form, die für Radix Sort (siehe Folien 14, 15) geeignet ist.

2. Erstellen Sie eine Vorgehensweise für die Speicherung einer Gruppe von Zahlen entsprechend 1)

3. Implementieren Sie einen Algorithmus für Radix-Sortierung einer Gruppe entsprechend 2)

4. Erstellen Sie eine Konsolenanwendung, die 30 Zahlen entsprechend 1) quasi-zufällig generiert, in einer Datenstruktur entsprechend 2) speichert und diese Daten entsprechend 3) sortiert. Originaldaten, Zwischenzustände und Ergebnis müssen auf der Konsole visualisiert werden.


## Abgabe 4: Hash

**Aufgabenbeschreibung**

1. Implementieren Sie notwendige Funktionen zur Verwaltung einer Hashtabelle (chaining) für Integer-Zahlen.
1.1 insert()
1.2 find()
1.3 delete()
1.4 showAllElements()

2. Implementieren Sie notwendige Funktionen zur Verwaltung einer Hashtabelle (offenes Hashing mit Double-Hash Sondieren) für Integer- Zahlen.

⋅⋅1. insert()⋅⋅
⋅⋅2. find()⋅⋅
⋅⋅3. showAllElements()⋅⋅

3. Erstellen Sie eine Konsole-Anwendung, in der ein Array von 17 Elementen als eine chaining-Hashtabelle mit 14 zufälligen Integers
gefüllt wird und danach Funktionen entsprechend 1) testet

4. Erstellen Sie eine Konsole-Anwendung, in der ein Array von 17 Elementen als eine Hashtabelle (offenes Hashing mit Double Hashing
Sondierung) mit 14 zufälligen Integers gefüllt wird und danach Funktionen entsprechend 2) testet.


