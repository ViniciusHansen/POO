from abc import ABC, abstractmethod


class Pessoa(ABC):
    def __init__(self):
        nome = str

    @abstractmethod
    def __repr__ (self):
        pass


class Aluno(Pessoa):
    def __init__(self):
        notas = []

    def calcularMedia():
        sum=0
        for i in Aluno.notas:
            sum+=i
        return sum/notas.length()
    def __repr__(self):
        if (Aluno.calcularMedia()) > 7:
            return "Aluno: {}, Notas: {}, Situação: APROVADO".format(self.nome,self.notas)
        else:
            return "Aluno: {}, Notas: {}, Situação: REPROVADO".format(self.nome,self.notas)


class Professor(Pessoa):
    def __init__(self):
        salario = []
    def __repr__(self):
        return "Nome: {}, Salario: {}".format(self.nome, self.salario)

