class Filme:
    def __init__(self):
        self.titulo = ""
        self.ano = 0
        self.clasInd = ""
        self.nota = 0.0

    def __str__(self):
        return "Titulo: {} - Ano: {} - Classificação indicativa: {} - Nota: {}".format(self.titulo,self.ano,self.clasInd,self.nota)

