# 💬 Gemini-App

An elegant Android app wrapping the **Gemini ChatBot** web client inside a native **WebView**, offering a clean, minimal UI and the full chat experience from your Gemini-inspired AI chatbot — all in a lightweight Kotlin Android application.


## ✨ Features

- 🔗 Loads [Gemini ChatBot](https://github.com/Harish-Srinivas-07/Gemini-chatBot) in WebView
- 🌙 Full dark mode support
- 🎯 Optimized for smooth performance and fast load times
- 🧠 Backend powered by OpenAI/Gemini APIs
- 📋 Chat UI with Markdown rendering, copy-to-clipboard, and typing animation

## 📁 Project Structure

```
Gemini-App/
├── app/                     # Android app code (Kotlin + WebView)
├── build.gradle             # Project-level build config
├── .github/workflows/       # GitHub Actions for CI/CD
└── README.md
```


## 🚀 Getting Started

### 1️⃣ Clone the Repo

```bash
git clone https://github.com/Harish-Srinivas-07/Gemini-App.git
cd Gemini-App
```

### 2️⃣ Open in Android Studio

* Open the folder in **Android Studio**
* Let it sync all Gradle dependencies

### 3️⃣ Run the App

* Connect an emulator or Android device
* Click ▶️ **Run**


## 🛠️ Build APK using GitHub Actions

The app is configured with a GitHub workflow to **auto-build and release APKs**.

🔧 **Steps:**

1. Push a new Git **tag** (e.g. `v1.0.1`)

   ```bash
   git tag v1.0.1
   git push origin v1.0.1
   ```

2. GitHub Actions will:

   * Build the APK
   * Upload it as a release asset under **Releases**

> Make sure `app-release.apk` is generated in `app/build/outputs/apk/release/` for the workflow to pick up.


## 📦 Gemini ChatBot (WebView Source)

This app wraps the following project:

**👉 [Gemini ChatBot (Web version)](https://github.com/Harish-Srinivas-07/Gemini-chatBot)**
A modern HTML/JS chatbot UI that uses OpenAI/Gemini API with Markdown, clipboard copy, and animated responses.



## 🖼️ Preview

| ChatBot UI (Web)                                                                                                      |
| --------------------------------------------------------------------------------------------------------------------- |
| ![Gemini Web](https://user-images.githubusercontent.com/114596900/215252106-a3253beb-2b45-4b18-acdf-0c1b2a9b3ccf.png) |



## 📄 License

This project is licensed under the [**MIT License**](LICENSE).
Feel free to use, modify, and distribute it for educational and personal projects 


Made with ❤️ by [@Harish-Srinivas-07](https://github.com/Harish-Srinivas-07)
