import org.gradle.api.provider.Property

interface MyAppExtension {

    abstract Property<String> getMainClass()

}