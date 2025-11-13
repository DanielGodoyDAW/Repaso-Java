## Visión general del repositorio

Repositorio de ejercicios y ejemplos en Java con dos líneas principales de trabajo:

- Archivos: utilidades y ejemplos completos para crear, leer y escribir archivos (crear archivos, anexar contenido, leer líneas/archivos enteros). Este bloque contiene todo lo necesario para practicar operaciones de E/S con archivos.

- Máquina de snacks: proyecto didáctico que explora colecciones y diseño por capas. Hay dos aproximaciones dentro de `src`:
  - Una versión en memoria (listas) que utiliza listas, sets y mapas, y que sirve como base para practicar colecciones y estructuras de datos.
  - Un proyecto derivado `Maquina_Snacks_archivos` que persigue la misma funcionalidad pero persistiendo datos en archivos (este proyecto está en proceso y aún no está completamente terminado).

Temas y conceptos que se tratan en el repositorio

- Colecciones: Listas, Sets y Maps.
- Interfases y separación de responsabilidades (servicios y presentación).
- Genéricos: uso general para colecciones y APIs locales.
- Funciones lambda y referencias a métodos donde se aplican operaciones funcionales/concisas.
- Manejo de excepciones para E/S y lógica de negocio.
- Persistencia simple mediante archivos de texto (lectura/escritura/append).

Resumen práctico

- Si quieres practicar E/S en Java, revisa la carpeta `src/Archivos`.
- Si te interesan colecciones, interfaces y programación orientada a objetos con ejemplos prácticos, revisa `src/Maquina_Snacks`.
- `src/Maquina_Snacks_archivos` es la evolución que integra persistencia por archivos; aún requiere completar la lectura/mostrar de snacks y devolver correctamente la lista desde el servicio.

Compilación y ejecución mínima (PowerShell en Windows)

```powershell
mkdir out; 
javac -d out src\*.java src\Archivos\*.java src\Maquina_Snacks\*.java src\Maquina_Snacks_archivos\dominio\*.java src\Maquina_Snacks_archivos\presentacion\*.java src\Maquina_Snacks_archivos\servicio\*.java
java -cp out Main 
```

Notas finales

- No se incluyó `pom.xml` ni `build.gradle`: el proyecto está pensado para compilarse con `javac` o abrirse en un IDE.
- Si quieres que deje el README aún más corto (sólo temas tratados) o que añada un apartado de “qué falta” detallado para `Maquina_Snacks_archivos`, dímelo y lo actualizo.
## Resumen del repositorio

Este repositorio contiene ejemplos y ejercicios en Java para repaso, principalmente enfocados en:

- Programas sencillos de "Hola mundo" y prácticas con `main`.
- Operaciones con archivos (crear, escribir, leer, anexar).
- Una implementación de ejemplo de una "máquina de snacks" (estructuras en memoria y otra versión que usa archivos).

Contenido destacable:

- `src/HolaMundo.java` — Ejemplo mínimo que imprime un saludo (sin paquete declarado).
- `src/Main.java` — Programa de ejemplo con `main` que imprime mensajes y un bucle.

- `src/Archivos/` — Clases relacionadas con operaciones sobre archivos:
  - `CrearArchivo.java` — Crea un archivo (`mi_archivo.txt`) si no existe.
  - `AgregarContenidoArchivo.java` — Añade (anexa) contenido a `mi_archivo.txt`.
  - `LeerArchivo.java`, `LeerTodo.java` — Utilidades para leer contenido (ejemplos).

- `src/Maquina_Snacks/` — Implementación sencilla en memoria:
  - `Snack.java` — DTO de un snack (id, nombre, precio).
  - `Snacks.java` — Inventario estático de snacks y métodos para mostrar/agregar.

- `src/Maquina_Snacks_archivos/` — Versión modular que separa dominio, presentación y servicio (más orientada a persistencia en archivos):
  - `dominio/Snack.java` — Clase `Snack` similar a la anterior, en su propio paquete.
  - `presentacion/MaquinaSnacks.java` — Interfaz de consola para la máquina de snacks (menú, comprar, agregar, mostrar ticket). Contiene `main` y depende de un servicio.
  - `servicio/ISevicioSnacks.java` — Interfaz que define operaciones de servicio.
  - `servicio/ServicioSnacksLista.java` — Implementación que mantiene la lista en memoria.
  - `servicio/ServicioSnacksArchivos.java` — Implementación pensada para persistir en `snacks.txt` (crea el archivo y agrega snacks), aunque tiene métodos por implementar/terminar (p. ej. `mostrarSnack()` y `getSnacks()` retornan implementaciones mínimas o vacías actualmente).

- Archivos de datos de ejemplo en la raíz:
  - `snacks.txt` — archivo usado por la implementación basada en archivos (puede crearse/escribirse cuando se usa la aplicación).
  - `mi_archivo.txt` — archivo de ejemplo usado por las utilidades de `Archivos`.

Estado actual / notas importantes

- El proyecto no contiene un `build.gradle` ni `pom.xml`; está preparado para compilarse directamente con `javac` o abrirse en un IDE (IntelliJ/Eclipse).


Cómo compilar y ejecutar (línea de comandos, PowerShell en Windows)

1) Desde la raíz del repo, crear la carpeta de salida y compilar todas las clases:

```powershell
mkdir out; 
javac -d out src\*.java src\Archivos\*.java src\Maquina_Snacks\*.java src\Maquina_Snacks_archivos\dominio\*.java src\Maquina_Snacks_archivos\presentacion\*.java src\Maquina_Snacks_archivos\servicio\*.java
```

2) Ejecutar el ejemplo principal (`Main`):

```powershell
java -cp out Main
```

3) Ejecutar la presentación de la máquina de snacks (interfaz por consola):

```powershell
java -cp out Maquina_Snacks_archivos.presentacion.MaquinaSnacks
```

Notas para desarrolladores

- Si usas un IDE (IntelliJ), basta con abrir el proyecto y ejecutar las clases con `main` directamente.
- Mejoras sugeridas:
  - Implementar completamente `ServicioSnacksArchivos.mostrarSnack()` y `getSnacks()` para que la versión de archivos funcione como la de lista.
  - Añadir pruebas unitarias (JUnit) para validar operaciones de archivo y lógica de venta.
  - Agregar un `build.gradle` o `pom.xml` si se desea automatizar compilación/ejecución.


