# Repositorio para pruebas de integración continua

Es una versión Java refactorizada de la kata [GildedRose](https://github.com/emilybache/GildedRose-Refactoring-Kata).

Cuenta con una batería de pruebas unitarias en JUnit 5.

Permite la construcción a traves de Maven, cobertura de código en JaCoCo y su escaneo con SonarQube.

## Jenkins

### Plugins
- JUnit
- Coverage
- Html Publisher
- SonarQube Scanner
- Maven Integration

### Configuración

Panel de Control > Administrar Jenkins > Tools > Instalaciones de Maven

    Nombre: maven-last  Instalar desde Apache (versión): 3.9.9
