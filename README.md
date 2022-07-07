# AvaliacaoTinnova

Essa é minha tentativa de resolução do testa da empresa Tinnova, que fiz no dia 07/07/2022.

Fazia quase um ano que eu não programava em Java, então tive que ir estudando e relembrando conforme fui fazendo o desafio. Dos dois dias propostos para a realização do desafio, utilizei apenas um, pois tenho outra proposta de emprego e preciso decidir até sexta-feira, e gostaria de receber um feedback da Tinnova primeiro.

O projeto foi criado usando o Spring Initializr e desenvolvido no IntelliJ.

## Exercícios 1-4

Os primeiro quatro exercícios involvem a resolução de problemas matemáticos. Foi feita uma classe para cada exercício. Estas classes estão definidas no pacote```src.main.java.com.tinnova.exerciciosmatematicos```, e a resolução dos exercícios pode ser vista no teste que está no pacote ```src.test.java.com.tinnova.exerciciosmatematicos```.

## Exercício 5

O serviço de cadastro de veículos está definido no pacote ```src.main.java.com.tinnova.cadastroveiculos```. Só consegui desenvolver o back-end, o front ficou no desenvolvimento inicial. 

Detalhes: 
* Fiz duas classes controladoras, que estão na pasta ```Controller```. O ```VeiculoController``` implementa todos os endpoints solicitados para a API Restful, já o ```CadastroController``` fiz posteriormente para controlar o front-end, mas ficou incompleto e deve ser ignorado.

* Testei a API utilizando o Postman (sei que o mais correto seria testar na própria aplicação), o workspace importado por este botão: [![Run in Postman](https://run.pstmn.io/button.svg)](https://god.postman.co/run-collection/52af28a1c2648a733613?action=collection%2Fimport)