# Contact List Automation Web

Automatización de pruebas end-to-end para [Contact List](https://thinking-tester-contact-list.herokuapp.com), con Java, Serenity BDD, Cucumber y el patrón Screenplay. Valida registro de usuarios, inicio de sesión y creación de contactos mediante Google Chrome.

## Tecnologías

Versiones declaradas en `pom.xml`:

| Tecnología | Versión | Uso |
| --- | --- | --- |
| Java | 21 | Lenguaje y compilación |
| Serenity BDD | 4.2.34 | Automatización, Screenplay y reportes |
| Cucumber | 7.22.2 | Escenarios Gherkin y definición de pasos |
| JUnit | 4.13.2 | Ejecución del runner |
| WebDriverManager | 5.7.0 | Configuración de ChromeDriver |
| Maven Surefire Plugin | 3.3.0 | Ejecución de pruebas en Maven |

## Requisitos

- JDK 21 y Google Chrome instalados.
- IntelliJ IDEA con el proyecto importado como Maven y JDK 21 seleccionado para el proyecto y el ejecutor de Maven.
- Conexión a la aplicación y a los repositorios de dependencias y controladores. El hook configura ChromeDriver con WebDriverManager antes de cada escenario.
- Para ejecutar desde terminal: Maven instalado y disponible en `PATH`, con `JAVA_HOME` apuntando al JDK. Comprobar con `java -version` y `mvn -version`.

## Arquitectura

```text
contact-list-automation-web/
├── pom.xml
├── README.md
└── src/
    ├── main/java/testing/
    │   ├── questions/           # Consultas de URL, mensajes y contactos visibles
    │   ├── tasks/               # Navegación, formularios, login y clics
    │   └── ui/home/             # Localizadores Target de las pantallas
    └── test/
        ├── java/testing/
        │   ├── runners/        # CucumberTestSuite
        │   └── stepDefinitions/
        │       ├── addContact/
        │       ├── addUser/
        │       ├── commons/
        │       ├── hooks/      # Preparación del escenario y gestión del driver
        │       └── login/
        └── resources/
            ├── features/
            │   ├── addNewContact.feature
            │   ├── addUser.feature
            │   └── login.feature
            └── serenity.conf
```


## Ejecución desde IntelliJ IDEA

1. Abrir **View → Tool Windows → Maven** y recargar las dependencias. Desactivar **Work offline** para permitir descargas.
2. Seleccionar **Execute Maven Goal**. También se puede buscar esta acción con `Ctrl + Shift + A`.
3. Introducir lo siguiente **sin escribir `mvn` al principio**:

```text
-U verify
```
`verify` ejecuta los casos y, si el ciclo llega a `post-integration-test`, genera los reportes configurados. `-U` solicita actualizar dependencias y reintentar resoluciones pendientes.

También se puede ejecutar `CucumberTestSuite` como prueba JUnit desde el editor. Después, ejecutar `serenity:aggregate` desde Maven para generar los reportes agregados.

## Reportes

Los reportes se generan en:

```text
target/site/serenity/reports/
├── index.html              # Reporte completo: gráficas, resultados y detalle
├── serenity-summary.html   # Resumen HTML de una sola página
└── ...                     # Evidencias, datos y recursos del reporte
```

Abrir los HTML en un navegador. Para compartir el reporte completo, conservar toda la carpeta para mantener sus recursos y evidencias. `target/` está excluido del control de versiones mediante `.gitignore`.

El reporte adicional `single-page-html` se habilita en `serenity-maven-plugin`, que incluye la dependencia `serenity-single-page-report` con la misma versión de Serenity.


## Referencias

- [Configuración de Serenity](https://serenity-bdd.github.io/docs/reference/serenity-properties)
- [Reportes adicionales de Serenity](https://serenity-bdd.github.io/docs/reporting/additional_reports)
