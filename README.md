# Spotify — prototipo Sprint
Universidad Nacional de Lanús

Departamento de Desarrollo Productivo y Tecnológico Licenciatura en Sistemas
Proyecto software
Alumnos:
Gian Franco Denaro Del Pero, 41065731	
Basalo Nicolas Ariel, 46358143 
Diaz De Maio Tomas Alejandro, 43895372 
Szymborski Ignacio Manuel, 42396340 

Docente: 
Damián Santos 
Maximiliano Santos 
Nazareno Galvan  
Darío Casais 
Link de video: https://youtu.be/08OAB_Xmyxk?si=lyEhJxUbF0DrPn4F
Fecha de entrega: 3/11/2026

Prototipo académico de catálogo, búsqueda, navegación por artistas/álbumes y reproducción HTML5. Incluye únicamente el alcance de Sprint 1; no incluye cuentas, playlists, recomendaciones ni favoritos.

## Requisitos
- Java 17 o superior
- Maven 3.9+ (o un wrapper Maven disponible)
- Node.js 20+ y npm

## Backend
```powershell
cd backend
mvn spring-boot:run
```
API: `http://localhost:8080/api`. H2 en memoria se carga con datos de ejemplo al iniciar.

Endpoints: `GET /api/catalog`, `/api/artists`, `/api/artists/{id}`, `/api/artists/{id}/albums`, `/api/artists/{id}/songs`, `/api/albums`, `/api/albums/{id}`, `/api/albums/{id}/songs`, `/api/songs`, `/api/search?q=texto`.

## Frontend
En otra terminal:
```powershell
cd frontend
npm install
npm run dev
```
Abrir la dirección de Vite indicada en consola (por defecto `http://localhost:5173`). Las canciones de muestra usan URLs MP3 públicas de SoundHelix y requieren conexión a Internet para audio.
