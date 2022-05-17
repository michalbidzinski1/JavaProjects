# Zadanie: Koszyk Internetowy

| Termin oddania | Punkty     |
|----------------|:-----------|
| 13.05.2022  23:00   |  10        |

--- 
Przekroczenie terminu o **n** zajęć wiąże się z karą:
- punkty uzyskania za realizację zadania są dzielone przez **2<sup>n</sup>**.

--- 

Twoja firma dostała zlecenie na stworzenie oprogramowania dla dużego sklepu internetowego *JavaMarkt*. 
Jedną z podstawowych funkcjonalności jest oprogramowanie koszyka zakupów, 
który potrafi uwzględniać różne promocje, rabaty oraz oferty specjalne, takie jak:
- jeśli wartość zamówienia jest większa niż 300 zł klient otrzymuje 5% zniżki na zakupione towary
- jeśli klient kupi 2 produkty to 3 najtańszy otrzymuje gratis
- jeśli wartość zamówienia przekracza wartość 200 zł klient otrzymuje firmowy kubek gratis
- jednorazowy kupon rabatowy 30% na wybrany produkt
oraz wiele innych jeszcze nieznanych na tym etapie implementacji. 
Promocje mogą się zmieniać w trakcie działania programu, tj. mogą się pojawiać nowe a istniejące mogą znikać.

Towary w koszyku powinny być posegregowane malejąco według ceny, 
a potem według kolejności alfabetycznej nazw produktów. 
Sposób sortowania może produktów może się zmieniać w trakcie działania programu. 

Twoim zadaniem jest zaimplementowanie logiki, operującej na obiektach typu ``Product``, 
która umożliwiałaby:
1. Wyszukiwanie najtańszego/najdroższego produktu w zadanej kolekcji produktów
2. Wyszukiwanie n najtańszych/najdrożyszych produktów w zadanej kolekcji produktów
3. Sortowanie kolekcji produktów po cenie jak i po nazwie
4. Wyliczanie sumy cen wszystkich zadanych produktów
6. Aplikowanie opisanych powyżej rodzajów promocji na zadanej kolekcji produktów w koszyku

Cechy związane z klasą ``Product``:
- kod produktu (code) - String
- nazwa produktu (name) - String
- cena produktu (price) – double
- cena produktu po uwzględnieniu promocji (discountPrice) - double

W tym zadaniu użyj tablicy produktów jako kolekcji, na której będziesz operował.

---

### Uwaga 1
Projekt powinien zawierać odpowiednie testy jednostkowe do implementowanej funkcjonalności.

### Uwaga 2
Implementując koszyk i promocje zwróć uwagę na wzorzec projektowy [Command](https://www.oodesign.com/command-pattern.html).

### Uwaga 3
Planując mechanizm sortowania zwróć uwagę na [Dependency Inversion Principle](https://www.oodesign.com/dependency-inversion-principle.html) oraz 
interfejsy dostępne w Java: ``Comparable`` oraz ``Comparator``.
