from abc import ABC, abstractmethod


class Pessoa(ABC):
    @abstractmethod
    def __repr__ (self):
        pass

class Aluno(Pessoa):
    def __init__(self):
        notas = []

    def calcularMedia():
        sum=0
        for i in notas:
            sum+=i
        return sum


