# MojangStatus-Rewrite
Całkowite przepisanie oryginalnego [MojangStatus](https://github.com/AndusDEV/MojangStatus)

Użyte: [Mojang-API](https://github.com/KevinPriv/MojangAPI), [Gson](https://github.com/google/gson), [Mcsrvstat.us API v2](https://api.mcsrvstat.us/) + kod z oryginału ([MojangStatus](https://github.com/AndusDEV/MojangStatus))
 
 # Instalacja:
 
1. [Pobierz najnowsze wydanie](https://github.com/AndusDEV/MojangStatus-Rewrite/releases/latest)
2. Wejdź do folderu gdzie pobrałeś plik zip
3. Rozpakuj zip
4. Wejdź do rozpakowanego foldeu
5. Postępuj zgodnie z instrukcjami dla swojego systemu operacyjnego:
## Windows
1. Dwukrotnie kliknij _**`run.bat`**_, i poczekaj aż program się włączy. </br>
#### LUB </br>
1. Otwórz Wiersz poleceń w folderze gdzie pobrałeś plik .jar.
2. Wpisz _**`run.bat`**_ </br>
#### LUB </br>
1. Otwórz Wiersz poleceń w folderze gdzie pobrałeś plik .jar.
2. Wpisz _**`java -jar MojangStatus_Rewrite.jar`**_

## Linux
1. Otwórz Wiersz poleceń w folderze gdzie pobrałeś plik .jar.
2. Wpisz _**`java -jar MojangStatus-Rewrite.jar`**_ </br>
#### LUB </br>
1. Kliknij prawym przyciskiem myszy plik .jar
2. Kliknij opcję "Właściwości" -> "Uprawnienia" ("Proporties" -> "Permissions")
3. Zaznacz opcję "Zezwolenie na wykonywanie pliku jako programu" ("Permission to execute a file as a program")
4. Zamknij Okno właściwości
5. Kliknij dwukrotnie plik .jar
## MacOS
1. Otwórz Wiersz poleceń w folderze gdzie pobrałeś plik .jar.
2. Wpisz _**`java -jar MojangStatus-Rewrite.jar`**_

## UUID - Jak działa?
UUID to uniwersalny unikalny identyfikator, który zastępuje twoją nazwę użytkownika w Minecraft w celu zweryfikowania twojej tożsamości.

UUID ma dwie formy:
 1. Przycięte (Trimmed) - nie ma "-"
 2. Pełne (Full) - ma "-"

### Użycie w tej aplikacji

[Mojang-API](https://github.com/KevinPriv/MojangAPI) wspiera tylko pełne UUID (z "-").

Dla przykładu moje pełne UUID to: **_03776c03-4494-4e30-b2e4-6701c05aeb00_**.

Możesz znaleźć swoje UUID na stronach jak: [MCUUID](https://mcuuid.net/).

## Nie jestem związany z Mojangiem. Po prostu tworzę program w oparciu o ich API.
