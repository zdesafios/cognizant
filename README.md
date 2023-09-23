# cognizant

### Questões 1 e 2

1) Uma imagem bitmap pode ser representada como uma matriz de dimensões
M x N, em que cada posição da matriz pode assumir um valor inteiro dentro de
um intervalo. Construa um algoritmo que receba como entrada um Vetor A[N]
em que An
∈ { 0, 1, 2,..., 15 }. A saída do seu algoritmo deve ser uma String
indicando a quantidade de vezes que cada An foi encontrado na matriz de
bitmap. No caso em que algum elemento não tenha sido encontrado, o
algoritmo deve retornar que a quantidade é zero para aquele elemento. O
formato da String é livre

2) Transforme o algoritmo anterior em uma API Rest. Você receberá como
parâmetro uma lista com os valores de An e deverá retornar a saída do
algoritmo no formato JSON.

Esse tema foi abordado:
* classe: com.desafios.bitmap.service.BitmapSearcher
* Testes: com.desafios.bitmap.service.BitmapSearcherTest
* Endpoint: GET localhost:8080/bitmap/image1?q=1,2
* JSON: [JSON responsta da busca por bit's](https://github.com/zdesafios/cognizant/blob/master/doc/bitmap.response.json)


### Questão 3

3) Dado o seguinte log da primeira corrida de Super-Heróis – Volta ao Mundo.
Desenvolva uma API que leia o arquivo de log acima e retorne as seguintes
informações:
Posição de Chegada, Código do Super-herói, Nome Super-herói, Quantidade de
Voltas Completadas e Tempo Total de Prova

Esse tema foi abordado:
* classe: com.desafios.heroes.service.HeroLoader
* Testes: com.desafios.heroes.service.HeroLoaderTest
* Endpoint: POST localhost:8080/hero passando o arquivo no campo file
* JSON: [JSON Responsta do processamento de logs](https://github.com/zdesafios/cognizant/blob/master/doc/hero.response.json)



### Testes e Cobertura

[Testes](https://github.com/zdesafios/cognizant/blob/master/doc/Testes-Unitarios.png)

[Cobertura](https://github.com/zdesafios/cognizant/blob/master/doc/Cobertura.png)

