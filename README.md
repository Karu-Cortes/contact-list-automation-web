# Descripción del Proyecto
Se implementa un framework de automatización Aplicativo Contact List
permitiendo pruebas end-to-end sobre el proceso completo mediante Serenity BDD, Cucumber y el patrón Screenplay.

# Arquitectura del Proyecto
```text
src
├── main
│   └── java
│       └── testing
│           ├── questions         # Preguntas (Questions) → Validaciones o consultas del estado
│           │   ├── common        # Preguntas genéricas (login, URL, títulos)
│           │
│           ├── tasks             # Tareas (Tasks) → Acciones ejecutadas por el actor
│           │   ├── common        # Acciones comunes de UI (login, navegación)
│           │
│           ├── ui                # Page Objects (mapas de elementos web)
│           │   ├── common        # Login, tablas, componentes genéricos
│           │
│           └── utils             # Utilidades generales y helpers (API, entorno, constantes)
└── test
├── java
│   └── testing
│       ├── runners           # Configuración de ejecución (Cucumber Runner)
│       ├── hooks             # Hooks de inicialización o teardown
│       └── stepdefinitions   # Step Definitions de Cucumber (flujos funcionales)
│           ├── commons       
└── resources
├── features      # Escenarios Gherkin
│   └── home.feature
├── serenity.conf
├── 
├── 
└──