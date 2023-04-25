# Aufgabe
Erstellen Sie ein Programm zur Navigation in einem öffentlichen Verkehrsnetz. Als Beispiel gilt das U-Bahn-Netz von Taschkent:
![alt text](https://trabercal.com/wp-content/uploads/2021/03/metro-uzbekistan.png?x93690)
Der Benutzer gibt Start und Ziel ein. Das Programm gibt anschließend einen Fahrplan aus, wie dieses Ziel mit den wenigstens Stationen erreicht werden kann.
## Beispiel
### Eingabe:
Start: Toshkent
Ziel: Pushkin
### Ausgabe:
Toshkent (Uzbekistan Line) 
Ming Urik – Oybek (Change to Yunusobod Line)
Amir Temur Xiyoboni - Yunus Rajabiy (Change to Chilonzor Line)
Khamid Alimjan (Chilonzor Line)
Pushkin (Chilonzor Line)
## Details
Das Programm liest am Anfang die einzelnen Linien aus mehreren Textdateien ein, die im Ordner „Lines“ gespeichert sind. Der Dateiname entspricht dem Namen der Linie. Jede Zeile in der Datei entspricht einer Station. (So kann das Programm auch für andere Städte verwendet werden.)
Die U-Bahn kann in beide Richtungen fahren.
Der Benutzer kann Start und Ziel selbst frei wählen.
Als Programmiersprache muss Java verwendet werden.
