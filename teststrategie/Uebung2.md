# Theorie:
**Teststrategie** und ein **Testkonzept** gehen Hand in Hand. Eine Strategie beschreibt, wie vorgegangen wird beim Testen.<br>
Dabei wird ein Testkonzept erstellt, wo die wichtigsten Elemente für das Testen festgelegt werden. Im Moment beschränken<br> wir uns hier auf die elementaren Faktoren für eine Strategie.<br>
- Testobjekte mit einer kurzen Auflistung aus welchen Teilen die Software besteht
- Auflistung was genau getestet wird (welche Funktionen zu testen sind und welche nicht getestet werden)
- Testmethode auswählen
- Welche Testinfrastruktur verwendet wird<br>

# Übungern:

## Auftrag 1:

## Auftrag 2:
[Webseite](https://www.sixt.ch/)
| ID | Beschreibung               | Erwartetes Resultat               |Effektives Resultat               |Status               |Mögliche Ursache               |
|-----------|-------------------------|-------------------------|-------------------------|-------------------------|-------------------------|
|   1     | Webseite ist erreichbar im Browser. | Nach dem öffnen der Seite wird die Homepage angezeigt und ein Cookies Popup erscheint. | Seite läst sich problemlos öffnen und es wird nach Cookies gefragt. | Erfolgreich | - |
|   2     | Nach Abhol-/Rückgabeort (Winterthur/Genf Flughafen) suchen und hinzufügen. | Während der Eingabe werden Vorschläge angezeigt, die Auswahl wird angezeigt. | Beide Orte wurden in gefunden und angezeigt. | Erfolgreich | - |
|   3     | Ein Abhol-/Rückgabedatum (22.9/22.9) auswählen. | Ein Kalenderinterface erlabt einem ein Datum auszuwählen. | Beide Orte wurden in gefunden und angezeigt. | Erfolgreich | - |
|   4     | Das Alter des Fahrers (24) bestimmen. | Ein Dropdown erscheint und man kann ein Alter (legal/sinnvoll) von einer vorbestimmten Auswahl auswählen. | Dropdown wurde geöffnet und alter konnte von der Auswahl ausgewählt werden. | Erfolgreich | - |
|   5     | Webseite scrolbar. | Beim runter scrolen wird der Rest der seite geladen und angezeigt. Das Autoverlei-Element bleibt darüber verfügbar. | Dropdown wurde geöffnet und alter konnte von der Auswahl ausgewählt werden. | Erfolgreich | - |

## Auftrag 3:
**Black Box Testfälle:**<br>
| Name | Beschreibung               |
|-----------|-------------------------|
| Alle Konten anzeigen. | Der Benutzer kann durch die Eingabe "a" alle Konten auflisten und anschauen. |
| Ein neues Konto erstellen. | Durch die Eingabe "e" kann ein neues Konto erstellt werden, dabei wird der Benutzer aufgefordert einen Nachnahmen und ein Währungskürzel. |
| Einen  Wechselkurs abfragen. | Mit der Eingabe "w" kann der Benutzer einen Wechselkurs, der Eingegeben wurde, aufgerufen. |
| Applikation starten. | Die Applikation kann problemlos vom Benutzer gestartet werden und Begrüsst diesen zubeginn. | 
| Menu benutzen. | Nach dem Starten der Applikation und Beenden einer Aktion wird der Benutzer zurück zum Menu gebracht, von wo aus dann weitere Aktionen möglich sind. | 
| Applikation beenden. | Der Benutzer kann durch die Eingabe "q" die Applikation beenden. | 
<br><br>

**White Box Testfälle:**<br>
| Class | Methode | Beschreibung               |
|-----------|-----------|-------------------------|
| Account | deposit(double amount) | Testen ob sich balance jehnach dem Wert von amount korrekt verändert. |
| Account | withdraw(double amount) | Testen ob balance erfolgreich verändert wurde abhängig von amount. |
| Account | pseudoDeleteAccount() | Testen ob alle Attribute des Kontos auf null/0 gesetzt wurden. |
| Bank | createAccount(String name, Currency currency, double startBalance) | Testen ob ein neues Konto der Liste hinzugefügt wurde. |
| Bank | getAccount(int nr) | Testen ob ein Konto-ID exitsiert oder nicht. |
| Bank | deleteAccount(Account a) | Testen ob ein Konto von der Liste entfehrnt wurde. |
| Counter | convertCurrency(double amount, Currency currencyFrom, Currency currencyTo) | Testen ob der Wechselkurst stimmt und ob die Währung unterstützt wird. |
