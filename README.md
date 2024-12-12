# README 
### [ (anchor to README in English) ](#in-english)

## Voyager:
Este aplicativo Android é um desafio de 7 dias, no qual deve ser implementado uma solução para que um usuário que quer viagem de ponto A até o ponto B. O usuário pode escolher entre motoristas e valores e confirmar a viagem. Depois, pode listar o histórico das viagens.

______

**Status atual do projeto**: incompleto.

**Motivação:** Priorizado esforço a manter organização e a qualidade do código, procurando implementar uma arquitetura sólida e seguir boas práticas de desenvolvimento.
O que foi considerado mais difícil está feito. 

**Reflexão:** 'Feito é melhor que perfeito'

______

## Clonando o repositório:

* No console: Acesse a pasta onde o projeto será clonado e digite: `git clone https://github.com/do5-5anto5/voyager.git`

______

## Entendendo as escolhas feitas:

* Para informações detalhadas de como, quando e porquê cada task/feature/chore/refactor foi implementado:
    - acompanhar os [Pull Requests](https://github.com/do5-5anto5/voyager/pulls?q=is%3Apr+is%3Aclosed) e [Issues](https://github.com/do5-5anto5/voyager/issues?q=is%3Aissue+is%3Aclosed)

* Na lista de commits, pode-se considerar que cada merge marcado com "Verified" agrupa uma idéia de tarefa

* Para um resumo, em português e inglês: Pode-se acompanhar a seguir, no README.

______

## Arquitetura implementada:

MVVM (Model-View-ViewModel)  é um padrão de arquitetura que separa a interface do usuário (View), a lógica de apresentação (ViewModel) e os dados (Model). O ViewModel atua como um intermediário, fornecendo dados para a View e processando as ações do usuário, enquanto o Model encapsula a lógica de negócios e os dados da aplicação. Essa separação promove organização, testabilidade e manutenibilidade do código.

## Dependências adicionadas:

- Google Secrets Gradle Plugin:
    - Permite o uso de segredos do projeto no build.gradle.kts. Plugins:
- Kotlin Serialization Plugin:
    -  Adiciona suporte à serialização Kotlin para codificação e decodificação de dados.
- Google Maps Platform Secrets Gradle Plugin:
    - Permite o gerenciamento seguro de segredos do Google Maps Platform. Implementation:
- Lottie Compose:
    -  Integra a biblioteca Lottie para animações no Compose.
- Koin Android:
    -  Fornece injeção de dependência usando o Koin.
- Retrofit:
    -  Permite realizar requisições HTTP usando o Retrofit.
- OkHttp BOM:
    -  Define a plataforma base para as dependências do OkHttp.
- OkHttp:
    -  Fornece um cliente HTTP para realizar requisições de rede.
- Logging Interceptor:
    -  Habilita o log de requisições e respostas HTTP.
- Kotlin Serialization Converter:
    -  Adiciona um conversor para usar a serialização Kotlin com o Retrofit.
- Kotlin Serialization JSON:
    -  Adiciona suporte à serialização JSON usando a serialização Kotlin.
- Jetpack Compose Navigation:
    -  Permite a navegação entre telas usando o Jetpack Compose Navigation.
- Google Maps Compose:
    -  Integra o Google Maps no Compose para exibir mapas.

______

## Road Map:
### Próximos passos:

1 - Refatorar o argumento passado por compose navigation de `RideRequestScreen` para `RideConfirmScreen`

Na tela de confirmação da corrida `RideConfirmScreen` recebe por argumentos via Compose Navigation type safe args um objeto par de argumentos Pair<String, List<Option>>.
O qual será tratado a se tornar um estado `RideConfirmState` que por sua vez, será transformado em request body para fazer o @PATCH request de confirmação da corrida, implementando o useCase da ApiService nesse objetivo.

Foi constatado que isso é um pouco complicado, e então é bem melhor e mais simples (para implementação e desempenho) mudar o argumento enviado para que seja o estado `RideRequestState.requesbody`. Assim sendo, será passado só um objeto, e no view model de confirmação `RideConfirmViewModel` será tratado de forma a se tornar os estados e objetos corretos. Essa refatoração simplifica o processo.

2 - Usar o mesmo processo de passar o corpo de response body enquanto é um estado da tela de `RideRequestScreen` para `RideHistoryScreen`, que seja tratado no seu view model para renderizar as listas de histórico e corridas.

3 - Implementar um tema customizado, com base no mesmo feito em outro projeto deste perfil [https://github.com/do5-5anto5/Quinto-Code]

4 - Implementar testes unitários

______


# README <a name="in-english"></a>

## Voyager:
This Android is a 7-day challenge, in which a solution must be implemented for a user who wants to travel from point A to point B. The user can choose between drivers and prices and confirm the trip. Afterwards, you can list the trip history.

______

**Current project status**: incomplete.

**Motivation:** Prioritized the effort to maintain the organization and quality of the code, seeking to implement a solid architecture and follow good development practices.

What was considered most difficult is done.

**Reflection:** 'Done is better than perfect'

______

## Cloning the repository:

* In the console: Access the folder where the project will be cloned and type: `git clone https://github.com/do5-5anto5/voyager.git`

______

## Understanding the choices made:

* For information provided on how, when and why each task/feature/task/refactor was implemented:
- follow the [Pull Requests](https://github.com/do5-5anto5/voyager/pulls?q=is%3Apr+is%3Aclosed) and [Issues](https://github.com/do5-5anto5/voyager/issues?q=is%3Aissue+is%3Aclosed)

* In the list of commits, you can consider that each merge marked with "Verified" groups a task idea

* For a summary, in Portuguese and English: You can follow the steps below in the README.

______

## Architecture:

MVVM (Model-View-ViewModel) is an architectural pattern that separates the user interface (View), presentation logic (ViewModel), and data (Model). The ViewModel acts as an intermediary, providing data to the View and processing user actions, while the Model encapsulates the business logic and application data. This separation promotes code organization, testability, and maintainability.

## Added dependencies:

- Google Secrets Gradle plugin:
- Allows the use of project secrets in build.gradle.kts. Plugins:
- Kotlin serialization plugin:
- Added support for Kotlin serialization for data encoding and decoding.
- Google Maps Platform Secrets Gradle plugin:
- Allows secure management of Google Maps Platform secrets. Implementation:
- Lottie Compose:
- Integrates the Lottie library for animations into Compose.
- Coin Android:
- Provides dependency injection using Koin.
- Retrofit:
- Allows for making HTTP requests using Retrofit.
- OkHttp BOM:
- Defines a base platform for OkHttp dependencies.
- OkHttp:
- Provides an HTTP client to make network requests.
- Logging Interceptor:
- Enables logging of HTTP requests and responses.
- Kotlin Serialization Converter:
- Added a converter to use Kotlin serialization with Retrofit.
- Kotlin Serialization JSON:
- Added support for JSON serialization using Kotlin serialization.
- Jetpack Compose Navigation:
- Allows for navigation between screens using Jetpack Compose Navigation.
- Google Maps Composition:
- Integrates Google Maps into Compose to visualize maps.

______

## Script:
### Next steps:

1 - Refactor the argument passed to compose the navigation from `RideRequestScreen` to `RideConfirmScreen`

On the ride confirmation screen, `RideConfirmScreen` receives arguments via Compose Navigation type safe args, a pair of arguments Pair<String, List<Option>>.

This will be treated to become a `RideConfirmState` state, which in turn will be transformed into a request body to make the @PATCH request to confirm the ride, implementing the ApiService useCase for this purpose.

It was found that this is a bit complicated, and so it is much better and simpler (for implementation and performance) to change the argument sent to be the `RideRequestState.requesbody` state. This way, only one object will be passed, and the confirmation view model `RideConfirmViewModel` will be treated to become the correct states and objects. This refactoring simplifies the process.

2 - Use the same process of passing the response body as a screen state from `RideRequestScreen` to `RideHistoryScreen`, which is handled in your view model to render the history and ride lists.

3 - Implement a custom theme, based on the same one done in another project of this profile [https://github.com/do5-5anto5/Quinto-Code]

4 - Implement unit tests

