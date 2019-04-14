plugins {
    `java-library`
    `maven-publish`
}

group = "space.npstr.prometheus_extensions"

repositories {
    jcenter()
}

val prometheusVersion = "0.6.0"
val dsProxyVersion = "1.5.1"
val okHttpVersion = "3.14.1"

dependencies {
    api("io.prometheus:simpleclient:$prometheusVersion")
    api("io.prometheus:simpleclient_hotspot:$prometheusVersion")
    api("io.prometheus:simpleclient_logback:$prometheusVersion")
    api("io.prometheus:simpleclient_common:$prometheusVersion")
    api("io.prometheus:simpleclient_caffeine:$prometheusVersion")

    compileOnly("net.ttddyy:datasource-proxy:$dsProxyVersion")
    compileOnly("com.squareup.okhttp3:okhttp:$okHttpVersion")
}

publishing {
    publications {
        create<MavenPublication>("prometheusExtensions") {
            from(components["java"])
        }
    }
}