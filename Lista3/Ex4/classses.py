from abc import ABC, abstractmethod


class Pessoa(ABC):
    def __init__(self):
        nome = str

    @abstractmethod
    def __repr__(self):
        pass


class Aluno(Pessoa):
    notas = []

    def __init__(self, notas):
        super().__init__()
        self.notas = notas

    def calcularMedia(self):
        s = 0
        for i in self.notas:
            s += i
        return s / len(self.notas)

    def __repr__(self):
        if (Aluno.calcularMedia(self)) > 7:
            return "Aluno: {}, Notas: {}, Média: {}, Situação: APROVADO".format(self.nome, self.notas, self.calcularMedia())
        else:
            return "Aluno: {}, Notas: {}, Média: {}, Situação: REPROVADO".format(self.nome, self.notas, self.calcularMedia())


class Professor(Pessoa):
    def __init__(self):
        salario = []

    def __repr__(self):
        return "Nome: {}, Salario: {}".format(self.nome, self.salario)
