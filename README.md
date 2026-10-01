# mynewapp

A simple Android calculator app written in Java. The user enters two numbers and taps **Add** or **Subtract** to see the result.

## Features

- Two input fields for numbers (decimals supported, parsed as `double`)
- **Add** button: shows `The sum of two number is : <result>`
- **Subtract** button: shows `The difference of two number is : <result>`
- Light and dark (night) themes

## Tech Stack

| Item | Value |
|------|-------|
| Language | Java 11 |
| Build system | Gradle 9.6.0 (Kotlin DSL) with version catalog |
| Android Gradle Plugin | 9.4.1 |
| Compile / Target SDK | 37 |
| Min SDK | 24 (Android 7.0) |
| Gradle daemon JVM | Java 25 (auto-provisioned via Foojay toolchain) |

### Dependencies

- `androidx.appcompat:appcompat` 1.8.0
- `androidx.activity:activity-ktx` 1.13.0
- `androidx.constraintlayout:constraintlayout` 2.2.2
- `com.google.android.material:material` 1.14.0

Test dependencies: JUnit 4.13.2, AndroidX Test JUnit 1.3.0, Espresso 3.7.0.

## Project Structure

```
mynewapp/
├── app/
│   ├── build.gradle.kts              # App module build config
│   └── src/
│       ├── main/
│       │   ├── AndroidManifest.xml
│       │   ├── java/com/example/mynewapp/
│       │   │   ├── MainActivity.java     # Calculator screen (launcher activity)
│       │   │   └── MainActivity2.java    # Second activity (empty placeholder)
│       │   ├── keepRules/rules.keep      # R8 keep rules
│       │   └── res/
│       │       ├── layout/
│       │       │   ├── activity_main.xml   # Calculator UI (LinearLayout)
│       │       │   └── activity_main2.xml  # Empty ConstraintLayout
│       │       ├── values/                 # colors, strings, themes
│       │       └── values-night/           # dark theme
│       ├── test/                         # Local unit tests
│       └── androidTest/                  # Instrumented tests
├── gradle/
│   ├── libs.versions.toml            # Dependency version catalog
│   └── wrapper/
├── build.gradle.kts                  # Root build file
├── settings.gradle.kts
└── gradlew / gradlew.bat
```

## How It Works

`MainActivity` loads `activity_main.xml`, which contains:

| View ID | Type | Purpose |
|---------|------|---------|
| `num1` | EditText | First number |
| `num2` | EditText | Second number |
| `addButton` | Button | Adds the two numbers |
| `subtractButton` | Button | Subtracts the second number from the first |
| `answer` | TextView | Shows the result |

Each button's click listener reads both inputs with `Double.parseDouble(...)`, computes the result, and writes it to the `answer` TextView.

`MainActivity2` is declared in the manifest (not exported) but is not yet opened from anywhere in the app.

## Getting Started

### Prerequisites

- Android Studio (a recent version that supports AGP 9.4)
- Android SDK Platform 37
- An emulator or a physical device running Android 7.0 (API 24) or newer

### Build and Run

**Android Studio:** Open the project folder, let Gradle sync, then click **Run**.

**Command line:**

```bash
# Build a debug APK
./gradlew assembleDebug

# Install on a connected device/emulator
./gradlew installDebug
```

The APK is generated at `app/build/outputs/apk/debug/app-debug.apk`.

### Run Tests

```bash
# Local unit tests
./gradlew test

# Instrumented tests (requires a device or emulator)
./gradlew connectedAndroidTest
```

## Known Limitations

- Leaving an input empty or entering non-numeric text and pressing a button crashes the app with a `NumberFormatException`; input is not validated.
- The input fields have no `inputType`, so the full text keyboard is shown instead of a number pad.
- UI strings are hardcoded in the layout and Java code instead of `strings.xml`.
- `MainActivity2` is an unused placeholder.

## Possible Improvements

- Validate input and show an error (e.g. a `Toast` or `EditText.setError`) when a field is empty or invalid
- Add `android:inputType="numberDecimal|numberSigned"` to the EditTexts
- Add multiply and divide operations (with divide-by-zero handling)
- Move text to `strings.xml` for localization
- Use `sp` instead of `dp` for `textSize`
