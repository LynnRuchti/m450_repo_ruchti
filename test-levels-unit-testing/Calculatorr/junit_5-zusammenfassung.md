# JUnit 5 Zusammenfassung & Wichtigste Features

JUnit 5 ist das Standard-Framework für Unit-Tests in Java.

---

## Grundlegende Annotationen (Lifecycle)

Mit den Lifecycle-Annotationen lässt sich steuern, wie und wann ein Test, vor oder nach einzelnen Testmethoden ausgeführt wird.

* `@Test`: Markiert eine Methode als Test.
* `@BeforeEach`: Dieser Test wird vor jedem Test ausgeführt.
* `@AfterEach`: Dieser Test wird nach jedem Test ausgeführt..
* `@BeforeAll`: Dieser Test wird einmal vor allen Tests der Klasse ausgeführt (muss static sein).
* `@AfterAll`: Dieser Test wird einmal nach allen Tests der Klasse ausgeführt (muss static sein).

### Beispiel:
```java
class CalculatorTest {

    @BeforeAll
    static void initAll() {}        //Wird einmal zu Beginn ausgeführt (z.B. Datenbankverbindung öffnen)

    @BeforeEach
    void init() {}        //Wird vor jedem Test aufgerufen

    @Test
    void testAddition() {}        //Normaler Test

    @AfterEach
    void tearDown() {}        //Nach jedem Test ausgeführt
}
```

---

## Assertions

Assertions verifizieren das erwartete Ergebnis mit dem tatsächlichen Resultat.

* `assertEquals(expected, actual)`: Überprüft Gleichheit.
* `assertTrue(condition)` / `assertFalse(condition)`: Prüft ob True/False.
* `assertNull(object)` / `assertNotNull(object)`: Prüft ob null.
* `assertAll(...)`: Bündelt mehrere Assertions. Alle werden ausgeführt, selbst wenn eine davon fehlschlägt (Soft Assertions).

### Beispiel:
```java
@Test
void testUserProperties() {
    User user = new User("Anna", 25);

    //Grouped Assertions: Alle Validierungen werden geprüft
    assertAll("User Validierung",
        () -> assertEquals("Anna", user.getName()),
        () -> assertEquals(25, user.getAge()),
        () -> assertNotNull(user)
    );
}
```

---

## Testen von Exceptions

Mit `assertThrows` lässt sich überprüfen, ob eine Methode bei ungültigen Eingaben die erwartete Exception wirft.

### Beispiel:
```java
@Test
void testDivideByZero() {
    Calculator calc = new Calculator();

    //Prüft, ob eine ArithmeticException geworfen wird
    Exception exception = assertThrows(ArithmeticException.class, () -> {
        calc.divide(10, 0);
    });

    assertEquals("/ by zero", exception.getMessage());
}
```

---

## Deaktivieren und Anpassen von Tests

* `@Disabled`: Deaktiviert einen Test temporär (z. B. wenn ein Bug noch ungelöst ist).
* `@DisplayName`: Vergibt eine lesbare Bezeichnung für Testklassen oder -methoden.

### Beispiel:
```java
@Test
@DisplayName("Sonderzeichen sollten korrekt gefiltert werden")
void testSpecialCharacterFiltering() {
}

@Test
@Disabled("Wartet auf Behebung von Issue #104")
void testLegacyFeature() {
    //Dieser Test wird übersprungen
}
```

---


## Referenzen 

[JUnit 5 User Guide (Offizielle Referenz)](https://junit.org/junit5/docs/current/user-guide/)<br>
=> Die umfassendste und aktuellste Dokumentation mit allen Details zur API, Konfiguration und Integration.