# avaliacaotexoit
Repositório Contendo a Avaliação Técnica da Texo IT


# Tecnologias Utilizadas
Foram utilizadas as seguintes tecnologias:
- Java 11
- IDE - Spring Tool Suite 4
- SpringBoot 
- H2 in Memory Database


# Pré Requisitos
Para executar o projeto em ambiente local, primeiramente ele deve ser clonado e depois ser aberto utilizando uma IDE (no desenvolvimento deste projeto foi utilizado a IDE Spring Tool Suite 4).


# Executando os Testes de Integração
A classe responsável pela execução dos testes é VencedorPiorFilmeControllerTest que fica na package com.vencedorpiorfilme.controllers da /VencedoresPiorFilme/src/test/java.


# Executando a API
A classe responsável pela execução da API é VencedorPiorFilmeController ela fica na package com.vencedorpiorfilme.controllers da /VencedoresPiorFilme/src/main/java.


# Rest API
O projeto contém os seguintes serviços acessados pela URL: http://localhost:1000/vencedores

# /getintervalo
Este serviço obtém o produtor com maior intervalo entre dois prêmios consecutivos, e o que
obteve dois prêmios mais rápido.
# Request
GET http://localhost:1000/vencedores/getintervalo
# Response
JSON
'
{
    "min": [
        {
            "producer": "Wyck Godfrey, Stephenie Meyer and Karen Rosenfelt",
            "interval": 1,
            "previousWin": 2011,
            "followingWin": 2012
        },
        {
            "producer": "Yoram Globus and Menahem Golan",
            "interval": 1,
            "previousWin": 1986,
            "followingWin": 1987
        }
    ],
    "max": [
        {
            "producer": "Jerry Weintraub",
            "interval": 9,
            "previousWin": 1980,
            "followingWin": 1989
        }
    ]
}
'
# /getvencedorano
Este serviço é responsavel pela consulta do vencedor ou vencedores do ano indicado.
# Request
GET http://localhost:1000/vencedores/getvencedorano/2018
# Response
JSON
'
[
    {
        "id": 197,
        "year": 2018,
        "title": "Holmes & Watson",
        "studios": "Columbia Pictures",
        "producers": "Will Ferrell, Adam McKay, Jimmy Miller and Clayton Townsend",
        "winner": "yes"
    }
]
'
# getindicadosano
Este serviço é responsável pela consulta dos filems indicados no ano.
# Request
GET http://localhost:1000/vencedores/getindicadosano/2019
# Response
JSON
'
[
    {
        "id": 202,
        "year": 2019,
        "title": "Cats",
        "studios": "Universal Pictures",
        "producers": "Debra Hayward, Tim Bevan, Eric Fellner, and Tom Hooper",
        "winner": "yes"
    },
    {
        "id": 203,
        "year": 2019,
        "title": "The Fanatic",
        "studios": "Quiver Distribution",
        "producers": "Daniel Grodnik, Oscar Generale, and Bill Kenwright",
        "winner": null
    },
    {
        "id": 204,
        "year": 2019,
        "title": "The Haunting of Sharon Tate",
        "studios": "Saban Films",
        "producers": "Lucas Jarach, Daniel Farrands, and Eric Brenner",
        "winner": null
    },
    {
        "id": 205,
        "year": 2019,
        "title": "A Madea Family Funeral",
        "studios": "Lionsgate",
        "producers": "Ozzie Areu, Will Areu, and Mark E. Swinton",
        "winner": null
    },
    {
        "id": 206,
        "year": 2019,
        "title": "Rambo: Last Blood",
        "studios": "Lionsgate",
        "producers": "Avi Lerner, Kevin King Templeton, Yariv Lerner, and Les Weldon",
        "winner": null
    }
]
'

# post
Este serviço é responsavel para a inclusão de um novo indicado.
# Request
POST http://localhost:1000/vencedores/post 
JSON
'
   {
        "year": 2020,
        "title": "OutroTeste",
        "studios": "Universal Pictures",
        "producers": "Teste",
        "winner": "yes"
    }
'    

# Response
JSON

'{
    "id": 207,
    "year": 2020,
    "title": "OutroTeste",
    "studios": "Universal Pictures",
    "producers": "Teste",
    "winner": "yes"
}'

# put
Este serviço é responsavel para realizar a alteração/atualização de uma indicação
# Request
PUT http://localhost:1000/vencedores/put
JSON

'    {
    	"id": 207,
        "year": 2019,
        "title": "Teste",
        "studios": "Universal Pictures",
        "producers": "Teste",
        "winner": "no"
    }'

# Response
JSON

'{
    "id": 207,
    "year": 2019,
    "title": "Teste",
    "studios": "Universal Pictures",
    "producers": "Teste",
    "winner": "no"
}'

