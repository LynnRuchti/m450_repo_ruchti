# Übung 1
## Aufgabe 1
**1. Unit-Testing:**<br>
Hier bei werden kleine einzelne Teile einer Applikation getestet. Z.B. eine Berechnung von einer Zahl oder die Validierung eines Userinputs.<br>
Diese Teile können auch nur eine Zeile von Code sein.<br><br>
In den Beispielen die ich gemacht habe, würde ich diese Tests während der Produktionsphase schreiben und regelmässig ausführen um Fehler frühzeitig zu bemerken.<br><br><br>

**2. End to End Testing:**<br>
Dabei testet man die ganze Applikation, alles komplet durch, den gesamten Code. Z.B. bei einer Webseite wederden alle Features getestet (nicht nur Frontend sondern auch Backend und DB) oder ein einfaches Java-Terminal-Game komplet durch spielen, verschiedene Szenarien und Mechaniken ausprobieren.<br>
Diese Tests sind sehr Aufwändig, Kostenfällich und nehmen viel Zeit in anspruch.<br><br>
Ich würde diese Art von Testing in der letzten Phase eines Projekts benutzen und sie während der Produktion schreiben.<br><br><br>

**3. Manual Testing:**<br>
Dies kommt dann ins Spiel wenn das automatisierte Testing zu komplex oder nich möglich ist. Somit werden einzelne Features von einer realen Person von Hand getestet. Z.B. bei einer App/Webseite die Benutzerfreundlichkeit und andere Interaktionen eines Users, wie Forms ausfüllen oder Dateien hochladen, getestet.<br><br>
Solche Tests würde ich während der Produktions- oder der letzten Phase benutzen und schreiben.<br><br><br>



## Aufgabe 2
**SW-Fehler:**<br>
Beim Erstellen einer Webseite wird an einer bestimmten Stelle wichtige Informationen nich angezeigt.<br>
**Bsp. (hoher Schaden):** Durch ein Programmfehler werden wichtige Daten falsch abgespeichert. Z.B. Der Geltbetrag aller Users wurde auf 10.- gesetzt. **=> Folgen:** Usern wird der falsche Geldbetrag angezeigt und Transaktionen über 10.- können nicht durchgeführt werden. Das Vertrauen des Users wird gebrochen.<br><br>

**SW-Mangel:**<br>
In einer App gibt es eine Suchleiste, die gewünschten Ergebnisse werden zwar angezeigt aber sie werden nicht wie gewollt Alphabetisch sortiert.<br><br>



## Aufgabe 3
**Main**<br>
```java
public class Main {
    public static void main(String[] args) {
        Testtreiber testtreiber = new Testtreiber();
        if(testtreiber.test_calculate_price()){
            System.out.println("Test ok!");
        }else{
            System.out.println("Test not ok!");
        }
    }
}
``` 
<br><br>

**Testtreiber**<br>
```java
public class Testtreiber {

    boolean test_calculate_price(){

        double price = 1234.56;
        PriceCalculator calculator = new PriceCalculator();

        if(calculator.calculatePrice(price,0, 0, 0, 20)!=987.65) return false;
        if(calculator.calculatePrice(price,78, 0, 0, 20)!=1065.65) return false;
        if(calculator.calculatePrice(price,78, 90, 1, 20)!=1155.65) return false;
        if(calculator.calculatePrice(price,78, 90, 4, 20)!=1146.65) return false;
        if(calculator.calculatePrice(price,78, 90, 5, 20)!=1142.15) return false;
        return true;
    }
}
```
<br><br>

**PriceCalculator**<br>
```java
public class PriceCalculator {

    double calculatePrice(double baseprice, double specialprice, double extraprice, int extras, double discount) {
        double extra_discount;
        double result;

        if (extras >= 5)
            extra_discount = 15;
        else if (extras >= 3)
            extra_discount = 10;
        else
            extra_discount = 0;


        result = baseprice/100.0 * (100-discount) + specialprice
                + extraprice/100.0 * (100-extra_discount);

        return Math.ceil(result * 100.0) / 100.0;   //rundet Endbetrag auf zwei Kommastellen auf/ab
    }
}
```
<br><br>

Logikfehler:<br>
- Im Orginal wäre es nicht möglich gewesen den Rabat für 5 oder mehr Zusätze zu erhalten da es ein else if war. **=>** Also habe ich die Reihenfolge geändert und nun wirds vom Grösten zum Kleinsten geprüft.
- Mir fiehl beim Testen auf, dass das Resultat fiel meht Kommastellen besitzt als man Normalerweise brauchen würde. **=>** Ich habe deshalb und da meine Ergebnisse welche ich zum Testen brauchte nicht so genau waren änderte ich die Endausgabe so ab, dass alle Resultate auf zwei Kommastellen auf oder ab gerundet werden.<br>
