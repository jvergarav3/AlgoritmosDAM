# DAM Simulator

Simulador de algoritmos de reemplazo de páginas desarrollado en **JavaFX** como proyecto académico para el estudio de la gestión de memoria en Sistemas Operativos.

## 📖 Descripción

DAM Simulator es una aplicación de escritorio que permite visualizar paso a paso el funcionamiento de distintos algoritmos de reemplazo de páginas.

El usuario puede ingresar una secuencia de referencias, definir la cantidad de marcos disponibles y seleccionar el algoritmo que desea ejecutar. La aplicación genera una simulación detallada mostrando cada estado del sistema, las decisiones tomadas por el algoritmo y estadísticas de rendimiento.

---

## ✨ Características

* Simulación de algoritmos de reemplazo de páginas.
* Visualización paso a paso de la ejecución.
* Configuración dinámica de referencias de páginas.
* Configuración del número de marcos.
* Selección del algoritmo a ejecutar.
* Tabla detallada de resultados.
* Resumen estadístico.
* Cálculo de:

    * Fallos de página.
    * Aciertos.
    * Tasa de fallos.
    * Tasa de aciertos.
* Gráfica de pastel para comparar fallos y aciertos.
* Interfaz gráfica moderna desarrollada con JavaFX.

---

## 🧠 Algoritmos Implementados

Actualmente la aplicación soporta:

| Algoritmo | Descripción              |
| --------- | ------------------------ |
| FIFO      | First In First Out       |
| LRU       | Least Recently Used      |
| OPT       | Optimal Page Replacement |

---

## 🖥️ Captura de Pantalla

### Dashboard

![Dashboard](docs/dashboard.png)

La interfaz permite:

1. Ingresar la secuencia de referencias.
2. Configurar el número de marcos.
3. Seleccionar el algoritmo.
4. Ejecutar la simulación.
5. Visualizar los resultados en tiempo real.

---

## 🏗️ Arquitectura

El proyecto está organizado siguiendo una arquitectura por capas:

```text
src/main/java
│
├── application
│   └── SimulationService
│
├── domain
│   ├── algorithm
│   ├── enums
│   └── model
│
└── presentation
    ├── controller
    ├── mapper
    └── viewmodel
```

### Domain

Contiene las reglas de negocio y la implementación de los algoritmos.

### Application

Orquesta los casos de uso y coordina la ejecución de las simulaciones.

### Presentation

Gestiona la interfaz gráfica desarrollada con JavaFX.

---

## 📂 Estructura del Proyecto

```text
## 📂 Estructura del Proyecto

```text
src/main
├── java
│   └── com
│       └── operative_systems
│           ├── App.java
│           │
│           ├── application
│           │   └── SimulationService.java
│           │
│           ├── domain
│           │   ├── algorithm
│           │   │   ├── FIFOAlgorithm.java
│           │   │   ├── LRUAlgorithm.java
│           │   │   ├── OPTAlgorithm.java
│           │   │   └── PageReplacementAlgorithm.java
│           │   │
│           │   ├── enums
│           │   │   └── AlgorithmType.java
│           │   │
│           │   └── model
│           │       ├── SimulationRequest.java
│           │       ├── SimulationResult.java
│           │       ├── SimulationStep.java
│           │       └── AlgorithmSummary.java
│           │
│           └── presentation
│               ├── controller
│               │   ├── component
│               │   │   ├── ConfigurationController.java
│               │   │   ├── SimulationTableController.java
│               │   │   └── SummaryController.java
│               │   │
│               │   └── page
│               │       └── DashboardController.java
│               │
│               ├── mapper
│               └── viewmodel
│
└── resources
    ├── css
    │   └── application.css
    │
    └── fxml
        ├── component
        │   ├── ConfigurationPanel.fxml
        │   ├── Sidebar.fxml
        │   ├── SimulationTable.fxml
        │   └── SummaryPanel.fxml
        │
        └── layout
            └── MainLayout.fxml
```

```

---

## 🛠️ Tecnologías Utilizadas

* Java 21
* JavaFX 21
* Maven
* FXML
* CSS
* IntelliJ IDEA

---

```

## 🚀 Instalación

### Clonar el repositorio

```bash
git clone https://github.com/jvergarav3/AlgoritmosDAM.git
```

```bash
cd dam_algorithms
```


### Compilar

```bash
mvn clean install
```

### Ejecutar

```bash
mvn javafx:run
```

---

## 📊 Ejemplo de Simulación

Entrada:

```text
Referencias: 7,0,1,2,0,3,0,4
Marcos: 4
Algoritmo: OPT
```

Salida:

```text
Fallos: 6
Aciertos: 2
Tasa de Fallos: 75%
Tasa de Aciertos: 25%
```

---

## 🎯 Objetivos del Proyecto

* Comprender el funcionamiento de los algoritmos de reemplazo de páginas.
* Visualizar la evolución de los marcos de memoria.
* Comparar el rendimiento de distintos algoritmos.


---

## 🔮 Mejoras Futuras

* Comparación simultánea entre algoritmos.
* Animaciones paso a paso.
* Exportación de resultados.
* Persistencia de simulaciones.
* Más algoritmos de reemplazo de páginas.
* Temas visuales configurables.
* Estadísticas avanzadas.

---

## 👨‍💻 Autores

**Joan Sebastián Vergara**

Estudiante de Ingeniería de Sistemas.

**Ismael Cano**

Estudiante de Ingeniería de Sistemas.

---

## 📄 Licencia

Este proyecto fue desarrollado con fines académicos y educativos.

