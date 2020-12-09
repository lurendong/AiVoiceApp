// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val kotlin_version by extra("1.3.72")
    val gradle_version = "4.0.1"
    repositories {
        google()
        maven {
            setUrl("http://maven.aliyun.com/nexus/content/groups/public/")
        }
        jcenter()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:$gradle_version")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:${KotlinConstants.kotlin_version}")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        maven {
            setUrl("http://maven.aliyun.com/nexus/content/groups/public/")
        }
        jcenter()
    }
}


tasks{
    val clean by registering(Delete::class){
        delete(buildDir)
    }
}