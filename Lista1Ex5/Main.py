from dados.Carro import *
from dados.Cliente import *

carro1 = Carro()
carro2 = Carro()

cliente = Cliente()

cliente.nome = "fulano"
cliente.cpf = "120983712890"
cliente.endereco = "udesc"

carro1.modelo = "up"
carro1.fabricante = "VW"
carro1.cor = "preto"

carro2.fabricante = "ford"
carro2.modelo = "ka"
carro2.cor = "branco"

print("Carro 1: ")
print(carro1)
print("Carro 2:")
print(carro2)
print("Cliente:")
print(cliente)

