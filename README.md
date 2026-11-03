# 🎵 Spotify — Prototipo Sprint 

Prototipo académico desarrollado en el marco de la asignatura **Proyecto Software** de la **Licenciatura en Sistemas** (**Departamento de Desarrollo Productivo y Tecnológico** — **Universidad Nacional de Lanús**).

[![Java 17+](https://img.shields.io/badge/Java-17%2B-orange?style=flat-square&logo=openjdk)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-Backend-green?style=flat-square&logo=springboot)](https://spring.io/projects/spring-boot)
[![React / Vite](https://img.shields.io/badge/Frontend-Vite%20%2F%20Node.js-blue?style=flat-square&logo=vite)](https://vitejs.dev/)

---

## 👥 Equipo de Desarrollo y Cátedra

* **Alumnos:**
  * Denaro Del Pero, Gian Franco (`41065731`)
  * Basalo, Nicolas Ariel (`46358143`)
  * Diaz De Maio, Tomas Alejandro (`43895372`)
  * Szymborski, Ignacio Manuel (`42396340`)

* **Docentes:**
  * Damián Santos
  * Maximiliano Santos
  * Nazareno Galván
  * Darío Casais

* 📅 **Fecha de entrega:** 11/03/2026
* 🎥 **Enlace al vídeo demostrativo:** [Ver en YouTube](https://youtu.be/08OAB_Xmyxk?si=lyEhJxUbF0DrPn4F)

---

## ⚙️ Requisitos del Sistema

Para ejecutar este proyecto de manera local, asegúrate de contar con lo siguiente:
* **Java:** Versión 17 o superior.
* **Maven:** Versión 3.9+ (o utilizar el contenedor Maven integrado).
* **Node.js:** Versión 20 o superior y **npm**.

---

## 🚀 Guía de Instalación y Ejecución

El proyecto está dividido en dos partes (Backend y Frontend). Deberás ejecutarlos en terminales separadas.

### 1️⃣ Backend (Spring Boot)
Abre una terminal, dirígete a la carpeta del backend e inicia el servidor:

```bash
cd backend
mvn spring-boot:run

🌐 API Base: http://localhost:8080/api🗄️ Nota: Utiliza una base de datos H2 en memoria que se autocompleta con datos de ejemplo al iniciar la aplicación.🔌 Endpoints disponibles:MétodoEndpointDescripciónGET/api/catalogObtiene el catálogo completo.GET/api/artistsLista todos los artistas.GET/api/artists/{id}Muestra el detalle de un artista.GET/api/artists/{id}/albumsLista los álbumes de un artista.GET/api/artists/{id}/songsLista las canciones de un artista.GET/api/albumsLista todos los álbumes.GET/api/albums/{id}Muestra el detalle de un álbum.GET/api/albums/{id}/songsLista las canciones de un álbum.GET/api/songsLista todas las canciones.GET/api/search?q=textoRealiza búsquedas por texto.2️⃣ Frontend (Interfaz Web)Abre una segunda terminal, dirígete a la carpeta del frontend y pon en marcha el entorno de desarrollo:Bashcd frontend
npm install
npm run dev
💻 Abre la dirección indicada en la consola por Vite (por defecto: http://localhost:5173).🌐 Conectividad: Las canciones de muestra utilizan URLs de archivos MP3 públicos de SoundHelix, por lo que se requiere conexión a Internet para la reproducción de audio.
