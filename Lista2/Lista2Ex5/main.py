from dados.Filme import Filme
import json

f = open("entrada.json")
data = json.load(f)

filmes = []

for sublista in data:
    filme = Filme()
    filme.titulo = sublista['titulo']
    filme.ano = sublista['ano']
    filme.clasInd = sublista['classificacao']
    filme.nota = sublista['nota']
    print(filme)
    filmes.append(filme)

#print(filmes)

#print(json.dumps(data,indent=4))
