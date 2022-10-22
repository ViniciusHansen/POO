from classses import *

prof1 = Professor()
prof1.nome = "Fabio"
prof2 = Professor()
prof2.nome = "Alberto"

a1notas = [7, 3, 9, 4, 6]
a1 = Aluno(a1notas)
a1.nome = "Robertinho"

a2notas = [2, 7, 9, 4, 1]
a2 = Aluno(a2notas)
a2.nome = "João"

a3notas = [7, 8, 9, 8, 9]
a3 = Aluno(a3notas)
a3.nome = "Jonas"

a4notas = [2, 3, 4, 5, 1]
a4 = Aluno(a4notas)
a4.nome = "Nicolas"

a5notas = [9, 9, 9, 9, 9]
a5 = Aluno(a5notas)
a5.nome = "Laura"

print(a1)
print(a2)
print(a3)
print(a4)
print(a5)
