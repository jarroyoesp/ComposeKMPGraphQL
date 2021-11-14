

# Architecture

<img src="https://github.com/jarroyoesp/ComposeKMPGraphQL/blob/master/images/arch_app.png">

# Languages, libraries and tools used

* [Apollo GraphQL](https://www.apollographql.com/)
* [Kotlin MultiPlatform](https://kotlinlang.org/docs/multiplatform.html/)
* [Kotlin](https://kotlinlang.org/)
* [Kotlin-Coroutines + Flow](https://kotlinlang.org/docs/reference/coroutines-overview.html)
* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
* [Android Architecture Components](https://developer.android.com/topic/libraries/architecture/index.html)
* Android X Core
* [Hilt-Dagger](https://dagger.dev/hilt/)
* [Room](https://developer.android.com/topic/libraries/architecture/room.html)
* [Mockito](http://site.mockito.org/)
* [Espresso](https://developer.android.com/training/testing/espresso/index.html)

# App

<img src="https://github.com/jarroyoesp/ComposeKMPGraphQL/blob/master/images/app_capture.png" width="200">

Use this to generate schema.graphqls:

```
./gradlew downloadApolloSchema \
  --endpoint="https://rickandmortyapi.com/graphql" \
  --schema="SharedCodeClient/src/commonMain/graphql/com/jarroyo/schema.graphqls"
```
GraphQL queries used:

```
query GetCharacters{
    characters {
        results {
            id,
            name,
            image
        }
    }
}
```


