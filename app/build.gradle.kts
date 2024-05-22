plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.malkinfo.rentalapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.malkinfo.rentalapp"
        minSdk = 25
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8

        sourceCompatibility =JavaVersion.VERSION_11
                targetCompatibility =JavaVersion.VERSION_11
    }
    buildFeatures{
        viewBinding=true
    }

}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-database:20.3.1")
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation("org.testng:testng:6.9.6")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation ("com.google.code.gson:gson:2.8.6")
    implementation ("de.hdodenhof:circleimageview:3.1.0")
    implementation ("com.google.android.material:material:<version>")
    implementation ("com.github.bumptech.glide:glide:4.11.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.11.0")

    testImplementation ("org.mockito:mockito-core:3.12.4")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
    testImplementation ("junit:junit:4.13.2")

    testImplementation ("org.mockito:mockito-core:3.11.2")
    testImplementation ("org.mockito:mockito-inline:3.11.2")
    testImplementation ("org.mockito:mockito-android:3.11.2")

    testImplementation ("com.google.firebase:firebase-database:20.0.3")
    testImplementation ("junit:junit:4.13.2")




    testImplementation ("androidx.test:core:1.4.0")
    testImplementation ("androidx.test.ext:junit:1.1.3")
    testImplementation("androidx.test:rules:1.4.0")
    testImplementation ("androidx.test:runner:1.4.0")
    androidTestImplementation ("androidx.test:core:1.4.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test:rules:1.4.0")
    androidTestImplementation("androidx.test:runner:1.4.0")




    implementation("com.paypal.checkout:android-sdk:1.1.0")
    androidTestImplementation ("androidx.test.espresso:espresso-intents:3.4.0")


}

apply(plugin = "com.google.gms.google-services")