# Banken-Simulation Übersicht & Funktionsweise

## Überblick
* **Zweck:** Simulation einer Bankverwaltung mit Konten, Buchungen und Auswertungen.
* **Währung:** Alle Beträge werden in **Millirappen** (long) gehandhabt (vermeidet Rundungsfehler).
* **Datum:** Repräsentiert als Integer (Tage seit 01.01.1970; Basis: 1 Jahr = 360 Tage, 1 Monat = 30 Tage).

---

## Kernklassen & Aufgaben

### `Bank` (Hauptsteuerung)
* `TreeMap<String, Account>`: Verwaltung der Konten (Key: Kontonummer).
* `SavingsAccount` / `SalaryAccount` / `PromoYouthSavingsAccount`: Erzeugung neuer Konten.
* `deposit` / `withdraw`: Weiterleitung von Transaktionen.
* Auswertungen:
  * `printTop5()` / `printBottom5()`: Sortiert und gibt Konten nach Kontostand aus.
  * `getFinalBalance()`: Berechnet den Gesamtsaldo aller Konten.

### `Account` (Abstrakte Basisklasse für Konten)
* **Attribute:** `id` (Kontonummer), `balance` (Saldo), `bookings` (Liste aller Buchungen).
* **`canTransact(date)`:** Prüft, ob Transaktionen chronologisch geordnet sind.
* **`deposit(date, amount)` / `withdraw(date, amount)`:** Validiert Transaktionen und erstellt `Booking`-Einträge.
* **`print()`:** Gibt Kontoauszüge (gesamt oder monatlich gefiltert) aus.

### Specialized Accounts (Spezifische Kontoseiten)
* **`SavingsAccount`:** Sparkonto, erlaubt keine Überziehung.
* **`SalaryAccount`:** Lohnkonto, erlaubt einen festgelegten Überziehungskredit.
* **`PromoYouthSavingsAccount`:** Erbt von `SavingsAccount`, fügt Boni/Gutschriften bei Einzahlungen hinzu.

### Hilfsklassen
* **`Booking`:** Einzelne Transaktion mit `date` und `amount` (+ für Einzahlung, - für Auszahlung).
* **`BankUtils`:** Statische Formatierung von Währung und Datum.
* **`AccountBalanceComparator`:** Vergleicht Konten nach Kontostand für Sortierungen (absteigend).

---

## Beziehungen & Zusammenhänge
1. **`Bank` 1 - * `Account`:** Eine Bank besitzt mehrere Konten.
2. **`Account` 1 - * `Booking`:** Ein Konto enthält mehrere Buchungen.
3. **Vererbung:** 
   * `SavingsAccount` **ist ein** `Account`
   * `SalaryAccount` **ist ein** `Account`
   * `PromoYouthSavingsAccount` **ist ein** `SavingsAccount`
4. **Hilfsaufrufe:** `Account` und `Booking` nutzen `BankUtils` zur Formatierung der Textausgaben.
