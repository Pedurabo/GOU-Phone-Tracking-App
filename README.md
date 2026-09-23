# GOU Phone Tracking App

Android-based **device security and anti-theft** application.

Provides real-time location tracking, remote device management, and protection features to help users locate and secure their smartphones if lost or stolen.

## Features
- Real-time GPS location tracking
- Live map view of device location
- Remote alarm (ring even when on silent)
- Remote device lock
- Optional front-camera capture on unauthorized access
- Location history
- Cloud synchronization
- Secure authentication

## Tech Stack
- **Language:** Kotlin / Java
- **UI:** Jetpack Compose or XML
- **Backend:** Firebase (Realtime Database / Firestore, Authentication, Cloud Messaging)
- **Maps & Location:** Google Maps API, Fused Location Provider
- **Platform:** Android

## Architecture Overview
- Mobile client handles location updates, UI, and remote command reception
- Firebase manages authentication, real-time data sync, and push notifications
- Google Maps displays live and historical locations

## Getting Started
1. Clone the repository
2. Open in Android Studio
3. Add your Firebase `google-services.json`
4. Configure Google Maps API key
5. Sync and run

## Security Notes
This type of application requires careful handling of location data and remote commands. Proper authentication and permission management are essential.

## Project Status
Core features (tracking, remote actions, Firebase integration) are designed and partially implemented. Further polish and testing are ongoing.
