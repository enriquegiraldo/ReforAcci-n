

# Introducción al Diagrama de Clases de la Aplicación ReforAccion

Este diagrama de clases UML representa la estructura de una aplicación móvil enfocada en la conciencia ambiental y la promoción de actividades eco-amigables, particularmente la plantación de árboles. La aplicación está diseñada para Android y utiliza el patrón de diseño de herencia para mantener una estructura coherente y reutilizable.

## Estructura General

El diagrama muestra una jerarquía de clases con una clase base **BaseActivity** de la cual heredan todas las demás actividades (pantallas) de la aplicación. Esta estructura permite compartir funcionalidades comunes entre todas las pantallas, como la gestión de fondos y preferencias de usuario.

## Componentes Principales

- **BaseActivity**: Clase base que proporciona funcionalidad común a todas las pantallas, incluyendo la gestión de fondos y menús de opciones.
- **PantallaPrincipal**: Representa la pantalla de inicio de la aplicación, ofreciendo acceso a las principales funcionalidades.
- **PantallaDeEstadisticas**: Muestra información sobre el impacto ambiental de las actividades del usuario, como árboles plantados y CO2 ahorrado.
- **PantallaDeInicioDeSesion**: Maneja la autenticación de usuarios.
- **PantallaDeConsejos**: Permite a los usuarios ver y guardar consejos eco-amigables.
- **PantallaRegistroActividades**: Facilita el registro de actividades de plantación de árboles.
- **RegistroDeUsuarios**: Gestiona el proceso de registro de nuevos usuarios.

## Características Clave

- **Consistencia de UI**: El uso de **BaseActivity** asegura una experiencia de usuario coherente en toda la aplicación.
- **Funcionalidad Compartida**: Elementos como la gestión de fondos y preferencias se comparten entre todas las pantallas.
- **Modularidad**: Cada pantalla está encapsulada en su propia clase, facilitando el mantenimiento y la escalabilidad.
- **Enfoque Ambiental**: Las funcionalidades se centran en actividades eco-amigables y seguimiento del impacto ambiental.

![image](https://github.com/user-attachments/assets/1eec290f-2b2f-490e-9bb5-29da37927620)
